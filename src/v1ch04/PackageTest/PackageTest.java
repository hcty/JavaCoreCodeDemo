package v1ch04.PackageTest;

import v1ch04.PackageTest.com.horstmann.coreJava.Employee;
import static java.lang.System.*;

/**
 * This program demonstrates the use of packages
 * 该程序演示了包的使用
 */
public class PackageTest {
	public static void main(String[] args) {
		//because of the import statement,we don't have to use com.horstmann.core.java.Employee here
		//因为import语句，我们不必在这里使用com.horstmann.core.java.Employee
		Employee harry = new Employee("Harry Hacker",50000,1989,10,1);
		harry.raiseSalary(5);
		//because of the static import statement,we don't have to use System.out here
		out.println(harry.toString());
	}
}
