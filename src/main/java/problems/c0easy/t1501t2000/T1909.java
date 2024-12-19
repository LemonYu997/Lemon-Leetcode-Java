package problems.c0easy.t1501t2000;

/**
 * 1909 删除一个元素使数组严格递增 https://leetcode.cn/problems/remove-one-element-to-make-the-array-strictly-increasing/description/
 * 给你一个下标从 0 开始的整数数组 nums ，如果 恰好 删除 一个 元素后，数组 严格递增 ，
 * 那么请你返回 true ，否则返回 false 。如果数组本身已经是严格递增的，请你也返回 true 。
 * 数组 nums 是 严格递增 的定义为：对于任意下标的 1 <= i < nums.length 都满足 nums[i - 1] < nums[i] 。
 *
 * 示例：
 * 输入1：nums = [1,2,10,5,7]
 * 输出1：true
 *
 * 输入2：nums = [2,3,1,2]
 * 输出2：false
 *
 * 输入3：nums = [1,1,1]
 * 输出3：false
 *
 * 输入4：nums = [1,2,3]
 * 输出4：true
 */
public class T1909 {
    /**
     * 官方解法：顺序一次遍历，分情况讨论
     */
    public boolean canBeIncreasing(int[] nums) {
        boolean ans = true;
        int n = nums.length;

        for (int i = 0; i < n - 1; i++) {
            // 每次比较都是当前数向后边的数比较
            if (nums[i] >= nums[i + 1]) {
                // 如果是第一次出错，进入矫正流程
                if (ans) {
                    // 如果 i - 1 < 0，说明要删除的数在开头，直接跳过即可
                    // 如果 nums[i + 1] > nums[i - 1]，说明当前数比较大，直接跳过即可
                    if (i - 1 < 0 || nums[i + 1] > nums[i - 1]) {
                        ans = false;
                    } else if (i + 2 >= n || nums[i + 2] > nums[i]) {
                        // 如果 i + 2 >= n 说明小的数在末尾，直接跳过即可
                        // 如果 nums[i + 2] > nums[i]，说明 nums[i+1] 比较小，直接跳过即可
                        ans = false;
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }
            }
        }

        return true;
    }
}
