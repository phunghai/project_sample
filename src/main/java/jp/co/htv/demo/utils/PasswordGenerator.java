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
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(4);
        System.out.println(bCryptPasswordEncoder.encode("123456"));
    }

}
