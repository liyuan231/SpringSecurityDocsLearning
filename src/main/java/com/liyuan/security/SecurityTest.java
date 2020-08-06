package com.liyuan.security;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class SecurityTest {
    public static void main(String[] args) {
        DelegatingPasswordEncoder passwordEncoder = (DelegatingPasswordEncoder) PasswordEncoderFactories.createDelegatingPasswordEncoder();
        System.out.println(passwordEncoder.encode("password"));
        PasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
//        passwordEncoder.setDefaultPasswordEncoderForMatches(bCryptPasswordEncoder);
        System.out.println(bCryptPasswordEncoder.encode("password"));

        System.out.println(bCryptPasswordEncoder.matches("password", "$2a$10$di.LWQO51P.j4F/guhhwH.7do912FLSaGB48KQVUzZ3MVnvj05dKa"));
        System.out.println(passwordEncoder.matches("password", "$2a$10$fXtTlIzAmcka/ipuJC19TuFHc5vgPbYtMTq6.gO6VszcXhQRhQw72"));
        System.out.println(passwordEncoder);
    }
}
