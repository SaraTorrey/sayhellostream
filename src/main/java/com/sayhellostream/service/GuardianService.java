package com.sayhellostream.service;


import com.sayhellostream.domain.Contact;
import com.sayhellostream.domain.Guardian;

public interface GuardianService {

    Guardian get(String id);
    Contact addForGuardian( String guardianId);
    void delete(String id);
    void save(Guardian guardian);
    Iterable<Guardian> findAll();
}