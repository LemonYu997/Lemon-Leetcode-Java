package problems.c0easy.t2001t2500;

import java.util.Arrays;

/**
 * 2148 元素计数 https://leetcode.cn/problems/count-elements-with-strictly-smaller-and-greater-elements/description/
 * 给你一个整数数组 nums ，统计并返回在 nums 中同时至少具有一个严格较小元素和一个严格较大元素的元素数目。
 *
 * 示例：
 * 输入1：nums = [11,7,2,15]
 * 输出1：2
 *
 * 输入2：nums = [-3,3,3,90]
 * 输出2：2
 */
public class T2148 {
    /**
     * 自己实现：根据题意模拟，排序后，找到除了最大值和最小值数目外的个数
     */
    public int countElements(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        // 默认去掉最大值和最小值
        int ans = n - 2;
        int l = 0;
        int r = n - 1;

        // 去掉所有最小值
        while (l + 1 < n) {
            if (nums[l + 1] == nums[l]) {
                l++;
                ans--;
            } else {
                break;
            }
        }

        // 去掉所有最大值
        while (r - 1 >= 0) {
            if (nums[r] == nums[r - 1]) {
                r--;
                ans--;
            } else {
                break;
            }
        }

        // 如果总数小于0取0
        return Math.max(ans, 0);
    }

    /**
     * 优化解法：不排序直接找
     */
    public int countElements1(int[] nums) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        // 最大值和最小值个数
        int minNum = 0;
        int maxNum = 0;

        for (int num : nums) {
            if (num > max) {
                max = num;
                maxNum = 1;
            } else if (num == max) {
                maxNum++;
            }

            if (num < min) {
                min = num;
                minNum = 1;
            } else if (num == min) {
                minNum++;
            }
        }

        int ans = nums.length - minNum - maxNum;

        return Math.max(ans, 0);
    }
}
