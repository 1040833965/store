package com.cy.store.utils;

import org.springframework.util.DigestUtils;

/**
 * @author 张金铭
 * @version 1.8
 * @Date:2022/7/18 20:26
 * @Description:
 */
@SuppressWarnings({"all"})
public class Md5Password {

    //密码加密的方法
    public static String getMd5Password(String password , String salt){
        for (int i = 0; i < 3; i++) {
            //md5加密算法的调用
           password =  DigestUtils.md5DigestAsHex((salt+password+salt).getBytes()).toUpperCase() ;
        }
        //返回加密后的password
        return password;
    }
}
