package com.xixi.util;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.apache.commons.io.FilenameUtils;
import org.aspectj.util.FileUtil;
import org.springframework.stereotype.Component;

import com.xixi.model.FileModel;
@Component("fileUpload")
public class FileUploadUtil implements FileUpload{
	private String getFileExtensionName(String name){
		return FilenameUtils.getExtension(name);
	}
	//shengcUUID作为唯一的名字
	public String newFileName(String fileName){
		String ext=getFileExtensionName(fileName);
		return UUID.randomUUID().toString()+"."+ext;
	}
	//3.实现文件的上传功能，返回新的文件名称
	@Override
	public String uploadFile(String filePath,FileModel filemodel){
		//获取新的唯一名
		String file=newFileName(filemodel.getFilename());
		try {
			FileUtil.copyFile(filemodel.getFile(), new File(filePath,file));
			return file;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}finally{
			filemodel.getFile().delete();
		}
	}
	
}
