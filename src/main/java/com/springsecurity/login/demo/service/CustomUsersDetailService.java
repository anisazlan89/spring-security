package com.springsecurity.login.demo.service;

import com.springsecurity.login.demo.model.Users;
import com.springsecurity.login.demo.repository.UsersRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;

@Service
public class CustomUsersDetailService implements UserDetailsService {

    private final UsersRepository usersRepository;

    public CustomUsersDetailService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users users = usersRepository.findByEmail(username).orElseThrow(() -> new UsernameNotFoundException("User not found with email: " + username));

        //when you dont have roles
        // If you DO have a user type string like "Recruiter" or "Job Seeker", you could do:
        // authorities = List.of(new SimpleGrantedAuthority(u.getUserTypeName()));
        Collection<? extends GrantedAuthority> authorities = Collections.emptyList();

        // Build Spring’s built-in UserDetails
        return User.withUsername(users.getEmail())
                .password(users.getPwd())
                .authorities(authorities)
                .accountExpired(false)
                .accountLocked(false)
                .credentialsExpired(false)
                .disabled(false)
                .build();
    }
}
