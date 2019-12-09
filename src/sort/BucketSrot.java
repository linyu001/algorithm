package sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

/**
 * 桶排序
 *
 * @author linyu
 *
 */
public class BucketSrot {
	public static double[] bucketSort(double[] array) {
		// 得到数列的最大值和最小值， 并算出差值d
		double max = array[0];
		double min = array[0];
		for (int i = 0; i < array.length; i++) {
			if (array[i] > max) {
				max = array[i];
			}
			if (array[i] < min) {
				min = array[i];
			}
		}
		//计算区间跨度
		double d = max - min;
		//区间跨度 = （最大值-最小值） / （桶的数量 - 1）
		double span =d/(array.length-1);
		// 初始化桶
		int bucketNum = array.length;
		ArrayList<LinkedList<Double>> bucketList = new ArrayList<LinkedList<Double>>(
				bucketNum);
		for (int i = 0; i < bucketNum; i++) {
			bucketList.add(new LinkedList<Double>());
		}
		// 遍历数组将数组元素放入桶中
		for (int i = 0; i < array.length; i++) {
			//计算当前元素在第几个通里面，等于当前元素值减去最小值除以区间跨度
			int num = (int) ((array[i] - min) /span);
			bucketList.get(num).add(array[i]);
		}

		// 对每个桶内部进行排序
		for (int i = 0; i < bucketList.size(); i++) {
			// JDK 底层采用了归并排序或归并的优化版本
			Collections.sort(bucketList.get(i));
		}

		// 输出全部元素
		double[] sortedArray = new double[array.length];
		int index = 0;
		for (LinkedList<Double> list : bucketList) {
			for (double element : list) {
				sortedArray[index] = element;
				index++;
			}
		}
		return sortedArray;
	}

	public static void main(String[] args) {
		double [] array=new double []{0.5,2.5,1.5,1.4,6.2,3.2};
		double [] sortArray=bucketSort(array);
		System.out.println(Arrays.toString(sortArray));

	}

}
