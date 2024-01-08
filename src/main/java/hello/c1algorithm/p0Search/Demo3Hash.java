package hello.c1algorithm.p0Search;

import java.util.HashMap;
import java.util.Map;

/**
 * 将线性查找替换为哈希查找来降低算法的时间复杂度
 * 给定一个整数数组 nums 和一个目标元素 target ，请在数组中搜索“和”为 target 的两个元素，
 * 并返回它们的数组索引。返回任意一个解即可。
 */
public class Demo3Hash {
    /**
     * 方法1：线性查找，暴力枚举
     * 时间复杂度 O(n^2)
     * 空间复杂度 O(1)
     */
    public int[] twoSumBruteForce(int[] nums, int target) {
        int size = nums.length;
        // 两层循环，时间复杂度 O(n^2)
        for (int i = 0; i < size - 1; i++) {
            for (int j = i + 1; j < size; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[] {i, j};
                }
            }
        }
        return new int[0];
    }

    /**
     * 方法2：哈希查找，使用哈希表，以空间换时间
     * 键值对分别为数组元素和元素索引，遍历整个数组
     *  1、判断数字 target - nums[i] 是否在哈希表中，如果是，返回两者索引
     *  2、将键值对 nums[i] 和 索引 i 添加进哈希表
     */
    public int[] twoSumHashTable(int[] nums, int target) {
        int size = nums.length;
        // 辅助哈希表，空间复杂度 O(n)
        Map<Integer, Integer> map = new HashMap<>();
        // 单层循环，时间复杂度 O(n)
        for (int i = 0; i < size; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[] {i, map.get(target - nums[i])};
            }
            map.put(nums[i], i);
        }
        return new int[0];
    }
}
