package problems.c0easy.t4001t4500;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 4065 移除不同值重排数组 https://leetcode.cn/problems/rearrange-array-by-removing-distinct-values/description/
 * 给你一个整数数组 nums。
 * 初始时，你有一个 空 数组 ans。重复执行以下操作，直到 nums 变为 空 ：
 * 找出当前 nums 中 所有不同 的值。
 * 将当前 nums 中每个 不同 的值各移除一个，并按 升序 将这些值依次添加到 ans 中。
 * 返回数组 ans。
 *
 * 示例：
 * 输入1：nums = [3,1,3,2,1,3]
 * 输出1：[1,2,3,1,3,3]
 *
 * 输入2：nums = [7,7,4,4,4]
 * 输出2：[4,7,4,7,4]
 */
public class T4065 {
    /**
     * 社区解法：暴力
     */
    public int[] rearrangeArray(int[] nums) {
        // 记录每个数出现的次数
        int mx = 0;
        for (int num : nums) {
            mx = Math.max(mx, num);
        }
        int[] cnt = new int[mx + 1];
        for (int num : nums) {
            cnt[num]++;
        }

        // 重排序
        int n = nums.length;
        int[] ans = new int[n];
        int k = 0;
        while (k < n) {
            for (int i = 1; i <= mx; i++) {
                if (cnt[i] > 0) {
                    ans[k++] = i;
                    cnt[i]--;
                }
            }
        }
        return ans;
    }

    /**
     * 社区解法：
     */
    public int[] rearrangeArray1(int[] nums) {
        int n = nums.length;
        int mx = 0;
        for (int num : nums) {
            mx = Math.max(mx, num);
        }
        int[] cnt = new int[mx + 1];
        List<Integer>[] levels = new ArrayList[n];
        Arrays.setAll(levels, i -> new ArrayList<>());

        for (int num : nums) {
            int c = cnt[num];
            levels[c].add(num);
            cnt[num]++;
        }

        int[] ans = new int[n];
        int k = 0;
        for (List<Integer> level : levels) {
            level.sort(null);
            for (Integer i : level) {
                ans[k++] = i;
            }
        }
        return ans;
    }
}
