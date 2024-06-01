package com.cc;

import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * @author chencen
 * @date 2024/5/17
 */
@RunWith(JUnit4.class)
public class SftpTest {

    @Test
    //sftp -oPort=22021 PP_SFTP@182.93.45.147
    public void test(){
        String host = "182.93.45.147"; // SFTP服务器地址
        int port = 22021; // SFTP服务器端口
        String username = "PP_SFTP"; // 用户名
        String password = "PPsftp0423"; // 密码

        try {
            JSch jsch = new JSch();

            Session session = jsch.getSession(username, host, port);
            session.setPassword(password);
            session.setTimeout(3000);

            // 设置第一次登陆的时候提示，可选值：(ask | yes | no)
            session.setConfig("StrictHostKeyChecking", "no");
            session.connect();

            ChannelSftp sftpChannel = (ChannelSftp) session.openChannel("sftp");
            sftpChannel.connect();

            System.out.println("Connected to SFTP server successfully.");

            sftpChannel.disconnect();
            session.disconnect();

            System.out.println("Disconnected from SFTP server.");
        } catch (Exception e) {
            System.err.println("Error while connecting to SFTP server: " + e.getMessage());
            e.printStackTrace();
        }
    }

}
