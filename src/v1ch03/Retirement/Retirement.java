package v1ch03.Retirement;

import java.util.Scanner;

/**
 * This program demonstrantes a <code>while</code> loop.
 * 该程序演示<code>while</code>循环
 */
public class Retirement {
	public static void main(String[] args) {
		//read inputs
		Scanner in = new Scanner(System.in);
		System.out.print("How much money do you need to retire?");
		double goal = in.nextDouble();
		System.out.print("How much money will ypu contribute every year?");
		double payment = in.nextDouble();
		System.out.print("Interest rate in %: ");
		double interestRate = in.nextDouble();
		double balance = 0;
		int years = 0;
		while (balance < goal) {
			//add this year's payment and interest
			balance += payment;
			double interest = balance * interestRate / 100;
			balance += interest;
			years++;
		}
		System.out.println("You can retire in " + years + "years.");
	}
}
