package problems.c0easy.t3501t4000;

import java.util.ArrayList;
import java.util.List;

/**
 * 3912 数组中的有效元素 https://leetcode.cn/problems/valid-elements-in-an-array/description/
 * 给你一个整数数组 nums。
 * 如果元素 nums[i] 满足以下 至少一个 条件，则认为它是 有效 元素：
 * 它 严格大于 其左侧的所有元素。
 * 它 严格大于 其右侧的所有元素。
 * 第一个元素和最后一个元素始终有效。
 * 返回所有有效元素组成的数组，顺序与它们在 nums 中出现的顺序相同
 *
 * 示例：
 * 输入1：nums = [1,2,4,2,3,2]
 * 输出1：[1,2,4,3,2]
 *
 * 输入2：nums = [5,5,5,5]
 * 输出2：[5,5]
 *
 * 输入3：nums = [1]
 * 输出3：[1]
 */
public class T3912 {
    /**
     * 社区解法：遍历两次
     */
    public List<Integer> findValidElements(int[] nums) {
        // 标记其严格大于右侧所有元素的元素
        int n = nums.length;
        boolean[] rightValid = new boolean[n];
        int mx = 0;
        for (int i = n - 1; i >= 0; i--) {
            int x = nums[i];
            rightValid[i] = x > mx;
            mx = Math.max(mx, x);
        }

        List<Integer> ans = new ArrayList<>();
        mx = 0;
        for (int i = 0; i < n; i++) {
            int x = nums[i];
            if (x > mx || rightValid[i]) {
                ans.add(x);
            }
            mx = Math.max(mx, x);
        }
        return ans;
    }
}
