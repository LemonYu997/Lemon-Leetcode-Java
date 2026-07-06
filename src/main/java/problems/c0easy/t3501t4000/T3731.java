package problems.c0easy.t3501t4000;

import java.util.*;

/**
 * 3731 找出缺失的元素 https://leetcode.cn/problems/find-missing-elements/description/
 * 给你一个整数数组 nums ，数组由若干 互不相同 的整数组成。
 * 数组 nums 原本包含了某个范围内的 所有整数 。但现在，其中可能 缺失 部分整数。
 * 该范围内的 最小 整数和 最大 整数仍然存在于 nums 中。
 * 返回一个 有序 列表，包含该范围内缺失的所有整数，
 * 并 按从小到大排序。如果没有缺失的整数，返回一个 空 列表。
 *
 * 示例：
 * 输入1：nums = [1,4,2,5]
 * 输出1：[3]
 *
 * 输入2：nums = [7,8,6,9]
 * 输出2：[]
 *
 * 输入3：nums = [5,1]
 * 输出3：[2,3,4]
 */
public class T3731 {
    /**
     * 自己实现：根据提议模拟
     */
    public List<Integer> findMissingElements(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        // 先排序，然后遍历，如果缺少则记录
        Arrays.sort(nums);

        for (int i = 1; i < nums.length; i++) {
            // 如果两个数不连续，则记录中间所有缺失数
            int a = nums[i - 1] + 1;
            int b = nums[i];
            for (int j = a; j < b; j++) {
                ans.add(j);
            }
        }

        return ans;
    }

    /**
     * 社区解法：使用 set
     */
    public List<Integer> findMissingElements1(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        Set<Integer> set = new HashSet<>();
        for (int x : nums) {
            min = Math.min(min, x);
            max = Math.max(max, x);
            set.add(x);
        }

        List<Integer> ans = new ArrayList<>();
        for (int i = min + 1; i < max; i++) {
            if (!set.contains(i)) {
                ans.add(i);
            }
        }
        return ans;
    }
}
