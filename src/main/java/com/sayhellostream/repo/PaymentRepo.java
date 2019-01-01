package com.sayhellostream.repo;


import com.sayhellostream.domain.Payment;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface PaymentRepo extends PagingAndSortingRepository<Payment, Long> {

    Payment findOneByIdAndCompanyId(Long id, Long companyId);
    void deleteOneByIdAndCompanyId(Long id, Long companyId);

    List<Payment> findByCompanyId(Long companyId);
}
