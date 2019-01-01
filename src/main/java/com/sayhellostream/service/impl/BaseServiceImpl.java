package com.sayhellostream.service.impl;


import com.sayhellostream.domain.CustomUserDetails;
import com.sayhellostream.service.BaseService;
import com.sayhellostream.service.WebService;
import com.sayhellostream.domain.Company;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BaseServiceImpl implements BaseService {

    @Autowired
    WebService webService;

    @Override
    public CustomUserDetails currentUser() {

        return webService.currentUser();
    }

    @Override
    public Company currentCompany() {

        return currentUser().getCompany();
    }

    @Override
    public Long currentCompanyId() {

        return currentUser().getCompany().getId();
    }
}