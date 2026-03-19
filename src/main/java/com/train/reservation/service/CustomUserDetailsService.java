package com.train.reservation.service;

import com.train.reservation.model.User;
import com.train.reservation.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        System.out.println("🔐 Trying login for: " + username);

        // Fetch user from DB
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> {
                    System.out.println("❌ User NOT found in DB");
                    return new UsernameNotFoundException("User not found");
                });

        // Debug logs
        System.out.println("✅ DB username: " + user.getUsername());
        System.out.println("🔑 DB password (encoded): " + user.getPassword());

        return org.springframework.security.core.userdetails.User
                .withUsername(user.getUsername())
                .password(user.getPassword())
                .roles("USER")
                .build();
    }
}