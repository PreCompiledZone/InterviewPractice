package interview.test.solutions;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BinarySearchWordFromWordList {

	// read word array from file seperated by comma(,)
	static String[] readFile(String fileLocation) throws FileNotFoundException {
		Scanner inFile1 = new Scanner(new File(fileLocation)).useDelimiter(",\\s*");

		List<String> temps = new ArrayList<String>();

		while (inFile1.hasNext()) {
			temps.add(inFile1.next());
		}
		inFile1.close();

		return temps.toArray(new String[0]);

	}

	// binary search for given word in String[]
	static int binarySearch(String[] wordsArray, String word) {
		int l = 0, r = wordsArray.length - 1;
		while (l <= r) {
			int m = l + (r - l) / 2;

			int res = word.compareTo(wordsArray[m]);

			// Check if x is present at mid
			if (res == 0)
				return m;

			// If x greater, ignore left half
			if (res > 0)
				l = m + 1;

			// If x is smaller, ignore right half
			else
				r = m - 1;
		}

		return -1;
	}

	// main class to run functionality
	public static void main(String[] args) throws FileNotFoundException {

		String fileLocation = "/home/amol/words.txt";
		String[] wordsArray = readFile(fileLocation);
		String word = "ide"; 
        int result = binarySearch(wordsArray, word); 
  
        if (result == -1) 
            System.out.println("Element not present"); 
        else
            System.out.println("Element found at index " + result); 
	}

}
