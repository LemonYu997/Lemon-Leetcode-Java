package problems.c0easy.t1501t2000;

import java.util.HashSet;
import java.util.Set;

/**
 * 1805 字符串中不同整数的数目 https://leetcode.cn/problems/number-of-different-integers-in-a-string/description/
 * 给你一个字符串 word ，该字符串由数字和小写英文字母组成。
 * 请你用空格替换每个不是数字的字符。例如，"a123bc34d8ef34" 将会变成 " 123  34 8  34" 。
 * 注意，剩下的这些整数为（相邻彼此至少有一个空格隔开）："123"、"34"、"8" 和 "34" 。
 * 返回对 word 完成替换后形成的 不同 整数的数目。
 * 只有当两个整数的 不含前导零 的十进制表示不同， 才认为这两个整数也不同。
 *
 * 示例：
 * 输入1：word = "a123bc34d8ef34"
 * 输出1：3
 *
 * 输入2：word = "leet1234code234"
 * 输出2:2
 *
 * 输入3：word = "a1b01c001"
 * 输出3:1
 */
public class T1805 {
    /**
     * 自己实现：使用 Set 统计
     */
    public int numDifferentIntegers(String word) {
        Set<String> set = new HashSet();
        int n = word.length();
        int l = 0;
        int r;

        while (true) {
            // 如果当前不是数字，则向前推进，直到一个数字字符为止
            while (l < n && !Character.isDigit(word.charAt(l))) {
                l++;
            }
            if (l == n) {
                break;
            }
            // 记录当前数字字符位置 l 为起始位置
            r = l;
            // 右指针向前推进，直到一个非数字字符为止
            while (r < n && Character.isDigit(word.charAt(r))) {
                r++;
            }
            // 跳过 l 和 r 之间的前置 0
            while (r - l > 1 && word.charAt(l) == '0') {
                l++;
            }
            // 记录数字
            set.add(word.substring(l, r));
            // 更新指针
            l = r;
        }

        return set.size();
    }
}
