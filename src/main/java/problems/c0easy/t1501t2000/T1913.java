package problems.c0easy.t1501t2000;

import java.util.Arrays;

/**
 * 1913 两个数对之间的最大乘积差 https://leetcode.cn/problems/maximum-product-difference-between-two-pairs/description/
 * 两个数对 (a, b) 和 (c, d) 之间的 乘积差 定义为 (a * b) - (c * d) 。
 * 例如，(5, 6) 和 (2, 7) 之间的乘积差是 (5 * 6) - (2 * 7) = 16 。
 * 给你一个整数数组 nums ，选出四个 不同的 下标 w、x、y 和 z ，
 * 使数对 (nums[w], nums[x]) 和 (nums[y], nums[z]) 之间的 乘积差 取到 最大值 。
 * 返回以这种方式取得的乘积差中的 最大值 。
 *
 * 示例：
 * 输入1：nums = [5,6,2,7,4]
 * 输出1：34
 *
 * 输入2：nums = [4,2,5,9,7,4,8]
 * 输出2：64
 */
public class T1913 {
    /**
     * 自己实现：排序后找到两个最大值的乘积减去两个最小值的乘积即可
     */
    public int maxProductDifference(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;

        return nums[n - 1] * nums[n - 2] - nums[0] * nums[1];
    }

    /**
     * 官方解法：一次遍历，找到最大的两个值和最小的两个值
     */
    public int maxProductDifference1(int[] nums) {
        int n = nums.length;
        // 最大的两个值，都先默认从前两个数中选
        int max1 = Math.max(nums[0], nums[1]);
        int max2 = Math.min(nums[0], nums[1]);
        // 最小的两个值
        int min1 = Math.min(nums[0], nums[1]);
        int min2 = Math.max(nums[0], nums[1]);

        // 从第三个数开始遍历
        for (int i = 2; i < n; i++) {
            int num = nums[i];
            if (num > max1) {
                max2 = max1;
                max1 = num;
            } else if (num > max2) {
                max2 = num;
            }

            if (num < min1) {
                min2 = min1;
                min1 = num;
            } else if (num < min2) {
                min2 = num;
            }
        }

        return max1 * max2 - min1 * min2;
    }
}
