package problems.c0easy.t1001t1500;

/**
 * 1295 统计位数为偶数的数字 https://leetcode.cn/problems/find-numbers-with-even-number-of-digits/description/
 * 给你一个整数数组 nums，请你返回其中位数为 偶数 的数字的个数。
 *
 * 示例：
 * 输入1：nums = [12,345,2,6,7896]
 * 输出1：2
 *
 * 输入2：nums = [555,901,482,1771]
 * 输出2：1
 */
public class T1295 {
    /**
     * 自己实现：遍历
     */
    public int findNumbers(int[] nums) {
        int ans = 0;
        for (int num : nums) {
            // 位数
            int count = 0;
            while (num > 0) {
                count++;
                num /= 10;
            }
            if (count % 2 == 0) {
                ans++;
            }
        }
        return ans;
    }

    /**
     * 官方解法1：转字符串，根据长度判断
     */
    public int findNumbers1(int[] nums) {
        int ans = 0;
        for (int num : nums) {
            if (String.valueOf(num).length() % 2 == 0) {
                ans++;
            }
        }
        return ans;
    }

    /**
     * 官方解法2：枚举+数学
     */
    public int findNumbers2(int[] nums) {
        int ans = 0;
        for (int num : nums) {
            // 假设有k个数字，则 10^(k-1) <= num <= 10^k
            // 可推得 k - 1 <= log10(num) <= k
            // 即 k = [log10(num) + 1]
            if ((int) (Math.log10(num) + 1) % 2 == 0) {
                ans++;
            }
        }
        return ans;
    }
}
