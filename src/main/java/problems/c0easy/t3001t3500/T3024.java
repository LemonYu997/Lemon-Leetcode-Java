package problems.c0easy.t3001t3500;

import java.util.Arrays;

/**
 * 3024 三角形类型 https://leetcode.cn/problems/type-of-triangle/description/
 * 给你一个下标从 0 开始长度为 3 的整数数组 nums ，需要用它们来构造三角形。
 * 如果一个三角形的所有边长度相等，那么这个三角形称为 equilateral 。
 * 如果一个三角形恰好有两条边长度相等，那么这个三角形称为 isosceles 。
 * 如果一个三角形三条边的长度互不相同，那么这个三角形称为 scalene 。
 * 如果这个数组无法构成一个三角形，请你返回字符串 "none" ，否则返回一个字符串表示这个三角形的类型。
 *
 * 示例：
 * 输入1：nums = [3,3,3]
 * 输出1："equilateral"
 *
 * 输入2：nums = [3,4,5]
 * 输出2："scalene"
 */
public class T3024 {
    /**
     * 自己实现：根据题意模拟
     * 三角形任意两边之和大于第三边
     */
    public String triangleType(int[] nums) {
        if (nums[0] == nums[1] && nums[1] == nums[2]) {
            return "equilateral";
        }
        // 判断是否能形成三角形
        if (nums[0] + nums[1] > nums[2]
                && nums[1] + nums[2] > nums[0]
                && nums[2] + nums[0] > nums[1]) {
            // 有两边相等
            if (nums[0] == nums[1] || nums[1] == nums[2] || nums[2] == nums[0]) {
                return "isosceles";
            } else {
                return "scalene";
            }
        } else {
            return "none";
        }
    }

    /**
     * 官方：优化写法
     */
    public String triangleType2(int[] nums) {
        Arrays.sort(nums);
        if (nums[0] + nums[1] <= nums[2]) {
            return "none";
        } else if (nums[0] == nums[2]) {
            return "equilateral";
        } else if (nums[0] == nums[1] || nums[1] == nums[2]) {
            return "isosceles";
        } else {
            return "scalene";
        }
    }
}
