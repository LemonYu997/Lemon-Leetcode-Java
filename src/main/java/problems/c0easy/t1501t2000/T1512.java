package problems.c0easy.t1501t2000;

import java.util.HashMap;
import java.util.Map;

/**
 * 1512 好数对的数目 https://leetcode.cn/problems/number-of-good-pairs/description/
 * 给你一个整数数组 nums 。
 * 如果一组数字 (i,j) 满足 nums[i] == nums[j] 且 i < j ，
 * 就可以认为这是一组 好数对 。
 * 返回好数对的数目。
 *
 * 示例：
 * 输入1：nums = [1,2,3,1,1,3]
 * 输出1：4
 *
 * 输入2：nums = [1,1,1,1]
 * 输出2：6
 *
 * 输入3：nums = [1,2,3]
 * 输出3：0
 */
public class T1512 {
    /**
     * 自己实现：根据题意即找从当前下标开始后续一致数字的次数
     * 双重暴力循环即可
     */
    public int numIdenticalPairs(int[] nums) {
        int n = nums.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[j] == nums[i]) {
                    ans++;
                }
            }
        }
        return ans;
    }

    /**
     * 官方解法：组合计数，统计每个数出现的次数，再计算
     */
    public int numIdenticalPairs1(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int ans = 0;
        for (Integer value : map.values()) {
            // 根据排列组合知识，两两组队，且只能向后关联
            ans += value * (value - 1) / 2;
        }

        return ans;
    }
}