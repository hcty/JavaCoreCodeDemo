package v1ch04.PackageTest.com.horstmann.coreJava;

import java.util.Date;
import java.util.GregorianCalendar;

/**
 * the classes in this file are part of this package
 * 此文件中的类是此包的一部分
 */
public class Employee {
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
	public void raiseSalary(double byPercent){
		double raise = salary* byPercent/100;
		salary+=raise;
	}
	public Employee(String n,double s,int year,int month,int day){
		name=n;
		salary=s;
		GregorianCalendar calendar=new GregorianCalendar(year,month-1,day);
		hireDay=calendar.getTime();
	}

	@Override public String toString() {
		return "Employee{" + "name='" + name + '\'' + ", salary=" + salary + ", hireDay=" + hireDay + '}';
	}
}
