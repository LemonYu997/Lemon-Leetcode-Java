package problems.c0easy.t3001t3500;

import java.util.HashSet;
import java.util.Set;

/**
 * 3396 使数组元素互不相同所需的最少操作次数 https://leetcode.cn/problems/minimum-number-of-operations-to-make-elements-in-array-distinct/description/
 * 给你一个整数数组 nums，你需要确保数组中的元素 互不相同 。为此，你可以执行以下操作任意次:
 * 从数组的开头移除 3 个元素。如果数组中元素少于 3 个，则移除所有剩余元素。
 * 注意：空数组也视作为数组元素互不相同。返回使数组元素互不相同所需的 最少操作次数 。
 *
 * 示例：
 * 输入1：nums = [1,2,3,4,2,3,3,5,7]
 * 输出1：2
 *
 * 输入2：nums = [4,5,6,4,4]
 * 输出2：2
 *
 * 输入3：nums = [6,7,8,9]
 * 输出3：0
 */
public class T3396 {
    /**
     * 自己实现：根据题意模拟
     */
    public int minimumOperations(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        int n = nums.length;
        int ans = 0;

        // 每次移除前3个，即索引一次挪 3 位
        for (int i = 0; i < n; i += 3) {
            boolean flag = true;
            for (int j = i; j < n; j++) {
                if (set.contains(nums[j])) {
                    flag = false;
                    break;
                }
                set.add(nums[j]);
            }
            if (flag) {
                return ans;
            }
            ans++;
            set.clear();
        }

        return ans;
    }

    /**
     * 官方解法：倒序遍历
     */
    public int minimumOperations1(int[] nums) {
        boolean[] seen = new boolean[128];
        for (int i = nums.length - 1; i >= 0; i--) {
            if (seen[nums[i]]) {
                return i / 3 + 1;
            }
            seen[nums[i]] = true;
        }
        return 0;
    }
}