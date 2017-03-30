package cn.com.mx.LinteCode;

import java.util.Arrays;

/**
 * Created by wangchangye on 2017/3/29.
 */
public class Q2_3SumSmallest {

	public static int threeSumSmaller(int[] nums, int target) {
		if (nums == null || nums.length <= 2) {
			return 0;
		}
		Arrays.sort(nums);
		int rst = 0;
		for (int i = 0; i < nums.length - 2; i++) {
			int j = i + 1;
			int k = nums.length - 1;
			while (j < k) {
				if (nums[i] + nums[j] + nums[k] >= target) {
					k--;
				} else {
					rst += (k - j);
					j++;
				}
			}
		}//END for
		return rst;
	}

	public static void main(String[] args) {
		int[] numbers = {-2,0,1,3};
		int target = 2;
		int result = threeSumSmaller(numbers, target);
		System.out.println(result);
	}
}
