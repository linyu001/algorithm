package com;

import java.util.Arrays;

/**
 * ����ѣ�С�ѣ�
 * 
 * @author 2
 * 
 */
public class MybinaryHeap {
	/**
	 * �ϸ�����
	 * 
	 * @param array
	 *            �������Ķ�
	 */
	public static void upAdjust(int[] array) {
		int childIndex = array.length - 1;
		int parentIndex = (childIndex - 1) / 2;
		// temp ����Ҷ�ӽڵ��ֵ���������ĸ�ֵ
		int temp = array[childIndex];
		while (childIndex > 0 && temp < array[parentIndex]) {
			// ���轻�������ֵ����
			array[childIndex] = array[parentIndex];
			childIndex = parentIndex;
			parentIndex = (parentIndex - 1) / 2;
		}
		array[childIndex] = temp;
	}

	/**
	 * �³�����
	 * 
	 * @param array
	 *            �������Ķ�
	 * @param parentIndex
	 *            Ҫ�³��ĸ��ڵ�
	 * @param length
	 *            �ѵ���Ч��С
	 */
	public static void downAdjust(int[] array, int parentIndex, int length) {
		// temp ���ڱ��游�ڵ��ֵ
		int temp = array[parentIndex];
		int childIndex = parentIndex * 2 + 1;
		while (childIndex < length) {
			// ������Һ��ӣ����Һ���С�����ӵ�ֵ����λ���Һ���
			if (childIndex + 1 < length
					&& array[childIndex] > array[childIndex + 1]) {
				childIndex++;
			}
			// ������ڵ��ֵС���κ�һ�����ӵ�ֵ����ֱ������
			if (temp <= array[childIndex]) {
				break;
			}
			// �����������������ֵ����
			array[parentIndex] = array[childIndex];
			parentIndex = childIndex;
			childIndex = childIndex * 2 + 1;
		}
		array[parentIndex] = temp;
	}

	/**
	 * ������
	 * 
	 * @param array
	 *            �������Ķ�
	 */
	public static void buildHeap(int[] array) {
		// �����һ����Ҷ�ӽڵ㿪ʼ���������³�����
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
