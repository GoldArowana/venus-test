package cn.com.mx.algorithm;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by wangchangye on 2017/3/6.
 *
 * @Author wangchangye
 */
public class LRU {


    public class LRUCache2<K, V> extends LinkedHashMap<K, V> {
        private final int MAX_CACHE_SIZE;

        public LRUCache2(int cacheSize) {
            super((int) Math.ceil(cacheSize / 0.75) + 1, 0.75f, true);
            MAX_CACHE_SIZE = cacheSize;
        }

        @Override
        protected boolean removeEldestEntry(Map.Entry eldest) {
            return size() > MAX_CACHE_SIZE;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            for (Map.Entry<K, V> entry : entrySet()) {
                sb.append(String.format("%s:%s ", entry.getKey(), entry.getValue()));
            }
            return sb.toString();
        }
    }



    public static void main(String[] args) {
        //FIFO版本实现
        final int cacheSize = 5;
        LinkedHashMap<Integer, Object> lru = new LinkedHashMap<Integer, Object>() {
            @Override
            protected boolean removeEldestEntry(Map.Entry<Integer, Object> eldest) {
                return size() > cacheSize;
            }
        };
        lru.put(1,1);
        lru.put(2,2);
        lru.put(3,3);
        lru.put(4,4);
        lru.put(5,5);
        lru.put(6,6);
        lru.put(7,7);
        for (Integer key: lru.keySet()) {
            System.out.println(key);
        }
    }

}//end of class
