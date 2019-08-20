package com.example.profiler.encryption;

import java.security.NoSuchAlgorithmException;

public interface EncryptionService {

    String hash(String inputStr) throws NoSuchAlgorithmException;
}
