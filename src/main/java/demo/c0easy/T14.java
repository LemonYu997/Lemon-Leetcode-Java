package demo.c0easy;

import java.util.Scanner;

/**
 * 14 最长公共前缀 https://leetcode.cn/problems/longest-common-prefix/
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 * 示例1：
 * 输入：strs = ["flower","flow","flight"]
 * 输出："fl"
 *
 * 示例2：
 * 输入：strs = ["dog","racecar","car"]
 * 输出：""
 */
public class T14 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine().trim();
        String[] strs = s.split(",");

        System.out.println(longestCommonPrefix1(strs));
    }

    //自己实现
    public static String longestCommonPrefix1(String[] strs) {
        //返回结果
        StringBuilder ans = new StringBuilder();
        StringBuilder sb = new StringBuilder();

        //找到长度最小的字符串作为判断标准
        int length = 201;   //在这个题目里最大值201
        String mins = "";   //长度最小的字符串
        for (int i = 0; i < strs.length; i++) {
            int sl = strs[i].length();
            if (sl < length) {
                length = sl;
                mins = strs[i];
            }
        }

        //已经确认的公共字符串
        String commonStr = "";

        //获取第一个字符串的每一个字符，将其拼接
        for (int i = 1; i <= mins.length(); i++) {
            //当前测试的公共字符串
            String tmep = "";
            if (i == mins.length()) {
                tmep = mins;
            } else {
                tmep = mins.substring(0, i);
            }

            //遍历每一个字符串，判断是否有重复，没有重复就退出循环
            for (String str : strs) {
                String s = str.substring(0, i);
                //只要有一个字符串不满足这个公共字符串，就返回上一个公共字符串
                if (!s.equals(tmep)) {
                    return commonStr;
                }
            }

            //如果所有字符串都确认重复，就更新公共字符串
            commonStr = tmep;
        }

        return commonStr;
    }
}
