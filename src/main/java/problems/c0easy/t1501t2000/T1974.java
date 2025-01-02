package problems.c0easy.t1501t2000;

/**
 * 1974 使用特殊打字机键入单词的最少时间 https://leetcode.cn/problems/minimum-time-to-type-word-using-special-typewriter/
 * 有一个特殊打字机，它由一个 圆盘 和一个 指针 组成， 圆盘上标有小写英文字母 'a' 到 'z'。
 * 只有 当指针指向某个字母时，它才能被键入。指针 初始时 指向字符 'a' 。
 *
 * 每一秒钟，你可以执行以下操作之一：
 * 将指针 顺时针 或者 逆时针 移动一个字符。
 * 键入指针 当前 指向的字符。
 * 给你一个字符串 word ，请你返回键入 word 所表示单词的 最少 秒数 。
 *
 * 示例：
 * 输入1：word = "abc"
 * 输出1:5
 *
 * 输入2：word = "bza"
 * 输出2：7
 *
 * 输入3：word = "zjpc"
 * 输出3:34
 */
public class T1974 {
    /**
     * 官方解法：根据题意模拟，找到每个字符都有两种可能：
     *  1、不跨过边界线，所需时间为 |cur - pre|
     *  2、跨过边境线，所需时间为 26 - |cur - pre|
     *  每次从两者之间选择耗时最少得
     */
    public int minTimeToType(String word) {
        int ans = 0;
        // 当前位置
        int pre = 0;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            // 计算输入每个字符的最小耗时并更新当前位置
            int cur = c - 'a';
            // 还需要键入，所以要 +1
            ans += 1 + Math.min(Math.abs(cur - pre), 26 - Math.abs(cur - pre));
            pre = cur;
        }

        return ans;
    }
}
