package cn.com.mx.javatzb.chapter03.asm;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URLClassLoader;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;

public class ASMTestMain {
	
	private final static DynamicClassLoader TEST_CLASS_LOADER = new DynamicClassLoader(
			(URLClassLoader)ASMTestMain.class.getClassLoader()
	);

	public static void main(String []args) 
			throws ClassNotFoundException, IOException, InstantiationException, 
			       IllegalAccessException, IllegalArgumentException, SecurityException, 
			       InvocationTargetException, NoSuchMethodException {
		//���ֽ�����ǿǰ��¼һ��Class
		Class <?>beforeASMClass = TEST_CLASS_LOADER.loadClass("chapter03.asm.ForASMTestClass");
		
		//��������װ���޸ĺ����
		TEST_CLASS_LOADER.defineClassByByteArray("chapter03.asm.ForASMTestClass", asmChangeClassCall());
		Class <?>afterASMClass = TEST_CLASS_LOADER.loadClass("chapter03.asm.ForASMTestClass");
		
		//�ֱ�ͨ������class��������
		Object beforeObject = beforeASMClass.newInstance();
		Object afterObject = afterASMClass.newInstance();
		
		//�ֱ�������ǵĴ���
		beforeASMClass.getMethod("display1").invoke(beforeObject);
		afterASMClass.getMethod("display1").invoke(afterObject);
	}
	
	private static byte[] asmChangeClassCall() throws IOException {
		ClassReader classReader = new ClassReader("chapter03.asm.ForASMTestClass");
		
		ClassWriter classWriter = new ClassWriter(ClassWriter.COMPUTE_MAXS);
		ASMClassModifyAdpter modifyAdpter = new ASMClassModifyAdpter(classWriter);
		classReader.accept(modifyAdpter, ClassReader.SKIP_DEBUG);
		//����������ֽ��룬������javap�������鿴Ŷ
        //byte []bytes = classWriter.toByteArray();
		//new FileOutputStream("d:/ForASMTestClass.class").write(bytes);
        //return bytes;
		
		return classWriter.toByteArray();
	}
}
