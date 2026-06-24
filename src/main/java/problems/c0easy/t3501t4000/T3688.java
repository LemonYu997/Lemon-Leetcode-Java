package problems.c0easy.t3501t4000;

/**
 * 3688 偶数的按位或运算 https://leetcode.cn/problems/bitwise-or-of-even-numbers-in-an-array/description/
 * 给你一个整数数组 nums。
 * 返回数组中所有 偶数 的按位 或 运算结果。
 * 如果 nums 中没有偶数，返回 0。
 *
 * 示例：
 * 输入1：nums = [1,2,3,4,5,6]
 * 输出1：6
 *
 * 输入2：nums = [7,9,11]
 * 输出2：0
 *
 * 输入3：nums = [1,8,16]
 * 输出3：24
 */
public class T3688 {
    /**
     * 自己实现：根据题意计算即可
     */
    public int evenNumberBitwiseORs(int[] nums) {
        // 任何数和 0 或都为它本身，因此可以设置初始值为 0
        int ans = 0;
        for (int num : nums) {
            if (num % 2 == 0) {
                ans |= num;
            }
        }
        return ans;
    }
}
