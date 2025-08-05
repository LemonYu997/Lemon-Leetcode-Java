package problems.c0easy.t2501t3000;

/**
 * 2591 将钱分给最多的儿童 https://leetcode.cn/problems/distribute-money-to-maximum-children/description/
 * 给你一个整数 money ，表示你总共有的钱数（单位为美元）和另一个整数 children ，
 * 表示你要将钱分配给多少个儿童。
 * 你需要按照如下规则分配：
 * 所有的钱都必须被分配。
 * 每个儿童至少获得 1 美元。
 * 没有人获得 4 美元。
 * 请你按照上述规则分配金钱，并返回 最多 有多少个儿童获得 恰好 8 美元。
 * 如果没有任何分配方案，返回 -1
 *
 * 示例：
 * 输入1：money = 20, children = 3
 * 输出1：1
 *
 * 输入2：money = 16, children = 2
 * 输出2：2
 */
public class T2591 {
    /**
     * 官方解法：贪心
     */
    public int distMoney(int money, int children) {
        if (money < children) {
            return -1;
        }
        // 先给每个人分 1 块钱，保证基础要求
        money -= children;
        // 再判断剩下的足够给多少人再分 7 元，这里要判断是否比人数少，防止钱溢出
        int cnt = Math.min(money / 7, children);
        money -= cnt * 7;
        children -= cnt;
        // 如果钱有剩余，则需要有一个人获取剩余的钱，总数 -1
        // 如果刚好剩余1个人且剩余钱为3，则需要少一个人来参与分配，防止出现4的情况
        if ((children == 0 && money > 0) || (children == 1 && money == 3)) {
            cnt--;
        }
        return cnt;
    }
}
