package problems.c0easy.t2501t3000;

import java.util.Arrays;
import java.util.List;
/**
 * 2869 收集元素的最少操作次数 https://leetcode.cn/problems/minimum-operations-to-collect-elements/description/
 * 给你一个正整数数组 nums 和一个整数 k 。
 * 一次操作中，你可以将数组的最后一个元素删除，将该元素添加到一个集合中。
 * 请你返回收集元素 1, 2, ..., k 需要的 最少操作次数 。
 *
 * 示例：
 * 输入1：nums = [3,1,5,4,2], k = 2
 * 输出1：4
 *
 * 输入2：nums = [3,1,5,4,2], k = 5
 * 输出2：5
 *
 * 输入3：nums = [3,2,5,3,1], k = 3
 * 输出3：4
 */
public class T2869 {
    /**
     * 自己实现：根据题意模拟即可
     */
    public int minOperations(List<Integer> nums, int k) {
        // 记录目标是否出现
        int[] temp = new int[k + 1];
        int n = nums.size();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            Integer t = nums.get(n - i - 1);
            ans++;
            if (t <= k) {
                temp[t] = 1;
                if (Arrays.stream(temp).sum() == k) {
                    return ans;
                }
            }

        }
        return ans;
    }

    /**
     * 社区解法：
     */
    public int minOperations1(List<Integer> nums, int k) {
        int n = nums.size();
        long u = (2L << k) - 2;
        long s = 0;
        for (int i = n - 1; ; i--) {
            s |= 1L << nums.get(i);
            if ((s & u) == u) {
                return n - i;
            }
        }
    }
}
