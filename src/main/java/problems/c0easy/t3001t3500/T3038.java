package problems.c0easy.t3001t3500;

/**
 * 3038 相同分数的最大操作数目 I https://leetcode.cn/problems/maximum-number-of-operations-with-the-same-score-i/description/
 * 给你一个整数数组 nums ，如果 nums 至少 包含 2 个元素，你可以执行以下操作：
 * 选择 nums 中的前两个元素并将它们删除。
 * 一次操作的 分数 是被删除元素的和。
 * 在确保 所有操作分数相同 的前提下，请你求出 最多 能进行多少次操作。
 * 请你返回按照上述要求 最多 可以进行的操作次数。
 *
 * 示例：
 * 输入1：nums = [3,2,1,4,5]
 * 输出1：2
 *
 * 输入2：nums = [3,2,6,1,4]
 * 输出2：1
 */
public class T3038 {
    /**
     * 自己实现：根据题意模拟
     */
    public int maxOperations(int[] nums) {
        int n = nums.length;
        int count = 1;
        int pre = nums[0] + nums[1];
        for (int i = 3; i < n; i+=2) {
            if (nums[i] + nums[i - 1] == pre) {
                count++;
            } else {
                break;
            }
        }

        return count;
    }


    /**
     * 官方解法：优化写法
     */
    public int maxOperations1(int[] nums) {
        int n = nums.length, t = 0;
        for (int i = 1; i < n; i += 2) {
            if (nums[i] + nums[i - 1] != nums[1] + nums[0]) {
                break;
            }
            t++;
        }
        return t;
    }
}
