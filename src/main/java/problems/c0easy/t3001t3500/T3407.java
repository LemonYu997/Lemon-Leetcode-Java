package problems.c0easy.t3001t3500;

/**
 * 3407 子字符串匹配模式 https://leetcode.cn/problems/substring-matching-pattern/description/
 * 给你一个字符串 s 和一个模式字符串 p ，其中 p 恰好 包含 一个 '*' 符号。
 * p 中的 '*' 符号可以被替换为零个或多个字符组成的任意字符序列。
 * 如果 p 可以变成 s 的 子字符串，那么返回 true ，否则返回 false 。
 *
 * 示例：
 * 输入1：s = "leetcode", p = "ee*e"
 * 输出1：true
 *
 * 输入2：s = "car", p = "c*v"
 * 输出2：false
 *
 * 输入3：s = "luck", p = "u*"
 * 输出3：true
 */
public class T3407 {
    public static void main(String[] args) {
//        String s = "c*v";
        String s = "*v";
//        String s = "c*v";
        String[] split = s.split("\\*");
        System.out.println(split[0]);
        System.out.println(split[1]);
        System.out.println(split[0].length());
        System.out.println(split[1].length());
    }


    /**
     * 自己实现：判断 * 前后的字符串在 s 中是否存在即可，但是得保证前后顺序一致
     */
    public boolean hasMatch(String s, String p) {
        int star = p.indexOf('*');
        // 先匹配前半部分
        int i = s.indexOf(p.substring(0, star));
        // 再匹配后半部分
        return i >= 0 && s.substring(i + star).contains(p.substring(star + 1));
    }
}
