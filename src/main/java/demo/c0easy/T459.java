package demo.c0easy;

/**
 * 459 重复的子字符串 https://leetcode.cn/problems/repeated-substring-pattern/
 * 给定一个非空字符串s，检查它是否可以通过它的一个子串重复多次构成
 *
 * 示例：
 * 输入1：s = "abab"
 * 输出1：true
 * 备注：可由子串 "ab" 重复两次构成。
 *
 * 输入2：s = "aba"
 * 输出2：false
 *
 * 输入3：s = "abcabcabcabc"
 * 输出3：true
 */
public class T459 {
    /**
     * 自己实现：暴力解法
     * 会超时
     */
    public boolean repeatedSubstringPattern1(String s) {
        int l = s.length();
        //遍历每一个子串（长度到一半为止）
        for (int i = 1; i <= l / 2; i++) {
            //当前子串
            String subs = s.substring(0, i);
            //拼接子串
            StringBuilder sb = new StringBuilder();
            String temp = sb.toString();
            while (temp.length() <= l) {
                if (temp.equals(s)) {
                    return true;
                }
                sb.append(subs);
                temp = sb.toString();
            }
        }

        return false;
    }

    /**
     * 自己实现：上述解法优化，先判断子串长度是否为s的公因数
     */
    public boolean repeatedSubstringPattern2(String s) {
        int l = s.length();
        //遍历每一个子串（长度到一半为止）
        for (int i = 1; i <= l / 2; i++) {
            //判断是否为公因数
            if (l % i != 0) {
                continue;
            }

            //当前子串
            String subs = s.substring(0, i);
            //拼接子串
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < l / i; j++) {
                sb.append(subs);
            }
            if (sb.toString().equals(s)) {
                return true;
            }
        }

        return false;
    }

    /**
     * 官方解法1：枚举
     * 大体思路同上
     */
    public boolean repeatedSubstringPattern3(String s) {
        int n = s.length();

        for (int i = 1; i * 2 <= n; i++) {
            if (n % i == 0) {
                boolean match = true;
                for (int j = i; j < n; j++) {
                    if (s.charAt(j) != s.charAt(j - i)) {
                        match = false;
                        break;
                    }
                }

                if (match) {
                    return true;
                }
            }
        }

        return false;
    }
}
