package problems.c0easy.t3001t3500;

/**
 * 3079 求出加密整数的和 https://leetcode.cn/problems/find-the-sum-of-encrypted-integers/description/
 * 给你一个整数数组 nums ，数组中的元素都是 正 整数。定义一个加密函数 encrypt ，
 * encrypt(x) 将一个整数 x 中 每一个 数位都用 x 中的 最大 数位替换。
 * 比方说 encrypt(523) = 555 且 encrypt(213) = 333 。
 * 请你返回数组中所有元素加密后的 和 。
 *
 * 示例：
 * 输入1：nums = [1,2,3]
 * 输出1：6
 *
 * 输入2：nums = [10,21,31]
 * 输出2：66
 */
public class T3079 {
    /**
     * 自己实现：根据题意模拟即可
     */
    public int sumOfEncryptedInt(int[] nums) {
        int ans = 0;

        for (int num : nums) {
            // 找到最大的位值和位数
            int count = 0;
            int max = 0;
            while (num > 0) {
                count++;
                max = Math.max(max, num % 10);
                num /= 10;
            }

            // 计算加密后最大值
            int temp = 0;
            while (count > 0) {
                temp = temp * 10 + max;
                count--;
            }
            ans += temp;
        }

        return ans;
    }

    /**
     * 社区解法：优化实现
     */
    public int sumOfEncryptedInt1(int[] nums) {
        int ans = 0;
        for (int num : nums) {
            int max = 0;
            int base = 0;
            while (num > 0) {
                max = Math.max(max, num % 10);
                base = base * 10 + 1;
                num /= 10;
            }
            ans += base * max;
        }
        return ans;
    }
}
