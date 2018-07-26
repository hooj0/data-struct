package io.github.hooj0.arrays._02_custom_array;

/**
 * 创建我们自己的数组对象
 * 功能：支持获取数组容量，空间大小，是否为空的基本方法
 * @author hoojo
 * @createDate 2018年7月26日 下午9:43:00
 * @file CustomArray.java
 * @package io.github.hooj0.arrays._02_custom_array
 * @project data-struct
 * @blog http://hoojo.cnblogs.com
 * @email hoojo_@126.com
 * @version 1.0
 */
public class CustomArray {

	private int[] arrays;
	private int size;
	
	// 构造函数，可以构建指定大小空间的数组
	public CustomArray(int capacity) {
		arrays = new int[capacity];
		size = 0;
	}
	
	// 构建默认空间大小的数组
	public CustomArray() {
		this(10);
	}
	
	// 获取数组的容量
	public int getCap() {
		return arrays.length;
	}
	
	// 获取数组存储元素数量
	public int getSize() {
		return this.size;
	}
	
	// 判断数组是否为空，即 有没有元素
	public boolean isEmpty() {
		return this.size == 0;
	}
}
