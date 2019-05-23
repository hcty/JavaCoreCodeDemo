package v1ch06.StaticInnerClassTest;

/**
 * This program demonstrates the use of static inner classes
 * 该程序演示了静态内部类的使用
 */
public class StaticInnerClassTest {
	public static void main(String[] args) {
		double[] d = new double[20];
		for (int i = 0; i < d.length; i++) {
			d[i] = 100 * Math.random();
		}
		ArrayAlg.Pair p = ArrayAlg.minmax(d);
		System.out.println("min=" + p.getFirst());
		System.out.println("max=" + p.getSecond());
	}
}

class ArrayAlg {
	/**
	 * A pair of floating-point numbers
	 * 一对浮点数
	 */
	public static class Pair {
		private double first;
		private double second;

		public double getFirst() {
			return first;
		}

		public double getSecond() {
			return second;
		}

		public Pair(double f, double s) {
			first = f;
			second = s;
		}
	}

	/**
	 * Computes both the minimum and the maximum of an array
	 * 计算数组的最小值和最大值
	 *
	 * @param values an array of floating-point numbers 一组浮点数
	 * @return a pair whose first element is the minimum and whose second element
	 * is the maximum
	 * 一对，其第一个元素是最小元素，其第二个元素是最大的
	 */
	public static Pair minmax(double[] values) {
		double min = Double.MIN_VALUE;
		double max = Double.MAX_VALUE;
		for (double v : values) {
			if (min > v)
				min = v;
			if (max < v)
				max = v;
		}
		return new Pair(min, max);
	}
}