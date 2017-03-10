package cn.com.mx.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by wangchangye on 2017/3/10.
 *
 * @Author wangchangye
 */
public class Hanoi
{
    public static void main(String[] args) throws IOException
    {
        int n;
        BufferedReader buf;
        buf = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("plates num:");
        n = Integer.parseInt(buf.readLine());

        Hanoi hanoi = new Hanoi();
        hanoi.move(n, 'A', 'B', 'C');
    }

    public void move(int n, char a, char b, char c)
    {
        if(n == 1)
            System.out.println("plate " + n + " from " + a + " to " + c);
        else {
            move(n - 1, a, c, b);
            System.out.println("plate" + n + " from " + a + " to " + c);
            move(n - 1, b, a, c);
        }
    }
}