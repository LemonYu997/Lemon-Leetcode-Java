package problems.c0easy.t3001t3500;

/**
 * 3304 找出第 K 个字符 I https://leetcode.cn/problems/find-the-k-th-character-in-string-game-i/description/
 * Alice 和 Bob 正在玩一个游戏。最初，Alice 有一个字符串 word = "a"。
 * 给定一个正整数 k。
 * 现在 Bob 会要求 Alice 执行以下操作 无限次 :
 * 将 word 中的每个字符 更改 为英文字母表中的 下一个 字符来生成一个新字符串，并将其 追加 到原始的 word。
 * 例如，对 "c" 进行操作生成 "cd"，对 "zb" 进行操作生成 "zbac"。
 * 在执行足够多的操作后， word 中 至少 存在 k 个字符，此时返回 word 中第 k 个字符的值。
 *
 * 示例：
 * 输入1：k = 5
 * 输出1："b"
 *
 * 输入2：k = 10
 * 输出2："c"
 */
public class T3304 {
    /**
     * 自己实现：根据题意计算，每次长度翻倍，并且变为下一个
     */
    public char kthCharacter(int k) {
        int ans = 0;
        int t;
        while (k != 1) {
            t = 31 - Integer.numberOfLeadingZeros(k);
            if (((1 << t) == k)) {
                t--;
            }
            k = k - (1 << t);
            ans++;
        }
        return (char) ('a' + ans);
    }
}
