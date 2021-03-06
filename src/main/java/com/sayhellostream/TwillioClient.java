package com.sayhellostream;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.apache.commons.lang.StringUtils;

public class TwillioClient {

    // Find your Account Sid and Token at twilio.com/console

    // Set these as environment variables in order to use
    public static String accountSid = System.getenv("TWILLIO_ACCOUNT_SID");
    public static String authToken = System.getenv("TWILLIO_AUTH_TOKEN");

    // Make sure from phone is in format +15555555555
    public static String fromPhone = System.getenv("TWILLIO_FROM_PHONE");

    public static void send(String to, String body) {

        if (configInitialized()) {

            Twilio.init(accountSid, authToken);

            Message message = Message.creator(
                    new PhoneNumber(to),
                    new PhoneNumber(fromPhone),
                    body).create();

            System.out.println(message.getSid());
        } else {
            System.out.println("Twillio config is not initialized");
        }
    }

    private static boolean configInitialized() {

        return StringUtils.isNotBlank(accountSid) && StringUtils.isNotBlank(authToken);
    }
}