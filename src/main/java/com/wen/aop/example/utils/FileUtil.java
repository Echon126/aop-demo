package com.wen.aop.example.utils;

import com.wen.aop.example.data.entity.RemoteDate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.util.UUID;

public class FileUtil {
    private static final Logger logger = LoggerFactory.getLogger(FileUtil.class);

    public static void uploadFile(byte[] file, String filePath, String fileName) throws Exception {
        File targetFile = new File(filePath);
        if (!targetFile.exists()) {
            targetFile.mkdirs();
        }
        FileOutputStream out = new FileOutputStream(filePath + fileName);
        out.write(file);
        out.flush();
        out.close();
    }


    public void save(File file) throws IOException {
        RemoteDate remoteDate = new RemoteDate();
        remoteDate.setName(file.getName());
        long freeMemory = (long) (Runtime.getRuntime().freeMemory() * 0.7);
        if (file.length() > freeMemory) {
            this.logger.debug("装载失败，文件大小与空余内存之比为 " + (file.length() / 1024 / 1024) + "/" + (freeMemory / 1024 / 1024) + " MB");
        }
        byte[] data = Files.readAllBytes(file.toPath());
        remoteDate.setContent(data);
    }

    public static boolean deleteFile(String fileName) {
        File file = new File(fileName);
        // 如果文件路径所对应的文件存在，并且是一个文件，则直接删除
        if (file.exists() && file.isFile()) {
            if (file.delete()) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public static String renameToUUID(String fileName) {
        return UUID.randomUUID() + "." + fileName.substring(fileName.lastIndexOf(".") + 1);
    }
}
