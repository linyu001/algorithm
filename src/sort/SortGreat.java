package sort;

import java.util.Arrays;

/**
 * 冒泡排序
 */
public class SortGreat {
    public static void sort(int[] array) {
        int lastIndex = 0;//记录最后一次交换的位置
        int sortBorder = array.length - 1;//无序数列的边界， 每次比较只需要比到这里为止
        for (int i = 0; i < array.length; i++) {
            boolean flag = true;//有序标记， 每一轮的初始值都是true
            for (int j = 0; j < sortBorder; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    flag = false;// 因为有元素进行交换， 所以不是有序的， 标记变为false
                    lastIndex = j;// 更新为最后一次交换元素的位置
                }
            }
            sortBorder = lastIndex;//最后一次交换的位置就是无序数列的新边界
            if (flag) {
                break;
            }
        }

    }

    public static void main(String[] args) {
        int[] array = new int[]{5, 8, 6, 3, 9, 2, 1, 7};
        sort(array);
        System.out.println(Arrays.toString(array));

    }

}

