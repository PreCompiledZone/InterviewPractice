package practice.interview.questions;

import java.util.ArrayList;
import java.util.Collections;

public class SortCollectionUsingComparable {
	
	public static void main(String[] args) {
		
		Employee emp1 = new Employee(1, "amol", 23000);
		Employee emp2 = new Employee(1, "abc", 8900);
		Employee emp3 = new Employee(1, "mohan", 324000);
		Employee emp4 = new Employee(1, "xyz", 1000);
	
		
		ArrayList<Employee> list = new ArrayList<Employee>();
		list.add(emp1);
		list.add(emp2);
		list.add(emp3);
		list.add(emp4);
		
		Collections.sort(list);
		
		list.stream().forEach(s->System.out.println(s.name));
		
	}

	
}

class Employee implements Comparable<Employee>{
	int id;
	String name;
	int salary;
	
	public Employee(int id, String name, int salary) {
		this.id = id;
		this.name = name;
		this.salary = salary;
	}
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public long getSalary() {
		return salary;
	}
	@Override
	public int compareTo(Employee emp) {
		// TODO Auto-generated method stub
		return emp.salary - this.salary;
	}
	
	
	
	
}
