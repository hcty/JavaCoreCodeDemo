package v1ch04.EmployeeTest;

import java.util.Date;
import java.util.GregorianCalendar;

/**
 * This program tests the Employee class
 * 该程序测试Employee类
 */
public class EmployeeTest {
	public static void main(String[] args) {
		//fill the staff array with three Employee objects  使用三个Employee对象填充staff数组
		Employee[] staff = new Employee[3];
		staff[0] = new Employee("Carl Cracker", 75000, 1987, 12, 15);
		staff[1] = new Employee("Harry Hacker", 50000, 1987, 10, 1);
		staff[2] = new Employee("Tony Tester", 40000, 1990, 3, 15);
		//raise everyone's salary by 5%  提高每个人的工资5％
		for (Employee e : staff)
			e.raiseSalary(5);
		//print out information about all Employee objects
		for (Employee e : staff) {
			System.out.println(e.toString());
		}
	}
}

class Employee {
	private String name;
	private double salary;
	private Date hireDayl;

	public String getName() {
		return name;
	}

	public double getSalary() {
		return salary;
	}

	public Date getHireDayl() {
		return hireDayl;
	}

	public void raiseSalary(double byPercent) {
		double raise = salary * byPercent / 100;
		salary += raise;
	}

	public Employee(String n, double s, int year, int month, int dat) {
		name = n;
		salary = s;
		GregorianCalendar calendar = new GregorianCalendar(year, month - 1, dat);
		//GregorianCalendar uses 0 for January   GregorianCalendar在1月使用0
		hireDayl = calendar.getTime();
	}

	@Override public String toString() {
		return "Employee{" + "name='" + name + '\'' + ", salary=" + salary + ", hireDayl=" + hireDayl + '}';
	}
}