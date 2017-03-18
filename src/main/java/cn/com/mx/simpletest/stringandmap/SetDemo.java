package cn.com.mx.simpletest.stringandmap;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;

/**
 * Created by wangchangye on 2016/12/30.
 *
 * @Author wangchangye
 */
public class SetDemo {

        public static void main(String[] args) {

            HashSet<String> hs = new HashSet<String>();
            hs.add("B");
            hs.add("A");
            hs.add("D");
            hs.add("E");
            hs.add("C");
            hs.add("F");
            System.out.println("HashSet顺序:\n"+hs);

            LinkedHashSet<String> lhs = new LinkedHashSet<String>();
            lhs.add("B");
            lhs.add("A");
            lhs.add("D");
            lhs.add("E");
            lhs.add("C");
            lhs.add("F");
            System.out.println("LinkedHashSet顺序:\n"+lhs);

            TreeSet<String> ts = new TreeSet<String>();
            ts.add("Z");
            ts.add("B");
            ts.add("A");
            ts.add("D");
            ts.add("E");
            ts.add("C");
            ts.add("F");
            ts.add("G");
            System.out.println("TreeSet顺序:\n"+ts);

            LinkedHashSet set = new LinkedHashSet(2);
            set.add("A");
            set.add("B");
            set.add("C");
            System.out.println(set.contains("A"));
            System.out.println(set);
    }
}
