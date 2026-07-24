package problems.c0easy.t3501t4000;

import java.util.function.Predicate;

/**
 * 3823 反转一个字符串里的字母后反转特殊字符 https://leetcode.cn/problems/reverse-letters-then-special-characters-in-a-string/description/
 * 给你一个由小写英文字母和特殊字符组成的字符串 s。
 * 你的任务是 按顺序 执行以下操作：
 * 反转小写字母，并将它们放回原来字母所占据的位置。
 * 反转特殊字符，并将它们放回原来特殊字符所占据的位置。
 * 返回执行反转操作后的结果字符串。
 *
 * 示例：
 * 输入1：s = ")ebc#da@f("
 * 输出1："(fad@cb#e)"
 *
 * 输入2：s = "z"
 * 输出2："z"
 *
 * 输入3：s = "!@#$%^&*()"
 * 输出3：")(*&^%$#@!"
 */
public class T3823 {
    /**
     * 社区解法：双指针
     */
    public String reverseByType(String s) {
        byte[] t = s.getBytes();
        reverse(t, ch -> 'a' <= ch && ch <= 'z');
        reverse(t, ch -> !('a' <= ch && ch <= 'z'));
        return new String(t);
    }

    private void reverse(byte[] t, Predicate<Byte> f) {
        int i = 0;
        int j = t.length - 1;
        while (i < j) {
            while (i < j && f.test(t[i])) {
                i++;
            }
            while (i < j && f.test(t[j])) {
                j--;
            }
            byte temp = t[i];
            t[i] = t[j];
            t[j] = temp;
            i++;
            j--;
        }
    }
}
