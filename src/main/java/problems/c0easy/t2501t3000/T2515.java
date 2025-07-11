package problems.c0easy.t2501t3000;

/**
 * 2515 到目标字符串的最短距离 https://leetcode.cn/problems/shortest-distance-to-target-string-in-a-circular-array/description/
 * 给你一个下标从 0 开始的 环形 字符串数组 words 和一个字符串 target 。
 * 环形数组 意味着数组首尾相连。
 * 形式上， words[i] 的下一个元素是 words[(i + 1) % n] ，
 * 而 words[i] 的前一个元素是 words[(i - 1 + n) % n] ，其中 n 是 words 的长度。
 * 从 startIndex 开始，你一次可以用 1 步移动到下一个或者前一个单词。
 * 返回到达目标字符串 target 所需的最短距离。如果 words 中不存在字符串 target ，返回 -1 。
 *
 * 输入1：words = ["hello","i","am","leetcode","hello"], target = "hello", startIndex = 1
 * 输出1：1
 *
 * 输入2：words = ["a","b","leetcode"], target = "leetcode", startIndex = 0
 * 输出2：1
 *
 * 输入3：words = ["i","eat","leetcode"], target = "ate", startIndex = 0
 * 输出3：-1
 */
public class T2515 {
    /**
     * 自己实现：根据题意模拟即可
     */
    public int closestTarget(String[] words, String target, int startIndex) {
        int n = words.length;
        int ans = -1;

        // 从头遍历，计算目标索引值到 startIndex 的两个方向距离
        for (int i = 0; i < n; i++) {
            if (words[i].equals(target)) {
                int temp1 = Math.abs(i - startIndex);
                int temp2 = n - Math.abs(i - startIndex);
                if (ans != -1) {
                    ans = Math.min(ans, Math.min(temp1, temp2));
                } else {
                    ans = Math.min(temp1, temp2);
                }
            }
        }

        return ans;
    }
}
