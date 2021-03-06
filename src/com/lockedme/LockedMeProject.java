package com.lockedme;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LockedMeProject {
	static final String folderpath = "E:\\MyPhase1Project\\LockedMeFiles";

	public static void main(String[] args)

	{
		int proceed = 1;
		do {

			// Variable declaration
			int ch;

			// Display Menu
			ch = displayMenu();

			switch (ch) {
			case 1:
				getAllFiles();
				break;
			case 2:
				createFiles();
				break;
			case 3:
				deleteFile();
				break;
			case 4:
				searchFile();
				break;
			case 5:
				System.exit(0);
				break;
			default:
				System.out.println("Invalid Option");
				break;
			}

		} while (proceed > 0);
	}

	public static int displayMenu() {
		Scanner obj = new Scanner(System.in);
		int ch;

		System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
		System.out.println("\t\t LockedMe.com ");
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		System.out.println("1. Display all files");
		System.out.println("2. Add new file");
		System.out.println("3. Delete a file");
		System.out.println("4. Search a file");
		System.out.println("5. Exit");
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		System.out.println("Enter your choice:");
		ch = Integer.parseInt(obj.nextLine());

		return ch;
	}

	/**
	 * This is Method is to createModular coding for all Methods.
	 */
	public static void getAllFiles() {
		// Get Files names

		List<String> fileNames = FileManager.getAllFiles(folderpath);

		if (fileNames.size() == 0)
			System.out.println("No files in the directory");
		else {

			System.out.println("FILE LIST IS SEEN BELOW:\n");
			for (String f : fileNames)
				System.out.println(f);
		}
	}

	/**
	 * This Method is to add file to the folder.
	 */
	public static void createFiles() {

		// Variable declaration
		Scanner obj = new Scanner(System.in);
		String fileName;
		int linesCount;
		List<String> content = new ArrayList<String>();

		// Read file name from user
		System.out.println("Enter file Name:");
		fileName = obj.nextLine();

		// Read number of lines from user
		System.out.println("Enter the number of lines in the file:");
		linesCount = Integer.parseInt(obj.nextLine());

		// Read Lines from user
		for (int i = 1; i <= linesCount; i++) {
			System.out.println("Enter line " + i + ":");
			content.add(obj.nextLine());
		}

		// Save the content into the file
		boolean isSaved = FileManager.createFiles(folderpath, fileName, content);

		if (isSaved)
			System.out.println("File and data saved successfully");
		else
			System.out.println("Some error occured.Please contact admin@niccomplex.com");

	}

	/**
	 * This method is to delete file from the folder.
	 */
	public static void deleteFile() {
		// Code for deleting a file
		String fileName;
		Scanner obj = new Scanner(System.in);
		System.out.println("Enter file name to be deleted:");
		fileName = obj.nextLine();

		boolean isDeleted = FileManager.deleteFile(folderpath, fileName);

		if (isDeleted)
			System.out.println("File deleted successfully");
		else
			System.out.println("May be File missing or some not accessible ");

	}

	/**
	 * This method is to search for a file in the folder.
	 */
	public static void searchFile() {
		// Code for Searching a file
		String fileName;
		Scanner obj = new Scanner(System.in);
		System.out.println("Enter file name to be searched:");
		fileName = obj.nextLine();

		boolean isFound = FileManager.searchFile(folderpath, fileName);

		if (isFound)
			System.out.println("File is present in the folder");
		else
			System.out.println("File is not present in the folder ");

	}
}
