package problems.c0easy.t2001t2500;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 2404 出现最频繁的偶数元素 https://leetcode.cn/problems/most-frequent-even-element/description/
 * 给你一个整数数组 nums ，返回出现最频繁的偶数元素。
 *
 * 如果存在多个满足条件的元素，只需要返回 最小 的一个。如果不存在这样的元素，返回 -1 。
 *
 * 示例：
 * 输入1：nums = [0,1,2,2,4,4,1]
 * 输出1：2
 *
 * 输入2：nums = [4,4,4,9,2,4]
 * 输出2：4
 *
 * 输入3：nums = [29,47,21,41,13,37,25,7]
 * 输出3：-1
 */
public class T2404 {
    /**
     * 自己实现：使用Set模拟计数
     */
    public int mostFrequentEven(int[] nums) {
        int ans = -1;
        int maxCount = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            if (num % 2 == 0) {
                int temp = map.getOrDefault(num, 0) + 1;
                map.put(num, temp);
                if (maxCount < temp) {
                    ans = num;
                    maxCount = temp;
                } else if (maxCount == temp && num < ans) {
                    ans = num;
                }
            }
        }

        return ans;
    }
}
