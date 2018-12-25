package com.sayhellostream.sayhellostream.repo;

import com.sayhellostream.sayhellostream.domain.Contact;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ContactRepo extends PagingAndSortingRepository<Contact, Long> {

    Contact findOneByIdAndCompanyId(Long id, Long companyId);
    void deleteOneByIdAndCompanyId(Long id, Long companyId);

    List<Contact> findByCompanyId(Long companyId);

}