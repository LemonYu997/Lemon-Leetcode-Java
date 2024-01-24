package problems.c0easy;

/**
 * 917 仅仅反转字母 https://leetcode.cn/problems/reverse-only-letters/
 * 给你一个字符串 s ，根据下述规则反转字符串：
 * 所有非英文字母保留在原有位置。所有英文字母（小写或大写）位置反转。
 * 返回反转后的 s 。
 *
 * 示例：
 * 输入1：s = "ab-cd"
 * 输出1："dc-ba"
 *
 * 输入2：s = "a-bC-dEf-ghIj"
 * 输出2："j-Ih-gfE-dCba"
 *
 * 输入3：s = "Test1ng-Leet=code-Q!"
 * 输出3："Qedo1ct-eeLg=ntse-T!"
 */
public class T917 {
    /**
     * 自己实现：双指针双向遍历，两边都遇到字母时，交换位置
     */
    public String reverseOnlyLetters(String s) {
        char[] chars = s.toCharArray();
        int l = 0;
        int r = chars.length - 1;

        while (l < r) {
            // 左指针向前遍历，找到下一个字母
            while (l < r && !Character.isLetter(chars[l])) {
                l++;
            }
            // 右指针向后遍历，找到上一个字母
            while (!Character.isLetter(chars[r])) {
                r--;
            }
            if (l < r) {
                // 交换位置
                char temp = chars[l];
                chars[l] = chars[r];
                chars[r] = temp;
                l++;
                r--;
            }
        }
        return new String(chars);
    }
}
