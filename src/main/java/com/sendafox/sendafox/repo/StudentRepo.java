package com.sayhellostream.sayhellostream.repo;

import com.sayhellostream.sayhellostream.domain.Student;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface StudentRepo extends PagingAndSortingRepository<Student, Long> {

    Student findOneByIdAndCompanyId(Long id, Long companyId);
    void deleteOneByIdAndCompanyId(Long id, Long companyId);

    List<Student> findByCompanyId(Long companyId);

}