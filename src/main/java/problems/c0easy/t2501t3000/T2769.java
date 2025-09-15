package problems.c0easy.t2501t3000;

/**
 * 2769 找出最大的可达成数字 https://leetcode.cn/problems/find-the-maximum-achievable-number/description/
 * 给你两个整数 num 和 t 。如果整数 x 可以在执行下述操作 不超过 t 次的情况下变为与 num 相等，则称其为 可达成数字 ：
 *
 * 每次操作将 x 的值增加或减少 1 ，同时可以选择将 num 的值增加或减少 1 。
 * 返回所有可达成数字中的 最大 值 x。
 *
 * 示例：
 * 输入1：num = 4, t = 1
 * 输出1：6
 *
 * 输入2：num = 3, t = 2
 * 输出2：7
 */
public class T2769 {
    /**
     * 自己实现：根据题意num + 2 * t 即可
     */
    public int theMaximumAchievableX(int num, int t) {
        return num + 2 * t;
    }
}
