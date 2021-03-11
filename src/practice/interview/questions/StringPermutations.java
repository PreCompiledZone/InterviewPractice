package practice.interview.questions;

public class StringPermutations {
	
	static void stringPermutations(String str,String ans)
	{
		if(str.length() == 0)
		{
			System.out.println(ans+" ");
			return;
		}
		
		for(int i=0;i<str.length();i++)
		{
			char ch = str.charAt(i);
			
			String ros = str.substring(0,i)+str.substring(i+1);
			stringPermutations(ros, ans+ch);
		}
	}
	
	public static void main(String[] args) {
		stringPermutations("dba","");
	}

}
