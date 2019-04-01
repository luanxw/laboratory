package com.app.luan.AES;

import org.apache.tomcat.util.codec.binary.Base64;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.SecureRandom;

/**
 * @author: xwluan
 * @Date: 2019-03-28
 * @Description:
 */
public class luanAES {


    private static String content = "dawei.ding@weaver.com.cn@201903291422";
    private static String publicKey = "OA";

    public static byte[] doAES(){
        try {
            //生成构造器
            KeyGenerator keyGenerator  = KeyGenerator.getInstance("AES");
            SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
            random.setSeed(publicKey.getBytes("utf-8"));
            //构造器初始化
            keyGenerator.init(128,random);
            //产生原始对称秘钥
            SecretKey secretKey = keyGenerator.generateKey();
            byte[] keyByte = secretKey.getEncoded();
            //根据字节组生成AES密匙
            SecretKey aesKey = new SecretKeySpec(keyByte,"AES");
            //生成密码器
            Cipher cipher = Cipher.getInstance("AES");
            //密码器初始化
            cipher.init(Cipher.ENCRYPT_MODE , aesKey);
            byte [] byte_encode=content.getBytes("utf-8");
            byte[] result = cipher.doFinal(byte_encode);
            System.out.println("AES_RESULR : "+ Base64.encodeBase64String(result));
          return result;
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }


    public static void undoAES(byte[] text){
        try {

            KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
            SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
            secureRandom.setSeed(publicKey.getBytes("utf-8"));
            keyGenerator.init(128, secureRandom);
            SecretKey secretKey = keyGenerator.generateKey();
            byte[] keybyte = secretKey.getEncoded();
            SecretKey aesKey = new SecretKeySpec(keybyte ,"AES");
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.DECRYPT_MODE , aesKey);
            byte[] result = cipher.doFinal(text);
            System.out.println("undoAES :"+ Base64.encodeBase64String(result));
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }


    public static void main(String[] args) {
        byte[] text = doAES();
        undoAES(text);
    }

}
