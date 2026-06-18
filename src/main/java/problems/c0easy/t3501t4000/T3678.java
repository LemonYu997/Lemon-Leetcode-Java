package problems.c0easy.t3501t4000;

import java.util.HashSet;
import java.util.Set;

/**
 * 3678 大于平均值的最小未出现正整数 https://leetcode.cn/problems/smallest-absent-positive-greater-than-average/description/
 * 给你一个整数数组 nums。
 * 返回 nums 中 严格大于 nums 中所有元素 平均值 的 最小未出现正整数。
 * 数组的 平均值 定义为数组中所有元素的总和除以元素的数量。
 *
 * 示例：
 * 输入1：nums = [3,5]
 * 输出1：6
 *
 * 输入2：nums = [-1,1,2]
 * 输出2：3
 *
 * 输入3：nums = [4,-1]
 * 输出3：2
 *
 * 1 <= nums.length <= 100
 * -100 <= nums[i] <= 100
 */
public class T3678 {
    /**
     * 自己实现：根据题意模拟
     */
    public int smallestAbsent(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int sum = 0;
        // 统计每一个数是否出现过
        for (int num : nums) {
            sum += num;
            set.add(num);
        }

        // 答案必须是正整数
        int ans = Math.max(sum / nums.length + 1, 1);
        while (set.contains(ans)) {
            ans++;
        }
        return ans;
    }
}
