package problems.c0easy.t1t500;

import java.util.Scanner;

/**
 * 69  x 的平方根  https://leetcode.cn/problems/sqrtx/
 * 给定一个非负整数x，返回x的算数平方根，只保留整数部分，舍弃小数部分
 *
 * 示例1：
 * 输入：x = 4
 * 输出：2
 *
 * 示例2：
 * 输入：x = 8
 * 输出：2
 * 解释：8 的算术平方根是 2.8284... 只保留整数部分
 */
public class T69 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine().trim();

        System.out.println(mySqrt1(Integer.parseInt(s)));
    }

    /**
     * 自己实现：二分查找，结果在0~x之间
     */
    public static int mySqrt1(int x) {
        int start = 0;
        int end = x;
        int ans = 0;

        while (start <= end) {
            int mid = (end - start) / 2 + start;
            //如果当前值的平方比目标小的时候，找右半边，更新答案
            //注意处理溢出
            if ((long)mid * (long)mid <= x) {
                ans = mid;
                start = mid + 1;
            } else {
                //找左半边
                end = mid - 1;
            }
        }

        return ans;
    }

    /**
     * 官方实现：袖珍计算器算法
     * 用指数函数exp和对数函数ln代替评分方根函数计算
     */
    public static int mySqrt2(int x) {
        if (x == 0) {
            return 0;
        }
        int ans = (int) Math.exp(0.5 * Math.log(x));
        return (long) (ans + 1) * (ans + 1) <= x ? ans + 1 : ans;
    }
}
