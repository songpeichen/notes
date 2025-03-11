package com.example.notesdemo;

import cn.hutool.core.io.FileUtil;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class Base64Test {
    public static void main(String[] args) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        // 字符串转base64
        String s = "Hello World";
        String encodeStr = Base64.getEncoder().encodeToString(s.getBytes(StandardCharsets.UTF_8));
        System.err.println(encodeStr);


        // base64转字符串
        byte[] decode = Base64.getDecoder().decode(encodeStr);
        System.err.println(new String(decode));


        // 文件转base64
        byte[] fileBytes = FileUtil.readBytes("/Users/song/Desktop/常用.txt");
        String fileString = Base64.getEncoder().encodeToString(fileBytes);
        System.err.println(fileString);



        // base64写入文件  内容与读取的文件相同
        FileUtil.writeBytes(Base64.getDecoder().decode(fileString),"/Users/song/Desktop/常用1.txt");



        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        keyGenerator.init(128);
        SecretKey secretKey = keyGenerator.generateKey();
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE,secretKey);


        // 对字符串进行AES加密，手动指定加密key
String k =  "keykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykey"+
"keykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykey"+
"keykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykeykey";
        String substring = k.substring(0, 16);
        SecretKeySpec secretKeySpec = new SecretKeySpec(substring.getBytes(StandardCharsets.UTF_8), "AES");
        Cipher cipher1 = Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher1.init(Cipher.ENCRYPT_MODE,secretKeySpec);
        byte[] bytes = cipher1.doFinal("inputString".getBytes(StandardCharsets.UTF_8));
        String s1 = Base64.getEncoder().encodeToString(bytes);
        System.err.println(s1);

        // 对字符串进行AES解密，手动指定加密key
        Cipher cipher2 = Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher2.init(Cipher.DECRYPT_MODE,secretKeySpec);
        byte[] bytes1 = cipher2.doFinal(Base64.getDecoder().decode("hlYLaePJoC8cX9Qbhgjm4A=="));
        System.err.println(new String(bytes1));

    }
}
