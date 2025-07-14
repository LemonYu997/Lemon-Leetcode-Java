package problems.c0easy.t2501t3000;

/**
 * 2520 统计能整除数字的位数 https://leetcode.cn/problems/count-the-digits-that-divide-a-number/description/
 * 给你一个整数 num ，返回 num 中能整除 num 的数位的数目。
 * 如果满足 nums % val == 0 ，则认为整数 val 可以整除 nums 。
 *
 * 示例：
 * 输入1：num = 7
 * 输出1：1
 *
 * 输入2：num = 121
 * 输出2：2
 *
 * 输入3：num = 1248
 * 输出3：4
 */
public class T2520 {
    /**
     * 自己实现：根据题意模拟
     */
    public int countDigits(int num) {
        int ans = 0;
        int temp = num;
        while (temp > 0) {
            // 得到当前位数
            int n = temp % 10;
            if (num % n == 0) {
                ans++;
            }
            // 获取下一位
            temp /= 10;
        }

        return ans;
    }
}
