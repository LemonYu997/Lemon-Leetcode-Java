package problems.c0easy.t1501t2000;

import java.util.*;

/**
 * 1636 按照频率将数组升序排序 https://leetcode.cn/problems/sort-array-by-increasing-frequency/description/
 * 给你一个整数数组 nums ，请你将数组按照每个值的频率 升序 排序。
 * 如果有多个值的频率相同，请你按照数值本身将它们 降序 排序。
 * 请你返回排序后的数组。
 *
 * 示例：
 * 输入1：nums = [1,1,2,2,2,3]
 * 输出1：[3,1,1,2,2,2]
 *
 * 输入2：nums = [2,3,1,3,2]
 * 输出2：[1,3,3,2,2]
 *
 * 输入3：nums = [-1,1,-6,4,5,-6,1,4,1]
 * 输出3：[5,-1,4,4,-6,-6,1,1,1]
 */
public class T1636 {
    /**
     * 官方解法：使用 map 统计每个数字出现的次数，然后排序
     */
    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }

        Collections.sort(list, (a, b) -> {
            int num1 = map.get(a);
            int num2 = map.get(b);
            // 次数不同按次数排序，次数相同按数字大小降序排序
            return num1 != num2 ? num1 - num2 : b - a;
        });

        int len = nums.length;
        for (int i = 0; i < len; i++) {
            nums[i] = list.get(i);
        }
        return nums;
    }
}
