package problems.c0easy.t2001t2500;

/**
 * 2011 执行操作后的变量值 https://leetcode.cn/problems/final-value-of-variable-after-performing-operations/description/
 * 存在一种仅支持 4 种操作和 1 个变量 X 的编程语言：
 *
 * ++X 和 X++ 使变量 X 的值 加 1
 * --X 和 X-- 使变量 X 的值 减 1
 * 最初，X 的值是 0
 *
 * 给你一个字符串数组 operations ，这是由操作组成的一个列表，返回执行所有操作后， X 的 最终值 。
 *
 * 示例：
 * 输入1：operations = ["--X","X++","X++"]
 * 输出1:1
 *
 * 输入2：operations = ["++X","++X","X++"]
 * 输出2:3
 *
 * 输入3：operations = ["X++","++X","--X","X--"]
 * 输出3：0
 */
public class T2011 {
    /**
     * 自己实现：根据题意模拟
     */
    public int finalValueAfterOperations(String[] operations) {
        int ans = 0;

        for (String operation : operations) {
            if (operation.equals("--X") || operation.equals("X--")) {
                ans--;
            } else {
                ans++;
            }
        }

        return ans;
    }

    /**
     * 优化解法：观察示例，发现只用判断第二个字符是 + 还是 - 即可
     */
    public int finalValueAfterOperations1(String[] operations) {
        int ans = 0;
        for (String operation : operations) {
            if (operation.charAt(1) == '+') {
                ans++;
            } else {
                ans--;
            }
        }

        return ans;
    }
}
