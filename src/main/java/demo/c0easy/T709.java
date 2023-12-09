package demo.c0easy;

/**
 * 709 转换成小写字母 https://leetcode.cn/problems/to-lower-case/
 * 给定一个字符串s，将该字符串中的大写字母转换成相同的小写字母，返回新的字符串
 *
 * 示例：
 * 输入1：s = 'Hello'
 * 输出1：'Hello'
 *
 * 输入2：s = 'here'
 * 输出2：'here'
 *
 * 输入3：s = 'LOVELY'
 * 输出3：'lovely'
 */
public class T709 {
    /**
     * 自己实现：调API
     */
    public String toLowerCase(String s) {
        return s.toLowerCase();
    }

    /**
     * 官方解法：位运算
     * ASCII码表中 A-Z 的范围是 [65, 90]，对应的二进制位是 [(01000001), (01011010)]
     * a-z 的范围是 [97, 122]，中间差 32
     * 而32的二进制位是 00100000，可以用 或 运算代替加法运算：
     * 如 01000001(65) | 00100000(32) = 01100001(97)
     */
    public String toLowerCase1(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= 65 && c <= 90) {
                c |= 32;
            }
            sb.append(c);
        }

        return sb.toString();
    }
}