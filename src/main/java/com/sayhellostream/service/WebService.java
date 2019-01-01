package com.sayhellostream.service;


import com.sayhellostream.domain.CustomUserDetails;

public interface WebService {

    String convert(Object object);

    CustomUserDetails currentUser();
}
