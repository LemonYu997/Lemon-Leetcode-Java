package problems.c0easy.t2501t3000;

/**
 * 2717 半有序排列 https://leetcode.cn/problems/semi-ordered-permutation/description/
 * 给你一个下标从 0 开始、长度为 n 的整数排列 nums 。
 * 如果排列的第一个数字等于 1 且最后一个数字等于 n ，则称其为 半有序排列 。
 * 你可以执行多次下述操作，直到将 nums 变成一个 半有序排列 ：
 * 选择 nums 中相邻的两个元素，然后交换它们。
 * 返回使 nums 变成 半有序排列 所需的最小操作次数。
 *
 * 排列 是一个长度为 n 的整数序列，其中包含从 1 到 n 的每个数字恰好一次。
 *
 * 示例：
 * 输入1：nums = [2,1,4,3]
 * 输出1：2
 *
 * 输入2：nums = [2,4,1,3]
 * 输出2：3
 *
 * 输入3：nums = [1,3,4,2,5]
 * 输出3：0
 */
public class T2717 {
    /**
     * 自己实现：只考虑 1 和 n 的位置以及要交换的次数即可
     */
    public int semiOrderedPermutation(int[] nums) {
        int n = nums.length;
        int i1 = 0;
        int in = 0;
        // 找到 1 和 n 的位置
        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) {
                i1 = i;
            } else if (nums[i] == n) {
                in = i;
            }
        }
        // 计算要交换的次数
        // 如果 i1 < in，则 i1 移动到 0 的次数为 i1，in 移动到 n-1 的位置为 n-1-in
        if (i1 < in) {
            return i1 + (n - 1 - in);
        } else {
            // 如果 in > i1，则 i1 移动到 0 的次数为 i1，in 移动到 n-1 的位置因为这时会交叉，所以为 n-1-in - 1
            return i1 + (n - 2 - in);
        }
    }
}
