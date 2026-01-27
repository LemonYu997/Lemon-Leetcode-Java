package problems.c0easy.t3001t3500;

/**
 * 3190 使所有元素都可以被 3 整除的最少操作数 https://leetcode.cn/problems/find-minimum-operations-to-make-all-elements-divisible-by-three/description/
 * 给你一个整数数组 nums 。一次操作中，你可以将 nums 中的 任意 一个元素增加或者减少 1 。
 * 请你返回将 nums 中所有元素都可以被 3 整除的 最少 操作次数。
 *
 * 示例：
 * 输入1：nums = [1,2,3,4]
 * 输出1：3
 *
 * 示例2：
 * 输入2：nums = [3,6,9]
 * 输出2：0
 */
public class T3190 {
    /**
     * 自己实现：一次遍历即可
     */
    public int minimumOperations(int[] nums) {
        int ans = 0;
        for (int num : nums) {
            // 主要是判断需要加还是减更容易达到3的倍数
            // 余数为 2 则加1，余数为 1 则减1，操作数都为1次
            // 所以只要有余数不为 0 的情况就算一次操作数即可
            if (num % 3 != 0) {
                ans++;
            }
        }
        return ans;
    }
}
