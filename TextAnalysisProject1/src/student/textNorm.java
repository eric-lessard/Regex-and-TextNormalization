package student;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;
import edu.stanford.nlp.util.StringUtils;

public class textNorm {
	public static void removeP (File fileIn) throws FileNotFoundException {
		Scanner s = new Scanner (fileIn);
		s.useDelimiter("\\p{Punct}");	//tokenize at the punctuation
		ArrayList <String> textNorm = new ArrayList<String>();
		while (s.hasNext()) {
			textNorm.add(s.next()); //collect everything in the arrayList
		}
		String formattedString = textNorm.toString()
			    .replace(",", "")  //remove the commas
			    .replace("[", "")  //remove the right bracket
			    .replace("]", "")  //remove the left bracket
			    .trim();
		System.out.println(formattedString);
		
	}
	
	public static void upToLow (File fileIn) throws FileNotFoundException {

		Scanner s = new Scanner (fileIn);
		
		while (s.hasNext()) {
			String temp = s.next();
			
			if (StringUtils.find(temp, "[A-Z]+")) { //use StanfordCoreNLP to find upper case
				temp= temp.toLowerCase(); 			//convert to lowercase
				System.out.print(temp + " ");
			}
			
			else {
				System.out.print(temp + " ");
			}
		}
	}
	public static void main(String[] args) throws FileNotFoundException {
		File input = new File ("input.txt");
		removeP(input);
		System.out.println();
		upToLow(input);

	}

}
