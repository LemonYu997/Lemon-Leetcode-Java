package problems.c0easy.t4001t4500;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 4038 计算单个区间中出现的整数数量 https://leetcode.cn/problems/count-integers-appearing-in-a-single-block/description/
 * 给你一个整数数组 nums。
 * 如果整数 x 在 nums 中的所有出现位置都位于同一个 连续 区间内，则称 x 为 特殊整数。
 * 返回 nums 中 不同 特殊整数的数量。
 *
 * 示例：
 * 输入1：nums = [1,2,2,1]
 * 输出1：1
 *
 * 输入2：nums = [3,3,1,2,2,1]
 * 输出2：2
 */
public class T4038 {
    /**
     * 社区解法：记录每个元素出现的位置，然后再判断是否连续
     */
    public int countSpecialIntegers(int[] nums) {
        Map<Integer, List<Integer>> pos = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            pos.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }

        int ans = 0;
        for (List<Integer> p : pos.values()) {
            if (p.get(p.size() - 1) - p.get(0) + 1 == p.size()) {
                ans++;
            }
        }
        return ans;
    }

    /**
     * 社区解法：一次遍历
     */
    public int countSpecialIntegers1(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            int x = nums[i];
            if (i == 0 || x != nums[i - 1]) {
                int c = map.merge(x, 1, Integer::sum);
                if (c == 1) {
                    ans++;
                } else if (c == 2) {
                    ans--;
                }
            }
        }
        return ans;
    }
}