package problems.c0easy.t1t500;

import java.util.Scanner;

/**
 * 9 回文数 https://leetcode.cn/problems/palindrome-number/
 * 给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
 *
 * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 *
 * 例如，121 是回文，而 123 不是。
 *
 * 示例1：
 * 输入：x = 121
 * 输出：true
 *
 * 示例2：
 * 输入：x = -121
 * 输出：false
 * 解释：从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 *
 * 示例3：
 * 输入：x = 10
 * 输出：false
 * 解释：从右向左读, 为 01 。因此它不是一个回文数。
 */
public class T9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String x = scanner.nextLine().trim();

        System.out.println(isPalindrome2(Integer.parseInt(x)));
    }

    /**
     * 解法1：转换格式
     * 牺牲空间
     */
    public static boolean isPalindrome1(int x) {
        String num1 = Integer.toString(x);
        String num2 = new StringBuilder(num1).reverse().toString();

        return num1.equals(num2);
    }

    /**
     * 纯数字计算和判断
     */
    public static boolean isPalindrome2(int x) {
        //负数必错，个位数为0也错（除了0本身）
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        //反转后的数
        int revertedNumber = 0;

        //原始数字<反转后的数时，表示已经处理了超过一半的数字
        while (x > revertedNumber) {
            //1234 % 10 = 4，得到末尾数，拼接到反转结果上
            revertedNumber = revertedNumber * 10 + x %10;
            //int类型/10直接抹掉最后一位
            x /= 10;
        }

        //原始数和反转后的数一样时（就是后半部分和前半部分一样）
        //对于奇数位数来说，如12321，经过上边的处理，x=12，revertedNumber=123
        //把反转后多的一位去除后再比较 x = revertedNumber / 10
        return x == revertedNumber || x == revertedNumber / 10;
    }
}
