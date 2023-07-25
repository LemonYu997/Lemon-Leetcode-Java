package demo.c0easy;

import java.util.Scanner;

/**
 * 28 找出字符串中第一个匹配项的下标 https://leetcode.cn/problems/find-the-index-of-the-first-occurrence-in-a-string/
 * 给定字符串haystack和needle，在haystack字符串中找出needle字符串的第一个匹配项的下标开始
 * 如果needle不是haystack的一部分，则返回-1
 *
 * 输入：haystack = "sadbutsad", needle = "sad"
 * 输出：0
 * 备注："sad" 在下标 0 和 6 处匹配
 *
 * 输入：haystack = "leetcode", needle = "leeto"
 * 输出：-1
 * 备注："leeto" 没有在 "leetcode" 中出现，所以返回 -1
 */
public class T28 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine().trim();
        String[] ab = s.split(",");

        System.out.println(strStr1(ab[0], ab[1]));
    }

    /**
     * 官方实现：暴力匹配
     * 对haystack每一个和needle长度相同的字符串进行匹配，有就返回
     */
    public static int strStr1(String haystack, String needle) {
        int n = haystack.length();
        int m = needle.length();

        //如果剩下的长度不够m，就不用继续遍历了
        for (int i = 0; i + m <= n; i++) {
            boolean flag = true;
            for (int j = 0; j < m; j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    flag = false;
                    break;  //返回上一层循环
                }
            }
            if (flag) {
                return i;
            }
        }

        return -1;
    }

    /**
     * API实现
     */
    public static int strStr2(String haystack, String needle) {
        return haystack.indexOf(needle);
    }
}
