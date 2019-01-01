package com.sayhellostream.service.impl;


import com.sayhellostream.TwillioSender;
import com.sayhellostream.repo.TextMessageRepo;
import com.sayhellostream.service.ScheduledService;
import com.sayhellostream.service.WebService;
import com.sayhellostream.domain.TextMessage;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScheduledServiceImpl extends BaseServiceImpl implements ScheduledService {

    @Autowired
    TextMessageRepo textMessageRepo;

    @Autowired
    WebService webService;

    @Value( "${spring.profiles.active}")
    private String activeProfile;

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
                TwillioSender.send( message.phoneNumber, "+19252332108", message.body );
                textMessageRepo.save( message );
            }

            System.out.println( String.format( "Adding another message.", messages.size() ) );

            DateTime scheduledDate = DateTime.now().plusMinutes( 720 );

            TextMessage message = new TextMessage();
            message.setBody( String.format( "Message scheduled to send at [%s] on [%s] in [%s]",
                                            webService.convert( scheduledDate ),
                                            webService.convert( DateTime.now() ),
                                            activeProfile ) );
            message.setFirstName( "Dan" );
            message.setFirstName( "Torrey" );
            message.setPhoneNumber( "8327072323" );
            message.setSendDate( scheduledDate );
            textMessageRepo.save( message );
        }
    }
}