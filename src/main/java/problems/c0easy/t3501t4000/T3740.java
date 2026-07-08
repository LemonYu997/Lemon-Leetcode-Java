package problems.c0easy.t3501t4000;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 3740 三个相等元素之间的最小距离 I https://leetcode.cn/problems/minimum-distance-between-three-equal-elements-i/description/
 * 给你一个整数数组 nums。
 * 如果满足 nums[i] == nums[j] == nums[k]，且 (i, j, k) 是 3 个 不同 下标，那么三元组 (i, j, k) 被称为 有效三元组 。
 * 有效三元组 的 距离 被定义为 abs(i - j) + abs(j - k) + abs(k - i)，其中 abs(x) 表示 x 的 绝对值 。
 * 返回一个整数，表示 有效三元组 的 最小 可能距离。如果不存在 有效三元组 ，返回 -1。
 *
 * 示例：
 * 输入1：nums = [1,2,1,1,3]
 * 输出1：6
 *
 * 输入2：nums = [1,1,2,3,2,1,2]
 * 输出2：8
 *
 * 输入3：nums = [1]
 * 输出3：-1
 */
public class T3740 {
    /**
     * 官方解法：暴力
     */
    public int minimumDistance(int[] nums) {
        int n = nums.length;
        int ans = n + 1;

        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                if (nums[i] != nums[j]) {
                    continue;
                }
                for (int k = j + 1; k < n; k++) {
                    if (nums[j] == nums[k]) {
                        ans = Math.min(ans, k - i);
                        break;
                    }
                }
            }
        }

        return ans == n + 1 ? -1 : ans * 2;
    }
}
