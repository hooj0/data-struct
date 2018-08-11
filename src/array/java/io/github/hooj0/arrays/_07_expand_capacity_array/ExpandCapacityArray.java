package io.github.hooj0.arrays._07_expand_capacity_array;

import io.github.hooj0.arrays._06_generic_data_struct_array.GenericDataStructArray;

/**
 * 数组扩容，扩展原数组的容量大小
 * @author hoojo
 * @createDate 2018年8月11日 上午9:59:14
 * @file ExpandCapacityArray.java
 * @package io.github.hooj0.arrays_07_expand_capacity_array
 * @project data-struct
 * @blog http://hoojo.cnblogs.com
 * @email hoojo_@126.com
 * @version 1.0
 */
public class ExpandCapacityArray<E> extends GenericDataStructArray<E> {

	public ExpandCapacityArray(int capacity) {
		super(capacity);
	}
	
	public void resize(int cap) {
		if (cap <= this.getSize()) {
			return;
		}
		
		@SuppressWarnings("unchecked")
		E[] newArrays = (E[]) new Object[cap];
		for (int i = 0; i < this.size; i++) {
			newArrays[i] = this.arrays[i];
		}
		
		this.arrays = newArrays;
	}
	
	// 在指定索引位置插入新元素，原来的元素向后移动
	public void add(int index, E item) {
		
		if (index < 0) {
			throw new IllegalArgumentException("Array index out of bounds");
		}
		if (index > this.getSize()) {
			throw new IllegalArgumentException("Discontinuous fragmentation data");
		}
		
		// 当数组容量和大小相等就进行扩容
		if (size == this.getCap()) {
			resize(size * 2);
		}

		// 依次 向后移动当前位置元素，从最后一个元素开始移动一个位置，直到在要插入的位置停止
		for (int i = size - 1; i >= index; i--) {
			arrays[i + 1] = arrays[i];
		}

		this.arrays[index] = item;
		// 改变大小
		size++;
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
		
		if ((this.getCap() - this.getSize()) >  this.getSize()) {
			resize(this.getCap() / 2);
		}

		return item;
	}
}
