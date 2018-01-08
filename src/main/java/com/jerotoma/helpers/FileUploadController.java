package com.jerotoma.helpers;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;

import com.jerotoma.model.Media;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;



public class FileUploadController {
	
	private static final Logger logger = LoggerFactory.getLogger(FileUploadController.class);
	private static FileUploadController fileUploadeController;
	
	private String resourcePath = "/resources/uploads";
    
	public FileUploadController(){
		
	}
	
	public static FileUploadController getInstance() {
		if(fileUploadeController == null)
			fileUploadeController = new FileUploadController();
	  return fileUploadeController;		
	}
	
	
	public Map<String, Object> uploadFileHandler(String name,MultipartFile file, ServletContext context,String folderName) {
		Map<String, Object>  map = new HashMap<String, Object>();
		String message;
		
		
		
		if (!file.isEmpty()) {
						
			try {
				byte[] bytes = file.getBytes();
			
				//BufferedImage mBufferedImage = Media.processFile(bytes);
				
				// Creating the directory to store file
				String rootPath = context.getRealPath(resourcePath); 
							
				File dir = new File(rootPath + File.separator + folderName);
				if (!dir.exists())
					dir.mkdirs();
              
				// Create the file on server
				File serverFile = new File(dir.getAbsolutePath() + File.separator + name);
				BufferedOutputStream stream = new BufferedOutputStream(
						new FileOutputStream(serverFile));
				stream.write(bytes);
				stream.close();

				logger.info("Server File Location="	+ serverFile.getAbsolutePath());
				
				Media media = new Media();
				media.setTitle(name);
				media.setType(file.getContentType());
				media.setAbsolutPath(serverFile.getAbsolutePath());
				media.setSize(file.getSize());
				media.setSrc(context.getContextPath()+ resourcePath +"/"+folderName+"/"+name);
				media.setDescription("");
				message = "You successfully uploaded file=" + serverFile.getAbsolutePath();
				
				
				map.put("media", media);
				map.put("success", true);
				map.put("message", message);
				
				System.out.println("The context : "+ media.getSrc());
				
				return map; 
			} catch (Exception e) {
				message = "You failed to upload " + name + " => " + e.getMessage();
				map.put("success", false);
				map.put("message", message);
				
				return map;
			}
		} else {
			
			message = "You failed to upload " + name + " because the file was empty.";
			map.put("success", false);
			map.put("message", message);
			
			return map; 
		}
	}
	
	public String uploadMultipleFileHandler(String[] names, MultipartFile[] files, ServletContext context, String folderName) {

		if (files.length != names.length)
			return "Mandatory information missing";

		String message = "";
		for (int i = 0; i < files.length; i++) {
			MultipartFile file = files[i];
			String name = names[i];
			try {
				byte[] bytes = file.getBytes();

				// Creating the directory to store file
				String rootPath = context.getRealPath("/resources/uploads"); //this.getClass().getResource("/uploads");    //System.getProperty("catalina.home");
				File dir = new File(rootPath + File.separator + folderName);
				if (!dir.exists())
					dir.mkdirs();

				// Create the file on server
				File serverFile = new File(dir.getAbsolutePath()
						+ File.separator + name);
				BufferedOutputStream stream = new BufferedOutputStream(
						new FileOutputStream(serverFile));
				stream.write(bytes);
				stream.close();

				logger.info("Server File Location="
						+ serverFile.getAbsolutePath());

				message = message + "You successfully uploaded file=" + name
						+ "";
			} catch (Exception e) {
				return "You failed to upload " + name + " => " + e.getMessage();
			}
		}
		return message;
	}
	
}
