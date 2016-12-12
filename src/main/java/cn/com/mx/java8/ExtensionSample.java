package cn.com.mx.java8;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static java.util.Collections.swap;
import static java.util.Collections.binarySearch;
import static java.util.Collections.max;

public class ExtensionSample {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> otherList = Arrays.asList(1, 2, 3);

        Collections.swap(list,
                Collections.binarySearch(list, Collections.max(otherList)),
                Collections.max(list));

        swap(list, binarySearch(list, max(otherList)), max(list));

        //list.swap(list.binarySearch(otherList.max()), list.max());
    }
}
