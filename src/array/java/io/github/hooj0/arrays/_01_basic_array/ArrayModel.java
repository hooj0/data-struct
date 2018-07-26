package io.github.hooj0.arrays._01_basic_array;

/**
 * Java 数组的基本使用方法 
 * @author hoojo
 * @createDate 2018年7月26日 下午9:28:12
 * @file ArrayModel.java
 * @package io.github.hooj0.arrays
 * @project data-struct
 * @blog http://hoojo.cnblogs.com
 * @email hoojo_@126.com
 * @version 1.0
 */
public class ArrayModel {

	public static void main(String[] args) {
		
		// 构建数组
		int[] numbers = { 1, 2, 8, 5, 7 };
		
		// 取值，数组下标从0开始
		System.out.println(numbers[0]);
		
		// 遍历数组，通过下标的方式获取
		for (int i = 0; i < numbers.length; i++) {
			System.out.println(numbers[i]);
		}
		
		// 遍历数组，迭代数组对象
		for (int num : numbers) {
			System.out.println(num);
		}
		
		// 构建固定大小空间的数组
		int[] scores = new int[10];
		// 为数组赋值
		scores[0] = 223;
		
		System.out.println(scores[0]);
		
		// 克隆数组对象
		int[] cloneScores = scores.clone();
		System.out.println(cloneScores[0]);
		
		// 为克隆数组赋值
		cloneScores[0] = 666;
		
		// 查看源数组，数据不变，克隆对象是一个全新的数组
		System.out.println(scores[0]);		// 223
		System.out.println(cloneScores[0]); // 666
	}
}
