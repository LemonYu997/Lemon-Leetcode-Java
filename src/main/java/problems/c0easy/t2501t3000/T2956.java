package problems.c0easy.t2501t3000;

import java.util.HashSet;
import java.util.Set;

/**
 * 2956 找到两个数组中的公共元素 https://leetcode.cn/problems/find-common-elements-between-two-arrays/description/
 * 给你两个下标从 0 开始的整数数组 nums1 和 nums2 ，
 * 它们分别含有 n 和 m 个元素。请你计算以下两个数值：
 * answer1：使得 nums1[i] 在 nums2 中出现的下标 i 的数量。
 * answer2：使得 nums2[i] 在 nums1 中出现的下标 i 的数量。
 * 返回 [answer1, answer2]。
 *
 * 示例：
 * 输入1：nums1 = [2,3,2], nums2 = [1,2]
 * 输出1：[2,1]
 *
 * 输入2：nums1 = [4,3,2,3,1], nums2 = [2,2,5,2,3,6]
 * 输出2：[3,4]
 *
 * 输入3：nums1 = [3,4,2,3], nums2 = [1,5]
 * 输出3：[0,0]
 */
public class T2956 {
    /**
     * 自己实现：根据题意模拟
     */
    public int[] findIntersectionValues(int[] nums1, int[] nums2) {
        HashSet<Integer> s1 = new HashSet<>();
        for (int x : nums1) {
            s1.add(x);
        }
        HashSet<Integer> s2 = new HashSet<>();
        for (int x : nums2) {
            s2.add(x);
        }

        int[] res = new int[2];
        for (int x : nums1) {
            if (s2.contains(x)) {
                res[0]++;
            }
        }
        for (int x : nums2) {
            if (s1.contains(x)) {
                res[1]++;
            }
        }
        return res;
    }

    /**
     * 双重遍历
     */
    public int[] findIntersectionValues1(int[] nums1, int[] nums2) {
        int[] res = new int[2];
        for (int x1 : nums1) {
            for (int x2 : nums2) {
                if (x1 == x2) {
                    res[0]++;
                    break;
                }
            }
        }
        for (int x2 : nums2) {
            for (int x1 : nums1) {
                if (x2 == x1) {
                    res[1]++;
                    break;
                }
            }
        }
        return res;
    }
}
