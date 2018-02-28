package com.common.test.demo23_util;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.shiro.crypto.hash.Md5Hash;

import java.io.UnsupportedEncodingException;

public class EncryptUtils {
	public static final String encryptMD5(String source) {
		if (source == null) {
			source = "";
		}
		Md5Hash md5 = new Md5Hash(source);
		return md5.toHex();
	}

	//把初始密码MD5后的16进制字符串，再加上loginName后再次MD5的

	/**
	 * 加密分3步骤
	 * 1. 得到初始密码的md5的16进制字符串
	 * 2. 把1的结果，加上loginName，再次m5得到16进制字符串
	 * 3. 把2的结果，加上盐的16进制字符串后，再次MD5得到16进制字符串
	 *  把3得到的字符串作为密码存储
	 *
	 * @param initPassword		初始密码
	 * @param loginName			用户名
	 * @param saltHexString		盐的16进制字符串
	 * @return	用以存储的密码信息
	 */
	public static String encodePassword(String initPassword, String loginName, String saltHexString){
		//进行MD5加密,一次直接密码加密，二次:一次结果加上account加密，三次:二次结果加上uuid加密
		String passMd5Frist = DigestUtils.md5Hex(initPassword);
		String passMd5Second = DigestUtils.md5Hex(passMd5Frist + loginName);
		return getStoredPassword(passMd5Second, saltHexString);
	}

	/**
	 * 加密分3步骤
	 * 1. 得到初始密码的md5的16进制字符串
	 * 2. 把1的结果，加上盐的16进制字符串后，再次MD5得到16进制字符串
	 *  把3得到的字符串作为密码存储
	 *
	 * @param initPassword		初始密码
	 * @param saltHexString		盐的16进制字符串
	 * @return	用以存储的密码信息
	 */
	public static String encodePassword(String initPassword, String saltHexString){
		//进行MD5加密,一次直接密码加密，二次:二次结果加上uuid加密
		String passMd5Frist = DigestUtils.md5Hex(initPassword);
		return getStoredPassword(passMd5Frist, saltHexString);
	}

	public static String getStoredPassword(String passMd5Second, String saltHexString){
		//进行MD5加密,一次直接密码加密，二次:一次结果加上account加密，三次:二次结果加上uuid加密
		return DigestUtils.md5Hex(passMd5Second + saltHexString);
	}

	/**
	 * 参考encodePassword()，客户端已经把初始密码处理了2次，发送到后台检验与存储的密码信息是否相符
	 * @param passMD5Second			已经处理了2次	的初始密码信息(16进制字符串)
	 * @param storedPassword	存储的密码信息(16进制字符串)
	 * @param saltHexString		存储的对应的盐(16进制字符串)
	 * @return
	 */
	public static boolean verifyPassword(String passMD5Second, String storedPassword, String saltHexString){
		String password = DigestUtils.md5Hex(passMD5Second + saltHexString);
		return StringUtils.equalsIgnoreCase(password, storedPassword);
	}


	public static void main(String[] args) throws UnsupportedEncodingException {
		String initPassword = "123456";
		String loginName = "test_user";
		String stored = EncryptUtils.encodePassword(initPassword, loginName, "f2ce71232b07056b2406dc2957bbab213b4383e9e018f566");
		System.out.println("stored:" + stored);


		String passMd5Frist = DigestUtils.md5Hex(initPassword);
		String passMd5Second = DigestUtils.md5Hex(passMd5Frist + loginName);
		System.out.println("passMd5Second?" +passMd5Second);

		/*SecureRandom random = new SecureRandom();
		byte[] saltByte = new byte[24];
		random.nextBytes(saltByte);

		String saltHexString = Hex.encodeHexString(saltByte);
		System.out.println(saltHexString);

		String saltedPassword = EncryptUtils.encodePassword(initPassword, loginName, saltHexString);

		System.out.println("saltedPassword:" + saltedPassword);

		String passMd5Frist = DigestUtils.md5Hex(initPassword);
		String passMd5Second = DigestUtils.md5Hex(passMd5Frist + loginName);
		System.out.println("passMd5Second?" +passMd5Second);
		System.out.println("right?" + EncryptUtils.verifyPassword(passMd5Second, saltedPassword, saltHexString));*/

	}


}
