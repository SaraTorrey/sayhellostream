package com.sayhellostream.controller;


import com.sayhellostream.TwillioSender;
import com.sayhellostream.service.ContactService;
import com.sayhellostream.domain.TextMessage;
import com.sayhellostream.repo.TextMessageRepo;

import org.joda.time.DateTime;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;

import javax.annotation.Resource;

@Controller
@RequestMapping( "/" )
public class IndexController {

    @Resource
    ContactService contactService;

    @Resource
    TextMessageRepo textMessageRepo;

    @PostMapping( value = "sendText" )
    public String send( @RequestParam( required = false ) String first,
                        @RequestParam( required = false ) String last,
                        @RequestParam( required = false ) String phone,
                        @RequestParam( required = false ) String body, Model model ) {

        if ( !phone.contains( "832" ) || ( !phone.contains( "2323" ) && !phone.contains( "3060" ) ) ) {
            System.out.println( String.format( "[%s] is an invalid phone number", phone ) );
            model.addAttribute( "errorMessage", String.format( "[%s] is an illegal phone number", phone ) );
            return "sendText";
        }

        TextMessage reminderMessage = new TextMessage();
        reminderMessage.firstName = first;
        reminderMessage.lastName = last;
        reminderMessage.body = body;
        reminderMessage.phoneNumber = phone;
        reminderMessage.wasSent = true;
        reminderMessage.sendDate = DateTime.now().plusMinutes( 5 ).plusDays( 1 );
        textMessageRepo.save( reminderMessage );

        TwillioSender.send( phone, "+19252332108", body );

        model.addAttribute( "successMessage", "Message sent successfully!" );

        return "sendText";
    }

    @GetMapping( value = "landing" )
    public String landing() {

        return "landing";
    }

    @GetMapping( value = "sendText" )
    public String sendText() {


        return "sendText";
    }

    @GetMapping( value = "userProfile/{name}/{age}" )
    public String userProfile( @PathVariable String name, @PathVariable Long age, Model model ) {

        model.addAttribute( "name", name );

        LocalDate birthDate = LocalDate.now();
        birthDate = birthDate.minusYears( age );

        model.addAttribute( "birthYear", birthDate.getYear() );

        return "userProfile";
    }

    @GetMapping( value = "1" )
    public String one() {

        return "1";
    }

    @GetMapping( value = "sendEmail" )
    public String sendEmail() {

        return "sendEmail";
    }

    @GetMapping( value = "login" )
    public String login() {

        return "login";
    }
}
