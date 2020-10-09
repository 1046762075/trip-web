package com.trip;

import com.trip.commons.AliyunOss;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:oss.xml")
public class AliyunTest {

	@Autowired
  AliyunOss aliyunOss;

    @Test
    public void testOss() throws FileNotFoundException {
        // 本地文件
        InputStream is = new FileInputStream("C:\\Users\\ASUS\\Desktop\\2.jpg");
        // 上传到OSS的路径
        String key = "2020/10/08/img.jpg";
        // 调用上传方法
        String url = aliyunOss.upload(is, key, "image/jpeg");
        // 打印生成的访问路径
        System.out.println(url);
    }

	@Test
	public void del() throws FileNotFoundException {
		// 本地文件
		String key = "2020/10/08/img.jpg";
		// 调用上传方法
		aliyunOss.delete("http://trip-fire.oss-cn-beijing.aliyuncs.com/2020/10/08/img.jpg?Expires=4755702000&OSSAccessKeyId=LTAI4GBrSuBw1fep44Sk71eq&Signature=G2OUJS%2FtIIMYJl0GiaHT%2FX9luLA%3D");
	}
	
	@Test
	public void test(){

    	String str = "test.jsp";
		System.out.println(str.substring(str.lastIndexOf(".") + 1));
	}

}