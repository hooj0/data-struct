package io.github.hooj0.arrays._03_add_elements_array;

/**
 * 测试自定义数组在首部/尾部/指定索引位置/添加新元素
 * @author hoojo
 * @createDate 2018年7月26日 下午10:47:05
 * @file App.java
 * @package io.github.hooj0.arrays._03_add_elements_array
 * @project data-struct
 * @blog http://hoojo.cnblogs.com
 * @email hoojo_@126.com
 * @version 1.0
 */
public class App {

	public static void main(String[] args) {

		CustomAddItemsArray array = new CustomAddItemsArray(10);
		
		// 在首部添加数据
		array.addFirst(100);
		// 在已有元素尾部追加新元素
		array.addLast(111);
		
		System.out.println(array.toString());				// 100;111;0;0;0;0;0;0;0;0;

		// 没有任何元素，大小为 0
		System.out.println("size: " + array.getSize());		// size: 2
		// 默认容量为 10
		System.out.println("cap: " + array.getCap());		// cap: 10
		System.out.println("empty: " + array.isEmpty());	// empty: false
		
		array.addLast(99);
		System.out.println(array.toString());				// 100;111;99;0;0;0;0;0;0;0;
		
		// 没有元素的地方不能直接添加元素，会造成数据不连续
		// array.add(8, 222);		// java.lang.IllegalArgumentException: Discontinuous fragmentation data
		
		// 在已有元素的索引处插入元素
		array.add(1, 222);									
		System.out.println(array.toString());				// 100;222;99;0;0;0;0;0;0;0;
	}
}
