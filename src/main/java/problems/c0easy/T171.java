package problems.c0easy;

/**
 * 171 Excel表列序号 https://leetcode.cn/problems/excel-sheet-column-number/
 * 给定一个字符串columnTitle，表示表格中的列名称，返回该列名称对应的序号
 *
 * 示例：
 * 输入1：columnTitle = "A"
 * 输出1:1
 *
 * 输入2：columnTitle = "AB"
 * 输出2:28
 *
 * 输入3：columnTitle = "ZY"
 * 输出3：701
 */
public class T171 {
    public static void main(String[] args) {
        String a = "AB";

        System.out.println(titleToNumber(a));
    }

    /**
     * 自己实现：反向进制运算
     */
    public static int titleToNumber(String columnTitle) {
        char[] chars = columnTitle.toCharArray();
        int len = chars.length;
        int res = 0;

        //倒序累加
        for (int i = len - 1; i >= 0; i--) {
            int temp = chars[i] - 'A' + 1;
            //进制转换累加
            res += temp * Math.pow(26, len - i - 1);
        }

        return res;
    }
}
