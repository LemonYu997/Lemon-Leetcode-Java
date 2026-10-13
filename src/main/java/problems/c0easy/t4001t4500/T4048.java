package problems.c0easy.t4001t4500;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 4048 统计等间距出现整数数目 I https://leetcode.cn/problems/count-values-with-equally-spaced-occurrences-i/description/
 * 给你一个整数数组 nums。
 * 如果一个整数 x 满足以下条件，则被称为 特别 的：
 * x 在 nums 中 恰好出现三次。
 * x 的 所有 三次出现，在 nums 中都是 等间隔 的。换句话说，如果 x 的所有出现位置的下标为 i1 < i2 < i3，那么 i2 - i1 = i3 - i2。
 * 返回 nums 中 不同 特别整数的数量。
 *
 * 示例：
 * 输入1：nums = [1,8,1,5,1,5,8,5]
 * 输出1：2
 *
 * 输入2：nums = [8,8,8,8]
 * 输出2：0
 *
 * 输入3：nums = [8,6,6,8,8]
 * 输出3：0
 */
public class T4048 {
    /**
     * 自己实现：使用map统计每个数出现的下标
     */
    public int countSpecialIntegers(int[] nums) {
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.get(nums[i]).add(i);
            } else {
                map.put(nums[i], new ArrayList<Integer>());
                map.get(nums[i]).add(i);
            }
        }

        int ans = 0;
        for (List<Integer> value : map.values()) {
            if (value.size() == 3 && value.get(1) - value.get(0) == value.get(2) - value.get(1)) {
                ans++;
            }
        }
        return ans;
    }

    /**
     * 社区解法：优化写法
     */
    public int countSpecialIntegers1(int[] nums) {
        Map<Integer, List<Integer>> pos = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            pos.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }
        int ans = 0;
        for (List<Integer> value : pos.values()) {
            if (value.size() == 3 && value.get(1) - value.get(0) == value.get(2) - value.get(1)) {
                ans++;
            }
        }
        return ans;
    }
}