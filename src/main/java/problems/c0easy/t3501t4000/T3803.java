package problems.c0easy.t3501t4000;

import java.util.HashSet;
import java.util.Set;

/**
 * 3803 统计残差前缀 https://leetcode.cn/problems/count-residue-prefixes/description/
 * 给你一个仅由小写英文字母组成的字符串 s。
 * 如果字符串 s 的某个 前缀 中 不同字符的数量 等于 len(prefix) % 3，则该前缀被称为残差前缀（residue）。
 * 返回字符串 s 中 残差前缀 的数量。
 * 字符串的 前缀 是一个 非空子字符串，从字符串的开头起始并延伸到任意位置。
 *
 * 示例：
 * 输入1：s = "abc"
 * 输出1：2
 *
 * 输入2：s = "dd"
 * 输出2：1
 *
 * 输入3：s = "bob"
 * 输出3：2
 */
public class T3803 {
    /**
     * 自己实现：遍历不同长度前缀 不同字符的数量是否为 3 的倍数
     */
    public int residuePrefixes(String s) {
        Set<Character> set = new HashSet<>();
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            set.add(s.charAt(i));
            // 如果不同字符的数量已经超过3了可以直接结束
            if (set.size() > 3) {
                break;
            }
            if ((i + 1) % 3 == set.size()) {
                ans++;
            }
        }
        return ans;
    }
}
