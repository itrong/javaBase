package com.singer.array;

/**
 * 数组查找
 *
 * @author lujianrong
 */
public class ArraySearch {


    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 3, 4, 5};
        int key = 2;
        System.out.println(halfSearch(arr, key));
    }


    /**
     * 二分法查找
     */
    static int halfSearch(int[] arr, int key) {

        int min = 0;
        int max = arr.length - 1;
        int mid = (min + max) >> 1;

        while (min <= max) {
            System.out.println(mid);
            if (arr[mid] == key) {
                return mid;
            }
            if (arr[mid] < key) {
                min = mid + 1;
                mid = (min + max) >> 1;
            } else {
                max = mid - 1;
                mid = (min + max) >> 1;
            }
        }
        return -1;
    }
}
