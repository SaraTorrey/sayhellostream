package com.sayhellostream.sayhellostream.service;


import com.sayhellostream.sayhellostream.domain.CustomUserDetails;

public interface WebService {

    String convert(Object object);

    CustomUserDetails currentUser();
}
