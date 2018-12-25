package com.sayhellostream.sayhellostream.service.impl;


import com.sayhellostream.sayhellostream.domain.Contact;
import com.sayhellostream.sayhellostream.domain.Payment;
import com.sayhellostream.sayhellostream.repo.ContactRepo;
import com.sayhellostream.sayhellostream.repo.PaymentRepo;
import com.sayhellostream.sayhellostream.service.ContactService;
import com.sayhellostream.sayhellostream.service.ConversionService;
import com.sayhellostream.sayhellostream.util.IdObfuscator;
import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;

@Service
public class ContactServiceImpl extends BaseServiceImpl implements ContactService {

    @Autowired
    ConversionService conversionService;

    @Autowired
    ContactRepo contactRepo;

    @Autowired
    PaymentRepo paymentRepo;

    @Override public int activeContactCount() {

        return Long.valueOf( contactRepo.count() ).intValue();
    }

    @Override public String totalMonthlyRevenue() {

        Iterable<Contact> all = contactRepo.findByCompanyIdOrderByLastNameAscFirstNameAsc(currentCompanyId() );


        BigDecimal total = BigDecimal.ZERO;
        for ( Contact contact : all ) {

            Money lessonFee = contact.getLessonFee();
            if ( lessonFee != null ) {
                total = total.add( lessonFee.getAmount().multiply( new BigDecimal( "4" ) ) );
            }
        }

        return conversionService.convert( Money.of(CurrencyUnit.USD, total ) );
    }

    @Override
    public Contact get( String id ) {

        return contactRepo.findOneByIdAndCompanyId(IdObfuscator.dec(id ),
                                                   currentCompanyId() );
    }

    @Override
    @Transactional
    public void delete( String id ) {

        contactRepo.findOneByIdAndCompanyId( IdObfuscator.dec( id ),
                                             currentCompanyId() );
    }

    @Override
    @Transactional
    public void save( Contact contact ) {

        contactRepo.save( contact );
    }

    @Override
    public Iterable<Contact> findAll() {

        return contactRepo.findByCompanyIdOrderByLastNameAscFirstNameAsc(currentCompanyId());
    }

    @Override public Payment addPayment( String contactId ) {

        Contact contact = contactRepo.findOneByIdAndCompanyId( IdObfuscator.dec( contactId ),
                                                               currentCompanyId() );

        Payment payment = new Payment();
        payment.setContact( contact );

        return payment;
    }

    @Override
    public Payment getPayment( String id ) {

        return paymentRepo.findOneByIdAndCompanyId( IdObfuscator.dec( id ),
                                             currentCompanyId() );
    }

    @Override
    public void deletePayment( String id ) {

        paymentRepo.findOneByIdAndCompanyId( IdObfuscator.dec( id ),
                                             currentCompanyId() );
    }

    @Override
    public void savePayment( Payment payment ) {

        paymentRepo.save( payment );
    }
}