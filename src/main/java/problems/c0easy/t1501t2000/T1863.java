package problems.c0easy.t1501t2000;

/**
 * 1863 找出所有子集的异或总和再求和 https://leetcode.cn/problems/sum-of-all-subset-xor-totals/description/
 * 一个数组的 异或总和 定义为数组中所有元素按位 XOR 的结果；如果数组为 空 ，则异或总和为 0 。
 * 例如，数组 [2,5,6] 的 异或总和 为 2 XOR 5 XOR 6 = 1 。
 * 给你一个数组 nums ，请你求出 nums 中每个 子集 的 异或总和 ，计算并返回这些值相加之 和 。
 * 注意：在本题中，元素 相同 的不同子集应 多次 计数。
 * 数组 a 是数组 b 的一个 子集 的前提条件是：从 b 删除几个（也可能不删除）元素能够得到 a 。
 *
 * 示例：
 * 输入1：nums = [1,3]
 * 输出1：6
 *
 * 输入2：nums = [5,1,6]
 * 输出2:28
 *
 * 输入3：nums = [3,4,5,6,7,8]
 * 输出3：480
 */
public class T1863 {
    /**
     * 官方解法：迭代所有子集
     */
    public int subsetXORSum(int[] nums) {
        int ans = 0;
        int n = nums.length;

        // 遍历所有子集
        for (int i = 0; i < (1 << n); i++) {
            int temp = 0;
            // 遍历子集中的每个元素
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                    temp ^= nums[i];
                }
            }

            ans += temp;
        }

        return ans;
    }
}
