package cn.com.mx.algorithm.sort;

/**
 * Created by wangchangye on 2017/2/8.
 *
 * @Author wangchangye
 */
public class sortTest {


    public static void main(String[] args) {
        int[] a = {3 ,5 ,4 ,2 ,1};
        bubbleSort(a);


        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }

    }

    //bubbo sort
    public static void bubbleSort(int[] arr){
        if(arr==null || arr.length==0) return;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = arr.length-1; j > i; j--) {
                if (arr[j] < arr[j-1]){
                    swap(arr, j-1, j);
                }
            }
        }

    }
    //select sort
    public static void selectSort(int[] arr) {
        if(arr == null || arr.length == 0)
            return ;
        int minIndex = 0;
        for(int i=0; i<arr.length-1; i++) { //只需要比较n-1次
            minIndex = i;
            for(int j=i+1; j<arr.length; j++) { //从i+1开始比较，因为minIndex默认为i了，i就没必要比了。
                if(arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            if(minIndex != i) { //如果minIndex不为i，说明找到了更小的值，交换之。
                swap(arr, i, minIndex);
            }
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }







}//end of class
