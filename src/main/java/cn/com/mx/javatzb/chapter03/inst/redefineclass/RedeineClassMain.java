package cn.com.mx.javatzb.chapter03.inst.redefineclass;

import java.io.IOException;

import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;
import javassist.NotFoundException;
import chapter03.asm.ForASMTestClass;

public class RedeineClassMain {

	public static void main(String []args) throws Exception {
		ForASMTestClass testClass = new ForASMTestClass();
		
		byte[] bytes = convertByteCode();
		
		InstForRedefineClass.redefineClass(ForASMTestClass.class, bytes);
		testClass.display1();
	}

	private static byte[] convertByteCode() throws NotFoundException,
			CannotCompileException, IOException {
		CtClass ctClass = ClassPool.getDefault().get("chapter3.asm.ForASMTestClass");
		CtMethod ctMethod = ctClass.getDeclaredMethod("display1");
		ctMethod.insertBefore("{ System.out.println(\"ǰ���һ��ѽ��\"); }");
		ctMethod.insertAfter(
				"String a = \"�����String\";" +
				"System.out.println(\"����Ҷ����String��\" + a);"
		);
		byte[]bytes = ctClass.toBytecode();
		return bytes;
	}
}
