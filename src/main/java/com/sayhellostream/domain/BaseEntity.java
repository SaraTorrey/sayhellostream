package com.sayhellostream.domain;

import com.sayhellostream.util.IdObfuscator;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;
import java.io.Serializable;

@MappedSuperclass
@EntityListeners( { AuditingEntityListener.class } )
public class BaseEntity implements Serializable {

    @Id
    @GeneratedValue( strategy = GenerationType.AUTO )
    Long id;

    String ident;

    @CreatedDate
    @Type( type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime" )
    private DateTime created = DateTime.now();

    @LastModifiedDate
    @Type( type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime" )
    private DateTime lastUpdated = DateTime.now();

    public Long getId() {

        return id;
    }

    public void setId( Long id ) {

        this.id = id;
    }

    public DateTime getCreated() {

        return created;
    }

    public void setCreated( DateTime created ) {

        this.created = created;
    }

    public DateTime getLastUpdated() {

        return lastUpdated;
    }

    public void setLastUpdated( DateTime lastUpdated ) {

        this.lastUpdated = lastUpdated;
    }

    @Transient
    public String getIdent() {

        if ( ident != null ) {
            return ident;
        }

        return this.id != null ? IdObfuscator.enc( this.id ) : null;
    }

    public void setIdent( String ident ) {

        this.ident = ident;
    }

    @Transient
    public String getDateString() {

        return created != null ? created.toString( "MM/dd/yyyy hh:mm a" ) : "";
    }
}