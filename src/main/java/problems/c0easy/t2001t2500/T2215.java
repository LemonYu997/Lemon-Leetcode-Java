package problems.c0easy.t2001t2500;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 2215 找出两数组的不同 https://leetcode.cn/problems/find-the-difference-of-two-arrays/description/
 * 给你两个下标从 0 开始的整数数组 nums1 和 nums2 ，请你返回一个长度为 2 的列表 answer ，其中：
 * answer[0] 是 nums1 中所有 不 存在于 nums2 中的 不同 整数组成的列表。
 * answer[1] 是 nums2 中所有 不 存在于 nums1 中的 不同 整数组成的列表。
 * 注意：列表中的整数可以按 任意 顺序返回。
 *
 *
 * 示例：
 * 输入1：nums1 = [1,2,3], nums2 = [2,4,6]
 * 输出1：[[1,3],[4,6]]
 *
 * 输入2：nums1 = [1,2,3,3], nums2 = [1,1,2,2]
 * 输出2：[[3],[]]
 */
public class T2215 {
    /**
     * 自己实现：使用数组存储每个数组的数字是否出现过
     */
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        // 由于值可能为负数，这里每个数都要 + 1000
        int[] exist1 = new int[2001];
        int[] exist2 = new int[2001];
        List<List<Integer>> ans = new ArrayList<>();

        // 使用数组存储每个数组的数字是否出现过
        for (int num : nums1) {
            exist1[num + 1000] = 1;
        }
        for (int num : nums2) {
            exist2[num + 1000] = 1;
        }

        // 使用 set 去重
        Set<Integer> ans1 = new HashSet<>();
        Set<Integer> ans2 = new HashSet<>();
        for (int num: nums1) {
            // 如果第一个数组中的数在第二个数组中不存在
            if (exist2[num + 1000] != 1) {
                ans1.add(num);
            }
        }
        for (int num: nums2) {
            // 如果第二个数组中的数在第一个数组中不存在
            if (exist1[num + 1000] != 1) {
                ans2.add(num);
            }
        }
        ans.add(new ArrayList<>(ans1));
        ans.add(new ArrayList<>(ans2));
        return ans;
    }
}
