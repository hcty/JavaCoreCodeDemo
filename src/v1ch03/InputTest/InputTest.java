package v1ch03.InputTest;

import java.util.Scanner;

/**
 * This program demonstrates console input.
 * 该程序演示了控制台输入
 */
public class InputTest {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		//get first input
		System.out.println("What is you name?");
		String name = in.nextLine();
		//get second input
		System.out.println("How old are you?");
		int age = in.nextInt();
		//display output on console
		System.out.println("Hello," + name + ". Next year,you'll be " + (age + 1));
	}
}
