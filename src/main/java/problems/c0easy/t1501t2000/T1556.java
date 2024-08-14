package problems.c0easy.t1501t2000;

/**
 * 1556 千位分隔数 https://leetcode.cn/problems/thousand-separator/description/
 * 给你一个整数 n，请你每隔三位添加点（即 "." 符号）作为千位分隔符，
 * 并将结果以字符串格式返回。
 *
 * 示例：
 * 输入1：n = 987
 * 输出1："987"
 *
 * 输入2：n = 1234
 * 输出2："1.234"
 *
 * 输入3：n = 123456789
 * 输出3："123.456.789"
 *
 * 输入4：n = 0
 * 输出4："0"
 */
public class T1556 {
    /**
     * 自己实现：根据题意模拟
     */
    public String thousandSeparator(int n) {
        String s = String.valueOf(n);
        StringBuilder sb = new StringBuilder(s);
        for (int i = s.length() - 3; i > 0; i-=3) {
            sb.insert(i, ".");
        }
        return sb.toString();
    }
}
