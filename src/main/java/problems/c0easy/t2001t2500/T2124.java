package problems.c0easy.t2001t2500;

/**
 * 2124 检查是否所有 A 都在 B 之前 https://leetcode.cn/problems/check-if-all-as-appears-before-all-bs/description/
 * 给你一个 仅 由字符 'a' 和 'b' 组成的字符串  s 。
 * 如果字符串中 每个 'a' 都出现在 每个 'b' 之前，返回 true ；否则，返回 false 。
 *
 * 示例：
 * 输入1：s = "aaabbb"
 * 输出1：true
 *
 * 输入2：s = "abab"
 * 输出2：false
 *
 * 输入3：s = "bbb"
 * 输出3：true
 */
public class T2124 {
    /**
     * 自己实现：根据题意模拟，只要存在 "ba" 即可认为失败
     */
    public boolean checkString(String s) {
        return !s.contains("ba");
    }

    /**
     * 官方解法：直接遍历
     */
    public boolean checkString1(String s) {
        int n = s.length();
        // 最后的 a 最早的 b 出现位置
        int lasta = -1;
        int firstb = n;

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'a') {
                lasta = i;
            } else {
                firstb = Math.min(i, firstb);
            }
        }

        return lasta < firstb;
    }
}
