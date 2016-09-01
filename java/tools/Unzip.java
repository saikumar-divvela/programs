package com.sss.tools;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class Unzip {

	static boolean doUnzip(String zipFilename,String searchFileName){
		boolean foundFile = false;
		ZipInputStream zis = null;
    	ZipEntry ze = null;
		try {	 
		  
		if(zipFilename == null || zipFilename.trim().equals(" ")){
			  zipFilename = "C:/project/Hack_a_thon/hackathon4/zip/Verification2";
		  } 
		  
		  if(searchFileName == null || searchFileName.trim().equals(" ")){
			  searchFileName = "Rules/testingENUMinIE.brl";
		  } 
		  
		  final String OUTPUT_FOLDER = zipFilename.substring(0,zipFilename.lastIndexOf("/"))+File.separator+"output";
		  File outputFolder = new File(OUTPUT_FOLDER);
		  
		  if(outputFolder.exists()){
			  if(!outputFolder.isDirectory()) outputFolder.mkdirs();
		  } else {
			  outputFolder.mkdirs();
		  }
		  
		  	byte[] buffer = new byte[1024];
		  
	    	zis = new ZipInputStream(new FileInputStream(zipFilename));
	    	ze = zis.getNextEntry();
	    	System.out.println("Unzipping the file "+zipFilename);    	
	    	while(ze!=null){
	    		String fileName = ze.getName();
	    		if(fileName.equals(searchFileName)){
	    			foundFile = true;
	    		}
	    		File newFile = new File(OUTPUT_FOLDER + File.separator + fileName);
	    		//System.out.println("file unzip : "+ newFile.getAbsoluteFile());
	            if(ze.isDirectory()){
	            	if(!newFile.exists()){
	            		newFile.mkdirs();
	            	}
	            } else {
	            	FileOutputStream fos = new FileOutputStream(newFile);             
		             int len;
		             while ((len = zis.read(buffer)) > 0) {
		        		fos.write(buffer, 0, len);
		             }
		             fos.close();   
		        }
	            ze = zis.getNextEntry();
	         }
	    	 System.out.println("Done");
	     	 if(foundFile){
	     		System.out.println("Found file "+searchFileName);
	     	 } else {
	     		System.out.println("Not found file -"+searchFileName);
	     	 }
	         return foundFile;
		} catch(Exception exp){
			exp.printStackTrace();
			return foundFile;
		} finally {
			try {
				zis.closeEntry();
				zis.close();
			} catch(Exception exp){}	
	    
		}
	}
	public static void main(String args[]) throws Exception{
		doUnzip(null,null);
	}
}
