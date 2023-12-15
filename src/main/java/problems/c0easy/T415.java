package problems.c0easy;

/**
 * 415 字符串相加 https://leetcode.cn/problems/add-strings/
 * 给定两个字符串形式的非负整数num1和num2，计算它们的和并同样以字符串形式返回
 *
 * 示例：
 * 输入1：num1 = "11", num2 = "123"
 * 输出1："134"
 *
 * 输入2：num1 = "456", num2 = "77"
 * 输出2："533"
 *
 * 输入3：num1 = "0", num2 = "0"
 * 输出3："0"
 */
public class T415 {
    /**
     * 官方解法：竖式加法
     */
    public String addStrings(String num1, String num2) {
        //从最后一位开始相加
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        //进位
        int add = 0;
        StringBuffer sb = new StringBuffer();

        while (i >= 0 || j >= 0 || add != 0) {
            //计算当前同竖列的两个值和进位相加
            //如果某个数当前位置没有，就取0
            int x = i >= 0 ? num1.charAt(i) - '0' : 0;
            int y = j >= 0 ? num2.charAt(j) - '0' : 0;
            int result = x + y + add;

            //得到当前位的值和进位
            sb.append(result % 10);
            add = result / 10;

            //计算下一列
            i--;
            j--;
        }

        //计算完后将结果进行翻转
        sb.reverse();
        return sb.toString();
    }
}
