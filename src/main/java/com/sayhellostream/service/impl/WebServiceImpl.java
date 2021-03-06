package com.sayhellostream.service.impl;

import com.sayhellostream.domain.CustomUserDetails;
import com.sayhellostream.service.WebService;
import com.sayhellostream.converter.DateFormatter;
import com.sayhellostream.converter.DateTimeFormatter;
import com.sayhellostream.converter.MoneyFormatter;
import com.sayhellostream.repo.UserRepo;

import org.apache.commons.lang.WordUtils;
import org.joda.money.Money;
import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class WebServiceImpl implements WebService {

    @Autowired
    DateFormatter dateFormatter;

    @Autowired
    DateTimeFormatter dateTimeFormatter;

    @Autowired
    MoneyFormatter moneyFormatter;

    @Autowired
    UserRepo userRepository;

    @Override
    public String convert( Object object ) {

        if ( object instanceof LocalDate) {
            return dateFormatter.print((LocalDate) object, null );
        }
        if ( object instanceof DateTime) {
            return dateTimeFormatter.print((DateTime) object, null );
        }
        else if ( object instanceof Money) {
            return moneyFormatter.print( (Money) object, null );
        }
        else if ( object instanceof Enum ) {
            return WordUtils.capitalizeFully(object.toString().replace("_", " " ) );
        }
        else {
            return object == null ? "" : object.toString();
        }
    }

    @Override public CustomUserDetails currentUser() {

        return (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}