package cn.com.mx.simpletest.fastjson;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.SerializeWriter;

import cn.com.mx.simpletest.model.Car;
import cn.com.mx.simpletest.model.Sofa;
import cn.com.mx.simpletest.model.Wheel;

public class TestFilter {
		public static void main(String args[]){
			Map<String,Car> map = new HashMap<String, Car>();
			map.put("car1", new Car());
			map.put("car2", new Car());
			//需要过滤的类 + 属性
			Map<Class<?>, Set<String>> includeMap = new HashMap<Class<?>, Set<String>>();
			Set<String> set = new HashSet<String>();
			set.add("color");
			//wheel干掉color
			includeMap.put(Wheel.class, set);
			set = new HashSet<String>();
			//sofa干掉texture
			set.add("texture");
			includeMap.put(Sofa.class, set);
			
			ComplexPropertyPreFilter cfilter = new ComplexPropertyPreFilter(includeMap);
			SerializeWriter sw = new SerializeWriter();
			JSONSerializer serializer = new JSONSerializer(sw); 
			serializer.getPropertyFilters().add(cfilter);
			serializer.write(map);  
			
			System.out.println(sw.toString());
		}

	}


