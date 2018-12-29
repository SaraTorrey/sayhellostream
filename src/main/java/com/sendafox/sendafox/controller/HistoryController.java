package com.sayhellostream.sayhellostream.controller;


import com.sayhellostream.sayhellostream.repo.PaymentRepo;
import com.sayhellostream.sayhellostream.repo.TextMessageRepo;
import com.sayhellostream.sayhellostream.service.WebService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.annotation.Resource;

@Controller
@SessionAttributes( value = { "entity" } )
@RequestMapping( "history" )
public class HistoryController {

    public static final String PAYMENTS = "#payments";

    @Resource
    TextMessageRepo textMessageRepo;

    @Resource
    PaymentRepo paymentRepo;

    @Resource
    WebService webService;

    @GetMapping
    public String index( Model model ) {

        model.addAttribute( "sentList", textMessageRepo.findByWasSentOrderByCreatedDesc( true ) );
        model.addAttribute( "scheduledList", textMessageRepo.findByWasSentOrderByCreatedDesc( false ) );
        System.out.println( "get list of messages" );
        return "history/index";
    }
}