package practice.interview.questions;

public class MethodOverloadingExample {
	
	public static void main(String[] args) {
		
		print(1,"amol");
		
		print("amol",2);
		
		System.out.println(add(3,4.5f));
		
		System.out.println(add(3.2f,4));
	}

	static void print(int i,String str)
	{
		System.out.println("argument 1 : "+i+" argument 2 : "+str);
	}
	
	static void print(String str,int i)
	{
		System.out.println("argument 1 : "+str+" argument 2 : "+i);
	}
	
	static float add(int i,float f)
	{
		System.out.println("argument 1 : "+i+" argument 2 : "+f);
		return i+f;
	}
	
	static float add(float f,int i)
	{
		System.out.println("argument 1 : "+f+" argument 2 : "+i);
		return f+i;
	}
}
