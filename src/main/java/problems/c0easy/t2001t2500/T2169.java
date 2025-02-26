package problems.c0easy.t2001t2500;

/**
 * 2169 得到 0 的操作数 https://leetcode.cn/problems/count-operations-to-obtain-zero/description/
 * 给你两个 非负 整数 num1 和 num2 。
 * 每一步 操作 中，如果 num1 >= num2 ，你必须用 num1 减 num2 ；否则，你必须用 num2 减 num1 。
 * 例如，num1 = 5 且 num2 = 4 ，应该用 num1 减 num2 ，因此，得到 num1 = 1 和 num2 = 4 。
 * 然而，如果 num1 = 4且 num2 = 5 ，一步操作后，得到 num1 = 4 和 num2 = 1 。
 * 返回使 num1 = 0 或 num2 = 0 的 操作数 。
 *
 * 示例：
 * 输入1：num1 = 2, num2 = 3
 * 输出1：3
 *
 * 输入2：num1 = 10, num2 = 10
 * 输出2：1
 */
public class T2169 {
    /**
     * 自己实现：根据题意模拟
     */
    public int countOperations(int num1, int num2) {
        int ans = 0;

        // 当有一个为 0 时就退出
        while (num1 != 0 && num2 != 0) {
            if (num1 >= num2) {
                num1 -= num2;
            } else {
                num2 -= num1;
            }

            // 每一步操作数加一
            ans++;
        }

        return ans;
    }

    /**
     * 官方解法：辗转相除法
     * 当 num1 > num2 时，如果每次减去 num1, 则需要进行 num1 / num2 的操作次数
     * 最终得到的结果是 num1 % num2
     */
    public int countOperations1(int num1, int num2) {
        int ans = 0;
        // 都不为 0
        while (num1 != 0 && num2 != 0) {
            // 每一步碾转相除操作
            // 当 num1 > num2 时，如果每次减去 num1, 则需要进行 num1 / num2 的操作次数
            ans += num1 / num2;
            // 最终得到的结果是 num1 % num2
            num1 %= num2;
            // 因为在下一个循环的时候需要 num1 > num2，这里交换两个数
            int temp = num1;
            num1 = num2;
            num2 = temp;
        }

        return ans;
    }
}