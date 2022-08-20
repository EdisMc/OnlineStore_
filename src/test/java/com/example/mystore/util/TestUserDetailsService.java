package com.example.mystore.util;

import com.example.mystore.securityUser.ShopUserDetails;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashSet;

@Service
public class TestUserDetailsService implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return new ShopUserDetails(1L,
                "12345",
                username,
                "Test",
                "user",
                Collections.emptyList(),
                new HashSet<>());
    }
}
