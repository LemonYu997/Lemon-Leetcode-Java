package problems.c0easy.t1501t2000;

/**
 * 1920 基于排列构建数组 https://leetcode.cn/problems/build-array-from-permutation/description/
 * 给你一个 从 0 开始的排列 nums（下标也从 0 开始）。请你构建一个 同样长度 的数组 ans ，
 * 其中，对于每个 i（0 <= i < nums.length），都满足 ans[i] = nums[nums[i]] 。返回构建好的数组 ans 。
 * 从 0 开始的排列 nums 是一个由 0 到 nums.length - 1（0 和 nums.length - 1 也包含在内）的不同整数组成的数组。
 *
 * 示例：
 * 输入1：nums = [0,2,1,5,3,4]
 * 输出1：[0,1,2,4,5,3]
 *
 * 输入2：nums = [5,0,1,2,3,4]
 * 输出2：[4,5,0,1,2,3]
 *
 * 说明：
 * 1 <= nums.length <= 1000
 * 0 <= nums[i] < nums.length
 * nums 中的元素 互不相同
 */
public class T1920 {
    /**
     * 自己实现：根据题意模拟即可
     */
    public int[] buildArray(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {
            ans[i] = nums[nums[i]];
        }

        return ans;
    }

    /**
     * 官方解法：原地修改
     * 需要使 nums[i] 同时存储当前值 nums[i] 和最终值 nums[nums[i]]
     */
    public int[] buildArray1(int[] nums) {
        int n = nums.length;

        //根据题目要求可以得知数组的值范围在 [0,999]
        //因此可以 1000 * 1000 共六位数来表示当前值和最终值，当前值为 后边的三位数 ，最终值为前边的三位数
        // 用其除以 1000 的商数表示最终值，用余数表示当前值
        // 第一次遍历得到 最终值 + 当前值
        for (int i = 0; i < n; i++) {
            nums[i] += 1000 * (nums[nums[i]] % 1000);
        }
        // 第二次遍历得到最终值
        for (int i = 0; i < n; i++) {
            // 在后三位的当前值会被舍弃掉，只留下最终值
            nums[i] /= 1000;
        }

        return nums;
    }
}
