package problems.c0easy;

import java.util.*;

/**
 * 217 存在重复元素 https://leetcode.cn/problems/contains-duplicate/
 *
 * 示例：
 * 输入1：nums = [1,2,3,1]
 * 输出1：true
 *
 * 输入2：nums = [1,2,3,4]
 * 输出2：false
 *
 * 输入3：nums = [1,1,1,3,3,4,3,2,4,2]
 * 输出3：true
 */
public class T217 {
    /**
     * 自己实现：判断数组中是否存在重复元素
     * 会超时
     */
    public boolean containsDuplicate1(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            if (list.contains(num)) {
                return true;
            }
            list.add(num);
        }

        return false;
    }

    /**
     * 自己实现：优化上边的逻辑，先排序再遍历
     */
    public boolean containsDuplicate2(int[] nums) {
        Arrays.sort(nums);
        int n = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == n) {
                return true;
            }
            n = nums[i];
        }

        return false;
    }

    /**
     * 官方实现：哈希表
     */
    public boolean containsDuplicate3(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.add(num)) {
                return true;
            }
        }

        return false;
    }
}
