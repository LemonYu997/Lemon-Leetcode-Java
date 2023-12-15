package problems.c0easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 500 键盘行 https://leetcode.cn/problems/keyboard-row/
 * 给定一个字符串数组words，只返回可以使用在美式键盘同一行的字母打印出来的单词。
 * 第一行：qwertyuiop
 * 第二行：asdfghjkl
 * 第三行：zxcvbnm
 *
 * 示例：
 * 输入1：words = ["Hello","Alaska","Dad","Peace"]
 * 输出1：["Alaska","Dad"]
 *
 * 输入2：words = ["omk"]
 * 输出2：[]
 *
 * 输入3：words = ["adsdf","sfd"]
 * 输出3：["adsdf","sfd"]
 */
public class T500 {
    /**
     * 自己实现：根据定义
     */
    public String[] findWords(String[] words) {
        String[] ans = new String[words.length];
        int count = 0;

        String s1 = "qwertyuiop";
        String s2 = "asdfghjkl";
        String s3 = "zxcvbnm";

        for (int i = 0; i < words.length; i++) {
            //转为小写字符方便判断
            String word = words[i].toLowerCase();
            String s = null;
            //判断标志
            boolean isLine = true;

            //先判断第一个字符属于哪个键盘行
            char c0 = word.charAt(0);
            if (s1.indexOf(c0) >= 0) {
                s = s1;
            } else if (s2.indexOf(c0) >= 0) {
                s = s2;
            } else {
                s = s3;
            }

            //再判断该单词余下的每个单词是否都为此行
            for (int j = 1; j < word.length(); j++) {
                //如果有不是此行的字符就将标志设为false
                if (s.indexOf(word.charAt(j)) < 0) {
                    isLine = false;
                }
            }

            //如果是同一行，就将原单词放入返回数组
            if (isLine) {
                ans[count] = words[i];
                count++;
            }
        }

        return Arrays.copyOfRange(ans, 0, count);
    }

    /**
     * 官方解法：遍历
     */
    public String[] findWords1(String[] words) {
        List<String> list = new ArrayList<>();
        //26个字母所对应的行号
        String rowIndx = "12210111011122000010020202";

        for (String word : words) {
            boolean isValid = true;
            char idx = rowIndx.charAt(Character.toLowerCase(word.charAt(0)) - 'a');
            for (int i = 1; i < word.length(); i++) {
                if (rowIndx.charAt(Character.toLowerCase(word.charAt(i)) - 'a') != idx) {
                    isValid = false;
                    break;
                }
            }

            if (isValid) {
                list.add(word);
            }
        }

        String[] ans = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }

        return ans;
    }
}
