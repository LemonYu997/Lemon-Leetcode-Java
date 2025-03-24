package problems.c0easy.t2001t2500;

import java.util.ArrayList;
import java.util.List;

/**
 * 2248 多个数组求交集 https://leetcode.cn/problems/intersection-of-multiple-arrays/description/
 * 给你一个二维整数数组 nums ，其中 nums[i] 是由 不同 正整数组成的一个非空数组，
 * 按 升序排列 返回一个数组，数组中的每个元素在 nums 所有数组 中都出现过。
 *
 * 示例：
 * 输入1：nums = [[3,1,2,4,5],[1,2,3,4],[3,4,5,6]]
 * 输出1：[3,4]
 *
 * 输入2：nums = [[1,2,3],[4,5,6]]
 * 输出2：[]
 *
 * 提示：
 * 1 <= nums.length <= 1000
 * 1 <= sum(nums[i].length) <= 1000
 * 1 <= nums[i][j] <= 1000
 * nums[i] 中的所有值 互不相同
 */
public class T2248 {
    /**
     * 自己实现：使用数组存储每个数出现的次数，最后遍历得到出现次数与数组数量一致的数即可
     */
    public List<Integer> intersection(int[][] nums) {
        List<Integer> ans = new ArrayList<>();
        // 数组的个数
        int n = nums.length;
        // 每个数出现次数
        int[] counts = new int[1001];

        for (int[] ints : nums) {
            for (int i : ints) {
                counts[i]++;
            }
        }

        for (int i = 0; i < counts.length; i++) {
            if (counts[i] == n) {
                ans.add(i);
            }
        }

        return ans;
    }
}
