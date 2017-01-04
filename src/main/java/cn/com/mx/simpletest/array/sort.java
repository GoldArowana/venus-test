package cn.com.mx.simpletest.array;

import java.util.Arrays;

/**
 * Created by wangchangye on 2017/1/3.
 *
 * @Author wangchangye
 *  arrays.sort & collections.sort
 */


public class sort {
    /**
     * (1)Arrays类中的sort()使用的是“经过调优的快速排序法”;

     (2)比如int[]，double[]，char[]等基数据类型的数组，Arrays类之只是提供了默认的升序排列，没有提供相应的降序排列方法。

     (3)要对基础类型的数组进行降序排序，需要将这些数组转化为对应的封装类数组，如Integer[]，Double[]，Character[]等，对这些类数组进行排序。(其实还不如先进行升序排序，自己在转为将序)。
     */
    public static void main(String[] args) {

        //
        arrayssort01();
    }
    private static void arrayssort01(){
        int[] a={1,4,-1,5,0};
        Arrays.sort(a);
        //数组a[]的内容变为{-1,0,1,4,5}
        for(int i=0;i<a.length;i++)
            System.out.print(a[i]+"  ");
    }



    class Point{
        int x;
        int y;
    }
}//end of class
