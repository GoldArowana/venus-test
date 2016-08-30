package cn.com.mx.javatzb.chapter07.annotation;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.StringUtils;

public class ConvertionService {

	private static List<Field> findFields(Class <?>clazz) {
		List<Field> fieldList = new ArrayList<Field>();
		Set<String>fieldNames = new HashSet<String>();
        Class <?>clazzTemp = clazz;
        while(clazzTemp != Object.class) {
        	Field []fields = clazzTemp.getDeclaredFields();
        	for(Field field : fields) {
        		if(!fieldNames.contains(field.getName())) {//ͬ���������า��
        			fieldList.add(field);
        			fieldNames.add(field.getName());
        		}
        	}
            clazzTemp = clazzTemp.getSuperclass();
        }
        return fieldList;
	}
	
	@SuppressWarnings("unchecked")
	public static <T> T convertMapToBean(Map<String , String>row , Class<T>clazz) 
				throws InstantiationException, IllegalAccessException {
		Object object = clazz.newInstance();
		List<Field>list = findFields(clazz);
		for(Field field : list) {
			if (!Modifier.isStatic(field.getModifiers()) && !Modifier.isFinal(field.getModifiers())) {
				if(!field.isAccessible()) field.setAccessible(true);
				Column columnAnnotation = field.getAnnotation(Column.class);
				if(columnAnnotation != null) {
					String value = row.get(columnAnnotation.name());//通过注解名称获取对应的值
					Class <?>fieldType = field.getType();
					if(fieldType == String.class) {
						field.set(object, value);
					}else if(fieldType == Integer.class) {
						field.set(object, getInteger(value));
					}else if(fieldType == int.class) {
						field.setInt(object, getInt(value));
					}else if(fieldType == Long.class) {
						field.set(object, getLongWrapper(value));
					}else if(fieldType == long.class) {
						field.setLong(object , getLong(value));
					}/*
						�����������ʹ�ҿ����Լ�����
					*/
				}else {
					/*û��annotation�Ĵ��뽻�����Լ�ȥ�����*/
				}
			}
		}
		return (T)object;
	}
	
	public static Integer getInteger(String value) {
        if (StringUtils.isEmpty(value)) return null;
        return Integer.valueOf(value);
    }

    public static int getInt(String value) {
        if (StringUtils.isEmpty(value)) return 0;
        return Integer.valueOf(value);
    }

    public static Long getLongWrapper(String value) {
        if (StringUtils.isEmpty(value)) return null;
        return Long.valueOf(value);
    }

    public static long getLong(String value) {
        if (StringUtils.isEmpty(value)) return 0;
        return Long.valueOf(value);
    }
}
