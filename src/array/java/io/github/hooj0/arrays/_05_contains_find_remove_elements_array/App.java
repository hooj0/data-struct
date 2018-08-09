package io.github.hooj0.arrays._05_contains_find_remove_elements_array;

/**
 * 测试自定义数组，获取数组元素索引、判断元素是否在数组中、移除数组
 * @author hoojo
 * @createDate 2018年8月9日 下午9:51:46
 * @file App.java
 * @package io.github.hooj0.arrays._05_contains_find_remove_elements_array
 * @project data-struct
 * @blog http://hoojo.cnblogs.com
 * @email hoojo_@126.com
 * @version 1.0
 */
public class App {

	public static void main(String[] args) {
		RemoveContainsFindItemsArray array = new RemoveContainsFindItemsArray();
		array.addLast(0);
		array.addLast(1);
		array.addLast(2);
		array.addLast(3);
		array.addLast(4);
		array.addLast(5);
		
		System.out.println(array);	// 0;1;2;3;4;5;0;0;0;0;
		
		array.remove(0);
		System.out.println(array);	// 1;2;3;4;5;0;0;0;0;0;

		array.remove(4);
		System.out.println(array);	// 1;2;3;4;0;0;0;0;0;0;
		
		int a = 5;
		array.addLast(a++);
		array.addLast(a++);
		array.addLast(a++);
		array.addLast(a++);
		array.addLast(a++);
		array.addLast(a++);

		System.out.println(array);	// 1;2;3;4;5;6;7;8;9;10;
		
		array.remove(9);
		System.out.println(array);	// 1;2;3;4;5;6;7;8;9;0;

		System.out.println(array.find(5));	// 4
		System.out.println(array.find(15));	// -1

		System.out.println(array.contains(5));	// true
		System.out.println(array.contains(15));	// false
		
		array.removeFirst();
		System.out.println(array);	// 2;3;4;5;6;7;8;9;0;0;
		
		array.removeLast();
		System.out.println(array);	// 2;3;4;5;6;7;8;0;0;0;
		
		array.removeElement(5);
		array.removeElement(15);
		System.out.println(array);	// 2;3;4;6;7;8;0;0;0;0;
	}
}
