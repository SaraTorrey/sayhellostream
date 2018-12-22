package com.sayhellostream.sayhellostream.service;


import com.sayhellostream.sayhellostream.domain.Company;
import com.sayhellostream.sayhellostream.domain.CustomUserDetails;

public interface BaseService {


    CustomUserDetails currentUser();
    Company currentCompany();

    Long currentCompanyId();
}