package com.example.dddleaning.application.security;

import com.example.dddleaning.domain.entities.User;
import com.example.dddleaning.domain.interfaces.UserRepository;
import com.example.dddleaning.domain.valueobjects.Email;
import com.example.dddleaning.domain.valueobjects.UserId;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(new Email(email))
                .orElseThrow(()->new UsernameNotFoundException("User not found with username or email: "+email));
        return UserPrincipal.create(user);
    }
    //This method is used by JWTAuthenticationFilter
    @Transactional
    public UserDetails loadUserById(Long id){
        User user = userRepository.findByUserId(new UserId(id))
                .orElseThrow(()->new UsernameNotFoundException("User not found with id: "+id));
    return  UserPrincipal.create(user);
    }
}
