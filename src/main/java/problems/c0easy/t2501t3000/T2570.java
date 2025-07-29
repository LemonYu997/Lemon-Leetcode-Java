package problems.c0easy.t2501t3000;

import java.util.ArrayList;
import java.util.List;

/**
 * 2570 合并两个二维数组 - 求和法 https://leetcode.cn/problems/merge-two-2d-arrays-by-summing-values/description/
 * 给你两个 二维 整数数组 nums1 和 nums2.
 * nums1[i] = [idi, vali] 表示编号为 idi 的数字对应的值等于 vali 。
 * nums2[i] = [idi, vali] 表示编号为 idi 的数字对应的值等于 vali 。
 * 每个数组都包含 互不相同 的 id ，并按 id 以 递增 顺序排列。
 * 请你将两个数组合并为一个按 id 以递增顺序排列的数组，并符合下述条件：
 * 只有在两个数组中至少出现过一次的 id 才能包含在结果数组内。
 * 每个 id 在结果数组中 只能出现一次 ，并且其对应的值等于两个数组中该 id 所对应的值求和。
 * 如果某个数组中不存在该 id ，则假定其对应的值等于 0 。
 * 返回结果数组。返回的数组需要按 id 以递增顺序排列。
 *
 * 示例：
 * 输入1：nums1 = [[1,2],[2,3],[4,5]], nums2 = [[1,4],[3,2],[4,1]]
 * 输出1：[[1,6],[2,3],[3,2],[4,6]]
 *
 * 输入2：nums1 = [[2,4],[3,6],[5,5]], nums2 = [[1,3],[4,3]]
 * 输出2：[[1,3],[2,4],[3,6],[4,3],[5,5]]
 */
public class T2570 {
    /**
     * 自己实现：根据题意模拟
     */
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        List<int[]> list = new ArrayList<>();
        int i = 0, j = 0;
        int m = nums1.length;
        int n = nums2.length;

        while (i < m && j < n) {
            // 如果两个id相等，则值相加
            if (nums1[i][0] == nums2[j][0]) {
                list.add(new int[]{nums1[i][0], nums1[i][1] + nums2[j][1]});
                i++;
                j++;
            }
            // 如果哪边id更小，就将其塞入list中
            while (i < m && j < n && nums1[i][0] < nums2[j][0]) {
                list.add(nums1[i]);
                i++;
            }
            while (i < m && j < n && nums1[i][0] > nums2[j][0]) {
                list.add(nums2[j]);
                j++;
            }
        }
        // 补充剩余的数组
        while (i < m) {
            list.add(nums1[i]);
            i++;
        }
        while (j < n) {
            list.add(nums2[j]);
            j++;
        }

        return list.toArray(new int[list.size()][]);
    }
}
