package problems.c0easy.t2501t3000;

/**
 * 2644 找出可整除性得分最大的整数 https://leetcode.cn/problems/find-the-maximum-divisibility-score/description/
 * 给你两个整数数组 nums 和 divisors 。
 * divisors[i] 的 可整除性得分 等于满足 nums[j] 能被 divisors[i] 整除的下标 j 的数量。
 * 返回 可整除性得分 最大的整数 divisors[i] 。如果有多个整数具有最大得分，则返回数值最小的一个。
 *
 * 示例：
 * 输入1：nums = [2,9,15,50], divisors = [5,3,7,2]
 * 输出1：2
 *
 * 输入2：nums = [4,7,9,3,9], divisors = [5,2,3]
 * 输出2：3
 *
 * 输入3：nums = [20,14,21,10], divisors = [10,16,20]
 * 输出3：10
 */
public class T2644 {
    /**
     * 自己实现：根据题意模拟
     */
    public int maxDivScore(int[] nums, int[] divisors) {
        int maxCount = 0;
        int min = Integer.MAX_VALUE;

        for (int divisor : divisors) {
            int temp = 0;
            for (int num : nums) {
                if (num % divisor == 0) {
                    temp++;
                }
            }
            if (temp > maxCount) {
                maxCount = temp;
                min = divisor;
            } else if (temp == maxCount) {
                min = Math.min(min, divisor);
            }
        }

        return min;
    }
}
