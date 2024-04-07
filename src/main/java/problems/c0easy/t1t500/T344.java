package problems.c0easy.t1t500;

/**
 * 344 反转字符串 https://leetcode.cn/problems/reverse-string/
 * 给定一个char[]，将其反转
 * 不能使用额外空间，只能原地修改输入数组
 *
 * 示例：
 * 输入1：s = ["h","e","l","l","o"]
 * 输出1：["o","l","l","e","h"]
 *
 * 输入2：s = ["H","a","n","n","a","h"]
 * 输出2：["h","a","n","n","a","H"]
 */
public class T344 {
    /**
     * 自己实现：双指针，将首尾调换位置
     */
    public void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;

        while (left < right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }
}
