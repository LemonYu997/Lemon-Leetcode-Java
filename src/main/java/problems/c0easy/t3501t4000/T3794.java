package problems.c0easy.t3501t4000;

/**
 * 3794 反转字符串前缀 https://leetcode.cn/problems/reverse-string-prefix/description/
 * 给你一个字符串 s 和一个整数 k。
 * 反转 s 的前 k 个字符，并返回结果字符串。
 *
 * 示例：
 * 输入1：s = "abcd", k = 2
 * 输出1："bacd"
 *
 * 输入2：s = "xyz", k = 3
 * 输出2："zyx"
 *
 * 输入3：s = "hey", k = 1
 * 输出3："hey"
 */
public class T3794 {
    /**
     * 自己实现：根据题意模拟
     */
    public String reversePrefix(String s, int k) {
        String s1 = s.substring(0, k);
        String s2 = s.substring(k);
        StringBuilder sb = new StringBuilder(s1);
        sb.reverse();
        sb.append(s2);

        return sb.toString();
    }

    /**
     * 社区解法：想向双指针
     */
    public String reversePrefix1(String s, int k) {
        int left = 0;
        int right = k - 1;
        char[] chars = s.toCharArray();
        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;

            left++;
            right--;
        }

        return new String(chars);
    }
}
