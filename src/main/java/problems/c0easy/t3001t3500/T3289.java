package problems.c0easy.t3001t3500;

/**
 * 3289 数字小镇中的捣蛋鬼 https://leetcode.cn/problems/the-two-sneaky-numbers-of-digitville/description/
 * 数字小镇 Digitville 中，存在一个数字列表 nums，其中包含从 0 到 n - 1 的整数。
 * 每个数字本应 只出现一次，然而，有 两个 顽皮的数字额外多出现了一次，使得列表变得比正常情况下更长。
 * 为了恢复 Digitville 的和平，作为小镇中的名侦探，请你找出这两个顽皮的数字。
 * 返回一个长度为 2 的数组，包含这两个数字（顺序任意）。
 *
 * 示例：
 * 输入1：nums = [0,1,1,0]
 * 输出1：[0,1]
 *
 * 输入2：nums = [0,3,2,1,3,2]
 * 输出2：[2,3]
 *
 * 输入3：nums = [7,1,5,4,3,4,6,0,9,5,8,2]
 * 输出3：[4,5]
 *
 * 2 <= n <= 100
 * nums.length == n + 2
 * 0 <= nums[i] < n
 */
public class T3289 {
    /**
     * 自己实现：找出重复数字即可
     */
    public int[] getSneakyNumbers(int[] nums) {
        // 因为 n 最大为100，可以拿数组统计
        int[] temp = new int[nums.length];
        int[] ans = new int[2];
        int ind = 0;

        for (int num : nums) {
            if (temp[num] == 1) {
                ans[ind++] = num;
            }
            temp[num]++;
        }

        return ans;
    }

    /**
     * 官方解法：数学
     * 1 ~ n-1
     */
    public int[] getSneakyNumbers1(int[] nums) {
        int n = nums.length - 2;
        double sum = 0, squaredSum = 0;
        for (int x : nums) {
            sum += x;
            squaredSum += x * x;
        }
        // 实际求和值 - 理论求和值
        double sum2 = sum - n * (n - 1) / 2.0;
        double squaredSum2 = squaredSum - n * (n - 1) * (2 * n - 1) / 6.0;
        int x1 = (int)((sum2 - Math.sqrt(2 * squaredSum2 - sum2 * sum2)) / 2);
        int x2 = (int)((sum2 + Math.sqrt(2 * squaredSum2 - sum2 * sum2)) / 2);
        return new int[]{x1, x2};
    }
}
