package problems.c0easy.t1501t2000;

/**
 * 1979 找出数组的最大公约数 https://leetcode.cn/problems/find-greatest-common-divisor-of-array/description/
 * 给你一个整数数组 nums ，返回数组中最大数和最小数的 最大公约数 。
 *
 * 两个数的 最大公约数 是能够被两个数整除的最大正整数。
 *
 * 示例：
 * 输入1：nums = [2,5,6,9,10]
 * 输出1:2
 *
 * 输入2：nums = [7,5,6,8,3]
 * 输出2:1
 *
 * 输入3：nums = [3,3]
 * 输出3:3
 */
public class T1979 {
    /**
     * 自己实现：根据提议模拟，先找到最大值和最小值，再找到最大公约数
     */
    public int findGCD(int[] nums) {
        int min = nums[0];
        int max = nums[0];

        // 遍历一遍，找到最大值和最小值
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < min) {
                min = nums[i];
            }
            if (nums[i] > max) {
                max = nums[i];
            }
        }

        // 找到两者之间的最大公约数 范围肯定为 [1,min]
        int ans = 1;
        for (int i = min; i > 1; i--) {
            // 找到后直接退出
            if (max % i == 0 && min % i == 0) {
                ans = i;
                break;
            }
        }

        return ans;
    }

    /**
     * 官方解法：使用辗转相除法找到最大公约数
     */
    public int findGCD1(int[] nums) {
        int min = nums[0];
        int max = nums[0];

        // 遍历一遍，找到最大值和最小值
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < min) {
                min = nums[i];
            }
            if (nums[i] > max) {
                max = nums[i];
            }
        }

        return gcd(min, max);
    }

    public int gcd(int x, int y) {
        return y == 0 ? x : gcd(y, x % y);
    }
}
