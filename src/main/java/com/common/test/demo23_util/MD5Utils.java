package com.common.test.demo23_util;

import org.apache.commons.codec.binary.Base64;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * <p>MD5Utils.java</p>
 * <p/>
 * <p>Copyright (c) 2015</p>
 * <p/>
 * <p>Description:</p>
 *
 * @version 1.0
 * @author: joey.lv
 * <p/>
 * Revision History:
 * 2015/3/23, joey.lv ,Initial Version.
 */
public class MD5Utils {

    /**
     * JAVA标准MD5算法，直接base64编码后的字符串
     * @param src
     * @return
     * @throws NoSuchAlgorithmException
     * @throws IOException
     */
    public static byte[] getDigestByMD5(String src) throws NoSuchAlgorithmException, IOException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        return md.digest(src.getBytes("UTF-8"));
    }

    /**
     * JAVA标准SHA-1算法，直接base64编码后的字符串
     * @param input
     * @return
     * @throws NoSuchAlgorithmException
     * @throws UnsupportedEncodingException
     */
    public static String getHashUsedSHA1(byte[] input) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest md = MessageDigest.getInstance("SHA-1");
        return encodeBase64(md.digest(input));

    }

    public static String sha1(byte[] input) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-1");
            byte[] bytes = md.digest(input);
            return byte2hex(bytes);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public static String sha1(String input) {
        try {
            return sha1(input.getBytes("UTF-8"));
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 将字节数组 BASE64 编码
     * @param b
     * @return
     * @throws UnsupportedEncodingException
     * @see java.util.prefs.Base64#byteArrayToBase64(byte[])
     */
    public static String encodeBase64(byte[] b) throws UnsupportedEncodingException {
        if (b == null) return null;
        Base64 base64 = new Base64();

        return new String(base64.encode(b), "UTF-8");
    }

    private static String byteToHexString(byte b) {
        int n = b;
        if (n < 0)
            n += 256;
        int d1 = n / 16;
        int d2 = n % 16;
        return hexDigits[d1] + hexDigits[d2];
    }


    public static String MD5Encode(String origin) {
       /* if(StringUtils.isEmpty(origin)){
            return null;
        }*/
        String resultString = null;
        try {
            resultString = new String(origin);
            MessageDigest md = MessageDigest.getInstance("MD5");
            resultString =  byte2hex(md.digest(resultString.getBytes("UTF-8"))) ;

        } catch (Exception exception) {
        }
        return resultString;
    }

    private static final String hexDigits[] = { "0", "1", "2", "3", "4", "5",
            "6", "7", "8", "9", "a", "b", "c", "d", "e", "f" };


    //将shor类型转为byte数组
    public static byte[] short2byte(int n) {
        byte b[] = new byte[2];
        b[0] = (byte) (n >> 8);
        b[1] = (byte) n;
        return b;
    }


    //将int类型转为byte数组
    public static byte[] int2byte(int n) {
        byte b[] = new byte[4];
        b[0] = (byte) (n >> 24);
        b[1] = (byte) (n >> 16);
        b[2] = (byte) (n >> 8);
        b[3] = (byte) n;
        return b;
    }

    //将long类型转为byte数组
    public static byte[] long2byte(long n) {
        byte b[] = new byte[8];
        b[0] = (byte) (int) (n >> 56);
        b[1] = (byte) (int) (n >> 48);
        b[2] = (byte) (int) (n >> 40);
        b[3] = (byte) (int) (n >> 32);
        b[4] = (byte) (int) (n >> 24);
        b[5] = (byte) (int) (n >> 16);
        b[6] = (byte) (int) (n >> 8);
        b[7] = (byte) (int) n;
        return b;
    }


    public static short byte2short(byte b[]) {
       /*return  ((short)(b[1]
               | b[0]<<8));*/

        return (short)(b[1] & 0xff
                | (b[0] & 0xff) << 8) ;
    }

    public static int byte2int(byte b[]) {
        return b[3] & 0xff
                | (b[2] & 0xff) << 8
                | (b[1] & 0xff) << 16
                | (b[0] & 0xff) << 24;
    }


    public static long byte2long(byte b[]) {
        return ((long)(b[7] & 0xff))
                | ((long)(b[6] & 0xff)) << 8
                | ((long)(b[5] & 0xff)) << 16
                | ((long)(b[4] & 0xff)) << 24
                | ((long)(b[3] & 0xff)) << 32
                | ((long)(b[2] & 0xff)) << 40
                | ((long)(b[1] & 0xff)) << 48
                | ((long)(b[0] & 0xff))<< 56;
    }


    public static String printByte(byte[] b){
        StringBuffer sb = new StringBuffer();
        if(b==null || b.length==0) return "[]";
        sb.append("[");
        for(int i=0; i<b.length; i++){
            sb.append(b[i]).append(",");
        }
        sb.setCharAt(sb.length()-1, ']');
        return sb.toString();
    }


    public static String byte2hex(byte b[]) {
        if (b == null || b.length == 0) {
            return null;
        }
        StringBuffer strbuf = new StringBuffer(b.length * 2);
        int i;

        for (i = 0; i < b.length; i++) {
            if (((int) b[i] & 0xFF) < 0x10) strbuf.append("0");

            strbuf.append(Long.toString((int) b[i] & 0xFF, 16));
        }
        return strbuf.toString().toUpperCase();
    }

    public static byte[] hex2byte(String s) {
        if (s == null || s.length() == 0) {
            return null;
        }

        byte[] arrB = s.toUpperCase().getBytes();
        int iLen = arrB.length;

        // 两个字符表示一个字节，所以字节数组长度是字符串长度除以2
        byte[] arrOut = new byte[iLen / 2];
        for (int i = 0; i < iLen; i = i + 2) {
            String strTmp = new String(arrB, i, 2);
            arrOut[i / 2] = (byte) Integer.parseInt(strTmp, 16);
        }
        return arrOut;
    }


    public static String SHA1(String decript) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-1");
            digest.update(decript.getBytes());
            byte messageDigest[] = digest.digest();
            // Create Hex String
            StringBuffer hexString = new StringBuffer();
            // 字节数组转换为 十六进制 数
            for (int i = 0; i < messageDigest.length; i++) {
                String shaHex = Integer.toHexString(messageDigest[i] & 0xFF);
                if (shaHex.length() < 2) {
                    hexString.append(0);
                }
                hexString.append(shaHex);
            }
            return hexString.toString();
 
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }
 

}
