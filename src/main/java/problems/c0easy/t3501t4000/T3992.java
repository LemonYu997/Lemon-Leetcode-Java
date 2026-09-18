package problems.c0easy.t3501t4000;

import java.util.Arrays;

/**
 * 3992 重新排列字符串以避免字符对 https://leetcode.cn/problems/rearrange-string-to-avoid-character-pair/description/
 * 给你一个字符串 s 和两个 不同 的小写英文字母 x 和 y。
 * 重新排列 s 中的字符来构造一个新的字符串 t，使得：
 * t 是 s 的一个 排列。
 * 在 t 中，所有 y 都必须在所有 x 之前。
 * 返回 任意 一个有效的字符串 t。
 * 排列 是对一个字符串中所有字符的重新排列。
 *
 * 示例：
 * 输入1：s = "aabc", x = "a", y = "c"
 * 输出1："cbaa"
 *
 * 输入2：s = "dcab", x = "d", y = "b"
 * 输出2："cabd"
 *
 * 输入3：s = "axe", x = "o", y = "x"
 * 输出3："axe"
 */
public class T3992 {
    /**
     * 社区解法：排序
     */
    public String rearrangeString(String s, char x, char y) {
        char[] t = s.toCharArray();
        Arrays.sort(t);
        if (x < y) {
            reverse(t);
        }
        return new String(t);
    }

    private void reverse(char[] a) {
        for (int i = 0, j = a.length - 1; i < j; i++, j--) {
            char temp = a[i];
            a[i] = a[j];
            a[j] = temp;
        }
    }

    /**
     * 社区解法2：想向双指针
     */
    public String rearrangeString1(String s, char x, char y) {
        char[] t = s.toCharArray();
        int l = 0;
        int r = t.length - 1;
        while (l < r) {
            if (t[l] != x) {
                l++;
            } else if (t[r] != y) {
                r--;
            } else {
                char tmp = t[l];
                t[l] = t[r];
                t[r] = tmp;
                l++;
                r--;
            }
        }
        return new String(t);
    }
}
