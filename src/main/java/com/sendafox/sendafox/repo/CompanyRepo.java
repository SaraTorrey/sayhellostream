package com.sayhellostream.sayhellostream.repo;

import com.sayhellostream.sayhellostream.domain.Company;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Component;

@Component
public interface CompanyRepo extends PagingAndSortingRepository<Company, Long> {



}
