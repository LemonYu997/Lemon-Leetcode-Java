package problems.c0easy.t4001t4500;

/**
 * 4070 拨号的最少旋转次数 I https://leetcode.cn/problems/minimum-rotations-to-dial-a-number-i/description/
 * 给你一个长度为 10、由数字组成的字符串 s。
 * 拨号盘上的数字 0 到 9 按顺序排列，且拨号盘是环形的，因此 0 和 9 相邻。指针最初指向 0。
 * 要按顺序拨出 s 中的每个数字，需要旋转指针，直到它指向该数字。每次旋转都会将指针移动到一个相邻的数字，你可以向任一方向旋转。如果指针已经指向要拨出的数字，则无需旋转。
 * 返回拨出 s 中所有数字所需的最少总旋转次数。
 *
 * 示例：
 * 输入1：s = "0192837465"
 * 输出1：25
 *
 * 输入2：s = "1200210200"
 * 输出2：12
 */
public class T4070 {
    /**
     * 自己实现：计算相邻两端最小差值即可
     */
    public int minRotations(String s) {
        int ans = 0;
        char pre = '0';
        for (char ch : s.toCharArray()) {
            int d = Math.abs(ch - pre);
            ans += Math.min(d, 10 - d);
            pre = ch;
        }
        return ans;
    }
}
