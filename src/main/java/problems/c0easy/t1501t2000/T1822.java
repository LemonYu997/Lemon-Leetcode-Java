package problems.c0easy.t1501t2000;

/**
 * 1812 数组元素积的符号 https://leetcode.cn/problems/sign-of-the-product-of-an-array/description/
 * 已知函数 signFunc(x) 将会根据 x 的正负返回特定值：
 * 如果 x 是正数，返回 1 。
 * 如果 x 是负数，返回 -1 。
 * 如果 x 是等于 0 ，返回 0 。
 * 给你一个整数数组 nums 。令 product 为数组 nums 中所有元素值的乘积。
 * 返回 signFunc(product) 。
 *
 * 示例：
 * 输入1：nums = [-1,-2,-3,-4,3,2,1]
 * 输出1：1
 *
 * 输入2：nums = [1,5,0,2,-3]
 * 输出2：0
 *
 * 输入3：nums = [-1,1,-1,1,-1]
 * 输出3：-1
 */
public class T1822 {
    /**
     * 自己实现：统计负数出现的次数，奇数返回 -1，偶数 返回 1
     */
    public int arraySign(int[] nums) {
        int count = 0;
        for (int num : nums) {
            if (num == 0) {
                return 0;
            }
            if (num < 0) {
                count++;
            }
        }

        return count % 2 == 0 ? 1 : -1;
    }
}
