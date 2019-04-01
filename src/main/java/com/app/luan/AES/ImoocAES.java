package com.app.luan.AES;
import org.apache.tomcat.util.codec.binary.Base64;

import java.security.Key;
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class ImoocAES {


 private static String content = "dawei.ding@weaver.com.cn@201903061430";
 private static String key = "OA";


    public static void doAES() {
        try {
        //生成KEY ,构造密钥生成器，指定为AES算法,不区分大小写
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
            System.out.println("key is :"+key);
            SecureRandom secureRandom = new SecureRandom(key.getBytes());
            System.out.println("secureRandom is :"+secureRandom.toString());
            //生成一个128位的随机源
        keyGenerator.init(128,secureRandom);
        //3.产生原始对称密钥
        SecretKey secretKey = keyGenerator.generateKey();
            //4.获得原始对称密钥的字节数组
            byte[] keyBytes = secretKey.getEncoded();
        //key转换
        Key key = new SecretKeySpec(keyBytes, "AES");
        //加密
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] result = cipher.doFinal(content.getBytes());
        System.out.println("jdk aes encrypt : " + Base64.encodeBase64String(result));
        //解密
        cipher.init(Cipher.DECRYPT_MODE, key);
        result = cipher.doFinal(result);
        System.out.println("jdk aes desrypt : " + new String(result));
        } catch (Exception e) {
        e.printStackTrace();
        }
    }

  public static void main(String[] args) {

      doAES();
//    String encrypt = doAES();
//      System.out.println("doAES :" + encrypt);


    }

}