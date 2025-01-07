package problems.c0easy.t1501t2000;

/**
 * 1995 统计特殊四元组 https://leetcode.cn/problems/count-special-quadruplets/description/
 * 给你一个 下标从 0 开始 的整数数组 nums ，
 * 返回满足下述条件的 不同 四元组 (a, b, c, d) 的 数目 ：
 *
 * nums[a] + nums[b] + nums[c] == nums[d] ，且
 * a < b < c < d
 *
 * 示例：
 * 输入1：nums = [1,2,3,6]
 * 输出1:1
 *
 * 输入2：nums = [3,3,6,4,5]
 * 输出2:0
 *
 * 输入3：nums = [1,1,1,3,5]
 * 输出3：4
 */
public class T1995 {
    /**
     * 自己实现：暴力解法
     */
    public int countQuadruplets(int[] nums) {
        int ans = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    for (int l = k + 1; l < n; l++) {
                        if (nums[i] + nums[j] + nums[k] == nums[l]) {
                            ans++;
                        }
                    }
                }
            }
        }

        return ans;
    }

}
