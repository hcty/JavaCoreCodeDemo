package v1ch05.EqualsTest;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Objects;

/**
 * This program demonstrates the equals method
 * 该程序演示了equals方法
 */
public class EqualsTest {
	public static void main(String[] args) {
		Employee alice1 = new Employee("Alica Adams", 75000, 1987, 12, 15);
		Employee alice2 = alice1;
		Employee alice3 = new Employee("Alica Adams", 75000, 1987, 12, 15);
		Employee bob = new Employee("Bob Brandson", 50000, 1989, 10, 1);
		System.out.println("alice1 == alice2:" + (alice1 == alice2));
		System.out.println("alice1 == alice3:" + (alice1 == alice3));
		System.out.println("alice1.equals(alice3):" + alice1.equals(alice3));
		System.out.println("alice1.equals(bob):" + alice1.equals(bob));
		System.out.println("bob.toString():" + bob);
		Manager carl = new Manager("Carl Cracker", 80000, 1987, 12, 15);
		Manager boss = new Manager("Carl Cracker", 80000, 1987, 12, 15);
		boss.setBouns(5000);
		System.out.println("boss.toString():" + boss);
		System.out.println("carl.equals(boss):" + carl.equals(boss));
		System.out.println("alice1.hashCode():" + alice1.hashCode());
		System.out.println("alice3.hashCode():" + alice3.hashCode());
		System.out.println("bob.hashCode():" + bob.hashCode());
		System.out.println("carl.hashCode():" + carl.hashCode());
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

	public Employee(String n, double s, int year, int month, int day) {
		name = n;
		salary = s;
		GregorianCalendar calendar = new GregorianCalendar(year, month - 1, day);
		hireDay = calendar.getTime();
	}

	public void raiseSalary(double byPercent) {
		double raise = salary * byPercent / 100;
		salary += raise;
	}

	public boolean equals(Object otherobject) {
		//a quick test to see if the object are identical 快速测试以查看对象是否相同
		if (this == otherobject)
			return true;
		//must return false if the explicit parameter is null 如果explicit参数为null，则必须返回false
		if (otherobject == null)
			return false;
		//if the classes don't match,they can't be queal
		if (getClass() != otherobject.getClass())
			return false;
		//now we know otherObject is a not -null Employee
		Employee other = (Employee) otherobject;
		//test whethere the fields have inentical values 测试字段是否具有相同的值
		return name.equals(other.name) && salary == other.salary && hireDay.equals(other.hireDay);
	}

	public int hashCode() {
		return 7 * name.hashCode() + 11 + new Double(salary).hashCode() + 13 * hireDay.hashCode();
	}

	@Override public String toString() {
		return "Employee{" + "name='" + name + '\'' + ", salary=" + salary + ", hireDay=" + hireDay + '}';
	}
}

class Manager extends Employee {
	private double bouns;

	public Manager(String n, double s, int year, int month, int day) {
		super(n, s, year, month, day);
		bouns = 0;
	}

	public double getSalary() {
		double baseSalary = super.getSalary();
		return baseSalary + bouns;
	}

	public void setBouns(double b) {
		bouns = b;
	}

	public boolean equals(Object o) {
		if (!super.equals(o))
			return false;
		Manager manager = (Manager) o;
		//super.equals checked that this and other belong to the same class
		return bouns == manager.bouns;
	}

	public int hashCode() {
		return super.hashCode() + 17 * new Double(bouns).hashCode();
	}

	@Override public String toString() {
		return super.toString() + "[bouns=" + bouns + ']';
	}
}