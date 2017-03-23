package cn.com.mx.algorithm;

/**
 * Created by wangchangye on 2017/3/23.
 *
 * @Author wangchangye
 */
public class deleteNumber {
    public static void main(String[] args) {
        int solution = Solution(10, 1);
        System.out.println("10->1======" + solution);
        int solution2 = Solution(2, 1);
        System.out.println("2->1=======" + solution2);
    }
    public static int Solution(int n, int m) {
        if (n < 1 || m < 1) {
            return -1;
        }
        int last = 0;
        for (int i = 2; i <= n; i++) {

            last = (last + m) % i;
        }

        return last;
    }
}
