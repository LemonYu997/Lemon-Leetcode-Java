package problems.c0easy.t2001t2500;

/**
 * 2341 数组能形成多少数对 https://leetcode.cn/problems/maximum-number-of-pairs-in-array/description/
 * 给你一个下标从 0 开始的整数数组 nums 。在一步操作中，你可以执行以下步骤：
 * 从 nums 选出 两个 相等的 整数
 * 从 nums 中移除这两个整数，形成一个 数对
 * 请你在 nums 上多次执行此操作直到无法继续执行。
 * 返回一个下标从 0 开始、长度为 2 的整数数组 answer 作为答案，其中 answer[0] 是形成的数对数目，
 * answer[1] 是对 nums 尽可能执行上述操作后剩下的整数数目。
 *
 * 示例：
 * 输入1；nums = [1,3,2,1,3,2,2]
 * 输出1：[3,1]
 *
 * 输入2：nums = [1,1]
 * 输出2；[1,0]
 *
 * 输入3：nums = [0]
 * 输出3：[0,1]
 *
 * 提示：
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 100
 */
public class T2341 {
    /**
     * 自己实现：使用数组统计所有数字出现的次数，根据 0 <= nums[i] <= 100
     */
    public int[] numberOfPairs(int[] nums) {
        int[] temp = new int[101];

        for (int num : nums) {
            temp[num]++;
        }

        int[] ans = new int[2];
        for (int i : temp) {
            // 对数即为相同数字的偶数对个数
            ans[0] += i / 2;
            // 剩余数字个数
            ans[1] += i % 2;
        }

        return ans;
    }
}
