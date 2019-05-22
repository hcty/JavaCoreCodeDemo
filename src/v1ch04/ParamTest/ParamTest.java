package v1ch04.ParamTest;

/**
 * This program demonstrates parameter passing in Java
 * 该程序演示了Java中的参数传递
 */
public class ParamTest {
	public static void main(String[] args) {
		/**
		 * Test 1:Methods can't modify numeric parameters
		 * 方法无法修改数字参数
		 */
		System.out.println("Testing tripleValue:");
		double percent = 10;
		tripleValue(percent);
		System.out.println("After:percent=" + percent);
		/**
		 * Test 2: Methods can change the state of object parameters
		 * 方法可以改变对象参数的状态
		 */
		System.out.println("\nTesting tripleSalary:");
		Employee harry = new Employee("Harry", 50000);
		System.out.println("Befor : salary=" + harry.getSalary());
		tripleSalary(harry);
		System.out.println("After:salary=" + harry.getSalary());
		/**
		 * Test 3:Methods can't attach new objects to object parameters
		 * 方法无法将新对象附加到对象参数
		 */
		System.out.println("\nTesting swap:");
		Employee a = new Employee("Alice", 70000);
		Employee b = new Employee("Bob", 60000);
		System.out.println("Before : a=" + a.getName());
		System.out.println("Before : b=" + b.getName());
		swap(a, b);
		System.out.println("After :a=" + a.getName());
		System.out.println("After :b=" + b.getName());
	}

	public static void tripleValue(double x) {//doesn]t work
		x = 3 * x;
		System.out.println("End of method:x=" + x);
	}

	public static void tripleSalary(Employee x) {//works
		x.raiseSalary(200);
		System.out.println("End of method: salary=" + x.getSalary());
	}

	public static void swap(Employee x, Employee y) {
		Employee temp = x;
		x = y;
		y = temp;
		System.out.println("End of methd:x=" + x.getName());
		System.out.println("End of methd:y=" + y.getName());
	}
}

class Employee {//simplified Employee class 简化的员工类
	private String name;
	private double salary;

	public String getName() {
		return name;
	}

	public double getSalary() {
		return salary;
	}

	public Employee(String n, double s) {
		name = n;
		salary = s;
	}

	public void raiseSalary(double byPercent) {
		double raise = salary * byPercent / 100;
		salary += raise;
	}
}
