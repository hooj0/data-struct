package io.github.hooj0.arrays._05_contains_find_remove_elements_array;

import io.github.hooj0.arrays._04_getter_setter_elements_array.GetterSetterItemsArray;

/**
 * 在上一节的基础上进行扩展，使得Array具有find、contains、remove 查找、判断、移除元素的功能
 * @author hoojo
 * @createDate 2018年8月9日 下午9:42:43
 * @file RemoveContrainsFindItemsArray.java
 * @package io.github.hooj0.arrays._05_contrains_find_remove_elements_array
 * @project data-struct
 * @blog http://hoojo.cnblogs.com
 * @email hoojo_@126.com
 * @version 1.0
 */
public class RemoveContainsFindItemsArray extends GetterSetterItemsArray {

	// 遍历元素，并进行匹配，如果没有找到就返回 -1，找到就返回对应的索引
	public int find(int item) {
		for (int i = 0; i < this.getSize(); i++) {
			if (this.arrays[i] == item) {
				return i;
			}
		}
		
		return -1;
	}
	
	// 判断元素是否存在数组中
	public boolean contains(int item) {
		for (int e : this.arrays) {
			if (e == item) {
				return true;
			}
		}
		
		return false;
	}
	
	// 删除指定位置上的元素，并返回删除的元素
	public int remove(int index) {
		if (index < 0) {
			throw new IllegalArgumentException("Array index out of bounds");
		}
		if (index > this.getSize()) {
			throw new IllegalArgumentException("Discontinuous fragmentation data");
		}
		
		int item = this.arrays[index];
		
		if (index == this.getCap() - 1) {	// last element
			this.arrays[index] = 0;
		} else {
			
			int end = this.size + 1;
			if (end >= this.getCap()) {
				end = this.size;
				//this.arrays[end] = 0;
			}
			
			// 删除位置的元素，都向前移动一个位置
			for (int i = index; i < end; i++) {
				
				this.arrays[i] = this.arrays[i + 1];
			}
		}
		
		size--;
		
		return item;
	}
	
	// 删除第一个元素
	public int removeFirst() {
		return this.remove(0);
	}
	
	// 删除最后一个元素
	public int removeLast() {
		return this.remove(size - 1);
	}
	
	// 删除指定元素，返回是否删除成功
	public boolean removeElement(int item) {
		int index = this.find(item);
		if (index != -1) {
			this.remove(index);
			return true;
		}
		
		return false;
	}
}
