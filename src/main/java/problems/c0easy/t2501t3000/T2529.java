package problems.c0easy.t2501t3000;

/**
 * 2529 正整数和负整数的最大计数 https://leetcode.cn/problems/maximum-count-of-positive-integer-and-negative-integer/description/
 * 给你一个按 非递减顺序 排列的数组 nums ，
 * 返回正整数数目和负整数数目中的最大值。
 * 换句话讲，如果 nums 中正整数的数目是 pos ，
 * 而负整数的数目是 neg ，返回 pos 和 neg二者中的最大值。
 * 注意：0 既不是正整数也不是负整数。
 *
 * 示例：
 * 输入1：nums = [-2,-1,-1,1,2,3]
 * 输出1：3
 *
 * 输入2：nums = [-3,-2,-1,0,0,1,2]
 * 输出2：3
 *
 * 输入3：nums = [5,20,66,1314]
 * 输出3：4
 */
public class T2529 {
    /**
     * 自己实现：根据题意遍历即可
     */
    public int maximumCount(int[] nums) {
        int a = 0;
        int b = 0;

        for (int num : nums) {
            if (num > 0) {
                a++;
            }
            if (num < 0) {
                b++;
            }
        }

        return Math.max(a, b);
    }
}
