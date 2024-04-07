package problems.c0easy.t1001t1500;

/**
 * 1071 字符串的最大公因子 https://leetcode.cn/problems/greatest-common-divisor-of-strings/description/
 * 对于字符串 s 和 t，只有在 s = t + t + t + ... + t + t
 * （t 自身连接 1 次或多次）时，我们才认定 “t 能除尽 s”。
 * 给定两个字符串 str1 和 str2 。返回 最长字符串 x，要求满足 x 能除尽 str1 且 x 能除尽 str2 。
 *
 * 示例：
 * 輸入1：str1 = "ABCABC", str2 = "ABC"
 * 輸出1："ABC"
 *
 * 輸入2：str1 = "ABABAB", str2 = "ABAB"
 * 輸出2："AB"
 *
 * 輸入3：str1 = "LEET", str2 = "CODE"
 * 輸出3：""
 */
public class T1071 {
    /**
     * 官方解法：找到符合公约数条件的前缀
     */
    public String gcdOfStrings(String str1, String str2) {
        int len1 = str1.length();
        int len2 = str2.length();
        // 从长度小的开始枚举
        for (int i = Math.min(len1, len2); i >= 1; i--) {
            // 找到公约数
            if (len1 % i == 0 && len2 % i == 0) {
                // 取前缀
                String X = str1.substring(0, i);
                // 判断是否满足题意
                if (check(X, str1) && check(X, str2)) {
                    return X;
                }
            }
        }

        return "";
    }

    private boolean check(String t, String s) {
        int lenx = s.length() / t.length();
        StringBuffer ans = new StringBuffer();
        for (int i = 1; i <= lenx; i++) {
            ans.append(t);
        }
        return ans.toString().equals(s);
    }
}
