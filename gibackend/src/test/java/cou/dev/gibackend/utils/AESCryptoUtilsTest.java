package cou.dev.gibackend.utils;

import com.alibaba.fastjson.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author sparkle6979l
 * @version 1.0
 * @data 2024/11/1 14:06
 */
public class AESCryptoUtilsTest {



    @Test
    public void testGenerateKey() throws Exception {
        System.out.println(JSONObject.toJSONString(AESCryptoUtils.generateKey()));
    }
//    @Test
//    public void testDecode() {
//        String token = "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";
//        AESCryptoUtils.encrypt();
//    }
}
