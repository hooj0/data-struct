package io.github.hooj0.arrays._07_expand_capacity_array;

/**
 * 数组扩容测试
 * @author hoojo
 * @createDate 2018年8月11日 上午10:33:56
 * @file App.java
 * @package io.github.hooj0.arrays._07_expand_capacity_array
 * @project data-struct
 * @blog http://hoojo.cnblogs.com
 * @email hoojo_@126.com
 * @version 1.0
 */
public class App {

	public static void main(String[] args) {
		ExpandCapacityArray<Object> array = new ExpandCapacityArray<>(3);
		
		array.addLast(1);
		array.addLast(2);
		array.addLast("c");

		System.out.println(array);	// size: 3, cap: 3 [1, 2, c] 

		// 扩容，可以存储更多元素
		array.resize(5);
		array.addLast("d");
		
		System.out.println(array);	// size: 4, cap: 5 [1, 2, c, d, null] 
		
		array.addLast(111);
		array.addLast(222);
		array.addLast(333); // auto resize
		System.out.println(array);	// size: 7, cap: 10 [1, 2, c, d, 111, 222, 333, null, null, null] 

		array.removeFirst();
		array.remove(3);
		array.removeLast();
		System.out.println(array);	// size: 4, cap: 5 [2, c, d, 222, null] 
	}
}
