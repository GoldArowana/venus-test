package cn.com.mx.springs;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest {
    @SuppressWarnings("resource")
	public static void main(String[] args){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("resources/bean.xml");//读取bean.xml中的内容
        Person p = ctx.getBean("person",Person.class);//创建bean的引用对象
        p.info();
    }
}