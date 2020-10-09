package com.trip.commons;

import com.aliyun.oss.OSS;
import com.aliyun.oss.model.ObjectMetadata;
import org.apache.http.HttpHost;
import org.apache.http.client.utils.URIUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Date;

/**
 * 阿里云OSS对象存储服务工具类
 * <p>
 * Author:Holmofy
 */
@Component
public class AliyunOss {

	@Autowired
    private OSS ossClient;

    @Value("${aliyun.oss.bucket.name}")
    private String bucketName;

    public String upload(InputStream is, String path, String contentType) {
        ObjectMetadata metadata = new ObjectMetadata();
        metadata.setContentType(contentType);
        ossClient.putObject(bucketName, path, is, metadata);
        URL url = generateUrl(path);
		// http://trip-fire.oss-cn-beijing.aliyuncs.com/2020/10/08/c531321f5cf6.jpg?Expires=4755742888&OSSAccessKeyId=LTAI4GBrSuBw1fep44Sk71eq&Signature=jyxOISDKksHAUPEKl0Hki7ZIpII%3D
        return url.toString();
    }

	public void delete(String ossKey){
    	if(ossKey != null && ossKey.length() > 27){
			ossKey = ossKey.split("\\?")[0];
			ossKey = ossKey.substring(ossKey.length() - 27);
		}
		// 2020/10/08/b3435543b8b0.jpg
		ossClient.deleteObject(bucketName, ossKey);
	}

	/**
     * 生成URL
     *
     * @param key 上传资源的标识
     * @return 生成的URL
     */
    public URL generateUrl(String key) {
        // 100年不过期
        final long duration = 1000L * 60L * 60L * 24L * 365L * 100L;
        long time = System.currentTimeMillis() + duration;
        Date expiration = new Date(time);
        return ossClient.generatePresignedUrl(bucketName, key, expiration);
    }

}