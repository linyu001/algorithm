package com;

import java.util.Arrays;

/**
 * 二叉堆（小堆）
 * 
 * @author 2
 * 
 */
public class MybinaryHeap {
	/**
	 * 上浮调整
	 * 
	 * @param array
	 *            待调整的堆
	 */
	public static void upAdjust(int[] array) {
		int childIndex = array.length - 1;
		int parentIndex = (childIndex - 1) / 2;
		// temp 保存叶子节点的值，用于最后的赋值
		int temp = array[childIndex];
		while (childIndex > 0 && temp < array[parentIndex]) {
			// 无需交换，单项赋值即可
			array[childIndex] = array[parentIndex];
			childIndex = parentIndex;
			parentIndex = (parentIndex - 1) / 2;
		}
		array[childIndex] = temp;
	}

	/**
	 * 下沉调整
	 * 
	 * @param array
	 *            待调整的堆
	 * @param parentIndex
	 *            要下沉的父节点
	 * @param length
	 *            堆的有效大小
	 */
	public static void downAdjust(int[] array, int parentIndex, int length) {
		// temp 用于保存父节点的值
		int temp = array[parentIndex];
		int childIndex = parentIndex * 2 + 1;
		while (childIndex < length) {
			// 如果有右孩子，且右孩子小于左孩子的值，则定位到右孩子
			if (childIndex + 1 < length
					&& array[childIndex] > array[childIndex + 1]) {
				childIndex++;
			}
			// 如果父节点的值小于任何一个孩子的值，则直接跳出
			if (temp <= array[childIndex]) {
				break;
			}
			// 无须真正交换，单项赋值即可
			array[parentIndex] = array[childIndex];
			parentIndex = childIndex;
			childIndex = childIndex * 2 + 1;
		}
		array[parentIndex] = temp;
	}

	/**
	 * 构建堆
	 * 
	 * @param array
	 *            待调整的堆
	 */
	public static void buildHeap(int[] array) {
		// 从最后一个非叶子节点开始，依次做下沉调整
		for (int i = (array.length - 2) / 2; i >= 0; i--) {
			downAdjust(array, i, array.length);
		}
	}

	public static void main(String[] args) {
		int[] array = new int[] { 1, 3, 2, 6, 5, 7, 8, 9, 10, 0 };
		upAdjust(array);
		System.out.println(Arrays.toString(array));

		int[] array2 = new int[] { 1, 10, 3, 5, 6, 7, 8, 9, 2 };
		buildHeap(array2);
		downAdjust(array2, 3, array2.length);
		System.out.println(Arrays.toString(array2));
		
	}
}
