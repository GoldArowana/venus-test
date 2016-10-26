package cn.com.mx.simpletest.annotation;

import java.lang.reflect.Method;  


public class Test{
  
    public static void main(String[] args) {  
        Method[] methods = Person.class.getMethods();  
        for(Method method : methods){  
            if(method.isAnnotationPresent(Name.class)){  
                Name name = method.getAnnotation(Name.class);  
                System.out.println("firstName:" + name.firstName() +",lastName:" + name.lastName());  
            }  
        }  
    }  
}  
