package com.sayhellostream.sayhellostream.controller;


import com.sayhellostream.sayhellostream.domain.Contact;
import com.sayhellostream.sayhellostream.domain.Payment;
import com.sayhellostream.sayhellostream.repo.PaymentRepo;
import com.sayhellostream.sayhellostream.service.ContactService;
import com.sayhellostream.sayhellostream.util.IdObfuscator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.annotation.Resource;

@Controller
@SessionAttributes( value = { "entity" } )
@RequestMapping( "contacts" )
public class ContactController {

    public static final String PAYMENTS = "#payments";
    @Resource
    ContactService contactService;
    @Resource
    PaymentRepo paymentRepo;

    @GetMapping
    public String main( Model model ) {

        model.addAttribute( "contactList", contactService.findAll() );

        return "contacts/index";
    }

    @GetMapping( "add" )
    public String add( Model model ) {

        model.addAttribute( "entity", new Contact() );

        return "contacts/edit";
    }

    @GetMapping( "edit/{id}" )
    public String edit(@PathVariable String id, Model model ) {

        model.addAttribute( "entity", contactService.get( id ) );

        return "contacts/edit";
    }

    @GetMapping( "details/{id}" )
    public String detail(@PathVariable String id, Model model ) {

        model.addAttribute( "entity", contactService.get( id ) );

        return "contacts/details";
    }

    @GetMapping( "delete/{id}" )
    public String delete( @PathVariable String id ) {

        contactService.delete( id );

        return "redirect:/contacts/details/" + id ;
    }

    @PostMapping( "edit/" )
    public String edit( @ModelAttribute( "entity" ) Contact entity ) {

        contactService.save( entity );

        return "redirect:/contacts/details/" + IdObfuscator.enc(entity.getId() );
    }


    @GetMapping( "addPayment" )
    public String addPayment( Model model ) {

        model.addAttribute( "entity", new Payment() );

        return "contacts/edit";
    }

    @GetMapping( "addPayment/{contactId}" )
    public String addPayment(@PathVariable String contactId, Model model ) {

        model.addAttribute( "entity", contactService.addPayment( contactId ) );

        return "contacts/paymentEdit";
    }

    @GetMapping( "editPayment/{id}" )
    public String editPayment(@PathVariable String id, Model model ) {

        model.addAttribute( "entity", contactService.getPayment( id ) );

        return "contacts/paymentEdit";
    }

    @PostMapping( "editPayment/" )
    public String edit( @ModelAttribute( "entity" ) Payment entity ) {

        contactService.savePayment( entity );

        return "redirect:/contacts/details/" + IdObfuscator.enc( entity.getContact().getId() ) + PAYMENTS;
    }

    @GetMapping( "deletePayment/{id}" )
    public String deletePayment( @PathVariable String id ) {

        Payment payment = contactService.getPayment( id );

        contactService.deletePayment( id );

        return "redirect:/contacts/details/" + IdObfuscator.enc( payment.getContact().getId() ) + PAYMENTS;
    }
}