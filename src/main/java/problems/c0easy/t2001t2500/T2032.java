package problems.c0easy.t2001t2500;

import java.util.ArrayList;
import java.util.List;

/**
 * 2032 至少在两个数组中出现的值 https://leetcode.cn/problems/two-out-of-three/description/
 * 给你三个整数数组 nums1、nums2 和 nums3 ，请你构造并返回一个 元素各不相同的 数组，
 * 且由 至少 在 两个 数组中出现的所有值组成。数组中的元素可以按 任意 顺序排列。
 *
 * 示例：
 * 输入1：nums1 = [1,1,3,2], nums2 = [2,3], nums3 = [3]
 * 输出1：[3,2]
 *
 * 输入2：nums1 = [3,1], nums2 = [2,3], nums3 = [1,2]
 * 输出2：[2,3,1]
 *
 * 输入3：nums1 = [1,2,2], nums2 = [4,3,3], nums3 = [5]
 * 输出3：[]
 *
 * 提示：
 *
 * 1 <= nums1.length, nums2.length, nums3.length <= 100
 * 1 <= nums1[i], nums2[j], nums3[k] <= 100
 */
public class T2032 {
    /**
     * 自己实现：统计每个数组每个字符出现的次数
     */
    public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
        List<Integer> ans = new ArrayList<>();

        // 根据题目条件 1 <= nums1[i], nums2[j], nums3[k] <= 100
        // 因此可以用一个 int[301] 来存储每个数组数字是否存在 1~100 表示 nums1 的值是否存在，
        // 101~200 表示 nums2，201~300 表示 nums3
        int[] temp = new int[301];

        for (int i : nums1) {
            temp[i] = 1;
        }
        for (int i : nums2) {
            temp[i + 100] = 1;
        }
        for (int i : nums3) {
            temp[i + 200] = 1;
        }

        //统计 1~100 内有多少个数字在两个以上数组中出现
        for (int i = 1; i <= 100; i++) {
            if (temp[i] + temp[i + 100] + temp[i + 200] >= 2) {
                ans.add(i);
            }
        }

        return ans;
    }
}
