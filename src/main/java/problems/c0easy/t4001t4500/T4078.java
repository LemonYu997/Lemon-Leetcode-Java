package problems.c0easy.t4001t4500;

import java.util.HashSet;
import java.util.Set;

/**
 * 4078 连续三项斐波那契数之和 https://leetcode.cn/problems/three-fibonacci-sum/description/
 * 给你一个整数 n。
 * 斐波那契数列 以 0 和 1 开始，之后的每个数都是前两个数之和。它的前几项为 0, 1, 1, 2, 3, 5, 8, 13, ...。
 * 如果 n 可以表示为斐波那契数列中 连续三项之和，则返回 true；否则返回 false。
 *
 * 输入1：n = 16
 * 输出1：true
 *
 * 输入2：n = 8
 * 输出2：false
 *
 * 输入3：n = 2
 * 输出3：true
 */
public class T4078 {
    private static final Set<Integer> fibSet = new HashSet<>();

    static {
        int a = 0;
        int b = 1;
        // 只处理 10^9 前的数
        while (b < 1e9) {
            int x = a + b;
            a = b;
            b = x;
            fibSet.add(b);
        }
    }

    public boolean threeFibonacciSum(int n) {
        // 连续三项之和必为偶数，因为  F(n - 2) + F(n - 1) = F(n)
        // 那么 F(n - 2) + F(n - 1) + F(n) = 2 * F(n)
        // 因此只需判断其是否为偶数且其的一半是否为斐波那列数即可
        return n % 2 == 0 && fibSet.contains(n / 2);
    }
}
