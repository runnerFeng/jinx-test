package com.common.test;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

/**
 * @author jinx
 * @date 2017/12/19 18:13
 * Desc:
 */
public class SftpUtil {

    public static List<String> sshSftp(String ip, String user, String psw, int port, String remotePath, List<String> filenames, String localpath) throws Exception {
        Session session;
        Channel channel = null;
        JSch jsch = new JSch();
        List<String> localFilePath = new ArrayList<>();
        if (port <= 0) {
            //连接服务器，采用默认端口
            session = jsch.getSession(user, ip);
        } else {
            //采用指定的端口连接服务器
            session = jsch.getSession(user, ip, port);
        }

        //如果服务器连接不上，则抛出异常
        if (session == null) {
            throw new Exception("session is null");
        }
        //设置登陆主机的密码
        session.setPassword(psw);
        //设置第一次登陆的时候提示，可选值：(ask | yes | no)
        session.setConfig("StrictHostKeyChecking", "no");
        //设置登陆超时时间
        session.connect(30000);
        try {
            //创建sftp通信通道
            channel = session.openChannel("sftp");
            channel.connect(1000);
            ChannelSftp sftp = (ChannelSftp) channel;
            //遍历该目录
            Vector ls = sftp.ls(remotePath);
            //进入服务器指定的文件夹上下两行代码的顺序一定不能乱，
            //不然就会报出2:No Such file的错误error，而不是异常exception了。
            sftp.cd(remotePath);
            Iterator iterator = ls.iterator();
            while (iterator.hasNext()) {
                //得到下一个元素
                Object next = iterator.next();
                if (next instanceof ChannelSftp.LsEntry) {
                    String fileName = ((ChannelSftp.LsEntry) next).getFilename();
                    System.out.println(fileName);
                    //如果是以zip结尾，那就进入
                    if (filenames.contains(fileName)) {
                        File localFile = new File(localpath + "/" + fileName);
                        OutputStream os = new FileOutputStream(localFile);
                        sftp.get(fileName, new FileOutputStream(localFile));
                        os.close();
                        localFilePath.add(localpath + "/" + fileName);
                    }
                }
                System.out.println(next.toString());

            }
            //列出服务器指定的文件列表
//          Vector v = sftp.ls("*.txt");
//          for(int i=0;i<v.size();i++)
//          {
//              System.out.println(v.get(i));
//          }
//
//          //以下代码实现从本地上传一个文件到服务器，如果要实现下载，对换以下流就可以了
//          OutputStream outstream = sftp.put("1.txt");//这两行代码的意思是把e盘 print.txt文件上传到指定SFTP服务器上，命名为1.txt
//          InputStream instream = new FileInputStream(new File("e:/print.txt"));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.disconnect();
            channel.disconnect();
        }
        return localFilePath;
    }

    public static void main(String[] args) throws Exception {
//        String hostname = "192.168.10.85";
        String hostname = "192.168.112.45";
        int port = 22;
        String username = "root";
        String password = "Juzhen123!";
        String remotePath = "/home/nemo/start";
        List<String> filenames = new ArrayList<>();
        String filename = "nohup.out";
        filenames.add(filename);

//		 String originfilename = "C:\\Users\\Downloads\\Downloads.rar";
//		 FavFTPUtil.uploadFileFromProduction(hostname, port, username, password, pathname, filename, originfilename);

        String localpath = "F:\\downLoadFilePath";

        List<String> sssList = sshSftp(hostname, username, password, port, remotePath, filenames, localpath);
        for (String ss : sssList) {
            System.out.println(ss);
        }
    }
}
