package problems.c0easy.t501t1000;

import java.util.HashSet;
import java.util.Set;

/**
 * 824 山羊拉丁文 https://leetcode.cn/problems/goat-latin/
 * 给定一个由若干单词组成的句子 sentence ，单词间由空格分隔。每个单词仅由大写和小写英文字母组成。
 * 将句子转换为 “山羊拉丁文（Goat Latin）“，定义如下：
 * 1、如果单词以元音开头（'a', 'e', 'i', 'o', 'u'），在单词后添加"ma"
 *      例如，单词 "apple" 变为 "applema"
 * 2、如果单词以辅音字母开头（即，非元音字母），移除第一个字符并将它放到末尾，之后再添加"ma"。
 *      例如，单词 "goat" 变为 "oatgma"
 * 3、根据单词在句子中的索引，在单词最后添加与索引相同数量的字母'a'，索引从 1 开始。
 *      例如，在第一个单词后添加 "a" ，在第二个单词后添加 "aa" ，以此类推。
 *
 * 示例：
 * 输入1：sentence = "I speak Goat Latin"
 * 输出1："Imaa peaksmaaa oatGmaaaa atinLmaaaaa"
 *
 * 输入2：sentence = "The quick brown fox jumped over the lazy dog"
 * 输出2："heTmaa uickqmaaa rownbmaaaa oxfmaaaaa umpedjmaaaaaa
 * overmaaaaaaa hetmaaaaaaaa azylmaaaaaaaaa ogdmaaaaaaaaaa"
 */
public class T824 {
    /**
     * 自己实现：根据定义模拟
     */
    public String toGoatLatin(String sentence) {
        StringBuilder sb = new StringBuilder();
        //分割每个单词
        String[] words = sentence.split(" ");
        String vowel = "aeiouAEIOU";

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            //判断首字母是否为元音
            if (vowel.contains(word.substring(0, 1))) {
                sb.append(word);
                sb.append("ma");
            } else {
                //不是元音的话，将首字母移到末尾
                char temp = word.charAt(0);
                sb.append(word.substring(1));
                sb.append(temp);
                sb.append("ma");
            }

            //在结尾添加 i 个 a
            for (int j = 0; j <= i; j++) {
                sb.append("a");
            }

            //最后一个单词不用加空格
            sb.append(" ");
        }

        //去除最后一个空格
        return sb.substring(0, sb.length() - 1);
    }

    /**
     * 官方解法：模拟
     */
    public String toGoatLatin1(String sentence) {
        Set<Character> vowels = new HashSet<Character>() {{
            add('a');
            add('e');
            add('i');
            add('o');
            add('u');
            add('A');
            add('E');
            add('I');
            add('O');
            add('U');
        }};

        int n = sentence.length();
        int i = 0, cnt = 1;
        StringBuffer ans = new StringBuffer();

        while (i < n) {
            int j = i;
            //跳过空格
            while (j < n && sentence.charAt(j) != ' ') {
                ++j;
            }

            //当前单词计数，用在后边补 a
            ++cnt;
            if (cnt != 2) {
                ans.append(' ');
            }
            //判断当前单词首字母是否为元音
            if (vowels.contains(sentence.charAt(i))) {
                ans.append(sentence.substring(i, j));
            } else {
                //不是元音，先添加后边的字符，最后把首字符补上
                ans.append(sentence.substring(i + 1, j));
                ans.append(sentence.charAt(i));
            }

            ans.append('m');
            //根据单词计数补 "a"
            for (int k = 0; k < cnt; ++k) {
                ans.append('a');
            }

            //指向下一个单词
            i = j + 1;
        }

        return ans.toString();
    }
}
