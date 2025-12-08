package problems.c0easy.t3001t3500;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 3005 最大频率元素计数 https://leetcode.cn/problems/count-elements-with-maximum-frequency/description/
 * 给你一个由 正整数 组成的数组 nums 。
 * 返回数组 nums 中所有具有 最大 频率的元素的 总频率 。
 * 元素的 频率 是指该元素在数组中出现的次数。
 *
 * 示例：
 * 输入1:nums = [1,2,2,3,1,4]
 * 输出1：4
 *
 * 输入2：nums = [1,2,3,4,5]
 * 输出2：5
 *
 * 1 <= nums.length <= 100
 * 1 <= nums[i] <= 100
 */
public class T3005 {
    /**
     * 自己实现：使用数组统计
     */
    public int maxFrequencyElements(int[] nums) {
        int[] count = new int[101];

        for (int num : nums) {
            count[num]++;
        }

        Arrays.sort(count);
        int ans = count[100];

        // 倒序排序找到最大的值
        for (int i = 99; i >= 0; i--) {
            if (count[i] == count[i + 1]) {
                ans += count[i];
            } else {
                break;
            }
        }

        return ans;
    }


    /**
     * 自己实现：使用数组统计
     */
    public int maxFrequencyElements1(int[] nums) {
        Map<Integer, Integer> cnt = new HashMap<>();
        int maxCnt = 0;
        int ans = 0;
        for (int num : nums) {
            int c = cnt.merge(num, 1, Integer::sum);
            if (c > maxCnt) {
                ans = maxCnt = c;
            } else if (c == maxCnt) {
                ans += c;
            }
        }
        return ans;
    }
}
