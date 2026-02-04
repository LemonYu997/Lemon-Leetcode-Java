package problems.c0easy.t3001t3500;

/**
 * 3210 找出加密后的字符串 https://leetcode.cn/problems/find-the-encrypted-string/description/
 * 给你一个字符串 s 和一个整数 k。请你使用以下算法加密字符串：
 * 对于字符串 s 中的每个字符 c，用字符串中 c 后面的第 k 个字符替换 c（以循环方式）。
 * 返回加密后的字符串。
 *
 * 示例：
 * 输入1：s = "dart", k = 3
 * 输出1："tdar"
 *
 * 输入2：s = "aaa", k = 1
 * 输出2："aaa"
 */
public class T3210 {
    /**
     * 自己实现：创建一个新字符串，根据题意模拟
     */
    public String getEncryptedString(String s, int k) {
        int n = s.length();
        char[] chars = new char[n];
        for (int i = 0; i < n; i++) {
            chars[i] = s.charAt((i + k) % n);
        }
        return new String(chars);
    }

    /**
     * 社区解法：原字符串拼接,相当于把 s 循环左移 k mod n 位
     */
    public String getEncryptedString1(String s, int k) {
        k %= s.length();
        return s.substring(k) + s.substring(0, k);
    }
}