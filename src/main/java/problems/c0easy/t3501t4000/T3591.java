package problems.c0easy.t3501t4000;

/**
 * 3591 检查元素频次是否为质数 https://leetcode.cn/problems/check-if-any-element-has-prime-frequency/description/
 * 给你一个整数数组 nums。
 * 如果数组中任一元素的 频次 是 质数，返回 true；否则，返回 false。
 * 元素 x 的 频次 是它在数组中出现的次数。
 * 质数是一个大于 1 的自然数，并且只有两个因数：1 和它本身。
 *
 * 示例：
 * 输入1：nums = [1,2,3,4,5,4]
 * 输出1：true
 *
 * 输入2：nums = [1,2,3,4,5]
 * 输出2：false
 *
 * 输入3：nums = [2,2,2,4,4]
 * 输出3：true
 */
public class T3591 {
    /**
     * 自己实现：根据题意模拟，先统计每个数出现的次数，再判断其次数是否为质数
     */
    public boolean checkPrimeFrequency(int[] nums) {
        int[] set = new int[101];
        for (int num : nums) {
            set[num]++;
        }

        // 判断每个次数是否为质数
        for (int n : set) {
            if (isPrime(n)) {
                return true;
            }
        }

        return false;
    }

    private boolean isPrime(int n) {
        // 小于2的数都不是质数
        if (n < 2) {
            return false;
        }
        // 2 是质数
        if (n == 2) {
            return true;
        }
        // 偶数（大于2）不是质数
        if (n % 2 == 0) {
            return false;
        }
        // 只需检查奇数因子，范围从3到 sqrt(n)
        int limit = (int) Math.sqrt(n);
        for (int i = 3; i <= limit; i += 2) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
