package problems.c0easy.t2001t2500;

import java.util.ArrayList;
import java.util.List;

/**
 * 2200 找出数组中的所有 K 近邻下标 https://leetcode.cn/problems/find-all-k-distant-indices-in-an-array/description/
 * 给你一个下标从 0 开始的整数数组 nums 和两个整数 key 和 k 。K 近邻下标 是 nums 中的一个下标 i ，
 * 并满足至少存在一个下标 j 使得 |i - j| <= k 且 nums[j] == key 。
 * 以列表形式返回按 递增顺序 排序的所有 K 近邻下标。
 *
 * 示例：
 * 输入1：nums = [3,4,9,1,3,9,5], key = 9, k = 1
 * 输出1：[1,2,3,4,5,6]
 *
 * 输入2：nums = [2,2,2,2,2], key = 2, k = 2
 * 输出2：[0,1,2,3,4]
 */
public class T2200 {
    /**
     * 自己实现：根据题意模拟
     */
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        List<Integer> ans = new ArrayList<>();
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (nums[j] == key && Math.abs(i - j) <= k) {
                    ans.add(i);
                    // 防止重复添加相同的 i
                    break;
                }
            }
        }

        return ans;
    }

    /**
     * 优化解法：提前判断，减少遍历次数
     */
    public List<Integer> findKDistantIndices1(int[] nums, int key, int k) {
        List<Integer> ans = new ArrayList<>();
        int n = nums.length;
        int r = 0;

        for (int j = 0; j < n; j++) {
            if (nums[j] == key) {
                // 找到遍历范围 |i - j| <= k
                int l = Math.max(r, j - k);
                r = Math.min(n - 1, j + k) + 1;
                for (int i = l; i < r; i++) {
                    ans.add(i);
                }
            }
        }

        return ans;
    }
}
