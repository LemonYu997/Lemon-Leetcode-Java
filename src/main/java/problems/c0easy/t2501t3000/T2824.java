package problems.c0easy.t2501t3000;

import java.util.Collections;
import java.util.List;

/**
 * 2824 统计和小于目标的下标对数目 https://leetcode.cn/problems/count-pairs-whose-sum-is-less-than-target/description/
 * 给你一个下标从 0 开始长度为 n 的整数数组 nums 和一个整数 target ，
 * 请你返回满足 0 <= i < j < n 且 nums[i] + nums[j] < target 的下标对 (i, j) 的数目。
 *
 * 输入1：nums = [-1,1,2,3,1], target = 2
 * 输出1：3
 *
 * 输入2：nums = [-6,2,5,-2,-7,-1,3], target = -2
 * 输出2：10
 */
public class T2824 {
    /**
     * 自己实现：根据题意模拟即可
     */
    public int countPairs(List<Integer> nums, int target) {
        int n = nums.size();
        int ans = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums.get(i) + nums.get(j) < target) {
                    ans++;
                }
            }
        }

        return ans;
    }

    /**
     * 官方解法：双指针
     */
    public int countPairs1(List<Integer> nums, int target) {
        Collections.sort(nums);
        int ans = 0;
        for (int i = 0, j = nums.size() - 1; i < j; i++) {
            while (i < j && nums.get(i) + nums.get(j) >= target) {
                j--;
            }
            ans += j - i;
        }

        return ans;
    }
}
