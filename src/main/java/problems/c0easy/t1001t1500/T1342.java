package problems.c0easy.t1001t1500;

/**
 * 1342 将数字变成 0 的操作次数 https://leetcode.cn/problems/number-of-steps-to-reduce-a-number-to-zero/description/
 * 给你一个非负整数 num ，请你返回将它变成 0 所需要的步数。
 * 如果当前数字是偶数，你需要把它除以 2 ；否则，减去 1 。
 *
 * 示例：
 * 输入1：num = 14
 * 输出1：6
 *
 * 输入2：num = 8
 * 输出2：4
 *
 * 输入3：num = 123
 * 输出3：12
 */
public class T1342 {
    /**
     * 自己实现：根据题意模拟
     */
    public int numberOfSteps(int num) {
        int ans = 0;

        while (num != 0) {
            if (num % 2 == 0) {
                num /= 2;
            } else {
                num--;
            }
            ans++;
        }
        return ans;
    }
}
