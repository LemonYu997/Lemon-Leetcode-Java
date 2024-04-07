package problems.c0easy.t1t500;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 66 加一 https://leetcode.cn/problems/plus-one/
 * 给定一个由整数组成的非空数组，用来表示一个非负整数，在其基础上加1
 * 数组首位是该数字的最高位，数组每个元素只能存储单个数字
 *
 * 示例1：
 * 输入：digits = [1,2,3]
 * 输出：[1,2,4]
 * 备注：输入表示123
 *
 * 示例2：
 * 输入：digits = [4,3,2,1]
 * 输出：[4,3,2,2]
 *
 * 示例3：
 * 输入：digits = [1,3,5,9]
 * 输出：[1,3,6,0]
 * 备注：1359+1=1360
 */
public class T66 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine().trim();
        int[] digits = Arrays.stream(s.split(",")).mapToInt(Integer::parseInt).toArray();

        System.out.println(Arrays.toString(plusOne1(digits)));
    }

    /**
     * 自己实现：倒序遍历每一位，遇9变0，前一位+1
     */
    public static int[] plusOne1(int[] digits) {
        int n = digits.length;

        //倒叙遍历，遇倒不为9的数，就+1，然后退出
        for (int i = n - 1; i >= 0; i--) {
            if (digits[i] != 9) {
                digits[i]++;
                return digits;
            } else {
                //如果是9，就置为0
                digits[i] = 0;
            }
        }

        //如果跑完还没有推出，就说明全是9，此时已经变成全为0
        int[] result = new int[n + 1];
        //将最高位置为1，其余位默认为0，直接返回即可
        result[0] = 1;

        return result;
    }
}
