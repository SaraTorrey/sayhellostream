package com.sayhellostream.sayhellostream.domain;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Transient;
import java.util.Collection;


public class CustomUserDetails extends AppUser implements UserDetails {

    public CustomUserDetails( AppUser user ) {

        super( user );
    }

    @Override public Collection<? extends GrantedAuthority> getAuthorities() {

        return AuthorityUtils.createAuthorityList( "ROLE_USER" );
    }

    @Override public boolean isAccountNonExpired() {

        return true;
    }

    @Override public boolean isAccountNonLocked() {

        return true;
    }

    @Override public boolean isCredentialsNonExpired() {

        return true;
    }

    @Override public boolean isEnabled() {

        return true;
    }

    @Transient
    public String userFirstLast() {

        return String.format( "%s %s", this.getFirstName(), this.getLastName() );
    }

    @Transient

    public Long companyId () {

        return getCompany().getId();
    }
}