package problems.c0easy.t2001t2500;

/**
 * 2057 值相等的最小索引 https://leetcode.cn/problems/smallest-index-with-equal-value/description/
 * 给你一个下标从 0 开始的整数数组 nums ，返回 nums 中满足 i mod 10 == nums[i] 的最小下标 i ；
 * 如果不存在这样的下标，返回 -1 。
 *
 * x mod y 表示 x 除以 y 的 余数 。
 *
 * 示例：
 * 输入1：nums = [0,1,2]
 * 输出1：0
 *
 * 输入2：nums = [4,3,2,1]
 * 输出2：2
 *
 * 输入3：nums = [1,2,3,4,5,6,7,8,9,0]
 * 输出3：-1
 *
 * 输入4：nums = [2,1,3,5,2]
 * 输出：1
 */
public class T2057 {
    /**
     * 自己实现：根据题意遍历
     */
    public int smallestEqual(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (i % 10 == nums[i]) {
                return i;
            }
        }

        return -1;
    }
}
