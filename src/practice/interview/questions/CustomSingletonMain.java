package practice.interview.questions;

/**
 * 
 * @author amol
 *
 */
class CustomSingleton {

	String name;
	
	// you can have default private constructor to create object
	private CustomSingleton(String name) {
		this.name = name;
	}

	private static CustomSingleton customeSingletonClass = null;

	public static CustomSingleton getInstance() {
		if (customeSingletonClass == null)
			customeSingletonClass = new CustomSingleton("SingletonClass");

		return customeSingletonClass;
	}

}

// driver class
public class CustomSingletonMain {
	public static void main(String[] args) {

		CustomSingleton obj1 = CustomSingleton.getInstance();
		CustomSingleton obj2 = CustomSingleton.getInstance();
		System.out.println(obj1.name);
		System.out.println(obj2.name);

	}
}
