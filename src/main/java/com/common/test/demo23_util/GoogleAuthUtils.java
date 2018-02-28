package com.common.test.demo23_util;

import com.juzix.jugo.developer.common.config.CommonConfig;
import com.juzix.jugo.developer.common.config.ConfigurationHelper;
import com.warrenstrange.googleauth.GoogleAuthenticator;
import com.warrenstrange.googleauth.GoogleAuthenticatorKey;
import com.warrenstrange.googleauth.GoogleAuthenticatorQRGenerator;

import java.io.File;

/**
 * Created by lvxy on 2017/2/22.
 */
public class GoogleAuthUtils {

    /**
     * 为content生成Google Authenticator的二维码
     *
     * @param content
     * @param file 二维码图片文件
     * @param format 二维码图片格式
     * @param width
     * @param height
     * @return Google Authenticator的token seed;如果生成不成功，则
     */
    public static String genQrCodeOfGoogleAuth(String content, String file, String format, int width, int height) throws Exception {
        GoogleAuthenticator gAuth = new GoogleAuthenticator();
        GoogleAuthenticatorKey credentials  =  gAuth.createCredentials();
        String qrCodeContent = GoogleAuthenticatorQRGenerator.getOtpAuthTotpURL(null, content, credentials );
        QrCodeUtils.encode(qrCodeContent, width, height, file, format);
        return credentials.getKey();
   }

    public static void main(String[] args) throws Exception {
        ConfigurationHelper.setBasePath("D:\\workspace\\framework\\admin\\trunk\\source_code\\security\\config");

        String userName = "test_user";

        GoogleAuthenticator gAuth = new GoogleAuthenticator();
        GoogleAuthenticatorKey credentials  =  gAuth.createCredentials();
        String qrCodeContent = GoogleAuthenticatorQRGenerator.getOtpAuthTotpURL(null, userName, credentials );

        String fileUrl = CommonConfig.getInstance().getGoogleAuthQrcodePath() + File.separator + userName + "_token.gif";

        QrCodeUtils.encode(qrCodeContent, 300, 300, fileUrl, "png");

    }



}
