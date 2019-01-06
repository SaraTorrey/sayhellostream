package com.sayhellostream.controller;


import com.sayhellostream.TwillioClient;
import com.sayhellostream.domain.TextMessage;
import com.sayhellostream.repo.TextMessageRepo;
import com.sayhellostream.service.ContactService;
import com.sayhellostream.view.SendTextView;

import org.joda.time.DateTime;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;

import javax.annotation.Resource;
import javax.validation.Valid;

@Controller
@RequestMapping( "/" )
public class IndexController {

    @Resource
    ContactService contactService;

    @Resource
    TextMessageRepo textMessageRepo;

    @PostMapping( value = "sendText" )
    public String send(@Valid @ModelAttribute SendTextView sendTextView, Model model, BindingResult result) {

        if (result.hasErrors()) {
            model.addAttribute( "errorMessage", "An error occurred" );
        }

        String phone = sendTextView.getPhoneNumber();
        if (!phone.contains("832" ) || (!phone.contains("2323" ) && !phone.contains("3060" ) ) ) {
            System.out.println( String.format( "[%s] is an invalid phone number", phone ) );
            model.addAttribute( "errorMessage", String.format( "[%s] is an illegal phone number", phone ) );
            return "sendText";
        }

        TextMessage reminderMessage = new TextMessage();
        reminderMessage.firstName = sendTextView.getFirstName();
        reminderMessage.lastName = sendTextView.getLastName();
        reminderMessage.body = sendTextView.getTextBody();
        reminderMessage.phoneNumber = phone;
        reminderMessage.wasSent = true;
        reminderMessage.sendDate = DateTime.now().plusMinutes( 5 ).plusDays( 1 );
        textMessageRepo.save( reminderMessage );

        TwillioClient.send( phone, "+19252332108", sendTextView.getTextBody() );

        model.addAttribute( "successMessage", "Message sent successfully!" );

        return "redirect:/sendText";
    }

    @GetMapping( value = "landing" )
    public String landing() {

        return "landing";
    }

    @GetMapping( value = "" )
    public String indexRedirect() {

        return "redirect:/sendText";
    }

    @GetMapping(value = "sendText")
    public String sendText(Model model) {

        SendTextView view = new SendTextView();
        model.addAttribute("sendTextView", view);

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
