package com.zxt.helper.common.utils;

import org.apache.tomcat.util.codec.binary.Base64;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

/**
 * 数据加解密
 * @author:TanXiao
 * @date:2023/3/23
 */
public class AESUtil {
    /**
     * 加密
     *
     * @param value
     * @return 加密后内容
     */
    public static byte[] encrypt(byte[] value) throws Exception{
        Cipher cipher = Cipher.getInstance(DEFAULT_CIPHER_ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(KEY_ALGORITHM.getBytes("UTF-8"), "AES"));
        return cipher.doFinal(value);
    }

    /**
     * 解密
     * @param value
     * @return 解密后内容
     */
    public static  String decrypt(byte[] value) throws Exception {
        Cipher cipher = Cipher.getInstance(DEFAULT_CIPHER_ALGORITHM);
        SecretKeySpec secretKeySpec = new SecretKeySpec(KEY_ALGORITHM.getBytes("UTF-8"), "AES");
        //使用密钥初始化，设置为解密模式
        cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);
        //执行操作
        return new String(cipher.doFinal(value));
    }

    /**
     * 生成加密秘钥
     *
     * @return
     */
    private static SecretKeySpec getSecretKey(final String password) {
        //返回生成指定算法密钥生成器的 KeyGenerator 对象
        KeyGenerator kg = null;
        try {
            //构造密钥生成器，指定为AES算法,不区分大小写
            kg = KeyGenerator.getInstance(KEY_ALGORITHM);
            //初始化SecureRandom，使用SHA1PRNG算法，SecureRandom类提供加密的强随机数生成器
            SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
            //设置种子
            random.setSeed(password.getBytes());
            //AES 要求密钥长度为 128
            kg.init(128, random);
            //生成一个密钥
            SecretKey secretKey = kg.generateKey();
            // 转换为AES专用密钥
            return new SecretKeySpec(secretKey.getEncoded(), KEY_ALGORITHM);
        } catch (NoSuchAlgorithmException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    //秘钥
    private static final String KEY_ALGORITHM = "AESqbcdefghijkmn";
    //默认的加密算法
    private static final String DEFAULT_CIPHER_ALGORITHM = "AES/ECB/PKCS5Padding";




    public static String encryptA(String content, String password) {
        try {
            //根据指定算法AES创建密码器
            Cipher cipher = Cipher.getInstance(DEFAULT_CIPHER_ALGORITHM);
            // 初始化密码器，第一个参数为加密(Encrypt_mode)或者解密(Decrypt_mode)操作，第二个参数为使用的KEY，
            cipher.init(Cipher.ENCRYPT_MODE, getSecretKey(password));
            // 获取加密内容的字节数组(这里要设置为utf-8)不然内容中如果有中文和英文混合中文就会解密为乱码
            byte[] byteContent = content.getBytes(StandardCharsets.UTF_8);
            // 加密
            byte[] result = cipher.doFinal(byteContent);
            //通过Base64转码返回
            return Base64.encodeBase64String(result).replaceAll("[+]", ".");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
    public static String decryptA(String content, String password) {

        try {
            //实例化，根据指定算法AES创建密码器
            Cipher cipher = Cipher.getInstance(DEFAULT_CIPHER_ALGORITHM);
            //使用密钥初始化，设置为解密模式
            cipher.init(Cipher.DECRYPT_MODE, getSecretKey(password));
            //执行操作
            byte[] result = cipher.doFinal(Base64.decodeBase64(content.replaceAll("[.]", "+")));
            return new String(result, StandardCharsets.UTF_8);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }


//    public static void main(String args[]) throws Exception {
//        byte[] encrypt = AESUtil.encrypt("123456".getBytes());
//        System.out.println(Base64.encodeBase64String(encrypt).replaceAll("[+]", "."));
//        System.out.println(new String(AESUtil.decrypt(AESUtil.encrypt("123456".getBytes()))));
//    }

}
