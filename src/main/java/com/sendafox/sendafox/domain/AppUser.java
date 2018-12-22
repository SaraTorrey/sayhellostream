package com.sayhellostream.sayhellostream.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class AppUser extends BaseEntity {

    private String firstName;
    private String lastName;
    private String email;

    @Column( unique = true )
    private String username;
    private String password;

    @ManyToOne( optional = false )
    private Company company;

    public AppUser() {

    }

    public AppUser( AppUser user ) {

        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.password = user.getPassword();
        this.company = user.getCompany();
        this.email = user.getEmail();
        this.username = user.getUsername();
    }

    private UserRoleType role;

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

    public String getEmail() {

        return email;
    }

    public void setEmail( String email ) {

        this.email = email;
    }

    public String getUsername() {

        return username;
    }

    public void setUsername( String username ) {

        this.username = username;
    }

    public String getPassword() {

        return password;
    }

    public void setPassword( String password ) {

        this.password = password;
    }

    public UserRoleType getRole() {

        return role;
    }

    public void setRole( UserRoleType role ) {

        this.role = role;
    }

    public Company getCompany() {

        return company;
    }

    public void setCompany( Company company ) {

        this.company = company;
    }
}