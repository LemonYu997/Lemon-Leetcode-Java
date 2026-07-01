package problems.c0easy.t3501t4000;

/**
 * 3712 出现次数能被 K 整除的元素总和 https://leetcode.cn/problems/sum-of-elements-with-frequency-divisible-by-k/description/
 * 给你一个整数数组 nums 和一个整数 k。
 * 请返回一个整数，表示 nums 中所有其 出现次数 能被 k 整除的元素的总和；如果没有这样的元素，则返回 0 。
 * 注意： 若某个元素在数组中的总出现次数能被 k 整除，则它在求和中会被计算 恰好 与其出现次数相同的次数。
 * 元素 x 的 出现次数 指它在数组中出现的次数。
 *
 * 示例：
 * 输入1：nums = [1,2,2,3,3,3,3,4], k = 2
 * 输出1：16
 *
 * 输入2：nums = [1,2,3,4,5], k = 2
 * 输出2：0
 *
 * 输入3：nums = [4,4,4,1,2,3], k = 3
 * 输出3：12
 */
public class T3712 {
    /**
     * 自己实现：根据题意模拟
     */
    public int sumDivisibleByK(int[] nums, int k) {
        // 统计所有数出现的次数
        int[] count = new int[101];
        int ans = 0;

        for (int num : nums) {
            count[num]++;
        }

        for (int i = 1; i < count.length; i++) {
            // 如果出现次数可以被 k 整除，则将该元素值全部加上求和
            if (count[i] > 0 && count[i] % k == 0) {
                ans += i * count[i];
            }
        }

        return ans;
    }
}
