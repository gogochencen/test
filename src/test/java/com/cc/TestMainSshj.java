package com.cc;

import net.schmizz.sshj.SSHClient;
import net.schmizz.sshj.sftp.FileAttributes;
import net.schmizz.sshj.sftp.RemoteResourceInfo;
import net.schmizz.sshj.sftp.SFTPClient;
import net.schmizz.sshj.transport.verification.PromiscuousVerifier;

import java.io.IOException;
import java.util.List;

/**
 * @author liuyi
 * @Date 2024/05/20
 */
public class TestMainSshj {

    public static void main(String[] args) {
        String host = "182.93.45.147"; // SFTP服务器地址
        int port = 22021; // SFTP服务器端口
        String username = "PP_SFTP"; // 用户名
        String password = "PPsftp0423"; // 密码
        String remoteFilePath = "/files/pp_ci/10000001518/CERT.pdf";

        try (SSHClient sshClient = new SSHClient()) {
            // 允许连接到未知的主机（在生产环境中，你应该使用更安全的主机密钥验证）
            sshClient.addHostKeyVerifier(new PromiscuousVerifier());
            // 连接到SFTP服务器
            sshClient.connect(host, port);
            // 使用用户名和密码进行身份验证
            sshClient.authPassword(username, password);
            // 获取SFTP客户端实例
            try (SFTPClient sftpClient = sshClient.newSFTPClient()) {
                // 检查远程文件是否存在
                FileAttributes fileAttributes = sftpClient.statExistence(remoteFilePath);
                System.out.println("fileAttributes: " + fileAttributes);
                List<RemoteResourceInfo> ls = sftpClient.ls("/files/pp_ci/");
                ls.forEach(i -> {
                    System.out.println(i.getPath());
                });
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
