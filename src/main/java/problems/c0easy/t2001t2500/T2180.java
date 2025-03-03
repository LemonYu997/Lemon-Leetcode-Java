package problems.c0easy.t2001t2500;

/**
 * 2180 统计各位数字之和为偶数的整数个数 https://leetcode.cn/problems/count-integers-with-even-digit-sum/description/
 * 给你一个正整数 num ，请你统计并返回 小于或等于 num
 * 且各位数字之和为 偶数 的正整数的数目。
 * 正整数的 各位数字之和 是其所有位上的对应数字相加的结果。
 *
 * 示例：
 * 输入1：num = 4
 * 输出1:2
 *
 * 输入2：num = 30
 * 输出2：14
 */
public class T2180 {
    /**
     * 自己实现：根据题意模拟
     */
    public int countEven(int num) {
        int ans = 0;

        for (int i = 2; i <= num; i++) {
            int temp = i;
            int n = 0;
            // 计算 temp 各位数之和是否为偶数
            while (temp > 0) {
                n += temp % 10;
                temp /= 10;
            }

            if (n % 2 == 0) {
                ans++;
            }
        }

        return ans;
    }
}
