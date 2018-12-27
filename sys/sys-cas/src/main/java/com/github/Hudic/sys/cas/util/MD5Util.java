package com.github.Hudic.sys.cas.util;

import sun.misc.BASE64Encoder;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

/**
 * Hudic
 * Created by Makkah at 2018/12/27 14:09
 */
public class MD5Util {

    // 不允许外部new此类的对象(此类只提供static方法)
    private MD5Util() {
    }

    // 对传入的字符串进行加密后返回
    public static String getMD5(String str) {
        try {
            //获得信息摘要算法
            MessageDigest md = MessageDigest.getInstance("md5");
            //拆解成字符数组
            byte[] bs = str.getBytes("UTF-8");
            //更新摘要
            md.update(bs);
            //进行哈希计算，即加密
            byte[] digest = md.digest(bs);
            //把加密后的字节数组进行Base64编码为字符串
            return new BASE64Encoder().encode(digest);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // 截取随机UUID作为随机盐
    public static String getRandomSalt() {
        UUID id = UUID.randomUUID();
        return id.toString().replaceAll("-", "").substring(5, 25);
    }

//    public static void main(String[] args) {
//        System.out.println(getMD5("123456" + "1c4b66b442687d90c8ed"));
//    }

}

