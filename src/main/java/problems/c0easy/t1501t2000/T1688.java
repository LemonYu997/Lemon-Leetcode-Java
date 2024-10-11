package problems.c0easy.t1501t2000;

/**
 * 1688 比赛中的配对次数 https://leetcode.cn/problems/count-of-matches-in-tournament/description/
 * 给你一个整数 n ，表示比赛中的队伍数。比赛遵循一种独特的赛制：
 * 如果当前队伍数是 偶数 ，那么每支队伍都会与另一支队伍配对。
 * 总共进行 n / 2 场比赛，且产生 n / 2 支队伍进入下一轮。
 * 如果当前队伍数为 奇数 ，那么将会随机轮空并晋级一支队伍，
 * 其余的队伍配对。总共进行 (n - 1) / 2 场比赛，且产生 (n - 1) / 2 + 1 支队伍进入下一轮。
 * 返回在比赛中进行的配对次数，直到决出获胜队伍为止。
 *
 * 示例：
 * 输入1：n = 7
 * 输出1：6
 *
 * 输入2：n = 14
 * 输出2：13
 */
public class T1688 {
    /**
     * 自己实现：根据题意模拟 先 % 2，再 / 2
     */
    public int numberOfMatches(int n) {
        int ans = 0;
        // 初始的轮空人数
        int temp = n % 2;
        while (n > 1) {
            // 当前人数需要的比赛次数
            ans += n / 2;
            // 下轮比赛的人数（需要加上上轮轮空的）
            n = n / 2 + temp;
            // 下轮比赛的轮空人数
            temp = n % 2;
        }
        return ans;
    }

    /**
     * 官方解法：每场比赛中只会有一个队伍不能晋级，由于最后只会选出一个队伍，即有 n - 1个队伍不会晋级
     * 因此需要 n - 1 轮比赛
     */
    public int numberOfMatches1(int n) {
        return n - 1;
    }
}
