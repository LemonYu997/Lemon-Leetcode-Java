package problems.c0easy.t501t1000;

import java.util.HashMap;
import java.util.Map;

/**
 * 819 最常见的单词 https://leetcode.cn/problems/most-common-word/
 * 给定一个字符串 paragraph 和一个表示禁用词的字符串数组 banned ，
 * 返回出现频率最高的非禁用词。题目数据 保证 至少存在一个非禁用词，且答案 唯一 。
 *
 * paragraph 中的单词 不区分大小写 ，答案应以 小写 形式返回。
 *
 * 示例：
 * 输入1：paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.", banned = ["hit"]
 * 输出1："ball"
 * 备注："hit" 出现了 3 次，但它是禁用词。"ball" 出现了两次
 *
 * 输入2：paragraph = "a.", banned = []
 * 输出2："a"
 */
public class T819 {
    /**
     * 自己实现：
     * 将连续英文字符视为一个单词
     * 使用 Map 存储每个单词出现的次数
     * 最后统计出现次数最多的单词，如果属于 banned，则不进行记录
     */
    public String mostCommonWord(String paragraph, String[] banned) {
        //先全部转小写
        paragraph = paragraph.toLowerCase();
        //使用 Map 存储每个单词出现的次数
        Map<String, Integer> map = new HashMap<>();
        String ans = "";    //存储答案
        int count = 0;      //最大出现次数


        StringBuilder sb = new StringBuilder();
        //这里 <= length 是为了方便如果最后一位是字母的话，也能进入到 else if 统计map的阶段
        for (int i = 0; i <= paragraph.length(); i++) {
            //将连续字符视为一个单词
            if (i < paragraph.length() && Character.isLetter(paragraph.charAt(i))) {
                sb.append(paragraph.charAt(i));
            } else if (sb.length() > 0){
                //如果当前字符不为字母，将当前单词存入map
                String word = sb.toString();
                map.put(word, map.getOrDefault(word, 0) + 1);
                //重置sb
                sb.setLength(0);
            }
        }


        //最后统计出现次数最多的单词，如果属于 banned，则不进行记录
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            //如果比当前最大值大，判断其是否被 ban
            if (entry.getValue() > count) {
                boolean flag = false;
                for (String s : banned) {
                    if (s.equals(entry.getKey())) {
                        flag = true;
                        break;
                    }
                }

                //如果没被ban，更新最大值
                if (!flag) {
                    count = entry.getValue();
                    ans = entry.getKey();
                }
            }
        }

        return ans;
    }
}
