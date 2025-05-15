package problems.c0easy.t2001t2500;

/**
 * 2379 得到 K 个黑块的最少涂色次数 https://leetcode.cn/problems/minimum-recolors-to-get-k-consecutive-black-blocks/description/
 * 给你一个长度为 n 下标从 0 开始的字符串 blocks ，blocks[i] 要么是 'W' 要么是 'B' ，
 * 表示第 i 块的颜色。字符 'W' 和 'B' 分别表示白色和黑色。
 * 给你一个整数 k ，表示想要 连续 黑色块的数目。
 * 每一次操作中，你可以选择一个白色块将它 涂成 黑色块。
 * 请你返回至少出现 一次 连续 k 个黑色块的 最少 操作次数。
 *
 * 示例：
 * 输入1：blocks = "WBBWWBBWBW", k = 7
 * 输出1：3
 *
 * 输入2：blocks = "WBWBBBW", k = 2
 * 输出2：0
 */
public class T2379 {
    /**
     * 自己实现：固定窗口，找到所有连续 k 个字符的子字符串中 B 最多的字符串
     */
    public int minimumRecolors(String blocks, int k) {
        int minW = blocks.length();
        for (int i = 0; i + k - 1 < blocks.length(); i++) {
            int tempW = 0;
            for (int j = i; j < i + k; j++) {
                if (blocks.charAt(j) == 'W') {
                    tempW++;
                }
            }
            minW = Math.min(minW, tempW);
        }

        return minW;
    }

    /**
     * 官方解法：滑动窗口
     */
    public int minimumRecolors1(String blocks, int k) {
        int l = 0;
        int r = 0;
        int cnt = 0;

        // 移动右指针
        while (r < k) {
            cnt += blocks.charAt(r) == 'W' ? 1 : 0;
            r++;
        }

        int res = cnt;
        while (r < blocks.length()) {
            cnt += blocks.charAt(r) == 'W' ? 1 : 0;
            cnt -= blocks.charAt(l) == 'W' ? 1 : 0;
            res = Math.min(res, cnt);
            l++;
            r++;
        }

        return res;
    }
}