package cn.com.mx.aInterview;

import java.util.Scanner;

/**
 * Created by wangchangye on 2017/3/28.
 *
 * @Author wangchangye
 */
public class InsertNumber {
    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40, 50};
        int[] arrchange = new int[arr.length + 1];

        System.out.print("before change:  ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print("  " + arr[i]);
        }
        System.out.println();

        System.out.println("Input a number:  ");
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();

        // 冒泡排序的思路
        arrchange = insort1(arr, number);
        System.out.print("changed:  ");
        for (int i = 0; i < arrchange.length; i++) {
            System.out.print("  " + arrchange[i]);
        }

    }

    public static int[] insort1(int[] arr, int number) {
        int[] arrchange = new int[arr.length + 1];

        //将源数组复制到新的数组里，新数组最后一个元素为需要插入的数字
        for (int i = 0; i < arr.length; i++) {
            arrchange[i] = arr[i];
        }
        arrchange[arr.length] = number;

        //类似进行冒泡排序的最后一轮
        for (int i = arr.length; i > 0; i--) {
            if (arrchange[i] < arrchange[i - 1]) {
                int temp = arrchange[i];
                arrchange[i] = arrchange[i - 1];
                arrchange[i - 1] = temp;
            }

        }
        return arrchange;
    }

}//

