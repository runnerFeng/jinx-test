package com.common.test.demo42_gaAuth;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;
import java.security.Key;

public class AESUtil {

	static final String CIPHER_NAME = "AES/CBC/PKCS5Padding";

	public static String encrypt(String message, String key, String iv) {
		return encrypt(message, key.getBytes(StandardCharsets.UTF_8), iv);
	}

	public static String encrypt(String message, byte[] keyBytes, String iv) {
		return encrypt(message, keyBytes, iv.getBytes(StandardCharsets.UTF_8));
	}

	public static String encrypt(String message, byte[] keyBytes, byte[] ivBytes) {
		if (keyBytes.length != 32) {
			throw new IllegalArgumentException("key must be 32 bytes.");
		}
		if (ivBytes.length != 16) {
			throw new IllegalArgumentException("iv must be 16 bytes.");
		}
		Key keySpec = new SecretKeySpec(keyBytes, "AES");
		IvParameterSpec ivSpec = new IvParameterSpec(ivBytes);
		try {
			Cipher cipher = Cipher.getInstance(CIPHER_NAME);
			cipher.init(Cipher.ENCRYPT_MODE, keySpec, ivSpec);
			byte[] result = cipher.doFinal(message.getBytes(StandardCharsets.UTF_8));
			return ByteUtil.toHexString(result);
		} catch (GeneralSecurityException e) {
			throw new RuntimeException();
		}
	}

	public static String decrypt(String encryptedHexStr, String key, String iv) {
		return decrypt(encryptedHexStr, key.getBytes(StandardCharsets.UTF_8), iv);
	}

	public static String decrypt(String encryptedHexStr, byte[] keyBytes, String iv) {
		return decrypt(encryptedHexStr, keyBytes, iv.getBytes(StandardCharsets.UTF_8));
	}

	public static String decrypt(String encryptedHexStr, byte[] keyBytes, byte[] ivBytes) {
		if (keyBytes.length != 32) {
			throw new IllegalArgumentException("key must be 32 bytes.");
		}
		if (ivBytes.length != 16) {
			throw new IllegalArgumentException("iv must be 16 bytes.");
		}
		Key keySpec = new SecretKeySpec(keyBytes, "AES");
		IvParameterSpec ivSpec = new IvParameterSpec(ivBytes);
		try {
			Cipher cipher = Cipher.getInstance(CIPHER_NAME);
			cipher.init(Cipher.DECRYPT_MODE, keySpec, ivSpec);
			byte[] encryptedBytes = ByteUtil.fromHexString(encryptedHexStr);
			byte[] result = cipher.doFinal(encryptedBytes);
			return new String(result, StandardCharsets.UTF_8);
		} catch (GeneralSecurityException e) {
			throw new RuntimeException();
		}
	}
}
