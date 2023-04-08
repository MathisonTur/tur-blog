package com.blog.util;

import cn.dev33.satoken.secure.SaSecureUtil;

/**
 * @author tur
 * @version 1.0
 * @date 2023/4/1 16:46
 * @description 加密工具
 */
public class AesEncryptUtils {

    // 秘钥
    final static String key = "turblog";

    /**
     * @author tur
     * @date 2023/4/1 17:05
     * @description 校验密码是否一致
     * @param target 数据库中已加密的密码
     * @param target1 用户输入的密码
     * @return boolean
    */
    public static boolean validate(String target, String target1){
        return target1.equalsIgnoreCase(SaSecureUtil.aesDecrypt(key, target));
    }

    /**
     * @author tur
     * @date 2023/4/1 17:04
     * @description AES加密
     * @param password 密码
     * @return java.lang.String
    */
    public static String aesEncrypt(String password){
        return SaSecureUtil.aesEncrypt(key, password);
    }

    public static void main(String[] args) {
        System.out.println(aesEncrypt("123456"));
    }
}
