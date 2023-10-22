package demo.c0easy;

/**
 * 405 数字转换为十六进制数 https://leetcode.cn/problems/convert-a-number-to-hexadecimal/
 * 给定一个整数，编写一个算法将这个数转为十六进制数，对于负整数，通常使用补码算法
 *
 * 示例：
 * 输入1：26
 * 输出1：la
 *
 * 输入2：-1
 * 输出2："ffffffff"
 */
public class T405 {
    public String toHex(int num) {
        if (num == 0) {
            return "0";
        }

        StringBuffer sb = new StringBuffer();
        for (int i = 7; i >= 0 ; i--) {
            int val = (num >> (4 * i)) & 0xf;
            if (sb.length() > 0 || val > 0) {
                char digit = val < 10 ? (char) ('0' + val) : (char) ('a' + val - 10);
                sb.append(digit);
            }
        }

        return sb.toString();
    }
}
