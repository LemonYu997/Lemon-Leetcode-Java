package demo.c0easy;

/**
 * 541 反转字符串II https://leetcode.cn/problems/reverse-string-ii/
 * 给定一个字符串s和一个整数k，从字符串开头算起，每计数至2k个字符，就反转这2k字符中的前k个字符
 * 如果剩余字符少于k个，则将剩余字符全部反转
 * 如果剩余字符小于2k但大于或等于k个，则反转前k个字符，其余字符保持原样
 *
 * 示例：
 * 输入1：s = "abcdefg", k = 2
 * 输出1："bacdfeg"
 *
 * 输入2：s = "abcd", k = 2
 * 输出2："bacd"
 */
public class T541 {
    public static void main(String[] args) {
        reverseStr("abcdefg", 2);
    }

    /**
     * 自己实现：根据定义
     */
    public static String reverseStr(String s, int k) {
        char[] chars = s.toCharArray();
        //索引
        int i = 0;

        while (i < chars.length){
            //如果剩下的长度不够k，那就将剩下的全部反转
            if (chars.length - i < k) {
                for (int j = 0; j < (chars.length - i) / 2; j++) {
                    char temp = chars[i + j];
                    chars[i + j] = chars[chars.length - j - 1];
                    chars[chars.length - j - 1] = temp;
                }
            } else {
                //反转k个字符
                for (int j = 0; j < k / 2; j++) {
                    char temp = chars[i + j];
                    chars[i + j] = chars[i + k - j - 1];
                    chars[i + k - j - 1] = temp;
                }
            }

            //更新索引
            i = i + 2 * k;
        }

        return new String(chars);
    }

    /**
     * 官方解法
     */
    public String reverseStr1(String s, int k) {
        int n = s.length();
        char[] chars = s.toCharArray();
        for (int i = 0; i < n; i+= 2 * k) {
            reverse(chars, i, Math.min(i + k, n) - 1);
        }

        return new String(chars);
    }

    public void reverse(char[] chars, int left, int right) {
        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
    }
}
