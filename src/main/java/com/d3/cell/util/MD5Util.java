package com.d3.cell.util;

import org.springframework.util.DigestUtils;

public class MD5Util {
    public static String md5(String plainText){
       return  DigestUtils.md5DigestAsHex(plainText.getBytes());
    }
}
