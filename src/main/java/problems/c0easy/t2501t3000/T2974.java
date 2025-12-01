package problems.c0easy.t2501t3000;

import java.util.Arrays;

/**
 * 2974 最小数字游戏 https://leetcode.cn/problems/minimum-number-game/description/
 * 你有一个下标从 0 开始、长度为 偶数 的整数数组 nums ，同时还有一个空数组 arr 。
 * Alice 和 Bob 决定玩一个游戏，游戏中每一轮 Alice 和 Bob 都会各自执行一次操作。游戏规则如下：
 * 每一轮，Alice 先从 nums 中移除一个 最小 元素，然后 Bob 执行同样的操作。
 * 接着，Bob 会将移除的元素添加到数组 arr 中，然后 Alice 也执行同样的操作。
 * 游戏持续进行，直到 nums 变为空。
 * 返回结果数组 arr 。
 *
 * 示例：
 * 输入1：nums = [5,4,2,3]
 * 输出1：[3,2,5,4]
 *
 * 输入2：nums = [2,5]
 * 输出2：[5,2]
 */
public class T2974 {
    /**
     * 自己实现：根据题意模拟
     */
    public int[] numberGame(int[] nums) {
        // 先排序，然后两两入队
        int n = nums.length;
        int[] ans = new int[n];
        Arrays.sort(nums);

        for (int i = 0; i < n; i+=2) {
            ans[i] = nums[i + 1];
            ans[i + 1] = nums[i];
        }

        return ans;
    }

    /**
     * 原地交换
     */
    public int[] numberGame1(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i+=2) {
            int temp = nums[i];
            nums[i] = nums[i + 1];
            nums[i + 1] = temp;
        }
        return nums;
    }
}