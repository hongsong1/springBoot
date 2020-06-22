package com.hs.util;

import org.apache.shiro.crypto.hash.Hash;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: 彭于晏
 * @create: 2020-04-03 11:11
 **/
@Component
@PropertySource("classpath:pwdmacther.properties")
public class PwdMacther {
    @Value("${hashname}")
    private static String hashname;
    @Value("${iteration}")
    private static int iterations;
    public static String pwdMacher(String pwd,String username){
        SimpleHash simpleHash=new SimpleHash("MD5",pwd,username,1024);
        String s = simpleHash.toString();//默认是16进制
        String s1 = simpleHash.toBase64();//这个是base64
        return s;
    }
    public static void main(String[] args) {
        System.out.println(pwdMacher("123", "hs"));
    }
}
