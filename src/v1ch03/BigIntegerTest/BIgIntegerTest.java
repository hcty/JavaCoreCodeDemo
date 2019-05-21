package v1ch03.BigIntegerTest;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * Java核心技术：Demo4
 */
public class BIgIntegerTest {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("How man munber do you need to draw?");
		int k = in.nextInt();
		System.out.println("What is the highest number you can draw?");
		int n = in.nextInt();
		BigInteger lotterOdds = BigInteger.valueOf(1);
		for (int i = 1; i < k; i++) {
			lotterOdds = lotterOdds.multiply(BigInteger.valueOf(n - i + 1)).divide(BigInteger.valueOf(i));
		}
		System.out.println("Your odds are 1 in " + lotterOdds + ". Good Luck!");
	}
}
