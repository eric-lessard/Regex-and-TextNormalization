package student;

import java.io.*;
import java.util.regex.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class regex {
	
	public static void returnEmail (File input) throws FileNotFoundException {
		List<String> allMatches= new ArrayList<String>();
		Pattern p = Pattern.compile("[I][S][B][N][-][1][3][:][ ]+[0-9]{3}[-][0-9]{10}"); //match the isbn
		@SuppressWarnings("resource")
		String content = new Scanner(input).useDelimiter("\\Z").next();
		Matcher m = p.matcher(content);
		while(m.find()) {
			allMatches.add(m.group());	//add all matches to the list
		}
		System.out.println(allMatches);	//print the list
	}

	public static void main(String[] args) throws FileNotFoundException {
		System.out.println("ISBN-13 found in document:");
		System.out.println();
		File fileIn = new File("Input1.txt");
		returnEmail(fileIn);

	}

}
