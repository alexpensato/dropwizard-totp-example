package com.pensatocode.example.services;

import com.pensatocode.example.services.otp.TimeBasedOneTimePasswordGenerator;
import com.pensatocode.example.services.otp.exception.UncheckedNoSuchAlgorithmException;

import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import java.security.Key;
import java.security.NoSuchAlgorithmException;

public class SecretKeyGenerator {

    private final TimeBasedOneTimePasswordGenerator totp;

    public SecretKeyGenerator(TimeBasedOneTimePasswordGenerator totp) {
        this.totp = totp;
    }

    public Key generateKey() {
        final Key key;
        try {
            final KeyGenerator keyGenerator = KeyGenerator.getInstance(totp.getAlgorithm());
            // Key length should match the length of the HMAC output (160 bits for SHA-1, 256 bits
            // for SHA-256, and 512 bits for SHA-512). Note that while Mac#getMacLength() returns a
            // length in _bytes,_ KeyGenerator#init(int) takes a key length in _bits._
            final int macLengthInBytes = Mac.getInstance(totp.getAlgorithm()).getMacLength();
            keyGenerator.init(macLengthInBytes * 8);

            key = keyGenerator.generateKey();
        } catch (NoSuchAlgorithmException e) {
            throw new UncheckedNoSuchAlgorithmException(e);
        }
        return key;
    }

}
