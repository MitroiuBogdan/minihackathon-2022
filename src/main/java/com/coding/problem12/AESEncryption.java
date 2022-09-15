package com.coding.problem12;

import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Base64;

/**
 * How do encryption & decryption work? We're not going into this now :)
 * As many other languages do, Java offers simple classes that can performs these functions and help us safely
 * store or transmit (secret) information.
 * The requirement is that your implementation contains 2 methods:
 * <p>
 * String-base64 encrypt(String plainText, String-base64 secret, String-base64 iv)
 * <p>
 * String decrypt(String cipherTextBase64, String-base64 secret, String-base64 iv)
 * <p>
 * The algorithm to use for the secret key and IV generation and encryption/decryption is AES/CBC/PKCS5PADDING
 * <p>
 * Extra fun:
 * Decrypt this String: RdxWq6siaV9XW1BDDVEYYMVDZWprjAAEHU5zmkx8uQw=
 * <p>
 * using this key in Base64 format c3VwZXJTZWNyZXRTZWNyZXQ=
 * <p>
 * and this IV: m2j0DbD4pDhHuJ/BV+Yzag==
 * <p>
 * What did you get?
 * <p>
 * Extra reference reading:
 * <a href="https://intranet.ing.net/sites/StaffSupport-global/IT/Documents/ING%20IT%20Security%20Standard%20on%20Cryptography%20v4.3.pdf">ING IT Security Standard on Cryptography</a>
 */
public class AESEncryption {

    private static final String ALGORITHM = "AES/CBC/PKCS5PADDING";
    public static String encrypt(String plainText, String secret, String iv)
            throws NoSuchAlgorithmException, NoSuchPaddingException,
            IllegalBlockSizeException, BadPaddingException, InvalidKeyException, InvalidAlgorithmParameterException {

        byte[] initVector = Base64.getDecoder().decode(iv);
        byte[] decodedKey = Base64.getDecoder().decode(secret);

            IvParameterSpec ivt = new IvParameterSpec(initVector);
            SecretKeySpec keySpec = new SecretKeySpec(decodedKey, "AES");

            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.ENCRYPT_MODE, keySpec, ivt);

            byte[] encrypted = cipher.doFinal(plainText.getBytes());
            return Base64.getEncoder().encodeToString(encrypted);

    }

    public static String decrypt(String cipherText, String secret, String iv)
            throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException,
            IllegalBlockSizeException, BadPaddingException, InvalidAlgorithmParameterException {

        byte[] initVector = Base64.getDecoder().decode(iv);
        byte[] decodedKey = Base64.getDecoder().decode(secret);

        IvParameterSpec ivt = new IvParameterSpec(initVector);
        SecretKeySpec keySpec = new SecretKeySpec(decodedKey, "AES");

        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, keySpec, ivt);
        byte[] original = cipher.doFinal(Base64.getDecoder().decode(cipherText));

        return new String(original);
    }

}
