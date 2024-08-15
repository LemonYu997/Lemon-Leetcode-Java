package problems.c0easy.t1501t2000;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 1560 圆形赛道上经过次数最多的扇区 https://leetcode.cn/problems/most-visited-sector-in-a-circular-track/description/
 * 给你一个整数 n 和一个整数数组 rounds 。有一条圆形赛道由 n 个扇区组成，
 * 扇区编号从 1 到 n 。现将在这条赛道上举办一场马拉松比赛，该马拉松全程由 m 个阶段组成。
 * 其中，第 i 个阶段将会从扇区 rounds[i - 1] 开始，到扇区 rounds[i] 结束。
 * 举例来说，第 1 阶段从 rounds[0] 开始，到 rounds[1] 结束。
 *
 * 请你以数组形式返回经过次数最多的那几个扇区，按扇区编号 升序 排列。
 *
 * 注意，赛道按扇区编号升序逆时针形成一个圆（请参见第一个示例）。
 *
 * 示例：
 * 输入1：n = 4, rounds = [1,3,1,2]
 * 输出1：[1,2]
 *
 * 输入2：n = 2, rounds = [2,1,2,1,2,1,2,1,2]
 * 输出2：[2]
 *
 * 输入3：n = 7, rounds = [1,3,5,7]
 * 输出3：[1,2,3,4,5,6,7]
 */
public class T1560 {
    /**
     * 官方解法：模拟
     */
    public List<Integer> mostVisited(int n, int[] rounds) {
        List<Integer> ans = new ArrayList<>();
        int l = rounds.length;
        int start = rounds[0];
        int end = rounds[l - 1];
        if (start <= end) {
            for (int i = start; i <= end; i++) {
                ans.add(i);
            }
        } else {
            for (int i = 1; i <= end; i++) {
                ans.add(i);
            }
            for (int i = start; i <= n; i++) {
                ans.add(i);
            }
        }
        return ans;
    }
}
