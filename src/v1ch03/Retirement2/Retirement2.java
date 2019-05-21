package v1ch03.Retirement2;

import java.util.Scanner;

/**
 * This program demonstrates a <code>do/while</code> loop.
 * 该程序演示了<code> do / while </ code>循环。
 */
public class Retirement2 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("How much money will you contribute every year?");
		double payment = in.nextDouble();
		System.out.println("Interest rate in %:");
		double interestRate = in.nextDouble();
		double balance = 0;
		int year = 0;
		String input;
		//update account balance while user isn't ready to retire
		do {
			//add this year's payment and interest
			balance += payment;
			double interest = balance * interestRate / 100;
			balance += interest;
			year++;
			//Print current balance
			System.out.printf("After year %d,your balance is %,.2f%n", year, balance);
			//as if read to retire and get input
			System.out.println("Read to retire?(Y/N)");
			input = in.next();

		} while (input.equals("N"));

	}
}
