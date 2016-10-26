package cn.com.mx.javatzb.chapter03.inst.sizeof;

import java.lang.instrument.Instrumentation;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.Stack;

public class DeepObjectSizeOf {
	
	private static Instrumentation inst;

	public static void premain(String agentArgs, Instrumentation instP) {
		inst = instP;
	}

	public static long sizeOf(Object object) {
		return inst.getObjectSize(object);
	}
	
	public static long deepSizeOf(Object obj) {//����������󣬲������С
	       Map<Object, Object> visited = new IdentityHashMap<Object, Object>();
	       Stack<Object> stack = new Stack<Object>();
	       long result = internalSizeOf(obj, stack, visited);
	       while (!stack.isEmpty()) {//ͨ��ջ���б���
	          result += internalSizeOf(stack.pop(), stack, visited);
	       }
	       visited.clear();
	       return result;
	    }

	    private static boolean needSkipObject(Object obj, Map<Object, Object> visited) {
	       if (obj instanceof String) {
	          if (obj == ((String) obj).intern()) {
	             return true;
	          }
	       }
	       return (obj == null) || visited.containsKey(obj);
	    }

	    private static long internalSizeOf(Object obj, Stack<Object> stack, Map<Object, Object> visited) {
	       if (needSkipObject(obj, visited)) {
	           return 0;
	       }
	       visited.put(obj, null);//����ǰ�������ջ��
	       long result = 0;
	       result += sizeOf(obj);
	       Class <?>clazz = obj.getClass();
	       if (clazz.isArray()) {//�������
	           if(clazz.getName().length() != 2) {//���primitive type array��Class��nameΪ2λ
	              int length =  Array.getLength(obj);
	              for (int i = 0; i < length; i++) {
	                 stack.add(Array.get(obj, i));
	              }
	           }
	           return result;
	       }
	       return getNodeSize(clazz , result , obj , stack);
	   }

	   //���������ȡ�������������Ĵ�С�����ҿ������������������
	   private static long getNodeSize(Class <?>clazz , long result , Object obj , Stack<Object> stack) {
	      while (clazz != null) {
	          Field[] fields = clazz.getDeclaredFields();
	          for (Field field : fields) {
	              if (!Modifier.isStatic(field.getModifiers())) {//�����׿���̬����
	                   if (field.getType().isPrimitive()) {//�����׿���ؼ��֣���Ϊ��ؼ����ڵ���javaĬ���ṩ�ķ������Ѿ�������ˣ�
	                       continue;
	                   }else {
	                       field.setAccessible(true);
	                      try {
	                           Object objectToAdd = field.get(obj);
	                           if (objectToAdd != null) {
	                                  stack.add(objectToAdd);//���������ջ�У�һ�鵯����������
	                           }
	                       } catch (IllegalAccessException ex) {
	                           assert false;
	                  }
	              }
	          }
	      }
	      clazz = clazz.getSuperclass();//�Ҹ���class��ֱ��û�и���
	   }
	   return result;
	  }
}
