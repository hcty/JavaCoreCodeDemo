package v1ch05.ManagerTest;

import java.util.Date;
import java.util.GregorianCalendar;

/**
 * This program demonstrates inheritance
 * 该程序演示了继承
 */
public class ManagerTest {
	public static void main(String[] args) {
		//consturct a Manage object
		Manage boss = new Manage("Carl Cracker", 80000, 1987, 12, 15);
		boss.setBonus(5000);
		Employee[] staff = new Employee[3];
		// fill the staff array with Manager and Employee objects
		staff[0] = boss;
		staff[1] = new Employee("Harry Hacker", 50000, 1989, 10, 1);
		staff[2] = new Employee("Tommy Tester", 40000, 1990, 3, 15);
		// print out information about all Employee objects
		for (Employee e : staff)
			System.out.println("name=" + e.getName() + ",salary=" + e.getSalary());
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
}

class Manage extends Employee {
	private double bouns;

	public Manage(String n, double s, int year, int month, int day) {
		super(n, s, year, month, day);
		bouns = 0;
	}

	public double getSalary() {
		double baseSalary = super.getSalary();
		return baseSalary + bouns;
	}

	public void setBonus(double b) {
		bouns = b;
	}
}