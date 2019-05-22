package v1ch05.ArrayListTest;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * This program demonstrates the ArrayList class
 * 该程序演示了ArrayList类
 */
public class ArrayListTest {
	public static void main(String[] args) {
		//fill the staff array list with three Employee objects
		ArrayList<Employee> staff = new ArrayList<Employee>();
		staff.add(new Employee("Carl Cracket", 75000, 1987, 12, 5));
		staff.add(new Employee("Harry Hacker", 500000, 1987, 10, 5));
		staff.add(new Employee("Tony Tester", 40000, 1987, 12, 15));
		//rais everyone's salary by 5%
		for (Employee e : staff) {
			e.raiseSalary(5);
		}
		//print out information about all Employee objects
		for (Employee e : staff) {
			System.out.println(e.toString());
		}
	}
}

class Employee {
	private String name;
	private double salary;
	private Date hireDay;

	public String getName() {
		return name;
	}

	public double getSalary() {
		return salary;
	}

	public Date getHireDay() {
		return hireDay;
	}

	public void raiseSalary(double byPercent) {
		double raise = salary * byPercent / 100;
		salary += raise;
	}

	public Employee(String n, double s, int year, int month, int day) {
		name = n;
		salary = s;
		GregorianCalendar calendar = new GregorianCalendar(year, month - 1, day);
		hireDay = calendar.getTime();
	}

	@Override public String toString() {
		return "Employee{" + "name='" + name + '\'' + ", salary=" + salary + ", hireDay=" + hireDay + '}';
	}
}