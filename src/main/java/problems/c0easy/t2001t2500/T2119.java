package problems.c0easy.t2001t2500;

/**
 * 2119 反转两次的数字 https://leetcode.cn/problems/a-number-after-a-double-reversal/description/
 * 反转 一个整数意味着倒置它的所有位。
 * 例如，反转 2021 得到 1202 。反转 12300 得到 321 ，不保留前导零 。
 * 给你一个整数 num ，反转 num 得到 reversed1 ，接着反转 reversed1 得到 reversed2 。
 * 如果 reversed2 等于 num ，返回 true ；否则，返回 false 。
 *
 * 示例：
 * 输入1：num = 526
 * 输出1：true
 *
 * 输入2：num = 1800
 * 输出2：false
 *
 * 输入3：num = 0
 * 输出3：true
 */
public class T2119 {
    /**
     * 自己实现：根据题意模拟
     */
    public boolean isSameAfterReversals(int num) {
        if (num == 0) {
            return true;
        }

        int temp = num;
        // 如果末尾几位是0，返回false
        while (temp > 0) {
            if (temp % 10 == 0) {
                temp = temp / 10;
                return false;
            } else {
                break;
            }
        }

        return true;
    }

    /**
     * 官方解法：优化判断条件
     */
    public boolean isSameAfterReversals1(int num) {
        // 如果 num 为 0 或者结尾不为 0 即可成立
        return num == 0 || num % 10 != 0;
    }
}
