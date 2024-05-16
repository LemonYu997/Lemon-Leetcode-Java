package problems.c0easy.t1001t1500;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 1365 有多少小于当前数字的数字 https://leetcode.cn/problems/how-many-numbers-are-smaller-than-the-current-number/description/
 * 给你一个数组 nums，对于其中每个元素 nums[i]，请你统计数组中比它小的所有数字的数目。
 * 换而言之，对于每个 nums[i] 你必须计算出有效的 j 的数量，
 * 其中 j 满足 j != i 且 nums[j] < nums[i] 。
 * 以数组形式返回答案。
 *
 * 示例：
 * 输入1：nums = [8,1,2,2,3]
 * 输出1：[4,0,1,1,3]
 *
 * 输入2：nums = [6,5,4,8]
 * 输出2：[2,1,0,3]
 *
 * 输入3：nums = [7,7,7,7]
 * 输出3：[0,0,0,0]
 */
public class T1365 {
    /**
     * 自己实现：暴力循环，遍历两次
     */
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (nums[j] < nums[i]) {
                    count++;
                }
            }
            ans[i] = count;
        }

        return ans;
    }

    /**
     * 官方解法：先排序再查找左侧第一个小于它的数
     */
    public int[] smallerNumbersThanCurrent1(int[] nums) {
        int n = nums.length;
        // 记录原数组及其对应的索引
        int[][] data = new int[n][2];
        for (int i = 0; i < n; i++) {
            data[i][0] = nums[i];
            data[i][1] = i;
        }
        // 根据原数组进行排序
        Arrays.sort(data, new Comparator<int[]>() {
            @Override
            public int compare(int[] data1, int[] data2) {
                return data1[0] - data2[0];
            }
        });

        int[] ans = new int[n];
        int prev = -1;
        for (int i = 0; i < n; i++) {
            // 查找左侧第一个小于它的数对应的索引，即小于该数字的个数
            if (prev == -1 || data[i][0] != data[i - 1][0]) {
                prev = i;
            }
            ans[data[i][1]] = prev;
        }
        return ans;
    }

    /**
     * 官方解法：计数排序
     * 利用 nums[i] 数值范围为 [0,100] 限制
     */
    public int[] smallerNumbersThanCurrent2(int[] nums) {
        int[] cnt = new int[101];
        int n = nums.length;
        // 统计每个元素出现次数
        for (int i = 0; i < n; i++) {
            cnt[nums[i]]++;
        }
        // 统计每个元素及其小于该元素的个数
        for (int i = 1; i <= 100; i++) {
            cnt[i] += cnt[i - 1];
        }
        int[] ans = new int[n];
        // 获取每个元素对应的少于该数字的个数
        for (int i = 0; i < n; i++) {
            ans[i] = nums[i] == 0 ? 0 : cnt[nums[i] - 1];
        }
        return ans;
    }
}
