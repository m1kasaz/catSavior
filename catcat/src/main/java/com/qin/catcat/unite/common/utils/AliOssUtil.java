package com.qin.catcat.unite.common.utils;

import cn.hutool.core.lang.UUID;
import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.esotericsoftware.minlog.Log;
import com.qin.catcat.unite.common.constant.Constant;
import com.qiniu.common.Constants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
@Slf4j
public class AliOssUtil {

    @Value("${aliyun.oss.endpoint}")
    private String endpoint;

    @Value("${aliyun.oss.access-key-id}")
    private String accessKeyId;

    @Value("${aliyun.oss.access-key-secret}")
    private String accessKeySecret;

    @Value("${aliyun.oss.bucket-name}")
    private String bucketName;

    /**
     * 上传文件
     * @param file 前端传来的文件对象
     * @return 文件的访问URL
     */
    public String upload(MultipartFile file) throws Exception {
        // 1. 获取上传的输入流
        InputStream inputStream = file.getInputStream();

        String originalFilename = file.getOriginalFilename();

        String suffix = originalFilename.substring(originalFilename.indexOf('.'));

        // 4. 按日期分类目录 (例如: 2026/01/02/uuid.jpg)
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        String datePath = sdf.format(new Date());
        String objectName = datePath + "/" + UUID.randomUUID() + suffix;
        // 5. 创建 OSSClient 实例
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);

        try {
            // 6. 执行上传
            ossClient.putObject(bucketName, objectName, inputStream);

            // 7. 拼接返回的 URL
            // 格式: https://bucket-name.endpoint/object-name
            String url = "https://" + bucketName + "." + endpoint + "/" + objectName;
            log.info("文件上传成功, url = {}", url);
            return url;

        } catch (Exception e) {
            log.info("文件上传失败");
            return null;
        } finally {
            // 8. 关闭 OSSClient
            if (ossClient != null) {
                ossClient.shutdown();
            }
        }
    }
}