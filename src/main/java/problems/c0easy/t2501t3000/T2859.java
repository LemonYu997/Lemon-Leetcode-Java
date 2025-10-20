package problems.c0easy.t2501t3000;

import java.util.List;

/**
 * 2859 计算 K 置位下标对应元素的和 https://leetcode.cn/problems/sum-of-values-at-indices-with-k-set-bits/description/
 * 给你一个下标从 0 开始的整数数组 nums 和一个整数 k 。
 * 请你用整数形式返回 nums 中的特定元素之 和 ，这些特定元素满足：其对应下标的二进制表示中恰存在 k 个置位。
 * 整数的二进制表示中的 1 就是这个整数的 置位 。
 * 例如，21 的二进制表示为 10101 ，其中有 3 个置位。
 *
 * 示例：
 * 输入1：nums = [5,10,1,5,2], k = 1
 * 输出1：13
 *
 * 输入2：nums = [4,3,2,1], k = 2
 * 输出2：1
 */
public class T2859 {
    /**
     * 自己实现：根据题意遍历即可
     */
    public int sumIndicesWithKSetBits(List<Integer> nums, int k) {
        int n = nums.size();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (Integer.bitCount(i) == k) {
                ans += nums.get(i);
            }
        }
        return ans;
    }
}
