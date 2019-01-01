package com.sayhellostream.service;


import com.sayhellostream.domain.Company;
import com.sayhellostream.domain.CustomUserDetails;

public interface BaseService {


    CustomUserDetails currentUser();
    Company currentCompany();

    Long currentCompanyId();
}