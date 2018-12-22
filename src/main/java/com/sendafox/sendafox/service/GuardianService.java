package com.sayhellostream.sayhellostream.service;


import com.sayhellostream.sayhellostream.domain.Guardian;
import com.sayhellostream.sayhellostream.domain.Student;

public interface GuardianService {

    Guardian get(String id);
    Student addForGuardian(String guardianId);
    void delete(String id);
    void save(Guardian guardian);
    Iterable<Guardian> findAll();
}