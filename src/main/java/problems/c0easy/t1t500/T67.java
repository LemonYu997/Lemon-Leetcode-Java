package problems.c0easy.t1t500;

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

    /**
     * 参考实现，按竖列式计算
     */
    public static String addBinary1(String a, String b) {
        //倒序的索引
        int i = a.length() - 1;
        int j = b.length() - 1;
        //进位，如果两个1相加，得到是0
        int carry = 0;
        //存取结果，是从低位开始存的，最后要反转
        StringBuilder builder = new StringBuilder();

        //循环相加两个字符串相同长度的低位数部分
        while (i >= 0 && j >= 0) {
            //当前位求和时要带上之前得进位
            int sum = carry;
            //将a和b同位置相加
            sum += a.charAt(i--) - '0'; //先取值再减一，就不用后边再减一了
            sum += b.charAt(j--) - '0';

            //计算是否进位，如果和为2，除以2得1，如果和为0或1，除以2得0
            carry = sum / 2;
            //%2得到 进位+a+b后的二进制结果
            builder.append(sum % 2);
        }
        //如果a比b长，将a的剩余的部分添上
        while (i >= 0) {
            //带上进位算
            int sum = carry + a.charAt(i--) - '0';
            carry = sum / 2;
            builder.append(sum % 2);
        }
        //如果b比a长，把b的剩余部分添上
        while (j >= 0) {
            //带上进位算
            int sum = carry + b.charAt(j--) - '0';
            carry = sum / 2;
            builder.append(sum % 2);
        }
        //如果最后剩下的进位是1，补到最后便
        if (carry == 1) {
            builder.append(carry);
        }

        //反转字符串得到结果
        return builder.reverse().toString();
    }
}
