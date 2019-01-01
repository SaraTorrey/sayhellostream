package com.sayhellostream;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

public class TwillioClient {

    // Find your Account Sid and Token at twilio.com/console
    public static final String ACCOUNT_SID = System.getenv( "TWILLIO_ACCOUNT_SID" );
    public static final String AUTH_TOKEN = System.getenv( "TWILLIO_AUTH_TOKEN" );

    // Make sure from phone is in format +19254444444
    public static final String FROM_PHONE = System.getenv( "TWILLIO_FROM_PHONE" );

    public static void send(String to, String from, String body) {

        Twilio.init( ACCOUNT_SID, AUTH_TOKEN);

        Message message = Message.creator(
                new PhoneNumber( to),
                new PhoneNumber(from),
                body).create();

        System.out.println(message.getSid());
    }
}