package com.world.Y2K.service;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.web.multipart.MultipartFile;

import com.world.Y2K.model.entity.PhotoEntity;


public class PhotoStore {

	private PhotoEntity photoEntity;
	
	public PhotoEntity insertEntity(String photoName, String photoPath, String renameName) {
		System.out.println("photoEntity : " + photoName);
		photoEntity.setPhotoName(photoName);
		photoEntity.setPhotoPath(photoPath);
		photoEntity.setRenameName(renameName);
		
		return photoEntity;
	}
	
	public HashMap<String, Object> insertImage(MultipartFile file, UUID randomUUID, String upladFolderPath) {
		
		String originFileName = file.getOriginalFilename();
		String renameFileName = randomUUID+"_"+originFileName;
		
		Path imageFilePath = Paths.get(upladFolderPath+renameFileName);
		
		try {
			Files.write(imageFilePath, file.getBytes());
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		return getFileInfo(originFileName, renameFileName, imageFilePath);
	}

	private HashMap<String, Object> getFileInfo(String originFileName, String renameFileName, Path imageFilePath) {
		HashMap<String, Object> fileInfo = new HashMap<String, Object>();
		fileInfo.put("originFileName", originFileName);
		fileInfo.put("renameFileName", renameFileName);
		fileInfo.put("imageFilePath", imageFilePath);
		return fileInfo;
	}
	
}
