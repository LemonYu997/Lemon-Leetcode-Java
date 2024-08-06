package problems.c0easy.t1501t2000;

import java.util.Arrays;

/**
 * 1528 重新排列字符串 https://leetcode.cn/problems/shuffle-string/description/
 * 给你一个字符串 s 和一个 长度相同 的整数数组 indices 。
 * 请你重新排列字符串 s ，其中第 i 个字符需要移动到 indices[i] 指示的位置。
 * 返回重新排列后的字符串。
 *
 * 示例：
 * 输入1：s = "codeleet", indices = [4,5,6,7,0,2,1,3]
 * 输出1："leetcode"
 *
 * 输入2：s = "abc", indices = [0,1,2]
 * 输出2："abc"
 */
public class T1528 {
    /**
     * 自己实现：生成一个新 char[] 存放排序后的字符
     */
    public String restoreString(String s, int[] indices) {
        int n = s.length();
        char[] chars = new char[n];

        // 重排序字符
        for (int i = 0; i < n; i++) {
            chars[indices[i]] = s.charAt(i);
        }

        return new String(chars);
    }
}
