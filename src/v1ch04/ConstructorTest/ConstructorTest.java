package v1ch04.ConstructorTest;

import java.util.Random;

/**
 * This program demonstrates object construction
 * 该程序演示了对象构造
 */
public class ConstructorTest {
	public static void main(String[] args) {
		Employee[] staff = new Employee[3];
		staff[0]=new Employee("Harry",40000);
		staff[1]=new Employee(60000);
		staff[2]=new Employee();
		//print out information about all Employee objects 打印出有关所有Employee对象的信息
		for (Employee e:staff) {
			System.out.println(e.toString());
		}
	}
}
class Employee{
	//three overloaded constructors  三个重载的构造函数
	public Employee(String n,double s) {
		name = n;
		salary=s;
	}

	public Employee(double salary) {
		//calls the Employee(String,double) constructor 调用Employee（String，double）构造函数
		this("Employee #"+nextId,salary);
	}
	//the default constructor  默认构造函数
	public  Employee(){

	}
	private static int nextId;
	private int id;
	private String name="";//instance field initialization 实例字段初始化
	private double salary;
	//static initialization block 静态初始化块
	static{
		Random generator = new Random();
		//set nextId to a random number between 0 and 9999
		nextId=generator.nextInt(10000);
	}
	//object initialization block 对象初始化块
	{
		id=nextId;
		nextId++;
	}
	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public double getSalary() {
		return salary;
	}

	@Override public String toString() {
		return "Employee{" + "id=" + id + ", name='" + name + '\'' + ", salary=" + salary + '}';
	}
}