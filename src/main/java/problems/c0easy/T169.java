package problems.c0easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 169 多数元素 https://leetcode.cn/problems/majority-element/
 * 给定一个大小为n的数组nums，返回其中多数元素。多数元素指在数组中出现次数大于 n/2 的元素
 * 可以假设数组是非空的，给定的数组总是存在多数元素
 *
 * 示例：
 * 输入1：nums = [3,2,3]
 * 输出1：3
 *
 * 输入2：nums = [2,2,1,1,1,2,2]
 * 输出2：2
 * */
public class T169 {
    public static void main(String[] args) {
        int[] nums = {3, 2, 3};
        majorityElement1(nums);
    }
    /**
     * 自己实现：使用map
     */
    public static int majorityElement1(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }

        Object[] counts = map.values().toArray();
        Arrays.sort(counts);
        int maxCount = (int) counts[counts.length - 1];

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue().equals(maxCount)) {
                return entry.getKey();
            }
        }

        return 0;
    }

    /**
     * 自己实现2：map优化，因为题目定义多数元素指在数组中出现次数大于 n/2 的元素
     * 可以每次遍历完进行判断
     */
    public static int majorityElement2(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }

            //多数元素指在数组中出现次数大于 n/2 的元素
            if (map.get(num) > nums.length / 2) {
                return num;
            }
        }

        return 0;
    }

    /**
     * 官方解法3：排序
     * 按照单调递增，排序后，下标为 n/2 的元素一定是众数，即多数元素
     * 因为题目定义多数元素指在数组中出现次数大于 n/2 的元素
     */
    public static int majorityElement3(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
}
