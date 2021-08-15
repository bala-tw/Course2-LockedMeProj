package com.lockedMePrototype;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;						

public class FileMgr 
{
	/**
	 * This method will return all the local files from folders
	 * @param folderpath
	 * @return List<String>
	 */
    public static List<String> getAllFiles(String folderpath)
 {
    	
   /*
    * Creating file object
    * Getting all files into FileArray
    * Declare a list to store filenames
    * return filenames
   */
    	
    	File fl=new File(folderpath);
    	File[] listOfFiles= fl.listFiles();
    	List<String> fileNames=new ArrayList<String>();
    	
    	for(File f:listOfFiles)
    		fileNames.add(f.getName());
 
    	return fileNames;
 }


/**
 * This method will create or append content into the specified file
 * @param folderpath
 * @param fileName
 * @param content
 * @return boolean
 */
 public static boolean createFiles(String folderpath, String fileName, List<String> content)
 {
  try
  {
	 
	 File fl= new File(folderpath, fileName);
	 FileWriter fw = new FileWriter(fl);
	  
	  for (String s:content)
	  {
		  fw.write(s+"\n");
	  }
	  fw.close();
	  return true;
  }
  catch(Exception Ex)
   {
	  return false;
   }
 }


/**
 * This method will delete the specified file
 * @param folderpath
 * @param fileName
 */
public static boolean deleteFiles(String folderpath, String fileName) 
  {
	
	File file=new File(folderpath+"\\"+fileName);
	try
	{
	  if(file.delete())
		  return true;
	  else
		  return false;
	}
	catch(Exception Ex)
	 {
		return false;
	 }
	}


/**
 * Search for the requested file
 * @param folderpath
 * @param fileName
 * @return
 */
public static boolean searchFiles(String folderpath, String fileName)
 {
	File file=new File(folderpath+"\\"+fileName);
	
	if(file.exists())
		return true;
	else
		return false;

 }

}
