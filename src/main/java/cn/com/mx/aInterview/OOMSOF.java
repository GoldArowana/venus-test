package cn.com.mx.aInterview;

import java.util.ArrayList;

public class OOMSOF {
	//OOM 堆溢出
	public static void main(String[] args)
    {
        ArrayList list=new ArrayList();
        while(true)
        {
            list.add(new OOMSOF());
        }
    }
}
