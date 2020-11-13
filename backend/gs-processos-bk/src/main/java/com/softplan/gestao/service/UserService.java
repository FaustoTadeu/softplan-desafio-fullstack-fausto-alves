package com.softplan.gestao.service;

import org.springframework.stereotype.Service;

import com.softplan.gestao.security.UserSS;

import org.springframework.security.core.context.SecurityContextHolder;

@Service
public class UserService {

    public static UserSS authenticated() {

        try {
            return (UserSS) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        }catch (Exception e) {
            return null;
        }
    }

}
