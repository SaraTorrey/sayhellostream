package com.sayhellostream.sayhellostream.service;


import com.sayhellostream.sayhellostream.domain.AppUser;
import com.sayhellostream.sayhellostream.domain.CustomUserDetails;
import com.sayhellostream.sayhellostream.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AppUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username ) throws UsernameNotFoundException {
        AppUser user = userRepo.findOneByUsername(username )
                               .orElseThrow(() -> new UsernameNotFoundException(String.format("User with email=%s was not found",
                                                                               username )));
        return new CustomUserDetails(user );
    }
}