package demo.c0easy;

/**
 * 504 七进制数 https://leetcode.cn/problems/base-7/
 * 给定一个整数 num，将其转化为 7 进制，并以字符串形式输出。
 *
 * 示例：
 * 输入1：num = 100
 * 输出1："202"
 *
 * 输入2：num = -7
 * 输出2："-10"
 */
public class T504 {
    /**
     * 自己实现：根据定义
     */
    public String convertToBase7(int num) {
        if (num == 0) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        //负数标志
        boolean flag = false;
        if (num < 0) {
            flag = true;
            num = -num;
        }

        while (num > 0) {
            sb.append(num % 7);
            num = num / 7;
        }

        //如果是负数，前边加-号
        if (flag) {
            sb.append("-");
        }

        //最终结果是反序的
        return sb.reverse().toString();
    }
}
