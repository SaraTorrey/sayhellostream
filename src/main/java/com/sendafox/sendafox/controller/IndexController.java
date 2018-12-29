package com.sayhellostream.sayhellostream.controller;


import com.sayhellostream.sayhellostream.domain.TextMessage;
import com.sayhellostream.sayhellostream.repo.TextMessageRepo;
import com.sayhellostream.sayhellostream.service.ContactService;

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
@RequestMapping("/")
public class IndexController {

    @Resource
    ContactService contactService;

    @Resource
    TextMessageRepo textMessageRepo;

    @PostMapping(value = "send")
    public String send(@RequestParam(required = false) String first, @RequestParam(required = false) String last, @RequestParam(required = false) String phone, @RequestParam(required = false) String body) {

        TextMessage reminderMessage = new TextMessage();
        reminderMessage.firstName = first;
        reminderMessage.lastName = last;
        reminderMessage.body = body;
        reminderMessage.phoneNumber = phone;
        reminderMessage.wasSent = true;
        reminderMessage.sendDate = DateTime.now().plusMinutes( 5 ).plusDays( 1 );
        textMessageRepo.save( reminderMessage );

// Skip sending for now.
//        TwillioSender.send(phone, "+19252332108", body);

        return "mainTemplate";
    }

    @GetMapping(value = "landing")
    public String landing() {

        return "landing";
    }

    @GetMapping(value = "sendText")
    public String sendText() {




        return "sendText";
    }

    @GetMapping(value = "userProfile/{name}/{age}")
    public String userProfile( @PathVariable String name, @PathVariable Long age, Model model ) {

        model.addAttribute("name", name);

        LocalDate birthDate = LocalDate.now();
        birthDate = birthDate.minusYears(age);

        model.addAttribute("birthYear", birthDate.getYear());
    
        return "userProfile";
    }

    @GetMapping(value = "1")
    public String one() {

        return "1";
    }

    @GetMapping(value = "sendEmail")
    public String sendEmail() {

        return "sendEmail";
    }

    @GetMapping(value = "login")
    public String login() {

        return "login";
    }
}
