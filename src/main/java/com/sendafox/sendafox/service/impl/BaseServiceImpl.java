package com.sayhellostream.sayhellostream.service.impl;


import com.sayhellostream.sayhellostream.domain.Company;
import com.sayhellostream.sayhellostream.domain.CustomUserDetails;
import com.sayhellostream.sayhellostream.service.BaseService;
import com.sayhellostream.sayhellostream.service.WebService;
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