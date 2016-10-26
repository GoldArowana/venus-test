package cn.com.mx.simpletest.reflection;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class Test<T> extends BaseAction<T>{
	public static void main(String[] args) {
	}
	
	
	
	
	@SuppressWarnings({ "rawtypes", "unused" })
	private static Class getSuperClassGenricType(final Class clazz, final int index) {
		Type genType = clazz.getGenericSuperclass();
		if (!(genType instanceof ParameterizedType)) {
			return Object.class;
		}
		Type[] params = ((ParameterizedType) genType).getActualTypeArguments();
		if (index >= params.length || index < 0) {
			return Object.class;
		}
		if (!(params[index] instanceof Class)) {
			return Object.class;
		}
		return (Class) params[index];
	}
}
