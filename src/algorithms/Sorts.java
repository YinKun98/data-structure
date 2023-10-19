package algorithms;

import java.util.Arrays;

/**
 * @Author: yin-k
 * @Description: 排序算法。默认都是排为递增序列
 * @Date: Created in 21:13 2023/5/8
 */
public class Sorts {
    /**
     * 选择排序
     * <p>
     * 算法思想：从当前位置往后寻找待排序序列中最小元素的索引，与当前位置进行交换
     * <p>
     * 时间复杂度 n² 空间复杂度 1 不稳定
     *
     * @param a 待排序数组
     * @return 已排序数组
     */
    public static int[] SelectionSort(int[] a) {
        for (int i = 0; i < a.length; i++) {  // 外层循环，依次把每个索引位置的值更新为待排序的元素中最小的
            int min = i;
            for (int j = i + 1; j < a.length; j++) {  // 内层循环：将外层位置的元素与之后的元素进行比较，获得最小元素下标
                if (a[j] < a[min])
                    min = j;
            }
            int v = a[i];
            a[i] = a[min];
            a[min] = v;
        }
        return a;
    }

    /**
     * 冒泡排序
     * <p>
     * 算法思想：相邻元素两两比较，大的元素换到后面，即保证后面的序列是递增有序的
     * <p>
     * 时间复杂度 n² 空间复杂度 1 不稳定
     *
     * @param a 待排序数组
     * @return 已排序数组
     */
    public static int[] BubbleSort(int[] a) {
        int len = a.length;
        for (int i = len - 1; i > 0; i--) { // 外层循环：目的保证最后的元素最大（后面的序列有序），所以选择逆序枚举
            for (int j = 0; j < i; j++) { // 内层循环：目的是从0索引到最后的元素中选出最大的元素，放在最后的位置上
                if (a[j] > a[j + 1]) {
                    int v = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = v;
                }
            }
//            System.out.println(Arrays.toString(a));
        }
        return a;
    }

    /**
     * 插入排序
     * <p>
     * 算法思想:
     * 将待排序元素插入到前面已经有序的部分中
     * <p>
     * 时间复杂度 n² 空间复杂度 1 稳定
     *
     * @param a 待排序数组
     * @return 已排序数组
     */
    public static int[] InsertionSort(int[] a) {
        int len = a.length;
        for (int i = 1; i < len; i++) { // 外层循环：从1开始将元素插入到前面有序的序列中
            for (int j = i; j > 0; j--) { // 内层循环：将元素与前面有序的序列从后往前依次比较，若元素小于前面的元素则交换换位置
                if (a[j - 1] > a[j]) {
                    int v = a[j];
                    a[j] = a[j - 1];
                    a[j - 1] = v;
                }
            }
//            System.out.println(Arrays.toString(a));
        }
        return a;

    }

    public static void main(String[] args) {
        int[] a = Utils.genRandomArray(10, 20);
        int[] b = Utils.genRandomArray(8, 50);
        int[] r0 = InsertionSort(a);
        System.out.println(Arrays.toString(r0));
        int[] r1 = BubbleSort(b);
        System.out.println(Arrays.toString(r1));
    }
}
