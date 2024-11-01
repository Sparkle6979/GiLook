package cou.dev.gibackend.utils;


import com.alibaba.fastjson.JSONObject;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.Security;
import java.util.Base64;

/**
 * @author sparkle6979l
 * @version 1.0
 * @data 2024/11/1 14:00
 */
public class AESCryptoUtils {
    private static SecretKey secretKey;

    static {
        Security.addProvider(new BouncyCastleProvider());
        secretKey = getSecretKey();
    }

    // 生成 AES 密钥
    public static SecretKey generateKey() throws Exception {
        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
        keyGen.init(128); // 可以使用 128、192 或 256 位密钥
        return keyGen.generateKey();
    }

    // 生成 AES 密钥
    public static SecretKey getSecretKey() {
        String SECRET_KEY_STRING = "{\"algorithm\":\"AES\",\"destroyed\":false,\"encoded\":\"Praqr4grXCJjRcicMFN+Sw==\",\"format\":\"RAW\"}";
        return JSONObject.parseObject(SECRET_KEY_STRING, SecretKey.class);
    }

    // 加密方法
    public static String encrypt(String data, SecretKey key) throws Exception {
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] encrypted = cipher.doFinal(data.getBytes());
        return Base64.getEncoder().encodeToString(encrypted);
    }

    public static String encrypt(String data) throws Exception {
        return encrypt(data, secretKey);
    }


    // 解密方法
    public static String decrypt(String encryptedData, SecretKey key) throws Exception {
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] decrypted = cipher.doFinal(Base64.getDecoder().decode(encryptedData));
        return new String(decrypted);
    }

    public static String decrypt(String encryptedData) throws Exception {
        return decrypt(encryptedData, secretKey);
    }
}
