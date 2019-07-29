package com.common.test.demo23_util;

import javax.swing.*;
import java.io.*;

/**
 * @Desription: 处理用户头像工具类
 * @Author: rui
 * @Create: 2017-11-20.11:03
 */
public class ImageUtils {


    /**
     * 弹窗读取图片
     *
     * @return data
     */
    public byte[] selectFile() {
        byte[] data = null;
        final JFileChooser chooser = new JFileChooser();
        int returnVal = chooser.showOpenDialog(null);
        File file = null;
        FileInputStream fis = null;
        try {
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                file = chooser.getSelectedFile();
            }
            fis = new FileInputStream(file.getPath());
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            byte[] byff = new byte[1024];
            int numByteRead = 0;
            while ((numByteRead = fis.read(byff)) != -1) {
                bos.write(byff, 0, numByteRead);
            }
            data = bos.toByteArray();
            bos.close();
            fis.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }

    public static void main(String[] args) {
        ImageUtils imageUtils = new ImageUtils();
        byte[] data = null;
        data = imageUtils.selectFile();
        System.out.println("--" + data.length);
    }
}
