package com.sayhellostream.domain;

import org.joda.money.Money;
import org.joda.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Payment extends BaseEntity {

    private LocalDate date;
    private Money amount;
    private PaymentType type;
    private String notes;

    @ManyToOne
    private Company company;

    @ManyToOne()
    private Contact contact;

    public LocalDate getDate() {

        return date;
    }

    public void setDate( LocalDate date ) {

        this.date = date;
    }

    public Money getAmount() {

        return amount;
    }

    public void setAmount( Money amount ) {

        this.amount = amount;
    }

    public PaymentType getType() {

        return type;
    }

    public void setType( PaymentType type ) {

        this.type = type;
    }

    public Contact getContact() {

        return contact;
    }

    public void setContact(Contact contact) {

        this.contact = contact;
    }

    public String getNotes() {

        return notes;
    }

    public void setNotes( String notes ) {

        this.notes = notes;
    }

    public Company getCompany() {

        return company;
    }

    public void setCompany( Company company ) {

        this.company = company;
    }
}