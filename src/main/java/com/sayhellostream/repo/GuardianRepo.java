package com.sayhellostream.repo;

import com.sayhellostream.domain.Guardian;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Component;

@Component
public interface GuardianRepo extends PagingAndSortingRepository<Guardian, Long> {

}
