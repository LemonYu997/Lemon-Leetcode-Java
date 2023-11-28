package demo.c0easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 645 错误的集合 https://leetcode.cn/problems/set-mismatch/
 * 集合s包含从1到n的整数，但是其中缺少了一个数字，并且有一个数字重复
 * 找出重复出现的整数和丢失的整数
 *
 * 示例：
 * 输入1：nums = [1,2,2,4]
 * 输出1：[2,3]
 *
 * 输入2：nums = [1,1]
 * 输出2：[1,2]
 */
public class T645 {
    /**
     * 官方解法：哈希表
     */
    public int[] findErrorNums(int[] nums) {
        int[] ans = new int[2];
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (int i = 1; i <= n; i++) {
            int count = map.getOrDefault(i, 0);
            if (count == 2) {
                ans[0] = i;
            } else if (count == 0) {
                ans[1] = i;
            }
        }

        return ans;
    }
}
