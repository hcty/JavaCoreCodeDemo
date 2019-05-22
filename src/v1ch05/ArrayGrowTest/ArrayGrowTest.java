package v1ch05.ArrayGrowTest;

import java.lang.reflect.Array;

/**
 * This program demonstrates the use of reflection for manipulation arrays
 * 该程序演示了如何使用反射操作数组
 */
public class ArrayGrowTest {
	public static void main(String[] args) {
		int [] a={1,2,3};
		a=(int[])goodArrayGrow(a);
		arrayPrint(a);
		String[] b={"Tom","Dick","Harry"};
		b=(String[]) goodArrayGrow(b);
		arrayPrint(b);
		System.out.println("The following call will generate an exception.");//以下调用将生成异常。
		b=(String[]) badArrayGrow(b);
	}

	/**
	 * This method attempts to grow an array by allocation a new array and copying all elements
	 * 此方法尝试通过分配新数组并复制所有元素来生成数组
	 * @param a the array to grow 要成长的阵列
	 * @return a larger array that contains all elements of a. However ,the returned array has type object[],
	 * not the same type as a
	 * 一个包含a的所有元素的更大数组。 但是，返回的数组的类型为Object []，与a的类型不同
	 */
	static Object[] badArrayGrow(Object[] a){
		int newLength = a.length*11/10+10;
		Object[] newArray=new Object[newLength];
		System.arraycopy(a,0,newArray,0,a.length);
		return newArray;
	}

	/**
	 * This method grows an array by allocation a new array of the same type
	 * and copying all elelmetns
	 * 此方法通过分配相同类型的新数组并复制所有元素来生成数组。
	 * @param a the array to grow, This can be an object array or a primitive type array
	 *          要增长的数组，这可以是对象数组或基本类型数组
	 * @return a larger array that contains all elements of a
	 * 一个包含a的所有元素的更大数组
	 */
	static Object goodArrayGrow(Object a){
		Class cl = a.getClass();
		if (!cl.isArray())return null;
		Class componentType=cl.getComponentType();
		int length= Array.getLength(a);
		int newLength=length*10/10+10;
		Object newArray=Array.newInstance(componentType,newLength);
		System.arraycopy(a,0,newArray,0,length);
		return newArray;
	}

	/**
	 * A convenience method to print all elements in an array
	 * 一种方便的方法来打印数组中的所有元素
	 * @param a the array to print. It can be an object array or a primitive type array
	 *          要打印的数组。 它可以是对象数组或基本类型数组
	 */
	static void arrayPrint(Object a){
		Class cl = a.getClass();
		if (!cl.isArray()) return;
		Class componentType=cl.getComponentType();
		int length=Array.getLength(a);
		System.out.println(componentType.getName()+"["+length+"] = {");
		for (int i = 0; i < Array.getLength(a); i++) {
			System.out.println(Array.get(a,i)+" ");
		}
		System.out.println("}");
	}


}
