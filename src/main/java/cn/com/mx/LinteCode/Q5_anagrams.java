package cn.com.mx.LinteCode;

import java.util.*;

/**
 * Created by wangchangye on 2017/3/29.
 *
 * Example
 Given ["lint", "intl", "inlt", "code"], return ["lint", "inlt", "intl"].

 Given ["ab", "ba", "cd", "dc", "e"], return ["ab", "ba", "cd", "dc"].

 */
public class Q5_anagrams {

    public static List<String> anagrams(String[] strs) {
        List<String> rst = new ArrayList<String>();
        if (strs == null || strs.length == 0) {
            return rst;
        }
        HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
        for (int i = 0; i < strs.length; i++) {
            char[] arr = strs[i].toCharArray();
            Arrays.sort(arr);
            String s = String.valueOf(arr);
            if (!map.containsKey(s)) {
                ArrayList<String> list = new ArrayList<String>();
                map.put(s, list);
            }
            map.get(s).add(strs[i]);
        }
        //check instance occurs >= 2
        for (Map.Entry<String, ArrayList<String>> entry : map.entrySet()) {
            if (entry.getValue().size() >= 2) {
                rst.addAll(entry.getValue());
            }
        }
        return rst;
    }

    public static void main(String[] args) {
        String[] strs = {"ab","ba","cd","dc","ef"};
        List<String> result = anagrams(strs);
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }

    }
}
