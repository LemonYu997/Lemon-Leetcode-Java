package demo.c0easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 345 反转字符串中的元音字母 https://leetcode.cn/problems/reverse-vowels-of-a-string/
 * 给定一个字符串s，仅反转字符串中的所有元音字母，并返回结果字符串
 * 元音字母包括 a e i o u，可能为大写或小写
 *
 * 示例：
 * 输入1：s = "hello"
 * 输出1："holle"
 *
 * 输入2：s = "leetcode"
 * 输出2："leotcede"
 */
public class T345 {
    /**
     * 自己实现：双指针
     */
    public String reverseVowels(String s) {
        char[] chars = s.toCharArray();
        int left = 0;
        int right = chars.length - 1;

        while (left < right) {
            while (left < chars.length && !isVowel(chars[left])) {
                left++;
            }
            while (right > 0 && !isVowel(chars[right])) {
                right--;
            }

            //更新指针之后重新判断是否越界
            if (left < right) {
                char temp = chars[left];
                chars[left] = chars[right];
                chars[right] = temp;
                //指针向前动一位，防止上边依旧判断为元音字母，陷入死循环
                left++;
                right--;
            }
        }

        return new String(chars);
    }

    //判断是否为元音字母
    public boolean isVowel(char c) {
        return "aeiouAEIOU".indexOf(c) >= 0;
    }
}
