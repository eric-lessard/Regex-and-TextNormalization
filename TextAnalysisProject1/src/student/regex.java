package student;

import java.io.*;
import java.util.regex.*;
import java.util.Scanner;
public class regex {
	
	public static void returnEmail (File input) throws FileNotFoundException {
		Pattern p = Pattern.compile("(\\w+\\.?\\w+)(@)(\\w+)(\\.)(com|edu|net|org)(\\.?|\s?)");
		boolean match =false;
		Scanner fileReader = new Scanner(input);
		while (fileReader.hasNext()) {
			String temp = fileReader.next();
			Matcher m= p.matcher(temp);
			match= m.matches();	
			
			if (match) {
				temp= temp.replaceAll("\\.$", "");
				System.out.println(temp);
			}
		}
		fileReader.close();
		
	}
	
	public static void returnTime (File input) throws FileNotFoundException {
		Pattern p = Pattern.compile("(\\(*)([0-9]{1,2})(:)([0-5])([0-9])(\\p{Blank}*)(PM$|AM$|pm$|am$)");
		boolean match =false;
		Scanner fileReader = new Scanner(input);
		while (fileReader.hasNext()) {
			String temp = fileReader.next();
			Matcher m= p.matcher(temp);
			match= m.matches();	
			
			if (match) {
				temp = temp.replaceAll("[()]", "");
				System.out.println(temp);
			}
		}
		fileReader.close();
	}
	public static void main(String[] args) throws FileNotFoundException {
		System.out.println("Emails found in document: ");
		System.out.println();
		File fileIn = new File("Input.txt");
		returnEmail(fileIn);
		System.out.println();
		System.out.println("Times found in document:");
		System.out.println();
		
		returnTime(fileIn);

	}

}
