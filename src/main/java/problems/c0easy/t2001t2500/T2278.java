package problems.c0easy.t2001t2500;

/**
 * 2278 字母在字符串中的百分比 https://leetcode.cn/problems/percentage-of-letter-in-string/description/
 * 给你一个字符串 s 和一个字符 letter ，返回在 s 中等于 letter 字符所占的 百分比 ，
 * 向下取整到最接近的百分比。
 *
 * 示例：
 * 输入1：s = "foobar", letter = "o"
 * 输出1：33
 *
 * 输入2：s = "jjjj", letter = "k"
 * 输出2：0
 */
public class T2278 {
    /**
     * 自己实现：遍历统计即可
     */
    public int percentageLetter(String s, char letter) {
        int n = s.length();
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == letter) {
                count++;
            }
        }

//        return (int) (((double) count / n) * 100);
        return 100 * count / n;
    }
}
