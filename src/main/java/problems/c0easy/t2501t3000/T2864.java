package problems.c0easy.t2501t3000;

/**
 * 2864 最大二进制奇数 https://leetcode.cn/problems/maximum-odd-binary-number/
 * 给你一个 二进制 字符串 s ，其中至少包含一个 '1' 。
 * 你必须按某种方式 重新排列 字符串中的位，
 * 使得到的二进制数字是可以由该组合生成的 最大二进制奇数 。
 * 以字符串形式，表示并返回可以由给定组合生成的最大二进制奇数。
 * 注意 返回的结果字符串 可以 含前导零。
 *
 * 示例：
 * 输入1：s = "010"
 * 输出1："001"
 *
 * 输入2：s = "0101"
 * 输出2："1001"
 */
public class T2864 {
    /**
     * 自己实现：末尾一定是1，剩余的1往前放
     */
    public String maximumOddBinaryNumber(String s) {
        int n = s.length();
        int count = 0;  // 1 的个数

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                count++;
            }
        }

        // 否则拼接至前边
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            // 要留一位放在末尾
            if (i == n - 1 || count > 1) {
                sb.append("1");
                count--;
            } else {
                sb.append("0");
            }
        }
        return sb.toString();
    }
}
