package problems.c0easy.t1t500;

/**
 * 258 各位相加 https://leetcode.cn/problems/add-digits/
 * 给定一个非负整数，反复将各个位上的数字相加，直到结果为一位数，返回该结果
 *
 * 示例：
 * 输入1：num=38
 * 输出1:2
 *
 * 输入2：num=0
 * 输出2:0
 */
public class T258 {
    /**
     * 自己实现
     */
    public int addDigits1(int num) {
        //直到满足条件
        while (num >= 10) {
            int temp = 0;
            //循环加上每一位
            while (num > 0) {
                //加上当前数的个位数
                temp += num % 10;
                //已经加过的位，就将数往后挪，例如 128 -> 12
                num = num / 10;
            }

            //更新值
            num = temp;
        }

        return num;
    }

    /**
     * 官方解法2：数学
     */
    public int addDigits2(int num) {
        return (num - 1) % 9 + 1;
    }
}
