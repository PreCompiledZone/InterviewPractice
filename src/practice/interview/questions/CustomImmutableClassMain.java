package practice;

/**
 * 
 * @author amol
 *
 *         After object creation user can not change value of name variable as
 *         it is private and public setter method is not available
 */
final class CustomImmutableClass {

	private final String name;

	public CustomImmutableClass(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

}

public class CustomImmutableClassMain
{
	public static void main(String[] args) {
		CustomImmutableClass obj = new CustomImmutableClass("Amol");
		System.out.println(obj.getName());
		
		// obj.name = "Nilwarn"; - not accessible because this is private variable
	}
}
