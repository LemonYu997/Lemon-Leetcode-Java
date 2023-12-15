package problems.c0easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 13 罗马数字转整数 https://leetcode.cn/problems/roman-to-integer/
 * 将罗马数字转为整数，包含以下字符：
 * I 1
 * V 5
 * X 10
 * L 50
 * C 100
 * D 500
 * M 1000
 *
 * 示例1：
 * 输入：s = III
 * 输出：3
 *
 * 示例2：
 * 输入：s = IV
 * 输出：4
 *
 * 示例3：
 * 输入：s = IX
 * 输出：9
 *
 * 示例4：
 * 输入：s = LVIII
 * 输出：58
 *
 * 示例5：
 * 输入：s = MCMXCIV
 * 输出：1994
 */
public class T13 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine().trim();

        System.out.println(romanToInt1(s));
    }


    //自己实现
    public static int romanToInt1(String s) {
        //先定义罗马字符及其对应的数字
        Map<Character, Integer> romanMap = new HashMap<>();
        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);

        //分割输入字符串
        char[] chars = s.toCharArray();

        //遍历每一个字符，如果上一个字符代表的值 < 下一个字符时，就把该字符代表的值置为负数
        //上一个值，初始为第一个值
        int temp = romanMap.get(chars[0]);
        int sum = 0;

        //从第二个值开始遍历
        for (int i = 1; i < chars.length; i++) {
            //当前值
            int n = romanMap.get(chars[i]);
            //如果当前值大于上一个值，就把上一个值作为负数计算
            if (n > temp) {
                sum = sum - temp;
            } else {
                sum = sum + temp;
            }
//            System.out.println(sum);
            temp = n;
        }

        //加上最后一位
        sum = sum + romanMap.get(chars[chars.length - 1]);

        return sum;
    }

    //官方实现 区别只在判断条件
    public static int romanToInt2(String s) {
        Map<Character, Integer> symbolValues = new HashMap<Character, Integer>() {{
            put('I', 1);
            put('V', 5);
            put('X', 10);
            put('L', 50);
            put('C', 100);
            put('D', 500);
            put('M', 1000);
        }};

        int ans = 0;
        int n = s.length();
        for (int i = 0; i < n; ++i) {
            int value = symbolValues.get(s.charAt(i));
            //如果当前数字 < 下一位数字时，就作为负数计算
            if (i < n - 1 && value < symbolValues.get(s.charAt(i + 1))) {
                ans -= value;
            } else {
                ans += value;
            }
        }
        return ans;
    }
}
