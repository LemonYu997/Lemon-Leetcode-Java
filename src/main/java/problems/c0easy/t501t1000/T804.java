package problems.c0easy.t501t1000;

import java.util.HashSet;
import java.util.Set;

/**
 * 804 唯一摩尔斯密码词 https://leetcode.cn/problems/unique-morse-code-words/
 * 国际摩尔斯密码定义一种标准编码方式，将每个字母对应于一个由一系列点和短线组成的字符串， 比如:
 * 'a' 对应 ".-" ，
 * 'b' 对应 "-..." ，
 * 'c' 对应 "-.-." ，以此类推。
 *
 * 为了方便，所有 26 个英文字母的摩尔斯密码表如下：
 * [".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."]
 *
 * 给你一个字符串数组 words ，每个单词可以写成每个字母对应摩尔斯密码的组合。
 * 对 words 中所有单词进行单词翻译，返回不同 单词翻译 的数量。
 *
 * 示例：
 * 输入1：words = ["gin", "zen", "gig", "msg"]
 * 输出1：2
 * 备注：各单词翻译如下:
 * "gin" -> "--...-."
 * "zen" -> "--...-."
 * "gig" -> "--...--."
 * "msg" -> "--...--."
 *
 * 共有 2 种不同翻译, "--...-." 和 "--...--.".
 *
 * 输入2：words = ["a"]
 * 输出2：1
 */
public class T804 {
    //码表
    String[] morse = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};

    /**
     * 自己实现：使用Set
     */
    public int uniqueMorseRepresentations(String[] words) {
        Set<String> set = new HashSet<>();

        //翻译每一个单词
        for (String word : words) {
            StringBuffer sb = new StringBuffer();
            //对单词的每一个字母进行翻译
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                sb.append(morse[c - 'a']);
            }
            //使用set去重
            set.add(sb.toString());
        }

        return set.size();
    }
}
