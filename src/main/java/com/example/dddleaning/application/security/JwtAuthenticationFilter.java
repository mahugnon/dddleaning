package com.example.dddleaning.application.security;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JwtAuthenticationFilter extends OncePerRequestFilter {
    @Autowired
    CustomUserDetailsService customUserDetails;
    @Autowired
    JwtTokenProvider tokenProvider;
    private static Logger LOGGER
            = LoggerFactory.getLogger(JwtAuthenticationFilter.class);
    @Override
    protected void doFilterInternal(
            HttpServletRequest httpServletRequest,
            HttpServletResponse httpServletResponse,
            FilterChain filterChain) throws ServletException, IOException {
        try {
            String jwt = getJwtFromRequest(httpServletRequest);
            if(StringUtils.hasText(jwt)&& tokenProvider.validateTocken(jwt)){
                Long userId = tokenProvider.getUserIdFromJWT(jwt);
                UserDetails userDetails= customUserDetails.loadUserById(userId);
            }
        }catch (Exception ex){
            LOGGER.error("Could not set usr authentication in security context", ex);
        }
    filterChain.doFilter(httpServletRequest,httpServletResponse);
    }

    private String getJwtFromRequest(HttpServletRequest httpServletRequest) {
        String bearerTocken = httpServletRequest.getHeader("Authorization");
        int jwt_start_pos =7;
      int jwt_end_pos =bearerTocken.length();
        if(StringUtils.hasText(bearerTocken) && bearerTocken.startsWith("Bearer ")){
            return bearerTocken.substring(jwt_start_pos,jwt_end_pos );
        }
        return null;
    }
}
