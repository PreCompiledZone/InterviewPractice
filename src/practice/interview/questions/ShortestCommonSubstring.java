package practice.interview.questions;

import java.util.Arrays;

public class ShortestCommonSubstring {
	
	static int MAX_CHAR = 26; 
   
    static int twoStrings(String s1, String s2)  
    { 
        boolean v[]=new boolean[MAX_CHAR]; 
        int count=0;
        Arrays.fill(v,false); 
        for (int i = 0; i < s1.length(); i++) 
            v[s1.charAt(i) - 'a'] = true; 
          
        for (int i = 0; i < s2.length(); i++)  
            if (v[s2.charAt(i) - 'a'])  
            count++; 
          
        return count;      
    } 
      
    // Driver code 
    public static void main (String[] args)  
    { 
        String str1 = "abdc"; 
        String str2 = "bd"; 
        System.out.println(twoStrings(str1, str2));
		/*
		 * if (twoStrings(str1, str2)) System.out.print("Yes"); else
		 * System.out.print("No");
		 */
    } 

}
