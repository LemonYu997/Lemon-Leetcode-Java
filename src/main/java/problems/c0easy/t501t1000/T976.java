package problems.c0easy.t501t1000;

import java.util.Arrays;

/**
 * 976 三角形的最大周长 https://leetcode.cn/problems/largest-perimeter-triangle/
 * 给定由一些正数（代表长度）组成的数组 nums ，
 * 返回 由其中三个长度组成的、面积不为零的三角形的最大周长 。
 * 如果不能形成任何面积不为零的三角形，返回 0。
 *
 * 示例：
 * 输入1：nums = [2,1,2]
 * 输出1：5
 *
 * 输入2：nums = [1,2,1,10]
 * 输出2：0
 */
public class T976 {
    /**
     * 自己实现：根据题意模拟，暴力循环
     * 会超时
     */
    public int largestPerimeter(int[] nums) {
        int ans = 0;
        // 遍历得到三个数字作为三边长度
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    // 判断三边能否围成三角形
                    if (nums[i] + nums[j] > nums[k]
                            && nums[i] + nums[k] > nums[j]
                            && nums[j] + nums[k] > nums[i]) {
                        ans = Math.max(ans, nums[i] + nums[j] + nums[k]);
                    }
                }
            }
        }
        return ans;
    }

    /**
     * 官方解法：先排序，再倒序遍历找到符合条件的最大三个边
     */
    public int largestPerimeter1(int[] nums) {
        Arrays.sort(nums);
        // 倒序遍历三个数
        for (int i = nums.length - 1; i >= 2; i--) {
            if (nums[i - 2] + nums[i - 1] > nums[i]) {
                return nums[i] + nums[i - 1] + nums[i - 2];
            }
        }
        return 0;
    }
}
