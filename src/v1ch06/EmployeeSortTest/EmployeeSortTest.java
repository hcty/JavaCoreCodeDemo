package v1ch06.EmployeeSortTest;

import java.util.Arrays;

/**
 * This program demonstrates the use of the Comparable interface
 * 该程序演示了Comparable接口的使用
 */
public class EmployeeSortTest {
	public static void main(String[] args) {
		Employee[] staff = new Employee[3];
		staff[0] = new Employee("Harry Hacker", 35000);
		staff[1] = new Employee("Carl Cracker", 75000);
		staff[2] = new Employee("Tony Tester", 38000);
		Arrays.sort(staff);
		// print out information about all Employee objects
		for (Employee e : staff) {
			System.out.println(e.toString());
		}
	}
}

class Employee implements Comparable<Employee> {
	private String name;
	private double salary;

	public String getName() {
		return name;
	}

	public double getSalary() {
		return salary;
	}

	public void raiseSalary(double byPercent) {
		double raise = salary * byPercent / 100;
		salary += raise;
	}

	@Override public int compareTo(Employee o) {
		if (salary < o.salary)
			return -1;
		if (salary > o.salary)
			return 1;
		return 0;
	}

	public Employee(String name, double salary) {
		this.name = name;
		this.salary = salary;
	}

	@Override public String toString() {
		return "Employee{" + "name='" + name + '\'' + ", salary=" + salary + '}';
	}
}