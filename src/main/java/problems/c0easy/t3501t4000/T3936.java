package problems.c0easy.t3501t4000;

/**
 * 3936 将 0 移到末尾的最少交换次数 https://leetcode.cn/problems/minimum-swaps-to-move-zeros-to-end/description/
 * 给你一个整数数组 nums 。
 * 在一步操作中，你可以选择任意两个 不同 的下标 i 和 j 并交换 nums[i] 和 nums[j] 。
 * 返回将所有 0 移动到数组末尾所需的 最少 操作次数。
 *
 * 示例：
 * 输入1：nums = [0,1,0,3,12]
 * 输出1：2
 *
 * 输入2：nums = [0,1,0,2]
 * 输出2：1
 *
 * 输入3：nums = [1,2,0]
 * 输出3：0
 */
public class T3936 {
    /**
     * 自己实现：只需要统计0的个数 count，然后看有多少个 0 在倒数 count位之前即可
     */
    public int minimumSwaps(int[] nums) {
        int n = nums.length;
        int count = 0;
        int ans = 0;

        for (int num : nums) {
            if (num == 0) {
                count++;
            }
        }

        for (int i = 0; i < n - count; i++) {
            if (nums[i] == 0) {
                ans++;
            }
        }
        return ans;
    }


    /**
     * 社区解法：一次遍历，相向双指针
     */
    public int minimumSwaps1(int[] nums) {
        int ans = 0;
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            if (nums[l] != 0) {
                l++;
            } else if (nums[r] == 0) {
                r--;
            } else {
                ans++;
                l++;
                r--;
            }
        }
        return ans;
    }
}
