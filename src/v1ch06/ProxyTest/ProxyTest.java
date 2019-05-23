package v1ch06.ProxyTest;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.Random;

/**
 * This program demonstrates the use of proxies
 * 该程序演示了代理的使用
 */
public class ProxyTest {
	public static void main(String[] args) {
		Object[] elements = new Object[1000];
		//fill elements with proxies for the integers 1...1000  用整数1 ... 1000的代理填充元素
		for (int i = 0; i < elements.length; i++) {
			Integer value = i + 1;
			InvocationHandler handler = new TraceHandler(value);
			Object proxy = Proxy.newProxyInstance(null, new Class[] { Comparable.class }, handler);
			elements[i] = proxy;
		}
		//construct a random integer 构造一个随机整数
		Integer key = new Random().nextInt(elements.length) + 1;
		//search for the key 搜索密钥
		int result = Arrays.binarySearch(elements, key);
		//print match if found 如果找到则打印匹配
		if (result >= 0)
			System.out.println("match key result:" + elements[result]);
	}
}

/**
 * An invocation handler that prints out the method name and parameters, then invokes the original method
 * 一个调用处理程序，它打印出方法名称和参数，然后调用原始方法
 */
class TraceHandler implements InvocationHandler {
	private Object target;

	/**
	 * Constructs a TraceHandler 构造一个TraceHandler
	 *
	 * @param t the implicit parameter of the method call
	 *          方法调用的隐式参数
	 */
	public TraceHandler(Object t) {
		target = t;
	}

	public Object invoke(Object proxy, Method m, Object[] args) throws Throwable {
		//print implicit argument 打印隐式参数
		System.out.println(target);
		//print method nane 打印方法名称
		System.out.println("." + m.getName() + "(");
		//print explicit arguments 打印显式参数
		if (args != null) {
			for (int i = 0; i < args.length; i++) {
				System.out.print(args[i]);
				if (i < args.length - 1)
					System.out.print(",");
			}
		}
		System.out.println(")");
		//invoke actual method 调用实际方法
		return m.invoke(target, args);
	}
}