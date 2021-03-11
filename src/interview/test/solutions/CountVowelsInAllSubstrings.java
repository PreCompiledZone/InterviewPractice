package interview.test.solutions;

/**
 * 
 * @author amol
 *
 * Program to find the presence of vowels in all possible sub-strings of a string.
 */
public class CountVowelsInAllSubstrings {

	static int countVowel(String s) {
		int n = s.length(); 
        int arr[] = new int[n]; 
  
        for (int i = 0; i < n; i++) { 
  
            if (i == 0) 
                arr[i] = n; 
  
            else
                arr[i] = (n - i) + arr[i - 1] - i; 
        } 
  
        int sum = 0; 
        for (int i = 0; i < n; i++) { 
            char ch = s.charAt(i); 
            // Check if character is a vowel 
            if (ch == 'a' || ch == 'e' || ch == 'i'
                || ch == 'o' || ch == 'u') 
                sum += arr[i]; 
        } 
  
        return sum; 
	}
	
	public static void main(String[] args) {
		
		// test case 1
		String test1 = "abc";
		int res1 = countVowel(test1);
		System.out.println("Test case 1 :"+res1);
		
		// test case 2
		String test2 = "daceh";
		int res2 = countVowel(test2);
		System.out.println("Test case 2 :"+res2);
		
	}
	
}
