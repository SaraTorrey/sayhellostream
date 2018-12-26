package com.sayhellostream.sayhellostream.controller;

import java.time.LocalDate;

import javax.annotation.Resource;

import com.sayhellostream.sayhellostream.TwillioSender;
import com.sayhellostream.sayhellostream.service.ContactService;

import org.joda.time.DateTime;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class IndexController {

    @Resource
    ContactService contactService;

    @PostMapping(value = "send")
    public String send(@RequestParam String first, @RequestParam String last, @RequestParam String phone, @RequestParam String body) {

        TwillioSender.send(phone, "+19252332108", body);

        return "mainTemplate";
    }

    @GetMapping(value = "landing")
    public String landing() {

        return "landing";
    }

    @GetMapping(value = "history")
    public String history( Model model ) {
        model.addAttribute( "contactList", contactService.findAll() );

        return "history";
    }

    // Pages

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
