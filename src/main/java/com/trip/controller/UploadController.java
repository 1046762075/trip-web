package com.trip.controller;

import com.trip.commons.AliyunOss;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * 文件上传控制器
 */
@RequestMapping(value = "upload")
@Controller
public class UploadController {

	@Autowired
	private AliyunOss aliyunOss;

	/**
	 * 文件上传实现方法
	 */
	private String fileUpload(MultipartFile dropFile) throws IOException {
		System.out.println("时间：" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + "\t文件类型：" + dropFile.getContentType() + "\t文件大小:" + dropFile.getSize() + "\t文件名称：" + dropFile.getOriginalFilename());
		String key = new SimpleDateFormat("yyyy/MM/dd/").format(new Date()) + UUID.randomUUID().toString().replace("-","").substring(0,12) + dropFile.getOriginalFilename().substring(dropFile.getOriginalFilename().lastIndexOf("."));
		return aliyunOss.upload(dropFile.getInputStream(), key, dropFile.getContentType());
	}

	/**
	 * 景点缩图上传
	 */
	@ResponseBody
	@RequestMapping(value = "viewAvatar", method = RequestMethod.POST)
	public Map<String, Object> viewAvatar(MultipartFile dropFile) throws IOException {

		String url = fileUpload(dropFile);
		Map<String, Object> result = new HashMap<>();
		result.put("fileName",url);
		return result;
	}

	@ResponseBody
	@RequestMapping(value = "useravatar", method = RequestMethod.POST)
	public Map<String, Object> userAvatar(MultipartFile dropFile) throws IOException {
		Map<String, Object> result = new HashMap<>();
		String url = fileUpload(dropFile);
		result.put("fileName", url);
		return result;
	}

	/**
	 * 后台内容图片上传
	 * @param dropFile
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "viewContentUpload", method = RequestMethod.POST)
	public Map<String, Object> viewContentUpload(MultipartFile dropFile) throws IOException {
		Map<String, Object> result = new HashMap<>();
		String url = fileUpload(dropFile);
		//传到前端
		result.put("errno",0);
		result.put("data",new String[] {url});
		return result;
	}

	/**
	 * 文件上传
	 * @param dropFile
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "hotelAvatar", method = RequestMethod.POST)
	public Map<String, Object> hotelAvatar(MultipartFile dropFile) throws IOException {
		Map<String, Object> result = new HashMap<>();
		String url = fileUpload(dropFile);
		result.put("fileName", url);
		return result;
	}

	/**
	 * 后台内容图片上传
	 * @param dropFile
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "hotelContentUpload", method = RequestMethod.POST)
	public Map<String, Object> hotelContentUpload(MultipartFile dropFile) throws IOException {
		Map<String, Object> result = new HashMap<>();
		String url = fileUpload(dropFile);
		result.put("errno",0);
		result.put("data",new String[] {url});
		return result;
	}

	/**
	 * 后台内容图片上传
	 * @param dropFile
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "fourmContentUpload", method = RequestMethod.POST)
	public Map<String, Object> fourmContentUpload(MultipartFile dropFile) throws IOException {
		Map<String, Object> result = new HashMap<>();
		String url = fileUpload(dropFile);
		result.put("errno",0);
		result.put("data",new String[] {url});
		return result;
	}
}
