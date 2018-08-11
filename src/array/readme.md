# 数组 `Array`

| 数据结构 :speech_balloon: | 年代 :speech_balloon: | 难度 :speech_balloon: | 实用性 :speech_balloon: | 重要度 :speech_balloon: | 友好度 :speech_balloon: | 性能 :speech_balloon: | 有序性 :speech_balloon: | 安全性 :speech_balloon: |
| :---------------------------: | :----------------------: | :----------------------: | :------------------------: | :------------------------: | :------------------------: | :----------------------: | :------------------------: | :----: |
|             数组              |           原始           |          :star:          |            :star::star::star::star:            | :star::star::star::star::star: |        :star::star:        | :star::star::star: |     :white_check_mark:     |  :x:   |

## 概述

数组，一种原始的数据结构，有序的元素序列。 数组适用于将很多个相同类型的数据存在一起，构建一个相同数据的集合。存储在数组中的数据类型，是根据声明时的类型而定的。数组中的数据称作元素，数组中数据的位置称作索引或下标。

数组可以是多维的，一般简单的是一维数组。二维数组就是在数组中存储数组，还可以有三维以上，太多纬度会导致数组运算复杂，不推荐应用。应考虑其他的数据结构模型。

Java的数组是由原始底层提供，其底层提供的方法有构建数组、数组长度、设置数据、获取指定索引位置元素数据、包括克隆数组等最常用最基本的API方法接口。

## 用途

可以有序的存储任何数据类型的数据结构，在简单的数据集合的选择上，数组是一个非常适合的选择。数组也是其他很多数据结构模型的基础模型，其他数据模型的构建都是通过在数组的基础上进行封装演变而来的成果。

## 特点

+ 数组可以存放原始数据类型或其他自定义对象数据类型
+ 数组存储的元素都是有序的，按照存入的顺序先后存放，是按照索引固定位置
+ 可以插入重复的数据
+ 数组长度是不可变
+ 下标（索引）从0开始
+ 插入速度快
+ 获取数据快
+ 支持通过元素遍历`forEach`和索引遍历`for`
+ 数组存在上界和下界，超过区间会抛出数组索引越界异常（`IndexOutOfBoundsException`）

## 优点与缺点

+ **优点**
  + 高效，插入、查询都非常快
  + 简单，基本的操作API，没有复杂的应用
  + 扩展性强，可以扩展成复杂的数据结构模型
+ **缺点**
  + 不支持直接查找元素，需要遍历

## 数据结构

+ 数组声明后的内存结构

  ![1533993790801](images/1533993790801.png)

+ 在下标 `2` 的位置上设置元素值

  ![1533995305512](images/1533995305512.png)

+ 全部赋值后的数据结构

![1533977945815](images/1533977945815.png)

## 性能分析

+ **插入**数组插入速度直接通过索引定位，**时间复杂度**：`O(1)`
+ **定位**数组获取某个元素，直接通过索引定位，**时间复杂度**：`O(1)`
+ **查找**数组查找元素，需要遍历全部元素，**时间复杂度**：`O(n)`
+ **移除**直接通过索引定位，然后设置默认空值，**时间复杂度**：`O(1)`

## 安全分析

原始数据结构，多线程下数据共享是不安全的。会存在多线程竞争同一个索引下标位置的元素修改权，导致指向内存地址错误的可能性。特别是在修改或者删除数据的情况下，多线程很容易出现问题。

若将一个数组，分成不同等份，再由多个线程去操作不同部分，这样不失为一个好的解决方案。实际中的使用案例有，多线程下载或上传文件，使用数组保存下载或上传文件数据的不同部分信息。

## 代码实现

数组的进一步封装和实现

```java
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
```

## 应用场景

数组应用场景非常广泛，随处可以见到，比如Java中的`main`函数的参数就是数组。

## 应用实例参考

### `JavaSDK`



### `GoSDK`

### `PythonSDK`

### `JavaScript Libs`



## 总结



## 参考资料





