package problems.c0easy.t1501t2000;

/**
 * 1800 最大升序子数组和 https://leetcode.cn/problems/maximum-ascending-subarray-sum/description/
 * 给你一个正整数组成的数组 nums ，返回 nums 中一个 升序 子数组的最大可能元素和。
 * 子数组是数组中的一个连续数字序列。
 * 已知子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，若对所有 i（l <= i < r），
 * numsi  < numsi+1 都成立，则称这一子数组为 升序 子数组。注意，大小为 1 的子数组也视作 升序 子数组。
 *
 * 示例：
 * 输入1：nums = [10,20,30,5,10,50]
 * 输出1：65
 *
 * 输入2：nums = [10,20,30,40,50]
 * 输出2：150
 *
 * 输入3：nums = [12,17,15,13,10,11,12]
 * 输出3：33
 *
 * 输入4：nums = [100,10,1]
 * 输出4：100
 */
public class T1800 {
    /**
     * 自己实现：双重遍历
     */
    public int maxAscendingSum(int[] nums) {
        int n = nums.length;
        int ans = 0;

        for (int i = 0; i < n; i++) {
            // 当前起始时升序数组的元素和
            int temp = nums[i];
            for (int j = i + 1; j < n; j++) {
                if (nums[j] > nums[j - 1]) {
                    temp += nums[j];
                } else  {
                    break;
                }
            }
            // 更新最大值
            ans = Math.max(ans, temp);
        }

        return ans;
    }
}
