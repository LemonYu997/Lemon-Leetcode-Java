package demo.c0easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 594 最长和谐子序列 https://leetcode.cn/problems/longest-harmonious-subsequence/
 * 和谐数组指一个数组里元素的最大值和最小值的差别正好是1,
 * 给定一个整数数组nums，请在所有可能的子序列中找到最长的和谐子序列的长度
 * 子序列不能改变数组的原有顺序
 *
 * 示例：
 * 输入1：nums = [1,3,2,2,5,2,3,7]
 * 输出1:5
 * 备注：最长的和谐子序列是 [3,2,2,2,3]
 *
 * 输入2：nums = [1,2,3,4]
 * 输出2:2
 *
 * 输入3：nums = [1,1,1,1]
 * 输出3:0
 */
public class T594 {
    /**
     * 自己实现：使用Map
     * 先统计每个数字的出现次数，再遍历map，计算 key 出现的次数和 key + 1 出现的次数和，找到最大的一个数
     */
    public int findLHS(int[] nums) {
        int ans = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (Integer k : map.keySet()) {
            if (map.containsKey(k + 1)) {
                //更新最大值
                ans = Math.max(map.get(k) + map.get(k + 1), ans);
            }
        }

        return ans;
    }


    /**
     * 官方解法：先排序再统计
     * 滑动窗口
     */
    public int findLHS1(int[] nums) {
        Arrays.sort(nums);
        int begin = 0;
        int ans = 0;

        for (int end = 0; end < nums.length; end++) {
            //滑动窗口，保持首尾差值不大于1
            while (nums[end] - nums[begin] > 1) {
                begin++;
            }
            if (nums[end] - nums[begin] == 1) {
                //更新结果为滑动窗口区间大小
                ans = Math.max(ans, end - begin + 1);
            }
        }

        return ans;
    }
}
