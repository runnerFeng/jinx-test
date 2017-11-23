package com.common.test.demo6_kt;

import org.apache.log4j.Logger;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/**
 * @逻辑说明：
 * @相关配置：
 * @作者： wanghengwei
 * @需求提出人：
 * @日期： 2015年9月11日
 * @版本：
 */
public class ZipUtil {

    private static int k = 1; // 定义递归次数变量

    private final static Logger logger = Logger.getLogger(ZipUtil.class);

    public static boolean zip(String zipFileName, File inputFile) throws IOException {
        boolean isSuccessful = false;
        BufferedOutputStream bo = null;
        ZipOutputStream out = null;
        try {
            logger.info("压缩中...");
            File zipFile = new File(zipFileName);
            out = new ZipOutputStream(new FileOutputStream(
                    zipFileName));
            bo = new BufferedOutputStream(out);
            isSuccessful = zip(out, inputFile, inputFile.getName(), bo);
            logger.info("压缩完成");
        } finally {
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bo != null) {
                try {
                    bo.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
        return isSuccessful;
    }

    public static boolean zip(ZipOutputStream out, File f, String base,
                              BufferedOutputStream bo) throws IOException { // 方法重载
        FileInputStream in = null;
        BufferedInputStream bi = null;
        boolean isSuccessful = false;
        try {
            if (f.isDirectory()) {
                File[] fl = f.listFiles();
                if (fl.length == 0) {
                    out.putNextEntry(new ZipEntry(base + "/")); // 创建zip压缩进入点base
                    logger.info(base + "/");
                }
                for (int i = 0; i < fl.length; i++) {
                    zip(out, fl[i], base + "/" + fl[i].getName(), bo); // 递归遍历子文件夹
                }
                logger.info("第" + k + "次递归");
                k++;
            } else {
                out.putNextEntry(new ZipEntry(base)); // 创建zip压缩进入点base
                logger.info(base);
                in = new FileInputStream(f);
                bi = new BufferedInputStream(in);
                int b;
                while ((b = bi.read()) != -1) {
                    bo.write(b); // 将字节流写入当前zip目录
                }
            }
            bo.flush();
            isSuccessful = true;
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }

            if (bi != null) {
                try {
                    bi.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
        return isSuccessful;
    }

    /**
     * 程序实现了ZIP压缩。共分为2部分 ： 解压（decompression）
     * <p>
     * <p>
     * 在本段代码中，实现的是解压部分；压缩部分见本包中compression部分。
     *
     * @throws IOException
     */

    public static boolean unzip(File zipFile, String dirPath) throws IOException {
        long startTime = System.currentTimeMillis();
        boolean isSuccessful = false;
        ZipInputStream zin = null;
        BufferedInputStream bin = null;
        FileOutputStream out = null;
        BufferedOutputStream bout = null;
        try {
            zin = new ZipInputStream(
                    new FileInputStream(zipFile));// 输入源zip路径
            bin = new BufferedInputStream(zin);
            String parent = dirPath; // 输出路径（文件夹目录）
            File Fout = null;
            ZipEntry entry;
            while ((entry = zin.getNextEntry()) != null
                    && !entry.isDirectory()) {
                Fout = new File(parent, entry.getName());
                if (!Fout.exists()) {
                    (new File(Fout.getParent())).mkdirs();
                }
                out = new FileOutputStream(Fout);
                bout = new BufferedOutputStream(out);
                int b;
                while ((b = bin.read()) != -1) {
                    bout.write(b);
                }
                logger.info(Fout + "解压成功");
            }
            isSuccessful = true;
        } finally {
            if (zin != null) {
                try {
                    zin.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }

            if (bin != null) {
                try {
                    bin.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }

            if (bout != null) {
                try {
                    bout.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }

            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }

        }
        long endTime = System.currentTimeMillis();
        logger.info("耗费时间： " + (endTime - startTime) + " ms");
        return isSuccessful;
    }

}
