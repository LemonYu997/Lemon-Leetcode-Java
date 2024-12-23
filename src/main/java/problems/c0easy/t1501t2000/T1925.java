package problems.c0easy.t1501t2000;

/**
 * 1925 统计平方和三元组的数目 https://leetcode.cn/problems/count-square-sum-triples/description/
 * 一个 平方和三元组 (a,b,c) 指的是满足 a2 + b2 = c2 的 整数 三元组 a，b 和 c 。
 *
 * 给你一个整数 n ，请你返回满足 1 <= a, b, c <= n 的 平方和三元组 的数目。
 *
 * 示例：
 * 输入1：n = 5
 * 输出1：2
 *
 * 输入2：n = 10
 * 输出2：4
 */
public class T1925 {
    /**
     * 自己实现：根据题意，先遍历找到前两个数，判断其平方和的第三个数是否在范围内，在的话就总数 +1
     */
    public int countTriples(int n) {
        int ans = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = i + 1; j <= n; j++) {
                int temp = i * i + j * j;
                // 平方和在数据范围内，并且其开根号需要为整数
                if (temp <= n * n) {
                    // 开根号 强制取整
                    int sqrt = (int) Math.sqrt(i * i + j * j);
                    if (temp == sqrt * sqrt) {
                        ans++;
                    }
                } else {
                    // 如果平方和不在范围内，继续遍历也没用，可以提前结束
                    break;
                }
            }
        }

        // 由于前两位位置可以互换，这里需要 * 2
        return ans * 2;
    }
}
