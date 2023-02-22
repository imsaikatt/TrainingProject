package com.example.TicketBookingApp.service;

import com.example.TicketBookingApp.Security.CutomUserDetails;
import com.example.TicketBookingApp.model.User;
import com.example.TicketBookingApp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepositoryObject;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepositoryObject.findByUsername(username);
        return new CutomUserDetails(user);
    }
}
