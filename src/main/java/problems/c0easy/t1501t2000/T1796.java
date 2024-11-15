package problems.c0easy.t1501t2000;

/**
 * 1796 字符串中第二大的数字 https://leetcode.cn/problems/second-largest-digit-in-a-string/description/
 * 给你一个混合字符串 s ，请你返回 s 中 第二大 的数字，
 * 如果不存在第二大的数字，请你返回 -1 。
 * 混合字符串 由小写英文字母和数字组成。
 *
 * 示例：
 * 输入1：s = "dfa12321afd"
 * 输出1：2
 *
 * 输入3：s = "abc1111"
 * 输出3：-1
 */
public class T1796 {
    /**
     * 自己实现：根据题意，找到第二大的数字即可
     */
    public int secondHighest(String s) {
        int first = -1;
        int second = -1;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                int temp = c - '0';
                // 如果当前值比最大值大，更新最大值
                if (temp > first) {
                    second = first;
                    first = temp;
                    // 如果当前值比第二值大且不等于最大值，更新了第二大的值，防止与最大值相等时更新了第二大的值
                } else if (temp > second && temp != first) {
                    second = temp;
                }
            }
        }

        return second;
    }
}
