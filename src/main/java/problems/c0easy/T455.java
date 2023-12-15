package problems.c0easy;

import java.util.Arrays;

/**
 * 455 分发饼干 https://leetcode.cn/problems/assign-cookies/
 * 假设你要给一群分发饼干，但是对于每个孩子 i，都有一个胃口值 g[i]，这是能让孩子满足的饼干最小尺寸
 * 对于每块饼干 j，都有一个尺寸 s[j]，如果s[j] >= g[i]，则可将这个饼干分配给孩子
 * 返回最多能满足孩子的数量
 *
 * 示例：
 * 输入1：g = [1,2,3], s = [1,1]
 * 输出1:1
 * 备注：你有三个孩子和两块小饼干，3个孩子的胃口值分别是：1,2,3。
 * 虽然你有两块小饼干，由于他们的尺寸都是1，你只能让胃口值是1的孩子满足。
 *
 * 输入2：g = [1,2], s = [1,2,3]
 * 输出2:2
 */
public class T455 {
    /**
     * 自己实现：先排序，再双指针
     */
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int gi = 0;
        int si = 0;
        //结果
        int count = 0;

        //如果当前饼干能发给当前孩子，就发，不能的话就等下一块饼干
        while (gi < g.length && si < s.length) {
            if (g[gi] <= s[si]) {
                count++;
                si++;
                gi++;
            } else {
                si++;
            }
        }

        return count;
    }
}
