package io.github.hooj0.arrays._06_generic_data_struct_array;

/**
 * 泛型数组，支持泛型接受任何数据类型数据的数组数据结构
 * 
 * @author hoojo
 * @createDate 2018年8月11日 上午11:18:17
 * @file GenericDataStructArray.java
 * @package io.github.hooj0.arrays._06_generic_data_struct_array
 * @project data-struct
 * @blog http://hoojo.cnblogs.com
 * @email hoojo_@126.com
 * @version 1.0
 */
public class GenericDataStructArray<E> {

	protected E[] arrays;
	protected int size;

	// 构造函数，可以构建指定大小空间的数组
	@SuppressWarnings("unchecked")
	public GenericDataStructArray(int capacity) {
		arrays = (E[]) new Object[capacity];
		size = 0;
	}

	// 构建默认空间大小的数组
	public GenericDataStructArray() {
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
	public void addFirst(E item) {
		add(0, item);
	}

	// 在已有元素后面追加新元素
	public void addLast(E item) {
		add(this.getSize(), item);
	}

	// 在指定索引位置插入新元素，原来的元素向后移动
	public void add(int index, E item) {
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

	// 设置元素，将指定位置上的元素进行替换，如果索引超过范围就抛出异常
	public void set(int index, E item) {
		if (index < 0) {
			throw new IllegalArgumentException("Array index out of bounds");
		}
		if (index >= this.getSize()) {
			throw new IllegalArgumentException("Discontinuous fragmentation data");
		}

		this.arrays[index] = item;
	}

	// 获取指定位置上的元素，如果索引超过范围就抛出异常
	public E get(int index) {
		if (index < 0) {
			throw new IllegalArgumentException("Array index out of bounds");
		}
		if (index >= this.getSize()) {
			throw new IllegalArgumentException("Discontinuous fragmentation data");
		}

		return this.arrays[index];
	}

	// 遍历元素，并进行匹配，如果没有找到就返回 -1，找到就返回对应的索引
	public int find(E item) {
		for (int i = 0; i < this.getSize(); i++) {
			if (this.arrays[i] == item) {
				return i;
			}
		}

		return -1;
	}

	// 判断元素是否存在数组中
	public boolean contains(E item) {
		for (E e : this.arrays) {
			if (e == item) {
				return true;
			}
		}

		return false;
	}

	// 删除指定位置上的元素，并返回删除的元素
	public E remove(int index) {
		if (index < 0) {
			throw new IllegalArgumentException("Array index out of bounds");
		}
		if (index > this.getSize()) {
			throw new IllegalArgumentException("Discontinuous fragmentation data");
		}

		E item = this.arrays[index];

		if (index == this.getCap() - 1) { // last element
			this.arrays[index] = null;
		} else {

			int end = this.size + 1;
			if (end >= this.getCap()) {
				end = this.size;
			}

			// 删除位置的元素，都向前移动一个位置
			for (int i = index; i < end; i++) {
				this.arrays[i] = this.arrays[i + 1];
			}
		}

		// 改变大小
		size--;

		return item;
	}

	// 删除第一个元素
	public E removeFirst() {
		return this.remove(0);
	}

	// 删除最后一个元素
	public E removeLast() {
		return this.remove(size - 1);
	}

	// 删除指定元素，返回是否删除成功
	public boolean removeElement(E item) {
		int index = this.find(item);
		if (index != -1) {
			this.remove(index);
			return true;
		}

		return false;
	}

	@Override
	public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append("size: ").append(this.size).append(", cap: ").append(this.getCap()).append(" [");
		
		//sb.append(Arrays.toString(arrays));
		
		for (int i = 0; i < arrays.length; i++) {
			sb.append(arrays[i]);
			
			if (i >= arrays.length - 1) {
				continue;
			}
			sb.append(", ");
		}
		
		sb.append("] ");
		return sb.toString();
	}
}
