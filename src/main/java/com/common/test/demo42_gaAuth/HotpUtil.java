package com.common.test.demo42_gaAuth;

import com.google.common.primitives.Ints;
import com.google.common.primitives.Longs;
import org.apache.commons.codec.binary.Base32;

import java.util.Arrays;
import java.util.regex.Pattern;

public class HotpUtil {

	static final Pattern CODE_PATTERN = Pattern.compile("^[0-9]{6}$");

	public static boolean validateGAAuth(String secretKey, String passCode) {
		return validateGAAuth(secretKey, passCode, true);
	}

	public static boolean validateGAAuth(String secretKey, String passCode, boolean alsoCheckPrev30Sec) {
		if (!validatePattern(passCode)) {
			return false;
		}
		long ts = System.currentTimeMillis() / 30000L;
		byte[] key = new Base32().decode(secretKey);
		String token = HotpUtil.hotp(key, ts);
		if (token.equals(passCode)) {
			return true;
		}
		// re-check prev 30 sec:
		if (alsoCheckPrev30Sec) {
			ts = ts - 1L;
			token = HotpUtil.hotp(key, ts);
			if (token.equals(passCode)) {
				return true;
			}
		}
		return false;
	}

	public static String hotp(byte[] gaKey, long ts) {
		byte[] tsBytes = Longs.toByteArray(ts);
		byte[] sha1 = HashUtil.hmacSha1(tsBytes, gaKey);
		int offset = 0xf & sha1[19];
		byte[] trunk = Arrays.copyOfRange(sha1, offset, offset + 4);
		int result = 0x7fffffff & Ints.fromByteArray(trunk);
		return String.format("%06d", (result % 1000000));
	}

	static boolean validatePattern(String passCode) {
		return CODE_PATTERN.matcher(passCode).matches();
	}
}
