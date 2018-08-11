package io.github.hooj0.arrays._06_generic_data_struct_array;

/**
 * 泛型数组数据类型增删改查测试
 * @author hoojo
 * @createDate 2018年8月11日 上午11:27:00
 * @file App.java
 * @package io.github.hooj0.arrays._06_generic_data_struct_array
 * @project data-struct
 * @blog http://hoojo.cnblogs.com
 * @email hoojo_@126.com
 * @version 1.0
 */
public class App {

	public static void main(String[] args) {

		GenericDataStructArray<Object> array = new GenericDataStructArray<Object>();
		array.addLast("a");
		array.addLast(1);
		array.addLast("c");
		array.addLast(3);
		array.addLast(1.22);
		array.addLast(5.0D);
		
		System.out.println(array);	// size: 6, cap: 10 [a, 1, c, 3, 1.22, 5.0, null, null, null, null, ] 
		
		array.remove(0);
		System.out.println(array);	// size: 5, cap: 10 [1, c, 3, 1.22, 5.0, null, null, null, null, null, ]

		array.remove(4);
		System.out.println(array);	// size: 4, cap: 10 [1, c, 3, 1.22, null, null, null, null, null, null, ] 
		
		int a = 5;
		array.addLast(a++);	
		array.addLast(a++);
		array.addLast(a++);
		array.addLast(a++);
		array.addLast(a++);
		array.addLast(a++);

		System.out.println(array);	// size: 10, cap: 10 [1, c, 3, 1.22, 5, 6, 7, 8, 9, 10, ] 
		
		array.remove(9);
		System.out.println(array);	// size: 9, cap: 10 [1, c, 3, 1.22, 5, 6, 7, 8, 9, null, ] 

		System.out.println(array.find(5));	// 4
		System.out.println(array.find(15));	// -1

		System.out.println(array.contains(5));	// true
		System.out.println(array.contains(15));	// false
		
		array.removeFirst();
		System.out.println(array);	// size: 8, cap: 10 [c, 3, 1.22, 5, 6, 7, 8, 9, null, null, ] 
		
		array.removeLast();
		System.out.println(array);	// size: 7, cap: 10 [c, 3, 1.22, 5, 6, 7, 8, null, null, null, ] 
		
		array.removeElement(5);
		array.removeElement(15);
		System.out.println(array);	// size: 6, cap: 10 [c, 3, 1.22, 6, 7, 8, null, null, null, null, ] 
	}
}
