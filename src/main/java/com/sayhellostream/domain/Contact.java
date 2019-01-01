package com.sayhellostream.domain;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import org.joda.time.LocalDate;
import org.joda.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Contact extends BaseEntity {

    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private String lessonSummary;

    private LessonDay lessonDay;
    private LessonType lessonType;
    private LessonLength lessonLength;
    private Money lessonFee;

    private org.joda.time.LocalTime lessonTime;

    @OneToMany( mappedBy = "contact" )
    @Cascade( CascadeType.ALL )
    private Set<Payment> payments = new HashSet<>();

    @ManyToOne( optional = false )
    private Company company;

    public Contact() {

    }

    public Contact(String firstName, String lastName, String lessonSummary, Company company, String phone) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.lessonSummary = lessonSummary;
        this.company = company;
        this.phone = phone;
    }

    public String getFirstName() {

        return firstName;
    }

    public void setFirstName( String firstName ) {

        this.firstName = firstName;
    }

    public String getLastName() {

        return lastName;
    }

    public void setLastName( String lastName ) {

        this.lastName = lastName;
    }

    public String getPhone() {

        return phone;
    }

    public void setPhone( String phone ) {

        this.phone = phone;
    }

    public String getEmail() {

        return email;
    }

    public void setEmail( String email ) {

        this.email = email;
    }

    public String getLessonSummary() {

        return lessonSummary;
    }

    public void setLessonSummary( String lessonSummary ) {

        this.lessonSummary = lessonSummary;
    }

    public Set<Payment> getPayments() {

        return payments;
    }

    public void setPayments( Set<Payment> payments ) {

        this.payments = payments;
    }

    public LessonDay getLessonDay() {

        return lessonDay;
    }

    public void setLessonDay( LessonDay lessonDay ) {

        this.lessonDay = lessonDay;
    }

    public LessonType getLessonType() {

        return lessonType;
    }

    public void setLessonType( LessonType lessonType ) {

        this.lessonType = lessonType;
    }

    public LessonLength getLessonLength() {

        return lessonLength;
    }

    public void setLessonLength( LessonLength lessonLength ) {

        this.lessonLength = lessonLength;
    }

    public Money getLessonFee() {

        return lessonFee;
    }

    public void setLessonFee( Money lessonFee ) {

        this.lessonFee = lessonFee;
    }

    public LocalTime getLessonTime() {

        return lessonTime;
    }

    public void setLessonTime( LocalTime lessonTime ) {

        this.lessonTime = lessonTime;
    }

    public Company getCompany() {

        return company;
    }

    public void setCompany( Company company ) {

        this.company = company;
    }

    @Transient
    public LocalDate nextLesson() {

        if ( lessonDay == null ) {
            return null;
        }

        LocalDate now = LocalDate.now();
        if ( now.getDayOfWeek() == lessonDay.getDayNumber() ) {
            return now;
        }

        while ( true ) {
            now = now.plusDays( 1 );
            if ( now.getDayOfWeek() == lessonDay.getDayNumber() ) {
                return now;
            }
        }
    }

    @Transient
    public Money totalPayments() {

        return Money.of( CurrencyUnit.USD, getPayments().stream().map( p -> p.getAmount().getAmount() )
                .reduce( BigDecimal.ZERO, BigDecimal::add ) );
    }
}