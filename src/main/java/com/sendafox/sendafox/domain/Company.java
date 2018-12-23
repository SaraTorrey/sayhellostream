package com.sayhellostream.sayhellostream.domain;

import javax.persistence.Entity;

@Entity
public class Company extends BaseEntity {

    private String name;

    public String getName() {

        return name;
    }

    public void setName( String name ) {

        this.name = name;
    }
}