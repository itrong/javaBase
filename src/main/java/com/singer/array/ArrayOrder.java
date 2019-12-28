package com.singer.array;

/**
 * 数组排序
 *
 * @author lujianrong
 */
public class ArrayOrder {


    public static void main(String[] args) {
        int[] arr = {1, 3, 6, 8, 1, 3, 0, 9, 3, 4, 5};
        bubbleSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }
        System.out.println();
        int[] arr2 = {1, 3, 6, 8, 1, 3, 0, 9, 3, 4, 5};
        selectSort(arr2);
        for (int i = 0; i < arr2.length; i++) {
            System.out.print(arr2[i]);
        }

    }

    /**
     * 冒泡排序
     */
    private static void bubbleSort(int[] arr) {
        int length = arr.length;
        for (int i = 1; i < length; i++) {
            for (int j = 0; j < length - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }

    /**
     * 选择排序
     */
    private static void selectSort(int[] arr) {
        int length = arr.length;
        for (int i = 0; i < length - 1; i++) {
            for (int j = i + 1; j < length; j++) {
                if (arr[i] > arr[j]) {
                    swap(arr, i, j);
                }
            }
        }
    }

    /**
     * 交换数组
     */
    private static void swap(int[] arr, int x, int y) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }
}
