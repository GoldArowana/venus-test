package cn.com.mx.algorithm;

/**
 * Created by wangchangye on 2017/3/23.
 *
 * @Author wangchangye
 */
public class Jiaofen {
    public static void main(String args[])
    {
        int i,j,k;
        int n=0;
        for(i=0;i<3;i++)                            //五分的硬币最多2个
        {
            for(j=0;j<=(10-5*i)/2;j++)              //2分的硬币的个数最多为（100-5i）/2
            {
                for(k=0;k<=10-5*i-2*j;k++)              //1分的硬币的个数最多为100-5i-2j
                {
                    n++;
                    if(10==5*i+2*j+k)     //注意是“==”
                        System.out.println("1fen:"+k+"->" +
                                "2fen:"+j+
                                "->5fen:"+i);

                }
            }
        }
        System.out.println(n);
    }
}
