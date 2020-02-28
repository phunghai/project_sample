package jp.co.htv.demo.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Class utility for string password generator.
 * 
 * @author Nguyen Phung Hai
 *
 */
public class PasswordGenerator {

    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(4);
        System.out.println(encoder.encode("123456"));
    }

}
