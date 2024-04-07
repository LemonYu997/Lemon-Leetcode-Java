package problems.c0easy.t501t1000;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * 961 在长度 2N 的数组中找出重复 N 次的元素在长度 2N 的数组中找出重复 N 次的元素 https://leetcode.cn/problems/n-repeated-element-in-size-2n-array/
 * 给定一个整数数组 nums，该数组有以下属性：
 * 1、nums.length = 2 * n
 * 2、nums 包含 n + 1 个不同的元素
 * 3、nums 中恰好有一个元素重复 n 次
 * 找出并返回重复了 n 次的那个元素。
 */
public class T961 {
    /**
     * 自己实现：使用哈希集合
     */
    public int repeatedNTimes(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int ans = 0;
        for (int num : nums) {
            if (set.contains(num)) {
                ans = num;
                break;
            }
            set.add(num);
        }
        return ans;
    }

    /**
     * 官方解法：数学
     * 在 2n 数组中有 n 个重复元素，那相邻3个元素一定会有一个重复的
     */
    public int repeatedNTimes1(int[] nums) {
        int n = nums.length;
        for (int gap = 1; gap <= 3; gap++) {
            for (int i = 0; i + gap < n; i++) {
                if (nums[i] == nums[i + gap]) {
                    return nums[i];
                }
            }
        }
        // 不可能的情况
        return -1;
    }

    /**
     * 官方解法：随机选择
     */
    public int repeatedNTimes2(int[] nums) {
        int n = nums.length;
        Random random = new Random();

        while (true) {
            int x = random.nextInt(n);
            int y = random.nextInt(n);
            if (x != y && nums[x] == nums[y]) {
                return nums[x];
            }
        }
    }
}
