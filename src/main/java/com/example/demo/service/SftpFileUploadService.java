package com.example.demo.service;

import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.Properties;

@Service
public class SftpFileUploadService {

    private final String SFTP_HOST = "31.97.129.35";
    private final int SFTP_PORT = 22;
    private final String SFTP_USERNAME = "root";
    private final String SFTP_PASSWORD = "Zynlogic@123";
    private final String REMOTE_DIR = "/var/www/employee-images/";

    public String uploadFile(MultipartFile file) throws Exception {
        JSch jsch = new JSch();

        Session session = jsch.getSession(SFTP_USERNAME, SFTP_HOST, SFTP_PORT);
        session.setPassword(SFTP_PASSWORD);

        Properties config = new Properties();
        config.put("StrictHostKeyChecking", "no");
        session.setConfig(config);
        session.connect();

        ChannelSftp channelSftp = (ChannelSftp) session.openChannel("sftp");
        channelSftp.connect();

        InputStream inputStream = file.getInputStream();
        String fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename();

        channelSftp.cd(REMOTE_DIR); // Change to target directory
        channelSftp.put(inputStream, fileName); // Upload

        channelSftp.disconnect();
        session.disconnect();

        return "https://images.bandhammatrimony.com/" + fileName;
    }
}
