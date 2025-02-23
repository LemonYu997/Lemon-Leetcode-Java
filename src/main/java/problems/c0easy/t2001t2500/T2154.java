package problems.c0easy.t2001t2500;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 2154 将找到的值乘以 2 https://leetcode.cn/problems/keep-multiplying-found-values-by-two/description/
 * 给你一个整数数组 nums ，另给你一个整数 original ，这是需要在 nums 中搜索的第一个数字。
 *
 * 接下来，你需要按下述步骤操作：
 *
 * 如果在 nums 中找到 original ，将 original 乘以 2 ，得到新 original（即，令 original = 2 * original）。
 * 否则，停止这一过程。
 * 只要能在数组中找到新 original ，就对新 original 继续 重复 这一过程。
 * 返回 original 的 最终 值。
 *
 * 示例：
 * 输入1：nums = [5,3,6,1,12], original = 3
 * 输出1:24
 *
 * 输入2：nums = [2,7,9], original = 4
 * 输出2：4
 */
public class T2154 {
    /**
     * 自己实现：使用 Set 记录
     */
    public int findFinalValue(int[] nums, int original) {
        Set<Integer> set = new HashSet<>();

        for (int num : nums) {
            set.add(num);
        }

        int ans = original;
        while (true) {
            if (set.contains(ans)) {
                ans = ans * 2;
            } else {
                return ans;
            }
        }
    }

    /**
     * 官方解法：先排序后遍历
     */
    public int findFinalValue1(int[] nums, int original) {
        Arrays.sort(nums);

        // 如果找到，就乘以 2，再继续找
        for (int num : nums) {
            if (original == num) {
                original *= 2;
            }
        }

        return original;
    }
}