package problems.c0easy.t2501t3000;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 2788 按分隔符拆分字符串 https://leetcode.cn/problems/split-strings-by-separator/description/https://leetcode.cn/problems/split-strings-by-separator/description/
 * 给你一个字符串数组 words 和一个字符 separator ，请你按 separator 拆分 words 中的每个字符串。
 * 返回一个由拆分后的新字符串组成的字符串数组，不包括空字符串 。
 * 注意
 * separator 用于决定拆分发生的位置，但它不包含在结果字符串中。
 * 拆分可能形成两个以上的字符串。
 * 结果字符串必须保持初始相同的先后顺序。
 *
 * 示例：
 * 输入1：words = ["one.two.three","four.five","six"], separator = "."
 * 输出1：["one","two","three","four","five","six"]
 *
 * 输入2：words = ["$easy$","$problem$"], separator = "$"
 * 输出2：["easy","problem"]
 *
 * 输入3：words = ["|||"], separator = "|"
 * 输出3：[]
 */
public class T2788 {
    /**
     * 自己实现：根据题意模拟即可
     */
    public List<String> splitWordsBySeparator(List<String> words, char separator) {
        List<String> ans = new ArrayList<>();

        for (String word : words) {
            // 手动分割字符串
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < word.length(); i++) {
                if (word.charAt(i) == separator) {
                    if (sb.length() > 0) {
                        ans.add(sb.toString());
                    }
                    sb.delete(0, sb.length());
                } else {
                    sb.append(word.charAt(i));
                }
            }
            // 最后还要判断一次
            if (sb.length() > 0) {
                ans.add(sb.toString());
            }
        }
        return ans;
    }
}
