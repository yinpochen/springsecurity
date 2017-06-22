package cn.ishutter.security.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Created by chenyinpo on 2017/6/22.
 */
public class QuickPasswordEncodingGenerator {
    public static void main(String[] args){
        String password = "abc123";
        BCryptPasswordEncoder pe = new BCryptPasswordEncoder();
        System.out.println(pe.encode(password));
    }
}
