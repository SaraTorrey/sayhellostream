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
    @Scheduled( fixedDelay = 10000 )
    public void checkForMessagesToSend() {


        System.out.println( "Checking for messages to send..." );
        List<TextMessage> messages = textMessageRepo.findBySendDateLessThanEqualAndWasSentFalse( DateTime.now() );

        if ( messages.isEmpty() ) {
            System.out.println( "No messages found" );
        }
        else {
            System.out.println( String.format( "[%d] messages found. Sending.", messages.size() ) );

            for ( TextMessage message : messages ) {
                message.setWasSent( true );
                textMessageRepo.save( message );
            }

            System.out.println( String.format( "Adding another message.", messages.size() ) );

            TextMessage message = new TextMessage();
            message.setBody( "Test message" );
            message.setSendDate( DateTime.now().plusMinutes( 1 ) );
            textMessageRepo.save( message );
        }

    }
}