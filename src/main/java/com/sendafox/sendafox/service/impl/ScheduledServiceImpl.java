package com.sayhellostream.sayhellostream.service.impl;


import com.sayhellostream.sayhellostream.domain.TextMessage;
import com.sayhellostream.sayhellostream.repo.TextMessageRepo;
import com.sayhellostream.sayhellostream.service.ScheduledService;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScheduledServiceImpl extends BaseServiceImpl implements ScheduledService {

    @Autowired
    TextMessageRepo textMessageRepo;

    @Override
    @Scheduled( fixedDelay = 3000 )
    public void checkForMessagesToSend() {


        System.out.println( "Checking for messages to send..." );
        List<TextMessage> messages = textMessageRepo.findBySendDateLessThanEqual( DateTime.now() );

        if ( messages.isEmpty() ) {
            System.out.println( "No messages found" );
        }
        else {
            System.out.println( String.format( "[%d] messages found.", messages.size() ) );
        }

    }
}