package problems.c0easy.t1001t1500;

/**
 * 1374 生成每种字符都是奇数个的字符串 https://leetcode.cn/problems/generate-a-string-with-characters-that-have-odd-counts/description/
 * 给你一个整数 n，请你返回一个含 n 个字符的字符串，其中每种字符在该字符串中都恰好出现 奇数次 。
 * 返回的字符串必须只含小写英文字母。如果存在多个满足题目要求的字符串，则返回其中任意一个即可。
 *
 * 示例：
 * 输入1：n = 4
 * 输出1："pppz"
 *
 * 输入2：n = 2
 * 输出2："xy"
 *
 * 输入3：n = 7
 * 输出3："holasss"
 */
public class T1374 {
    /**
     * 自己实现：如果n是奇数，全返回a，如果n是偶数，返回n-1个a和一个b
     */
    public String generateTheString(int n) {
        char[] chars = new char[n];
        if (n % 2 == 1) {
            for (int i = 0; i < n; i++) {
                chars[i] = 'a';
            }
        } else {
            for (int i = 0; i < n - 1; i++) {
                chars[i] = 'a';
            }
            chars[n - 1] = 'b';
        }

        return new String(chars);
    }

    /**
     * 官方解法：StringBuilder实现
     * JDK 11 函数 repeat
     */
//    public String generateTheString1(int n) {
//        StringBuilder sb = new StringBuilder();
//        if (n % 2 == 1) {
//            return sb.append("a".repeat(n)).toString();
//        }
//        return sb.append("a".repeat(n - 1)).append("b").toString();
//    }
}
