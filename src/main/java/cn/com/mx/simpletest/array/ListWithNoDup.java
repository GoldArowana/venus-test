package cn.com.mx.simpletest.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

/**
 * Created by wangchangye on 2017/1/3.
 *
 * @Author wangchangye
 */
public class ListWithNoDup {
        public static void main(String[] args) {
            List<String> listWithDup = new ArrayList<String>();
            listWithDup.add("1");
            listWithDup.add("2");
            listWithDup.add("3");
            listWithDup.add("1");

            List<String> listWithoutDup = new ArrayList<String>(new HashSet<String>(listWithDup));
            System.out.println("list with dup:"+ listWithDup);
            System.out.println("list without dup:"+ listWithoutDup);

            sort02();
        }

        private static void sort02(){

            List<String> resourceList = new ArrayList<String>();
            resourceList.add("1");
            resourceList.add("2");
            resourceList.add("5");
            resourceList.add("3");
            resourceList.add("1");
            resourceList.add("4");

            List<String> newList = new ArrayList<String>();
            for (String s : resourceList) {
                if(Collections.frequency(newList, s) < 1){
                    newList.add(s);
                }
            }
            System.out.println(newList);
        }


}
