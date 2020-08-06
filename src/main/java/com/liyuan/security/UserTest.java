package com.liyuan.security;


import org.junit.Test;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.argon2.Argon2PasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;

public class UserTest {
    public static void main(String[] args) {
        User user = (User) User.withDefaultPasswordEncoder()
                .username("liyuan")
                .password("123456")
                .roles("user")
                .build();
        System.out.println(user.getUsername() + ":" + user.getPassword() + ":" + user.getAuthorities());
    }

    @Test
    public void test1() {
        User.UserBuilder userBuilder = User.withDefaultPasswordEncoder();
        User user = (User) userBuilder.username("liyuan")
                .password("123456")
                .roles("USER")
                .build();
        System.out.println(user.getUsername() + ":" + user.getPassword() + ":" + user.getAuthorities());
    }

    @Test
    public void bcryptPasswordEncoderTest() {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(4);
        String result = encoder.encode("mypassword");
        System.out.println(encoder.matches("mypassword", result));
    }

    @Test
    public void argon2() {
        Argon2PasswordEncoder argon2PasswordEncoder = new Argon2PasswordEncoder();
        String result = argon2PasswordEncoder.encode("liyuan");
        System.out.println(argon2PasswordEncoder.matches("liyuan", result));
    }

    @Test
    public void pbkdf2Test() {
        Pbkdf2PasswordEncoder pbkdf2PasswordEncoder = new Pbkdf2PasswordEncoder();
        String result = pbkdf2PasswordEncoder.encode("liyuan");
        System.out.println(pbkdf2PasswordEncoder.matches("liyuan", result));
    }

    @Test
    public void scryptTest() {
        SCryptPasswordEncoder sCryptPasswordEncoder = new SCryptPasswordEncoder();
        String liyuan = sCryptPasswordEncoder.encode("liyuan");
        System.out.println(sCryptPasswordEncoder.matches("liyuan", liyuan));
    }

    @Bean
    public static PasswordEncoder noOpPasswordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }
}
