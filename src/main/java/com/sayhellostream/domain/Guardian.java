package com.sayhellostream.domain;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity
public class Guardian extends BaseEntity {

    private String firstName;
    private String lastName;

    private String address1;
    private String address2;
    private String city;
    private String state;
    private String zip;

    private String phone;

    @OneToMany
    private Set<Contact> contacts;

    public Guardian( ) {

    }

    public Guardian( String firstName, String lastName) {

        this.firstName = firstName;
        this.lastName = lastName;
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

    public Set<Contact> getContacts() {

        return contacts;
    }

    public void setContacts(Set<Contact> contacts) {

        this.contacts = contacts;
    }

    public String getAddress1() {

        return address1;
    }

    public void setAddress1( String address1 ) {

        this.address1 = address1;
    }

    public String getAddress2() {

        return address2;
    }

    public void setAddress2( String address2 ) {

        this.address2 = address2;
    }

    public String getCity() {

        return city;
    }

    public void setCity( String city ) {

        this.city = city;
    }

    public String getState() {

        return state;
    }

    public void setState( String state ) {

        this.state = state;
    }

    public String getZip() {

        return zip;
    }

    public void setZip( String zip ) {

        this.zip = zip;
    }

    public String getPhone() {

        return phone;
    }

    public void setPhone( String phone ) {

        this.phone = phone;
    }
}