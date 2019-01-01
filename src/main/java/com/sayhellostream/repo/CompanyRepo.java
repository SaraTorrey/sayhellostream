package com.sayhellostream.repo;

import com.sayhellostream.domain.Company;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Component;

@Component
public interface CompanyRepo extends PagingAndSortingRepository<Company, Long> {



}
