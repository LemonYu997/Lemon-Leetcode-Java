package problems.c0easy.t1501t2000;

/**
 * 1844 将所有数字用字符替换 https://leetcode.cn/problems/replace-all-digits-with-characters/description/
 * 给你一个下标从 0 开始的字符串 s ，它的 偶数 下标处为小写英文字母，奇数 下标处为数字。
 * 定义一个函数 shift(c, x) ，其中 c 是一个字符且 x 是一个数字，函数返回字母表中 c 后面第 x 个字符。
 *
 * 比方说，shift('a', 5) = 'f' 和 shift('x', 0) = 'x' 。
 * 对于每个 奇数 下标 i ，你需要将数字 s[i] 用 shift(s[i-1], s[i]) 替换。
 *
 * 请你替换所有数字以后，将字符串 s 返回。题目 保证 shift(s[i-1], s[i]) 不会超过 'z' 。
 *
 * 示例：
 * 输入1：s = "a1c1e1"
 * 输出1："abcdef"
 *
 * 输入2：s = "a1b2c3d4e"
 * 输出2："abbdcfdhe"
 */
public class T1844 {
    /**
     * 自己实现：根据题意模拟
     */
    public String replaceDigits(String s) {
        char[] chars = s.toCharArray();

        for (int i = 1; i < chars.length; i++) {
            // 当 i 是奇数时需要替换为字符
            if (i % 2 == 1) {
                // 此时该坐标为数字，将其前一个字符（字母）向后移该数字位数即可
                chars[i] = (char) (chars[i - 1] + chars[i] - '0');
            }
        }

        return new String(chars);
    }
}
