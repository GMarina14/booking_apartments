package com.example.booking_apartments.service.impl;

import java.util.Base64;

public class B64ServiceImpl {

    public static String getEncode(String str) {

        Base64.Encoder encoder = Base64.getEncoder();
        String result = encoder.encodeToString(str.getBytes());
        return result;
    }

    public static String getDecode(String str) {

        Base64.Decoder decoder = Base64.getDecoder();
        byte[] decode = decoder.decode(str.getBytes());
        return new String(decode);
    }

}
