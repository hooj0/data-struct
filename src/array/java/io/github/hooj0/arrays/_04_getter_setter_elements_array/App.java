package io.github.hooj0.arrays._04_getter_setter_elements_array;

/**
 * 测试 从数组中获取元素和设置元素
 * @author hoojo
 * @createDate 2018年8月9日 下午9:31:09
 * @file App.java
 * @package io.github.hooj0.arrays._04_getter_setter_elements_array
 * @project data-struct
 * @blog http://hoojo.cnblogs.com
 * @email hoojo_@126.com
 * @version 1.0
 */
public class App {

	public static void main(String[] args) {
		GetterSetterItemsArray array = new GetterSetterItemsArray();
		
		array.addFirst(2);
		array.addFirst(1);
		array.addFirst(5);
		array.addFirst(7);
		
		array.addLast(8);
		
		array.add(4, 11);
		
		System.out.println(array.get(5));	// 8
		System.out.println(array.get(4));	// 11

		array.set(4, -1);
		System.out.println(array.get(4));	// -1
	}
}
