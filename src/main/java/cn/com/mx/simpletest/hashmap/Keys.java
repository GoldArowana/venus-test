package cn.com.mx.simpletest.hashmap;

import java.util.HashMap;

public class Keys {
	public static final int MAX_KEY = 10_000_000;
	private static final Key[] KEYS_CACHE = new Key[MAX_KEY];

		static {
			for (int i = 0; i < MAX_KEY; ++i) {
				KEYS_CACHE[i] = new Key(i);
			}
		}

		public static Key of(int value) {
			return KEYS_CACHE[value];
		}
		
		static void test(int mapSize) {

	        HashMap<Key, Integer> map = new HashMap<Key,Integer>(mapSize);
	        for (int i = 0; i < mapSize; ++i) {
	            map.put(Keys.of(i), i);
	        }

	        long beginTime = System.nanoTime(); //获取纳秒
	        for (int i = 0; i < mapSize; i++) {
	            map.get(Keys.of(i));
	        }
	        long endTime = System.nanoTime();
	        System.err.println(endTime - beginTime);
	    }

	    public static void main(String[] args) {
	        for(int i=10;i<= 1000_0000;i*= 10){
	            test(i);
	        }
	    }
		
		
		
		
}//
