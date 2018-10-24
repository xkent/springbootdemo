package com.example;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.codec.digest.DigestUtils;//开发的jar包 使用更方便

public class Md5Utils {

    /*
     * 1.一个运用基本类的实例
     * MessageDigest 对象开始被初始化。该对象通过使用 update 方法处理数据。
     * 任何时候都可以调用 reset 方法重置摘要。
     * 一旦所有需要更新的数据都已经被更新了，应该调用 digest 方法之一完成哈希计算。
     * 对于给定数量的更新数据，digest 方法只能被调用一次。
     * 在调用 digest 之后，MessageDigest 对象被重新设置成其初始状态。
     */
    public static String encrypByMd5(String toEncryptStr) {
        StringBuffer buf = new StringBuffer("");
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(toEncryptStr.getBytes());//update处理
            byte[] encryContext = md.digest();//调用该方法完成计算

            int i;

            for (int offset = 0; offset < encryContext.length; offset++) {//做相应的转化（十六进制）
                i = encryContext[offset];
                if (i < 0) i += 256;
                if (i < 16) buf.append("0");
                buf.append(Integer.toHexString(i));
            }
            //System.out.println("32result: " + buf.toString());// 32位的加密
            //System.out.println("16result: " + buf.toString().substring(8, 24));// 16位的加密

        } catch (NoSuchAlgorithmException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return buf.toString();
    }

    /*
     * 2.使用开发的jar直接应用
     *  使用外部的jar包中的类：import org.apache.commons.codec.digest.DigestUtils;
     *  对上面内容的一个封装使用方便
     */
    public static String encrypByMd5Jar(String context) {
        String md5Str = DigestUtils.md5Hex(context);
        return md5Str;
    }

    public static String toMD5(String plainText) {
        MessageDigest messageDigest = null;
        try {
            messageDigest = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("MD5 error:", e);
        }
        messageDigest.update(plainText.getBytes());
        byte[] by = messageDigest.digest();

        StringBuffer buf = new StringBuffer();

        for (int i = 0; i < by.length; ++i) {
            int val = by[i];
            if (val < 0)
                val += 256;
            else if (val < 16) {
                buf.append("0");
            }
            buf.append(Integer.toHexString(val));
        }
        return buf.toString();
    }
    public static void main(String[] args) {

        String aaa = encrypByMd5Jar("yang");
        System.out.println("aaa="+aaa);
    }
}