package problems.c0easy.t2001t2500;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 2176 统计数组中相等且可以被整除的数对 https://leetcode.cn/problems/count-equal-and-divisible-pairs-in-an-array/description/
 * 给你一个下标从 0 开始长度为 n 的整数数组 nums 和一个整数 k ，请你返回满足 0 <= i < j < n ，
 * nums[i] == nums[j] 且 (i * j) 能被 k 整除的数对 (i, j) 的 数目 。
 *
 * 示例：
 * 输入1：nums = [3,1,2,2,2,1,3], k = 2
 * 输出1：4
 *
 * 输入2：nums = [1,2,3,4], k = 1
 * 输出2：0
 */
public class T2176 {
    /**
     * 自己实现：使用 Map 统计每个相同数出现的索引位置
     */
    public int countPairs(int[] nums, int k) {
        Map<Integer, List<Integer>> map = new HashMap<>();

        // 统计每个相同数及其出现的索引
        for (int i = 0; i < nums.length; i++) {
            List<Integer> tmep = map.getOrDefault(nums[i], new ArrayList<>());
            tmep.add(i);
            map.put(nums[i], tmep);
        }

        int ans = 0;

        for (List<Integer> value : map.values()) {
            if (value.size() >= 2) {
                // 计算每一个相同数两个索引相乘是否能被 k 整除
                for (int i = 0; i < value.size(); i++) {
                    for (int j = i + 1; j < value.size(); j++) {
                        if ((value.get(i) * value.get(j)) % k == 0) {
                            ans++;
                        }
                    }
                }
            }
        }

        return ans;
    }

    /**
     * 自己实现：优化，直接双重遍历
     */
    public int countPairs1(int[] nums, int k) {
        int ans = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] == nums[j] && (i * j) % k == 0) {
                    ans++;
                }
            }
        }

        return ans;
    }
}