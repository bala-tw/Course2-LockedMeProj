package com.lockedMePrototype;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;



public class LockedMePrototype 
{
	static final String folderpath="C:\\Users\\balan\\Desktop\\MyPhase1Project\\SourceCode\\LockedMeFiles";
	
	public static void main(String[] args) 
 {
		//Variable declaration
		Scanner obj=new Scanner(System.in);
		int ch;
		int proceed=1;
	do
		{			
		//Menu	
			displayMenu();
			System.out.println("Enter your choice: ");
			ch=Integer.parseInt(obj.nextLine());
			
			switch(ch)
			{
			
			case 1 : getAllFiles();
			         break;
			case 2 : addFile();
			         break;
			case 3 : removeFile();
	                 break;         
			case 4 : searchFile();
	                 break;
			case 5 : System.out.println("Exiting application");
				     System.exit(0);
	                 break;
			default : System.out.println("Invalid Option");
	                 break;
			}
			System.out.println("***-------Proceeding to Main menu-------****"
					+ "");
			} while (proceed>0);
	obj.close();
 }

/**
 *  Main Menu
 */
     public static void displayMenu()
	{
		System.out.println("**********************************************************************");
		System.out.println("\t\t\tLockedMe.com");
		System.out.println("**********************************************************************");
		System.out.println("****************************************developed by - Balanarenthiran");
		System.out.println("**********************************************************************");
		System.out.println("**********************************************************************");
		System.out.println("1. Display all files");
		System.out.println("2. Add new file");
		System.out.println("3. Delete a file");
		System.out.println("4. Search a file");
		System.out.println("5. Exit");
		System.out.println("**********************************************************************");
	}

	/**
 * List all the files from folder
	 */
    public static void getAllFiles() 
	{
		//List all files and print them
		List<String> fileNames = FileMgr.getAllFiles(folderpath);
		Collections.sort(fileNames); // to sort elements in ascending order
	    fileNames.forEach(f->System.out.println(f));
	}

/**
 * add a new file
 */
	public static void addFile()
	{
		//variable declaration
		 Scanner obj= new Scanner(System.in);
	     String fileName;
	     int linesCount;
	     List<String> content = new ArrayList<String>();
	     
	     //read filename from user
	     System.out.println("Enter file Name: ");
	     fileName=obj.nextLine();
	     
	     
	     //Read no of lines from user
	     System.out.println("Enter how many lines in the file: ");
	     linesCount=Integer.parseInt(obj.nextLine());
	     
	     //Read lines from user
	     for (int i=1;i<=linesCount;i++)
	     {
	    	 System.out.println("Enter line "+i+" :");
	    	 content.add(obj.nextLine());
	     }
	    
	    
	     //Save the content into the file	
	     boolean isSaved= FileMgr.createFiles(folderpath, fileName, content);
	    		 
	    if(isSaved)
	    	System.out.println("File and data saved successfully");
	    else
	    	System.out.println("Error occured. Please contact admin");
	}

/**
 * Remove a file
 */
    public static void removeFile()
    {
    	//variable declaration
    	String fileName;
    	//String fn;
		
    	//get the file from user
    	Scanner obj=new Scanner(System.in);
		System.out.println("Enter a filename to be deleted: ");
		fileName=obj.nextLine();
		
		// for case-sensitivity
		
		List<String> fnl = FileMgr.getAllFiles(folderpath);
		if(fnl.contains(fileName))
		{		
			FileMgr.deleteFiles(folderpath, fileName);
			
			System.out.println("File deleted successfully");
		}	
	else
			System.out.println("Either file not found or access issue");
		
    }

 /**
  * Search file   
  */
    public static void searchFile()
    {
    	//variable declaration
    	String fileName;
    	
    	//get the file from user
		Scanner obj=new Scanner(System.in);
		System.out.println("Enter a filename to be searched: ");
		fileName=obj.nextLine();
		
		// for case-sensitivity
		List<String> fnl = FileMgr.getAllFiles(folderpath);
		if(fnl.contains(fileName))
		{	
		FileMgr.searchFiles(folderpath, fileName);
		
			System.out.println("Search successful");
		}
		else
			System.out.println("Either file not found or access issue");
		
    }
}
