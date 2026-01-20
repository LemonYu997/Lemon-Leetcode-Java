package problems.c0easy.t3001t3500;

import java.util.HashMap;
import java.util.Map;

/**
 * 3162 优质数对的总数 I https://leetcode.cn/problems/find-the-number-of-good-pairs-i/description/
 * 给你两个整数数组 nums1 和 nums2，长度分别为 n 和 m。同时给你一个正整数 k。
 * 如果 nums1[i] 可以除尽 nums2[j] * k，则称数对 (i, j) 为 优质数对（0 <= i <= n - 1, 0 <= j <= m - 1）。
 * 返回 优质数对 的总数。
 *
 * 示例：
 * 输入1：nums1 = [1,3,4], nums2 = [1,3,4], k = 1
 * 输出1：5
 *
 * 输入2：nums1 = [1,2,4,12], nums2 = [2,4], k = 3
 * 输出2：2
 */
public class T3162 {
    /**
     * 自己实现：根据题意模拟
     */
    public int numberOfPairs(int[] nums1, int[] nums2, int k) {
        int ans = 0;
        for (int n1 : nums1) {
            for (int n2 : nums2) {
                if (n1 % (n2 * k) == 0) {
                    ans++;
                }
            }
        }

        return ans;
    }

    /**
     * 官方解法：枚举倍数
     * 分别统计 nums1 和 nums2 的频数。
     * 遍历 nums2 出现过的数 a，枚举 a×k 的倍数，如果在 nums1 出现过就可以组成优质数对，更新结果。
     * 返回优质数对的总数。
     */
    public int numberOfPairs1(int[] nums1, int[] nums2, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        Map<Integer, Integer> count2 = new HashMap<>();
        int max1 = 0;
        for (int num : nums1) {
            count.put(num, count.getOrDefault(num, 0) + 1);
            max1 = Math.max(max1, num);
        }
        for (int num : nums2) {
            count2.put(num, count2.getOrDefault(num, 0) + 1);
        }
        int res = 0;
        for (int a : count2.keySet()) {
            for (int b = a * k; b <= max1; b += a * k) {
                if (count.containsKey(b)) {
                    res += 1L * count.get(b) * count2.get(a);
                }
            }
        }
        return res;
    }
}