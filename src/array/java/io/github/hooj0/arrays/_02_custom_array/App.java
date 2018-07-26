package io.github.hooj0.arrays._02_custom_array;

/**
 * 测试自定义数组的运行情况
 * @author hoojo
 * @createDate 2018年7月26日 下午9:50:04
 * @file App.java
 * @package io.github.hooj0.arrays._02_custom_array
 * @project data-struct
 * @blog http://hoojo.cnblogs.com
 * @email hoojo_@126.com
 * @version 1.0
 */
public class App {

	public static void main(String[] args) {
		// 无参构造一个自定义数组
		CustomArray array = new CustomArray();
		
		// 没有任何元素，大小为 0
		System.out.println("size: " + array.getSize());		// size: 0
		// 默认容量为 10
		System.out.println("cap: " + array.getCap());		// cap: 10
		System.err.println("empty: " + array.isEmpty());	// empty: true
		
		// 构造5个空间容量的自定义数组
		array = new CustomArray(5);
		
		// 没有任何元素，大小为 0
		System.out.println("size: " + array.getSize());		// size: 0
		// 容量 为 5
		System.out.println("cap: " + array.getCap());		// cap: 5
		// 空数组
		System.err.println("empty: " + array.isEmpty());	// empty: true
	}
}
