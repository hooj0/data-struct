package io.github.hooj0.arrays._04_getter_setter_elements_array;

/**
 * 在上一节的代码上，进行扩展：添加设置 数组元素 和 更新数组元素的方法
 * @author hoojo
 * @createDate 2018年8月9日 下午9:26:05
 * @file GetterSetterItemsArray.java
 * @package io.github.hooj0.arrays._04_getter_setter_elements_array
 * @project data-struct
 * @blog http://hoojo.cnblogs.com
 * @email hoojo_@126.com
 * @version 1.0
 */
public class GetterSetterItemsArray {
	
	private int[] arrays;
	private int size;
	
	// 构造函数，可以构建指定大小空间的数组
	public GetterSetterItemsArray(int capacity) {
		arrays = new int[capacity];
		size = 0;
	}
	
	// 构建默认空间大小的数组
	public GetterSetterItemsArray() {
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
	
	public void set(int index, int item) {
		if (index < 0) {
			throw new IllegalArgumentException("Array index out of bounds");
		}
		if (index > this.getSize()) {
			throw new IllegalArgumentException("Discontinuous fragmentation data");
		}
		
		this.arrays[index] = item;
	}
	
	public int get(int index) {
		if (index < 0) {
			throw new IllegalArgumentException("Array index out of bounds");
		}
		if (index > this.getSize()) {
			throw new IllegalArgumentException("Discontinuous fragmentation data");
		}
		
		return this.arrays[index];
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
