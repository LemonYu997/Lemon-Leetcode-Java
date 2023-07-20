package demo.c0easy;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 67 二进制求和 https://leetcode.cn/problems/add-binary/
 * 给定两个二进制字符串，以二进制字符串形式返回他们的和
 *
 * 示例1：
 * 输入：a = "11", b = "1"
 * 输出："100"
 *
 * 示例2：
 * 输入：a = "1010", b = "1011"
 * 输出："10101"
 */
public class T67 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine().trim();
        String[] ab = s.split(",");

        System.out.println(addBinary1(ab[0], ab[1]));
    }


    public static String addBinary1(String a, String b) {



        return null;
    }
}
