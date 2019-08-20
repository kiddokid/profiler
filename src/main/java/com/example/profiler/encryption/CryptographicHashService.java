package com.example.profiler.encryption;

import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Service
public class CryptographicHashService implements EncryptionService {

    @Override
    public String hash(String inputStr) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance(EncryptionConstants.SHA256);
        byte[] inputInBytes = inputStr.getBytes(StandardCharsets.UTF_8);
        byte[] inputDigest = messageDigest.digest(inputInBytes);
        BigInteger inputDigestBigInt = new BigInteger(1, inputDigest);
        String hash = inputDigestBigInt.toString(16);
        return make32bitsCompatible(hash);
    }

    private String make32bitsCompatible(String hash) {
        while (hash.length() < 32) {
            hash = "0" + hash;
        }
        return hash;
    }
}
