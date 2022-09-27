package com.onlie.edu.Utils.jwt;

import cn.hutool.core.util.CharsetUtil;
import cn.hutool.crypto.symmetric.SymmetricAlgorithm;
import cn.hutool.crypto.symmetric.SymmetricCrypto;

/**
 * @Author csz
 * @Date 2022/9/22 18:03
 */
public class PassWorldUtils {

    static byte [] key = "keys".getBytes(CharsetUtil.CHARSET_UTF_8);

    private static SymmetricCrypto aes = new SymmetricCrypto(SymmetricAlgorithm.AES, key);;

    //加密工具
    public static String cryContext(String context){
        String encryptHex = aes.encryptHex(context);
        return encryptHex;
    }

    //解密工具
    public static String decrypContext(String context){
        String s = aes.decryptStr(context, CharsetUtil.CHARSET_UTF_8);
        return s;
    }


}
