package com.sayhellostream.sayhellostream.service.impl;


import com.sayhellostream.sayhellostream.service.ScheduledService;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class ScheduledServiceImpl extends BaseServiceImpl implements ScheduledService {

    @Override
    @Scheduled(fixedDelay = 5000)
    public void checkForMessagesToSend() {

        System.out.println( "Checking for messages to send..." );
    }
}