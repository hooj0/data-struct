package io.github.hooj0.arrays._03_add_elements_array;

/**
 * 在自定义数组的基础上，增加可以添加数组元素功能的自定义数组。
 * 功能：支持获取数组容量，空间大小，是否为空的基本方法，支持在首部/尾部/指定索引位置/添加新元素
 * @author hoojo
 * @createDate 2018年7月26日 下午9:58:53
 * @file CustomAddItemsArray.java
 * @package io.github.hooj0.arrays_03_add_elements_array
 * @project data-struct
 * @blog http://hoojo.cnblogs.com
 * @email hoojo_@126.com
 * @version 1.0
 */
public class CustomAddItemsArray {

	private int[] arrays;
	private int size;
	
	// 构造函数，可以构建指定大小空间的数组
	public CustomAddItemsArray(int capacity) {
		arrays = new int[capacity];
		size = 0;
	}
	
	// 构建默认空间大小的数组
	public CustomAddItemsArray() {
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
	
	// 将元素添加到数组最顶端
	public void addFirst(int item) {
		add(0, item);
	}
	
	// 在已有元素后面追加新元素
	public void addLast(int item) {
		add(this.getSize(), item);
	}
	
	// 在指定索引位置插入新元素，原来的元素向后移动
	public void add(int index, int item) {
		if (this.getCap() == index) {
			throw new IllegalArgumentException("Array full.");
		}
		if (index > this.getCap() || index < 0) {
			throw new IllegalArgumentException("Array index out of bounds");
		}
		if (index > this.getSize()) {
			throw new IllegalArgumentException("Discontinuous fragmentation data");
		}
		
		// 依次 向后移动当前位置元素，从最后一个元素开始移动一个位置，直到在要插入的位置停止
		for (int i = size - 1; i >= index; i--) {
			arrays[i + 1] = arrays[i];
		}

		this.arrays[index] = item;
		// 改变大小
		size++;
	}
	
	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		for (int item : arrays) {
			sb.append(item).append(";");
		}
		
		return sb.toString();
	}
}
