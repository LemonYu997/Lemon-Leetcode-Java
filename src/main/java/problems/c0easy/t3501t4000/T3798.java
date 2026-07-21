package problems.c0easy.t3501t4000;

/**
 * 3798 最大的偶数 https://leetcode.cn/problems/largest-even-number/description/
 * 给你一个仅由字符'1'和'2'组成的字符串s。
 * 你可以删除字符串s中的任意数量的字符，但必须保持剩余字符的顺序不变。
 * 返回可以表示 偶数 整数的 最大结果字符串 。如果不存在这样的字符串，则返回空字符串""。
 *
 * 示例：
 * 输入1：s = "1112"
 * 输出1："1112"
 *
 * 输入2：s = "221"
 * 输出2："22"
 *
 * 输入3：s = "1"
 * 输出3：""
 */
public class T3798 {
    /**
     * 自己实现：找到以2为结尾的最长字符串即可
     */
    public String largestEven(String s) {
        int i = s.lastIndexOf('2');
        return i == -1 ? "" : s.substring(0, i);
    }

    /**
     * 社区解法：遍历实现
     */
    public String largestEven1(String s) {
        int n = s.length();
        while (n > 0 && s.charAt(n - 1) == '1') {
            n--;
        }
        return s.substring(0, n);
    }
}