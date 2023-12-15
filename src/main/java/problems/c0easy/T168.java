package problems.c0easy;

/**
 * 168  Excel表列名称 https://leetcode.cn/problems/excel-sheet-column-title/
 * 给定一个整数columnNumber，返回它在Excel表中对应的列名称
 *
 * 示例：
 * 输入1：columnNumber = 1
 * 输出1："A"
 *
 * 输入2：columnNumber = 28
 * 输出2："AB"
 *
 * 输入3：columnNumber = 701
 * 输出3："ZY"
 *
 * 输入4：columnNumber = 2147483647
 * 输出4："FXSHRXW"
 */
public class T168 {
    public String convertToTitle(int columnNumber) {
        StringBuffer sb = new StringBuffer();
        while (columnNumber > 0) {
            int a0 = (columnNumber - 1) % 26 + 1;
            sb.append((char) (a0 - 1 + 'A'));
            columnNumber = (columnNumber - a0) / 26;
        }

        return sb.reverse().toString();
    }
}
