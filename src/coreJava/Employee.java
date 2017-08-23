package coreJava;

import java.util.*;

public class Employee<E> implements Comparable<Employee>{
	

	private String empName;
	private int empId;
	private int empAge;
	
	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public int getEmpAge() {
		return empAge;
	}

	public void setEmpAge(int empAge) {
		this.empAge = empAge;
	}

	public Employee(int empId, String empName, int empAge){
		this.empId = empId;
		this.empName = empName;
		this.empAge = empAge;
	}
	public Employee() {
		// TODO Auto-generated constructor stub
	}

	public String toString() {
	    return "Employee  name=" + empName ;
	}
	
	public static void main(String[] args) {

		List<Employee> empList = new ArrayList<Employee>();
		//Employee[] empArray = new Employee[10];
	
		empList.add(new Employee(3, "Nikhil", 29));
		empList.add(new Employee(2, "Vijay", 35));
		empList.add(new Employee(8, "Jayesh", 29));
		empList.add(new Employee(6, "Swati", 28));
		empList.add(new Employee(5, "Vanita", 29));
		empList.add(new Employee(7, "Devanshi", 24));
		empList.add(new Employee(4, "Meet", 23));
		empList.add(new Employee(9, "Mitul", 26));
		empList.add(new Employee(10, "Niklo", 25));
		empList.add(new Employee(1, "Malay", 24));
		Collections.sort(empList);
		for(Employee emp:empList) {
			System.out.println(emp.getEmpName());
		}
		empList.forEach(System.out::println);

		empList.stream().map(Employee::getEmpName).forEach(System.out::println);
		
		Employee emp = new Employee();
		emp.sortUsingJava8(empList);
		System.out.println(empList);
	}
	
	private void sortUsingJava8(List<E> names){
		Collections.sort(names, (s1,s2) -> ((Comparable<Employee>) s1).compareTo((Employee) s2));
		
	}

	@Override
	public int compareTo(Employee emp) {
		// TODO Auto-generated method stub
		return (this.empAge - emp.empAge);
	}


}

