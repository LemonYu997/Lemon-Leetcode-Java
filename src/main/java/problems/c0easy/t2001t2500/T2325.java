package problems.c0easy.t2001t2500;

import java.util.HashMap;
import java.util.Map;

/**
 * 2325 解密消息 https://leetcode.cn/problems/decode-the-message/description/
 * 给你字符串 key 和 message ，分别表示一个加密密钥和一段加密消息。解密 message 的步骤如下：
 *
 * 使用 key 中 26 个英文小写字母第一次出现的顺序作为替换表中的字母 顺序 。
 * 将替换表与普通英文字母表对齐，形成对照表。
 * 按照对照表 替换 message 中的每个字母。
 * 空格 ' ' 保持不变。
 * 例如，key = "happy boy"（实际的加密密钥会包含字母表中每个字母 至少一次），
 * 据此，可以得到部分对照表（'h' -> 'a'、'a' -> 'b'、'p' -> 'c'、'y' -> 'd'、'b' -> 'e'、'o' -> 'f'）。
 * 返回解密后的消息。
 *
 * 示例：
 * 输入1：key = "the quick brown fox jumps over the lazy dog",
 * message = "vkbs bs t suepuv"
 * 输出1："this is a secret"
 *
 * 输入2：key = "eljuxhpwnyrdgtqkviszcfmabo",
 * message = "zwx hnfx lqantp mnoeius ycgk vcnjrdb"
 * 输出2："the five boxing wizards jump quickly"
 */
public class T2325 {
    /**
     * 自己实现：根据题意模拟
     */
    public static String decodeMessage(String key, String message) {
        // 使用 Map 记录两个字母的映射表 key 为新顺序 value 为正常顺序
        Map<Character, Character> map = new HashMap<>();
        int index = 0;

        for (int i = 0; i < key.length(); i++) {
            // 如果26个字母全录入过，则跳过
            if (index == 26) {
                break;
            }
            char c = key.charAt(i);
            // 如果当前字母未录入过，则录入映射表
            if (c != ' ' && !map.containsKey(c)) {
                map.put(c, (char) ('a' + index));
                index++;
            }
        }

        // 进行翻译
        char[] chars = message.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            // 如果是字母则翻译，如果不是则保留原值
            if (chars[i] != ' ') {
                chars[i] = map.get(chars[i]);
            }
        }

        return String.valueOf(chars);
    }
}
