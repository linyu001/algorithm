package sort;

import java.util.Arrays;

/**
 * 鸡尾酒排序
 */
public class CockTailSort {
    public static void sort(int[] array) {
        int leftlastIndex = 0;//记录左面侧最后一次交换的位置
        int rightlastIndex = 0;//记录右侧最后一次交换的位置
        int rightsortBorder = array.length - 1;//无序数列的右边界， 每次比较只需要比到这里为止
        int leftBorder = 0;//无序数列的左边界， 每次比较只需要比到这里为止
        for (int i = 0; i < array.length / 2; i++) {
            boolean flag = true;//有序标记， 每一轮的初始值都是true
            for (int j = leftBorder; j < rightsortBorder; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    flag = false;// 因为有元素进行交换， 所以不是有序的， 标记变为false
                    rightlastIndex = j;// 更新为最后一次交换元素的位置
                }
            }
            rightsortBorder = rightlastIndex;//最后一次交换的位置就是无序数列的右边界
            if (flag) {
                break;
            }

            flag = true;//有序标记， 每一轮的初始值都是true
            for (int j = rightsortBorder; j > leftBorder; j--) {
                if (array[j] < array[j - 1]) {
                    int temp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = temp;
                    flag = false;// 因为有元素进行交换， 所以不是有序的， 标记变为false
                    leftlastIndex = j;// 更新为最后一次交换元素的位置
                }
            }
            leftBorder = leftlastIndex;//最后一次交换的位置就是无序数列左边界
            if (flag) {
                break;
            }
        }

    }

    public static void main(String[] args) {
        int[] array = new int[]{2, 4, 5, 3, 6, 7, 8, 1};
        sort(array);
        System.out.println(Arrays.toString(array));

    }

}

