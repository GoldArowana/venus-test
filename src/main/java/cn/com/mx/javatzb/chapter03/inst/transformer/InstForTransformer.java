package cn.com.mx.javatzb.chapter03.inst.transformer;

import java.lang.instrument.Instrumentation;
import java.lang.instrument.UnmodifiableClassException;

public class InstForTransformer {
	
    private static Instrumentation inst;
	
    /*����Ϊagent��ϵͳ����ִ��main����ǰ�������*/
    public static void premain(String agentArgs, Instrumentation instP) {
       inst = instP;
       inst.addTransformer(new TestTransformer() , true);
       //����Ϊtrue�󣬿���������ʱ����retransformClasses�������������retransformClasses��Ч
       //inst.addTransformer(new TestTransformer() , true);
    }
    
    public static void reTransClass(Class <?>clazz) throws UnmodifiableClassException {
    	inst.retransformClasses(clazz);
    }
}
