package com.common.test.demo42_gaAuth;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Random;

/**
 * Random util.
 */
public class RandomUtil {

	static final Logger logger = LoggerFactory.getLogger(RandomUtil.class);

	static final SecureRandom SECURE_RANDOM = createSecureRandom();

	static final DateTimeFormatter DT_FORMATTER = DateTimeFormatter.ofPattern("MMdd_HHmmss_SSS", Locale.US);

	static final Random RANDOM = new Random();


	public static final int AES_KEY_LENGTH = 32;
	public static final int AES_IV_LENGTH = 16;

	/**
	 * Holds "A-Z".
	 */
	public static final String ALPHABET_UPPER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

	/**
	 * Holds "a-z".
	 */
	public static final String ALPHABET_LOWER = "abcdefghijklmnopqrstuvwxyz";

	/**
	 * Holds "0-9"
	 */
	public static final String DIGITS = "0123456789";

	/**
	 * Holds "0-9a-f"
	 */
	public static final String HEX_DIGITS = "0123456789abcdef";

	/**
	 * Holds words "A~Z a~z 0~9"
	 */
	public static final String WORDS = ALPHABET_UPPER + ALPHABET_LOWER + DIGITS;

	private static SecureRandom createSecureRandom() {
		return new SecureRandom();
	}

	/**
	 * Create a trace id including time, userId, and random.
	 *
	 * @param userId The user id.
	 * @return String.
	 */
	public static String createTraceId(long userId) {
		return String.format("%s_%010d_%04x", LocalDateTime.now().format(DT_FORMATTER), userId,
				RANDOM.nextInt(0x10000));
	}

	/**
	 * Create a random bytes with specific length.
	 *
	 * @param length Length of bytes.
	 * @return Random bytes.
	 */
	public static byte[] createRandomBytes(int length) {
		byte[] buffer = new byte[length];
		SECURE_RANDOM.nextBytes(buffer);
		return buffer;
	}

	/**
	 * Create a secure random string with specific length based on char list.
	 *
	 * @param charList A string that holds chars.
	 * @param length   The length of random string.
	 * @return Random string.
	 */
	public static String createRandomString(String charList, int length) {
		char[] buffer = new char[length];
		int n = charList.length();
		for (int i = 0; i < length; i++) {
			buffer[i] = charList.charAt(SECURE_RANDOM.nextInt(n));
		}
		return new String(buffer);
	}
}
