package com.example.booking_apartments.service.impl;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Base64;

@RequiredArgsConstructor
public class B64ServiceImpl {

    private Logger log = LoggerFactory.getLogger(B64ServiceImpl.class);

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
