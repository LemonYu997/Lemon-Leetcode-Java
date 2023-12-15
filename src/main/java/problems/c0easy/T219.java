package problems.c0easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 219 存在重复元素2 https://leetcode.cn/problems/contains-duplicate-ii/
 * 给定一个整数数组nums和整数k，判断数组中是否存在两个不同的索引i和j
 * 满足nums[i] == nums[j]且abs(i - j) <= k，返回true，否则返回false
 *
 * 示例：
 * 输入1：nums = [1,2,3,1], k = 3
 * 输出1：true
 *
 * 输入2：nums = [1,0,1,1], k = 1
 * 输出2：true
 *
 * 输入3：nums = [1,2,3,1,2,3], k = 2
 * 输入3：false
 */
public class T219 {
    /**
     * 官方解法1：哈希表
     */
    public boolean containsNearbyDuplicate1(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int length = nums.length;

        //根据题目要求进行判断
        for (int i = 0; i < length; i++) {
            int num = nums[i];
            if (map.containsKey(num) && i - map.get(num) <= k) {
                return true;
            }
            map.put(num, i);
        }
        return false;
    }

    /**
     * 官方解法2：滑动窗口
     * 在一个 k+1 长度范围内的窗口中寻找是否存在重复元素
     */
    public boolean containsNearbyDuplicate2(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        int length = nums.length;

        for (int i = 0; i < length; i++) {
            //只在 i-k-1 到 i 之间的数据中寻找是否有重复元素
            if (i > k) {
                set.remove(nums[i - k - 1]);
            }
            if (!set.add(nums[i])) {
                return true;
            }
        }

        return false;
    }
}
