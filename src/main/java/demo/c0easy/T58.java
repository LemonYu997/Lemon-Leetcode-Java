package demo.c0easy;

import java.util.Scanner;

/**
 * 58 最后一个单词的长度 https://leetcode.cn/problems/length-of-last-word/
 * 给定一个字符串，包含若干个单词，用空格隔开，返回最后一个单词的长度
 *
 * 示例1：
 * 输入：s = "Hello World"
 * 输出：5
 *
 * 示例2：
 * 输入：s = "luffy is still joyboy"
 * 输出：6
 */
public class T58 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine().trim();

        System.out.println(lengthOfLastWord1(s));
    }

    /**
     * 自己实现：使用API
     */
    public static int lengthOfLastWord1(String s) {
        //根据空格分成String数组
        String[] ss = s.split(" ");
        //找到最后一个单词所占长度
        return ss[ss.length - 1].length();
    }

    /**
     * 官方实现：反向遍历，找到最后一个字母和最后一个空格，之间的差值即为单词长度
     */
    public static int lengthOfLastWord2(String s) {
        //从最后一位向前遍历，找到到数第一个空格
        int index = s.length() - 1;
        while (s.charAt(index) == ' ') {
            index--;
        }
        int wordLength = 0;
        while (index >= 0 && s.charAt(index) != ' ') {
            wordLength++;
            index--;
        }
        return wordLength;
    }

    /**
     * 官方实现：调API
     */
    public static int lengthOfLastWord3(String s) {
        s = s.trim();
        //末尾索引 - 最后一个空格索引
        return s.length() - 1 - s.lastIndexOf(' ');
    }
}
