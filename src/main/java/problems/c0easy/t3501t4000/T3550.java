package problems.c0easy.t3501t4000;

/**
 * 3550 数位和等于下标的最小下标 https://leetcode.cn/problems/smallest-index-with-digit-sum-equal-to-index/description/
 * 给你一个整数数组 nums 。
 * 返回满足 nums[i] 的数位和（每一位数字相加求和）等于 i 的 最小 下标 i 。
 * 如果不存在满足要求的下标，返回 -1 。
 *
 * 示例：
 * 输入1：nums = [1,3,2]
 * 输出1：2
 *
 * 输入2：nums = [1,10,11]
 * 输出2：1
 *
 * 输入3：nums = [1,2,3]
 * 输出3：-1
 */
public class T3550 {
    /**
     * 自己实现：根据题意模拟
     */
    public int smallestIndex(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            // 计算数位和
            int num = nums[i];
            int sum = 0;
            while (num > 0) {
                sum += num % 10;
                num /= 10;
            }
            if (sum == i) {
                return i;
            }
        }

        return -1;
    }
}
