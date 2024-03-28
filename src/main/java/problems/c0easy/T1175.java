package problems.c0easy;

/**
 * 1175 质数排列 https://leetcode.cn/problems/prime-arrangements/description/
 * 给从 1 到 n 的数设计排列方案，使得所有的「质数」都应该被放在「质数索引」
 * （索引从 1 开始）上；你需要返回可能的方案总数。
 * [质数]：质数一定是大于 1 的，并且不能用两个小于它的正整数的乘积来表示。
 *
 * 由于答案可能会很大，所以请你返回答案 模 mod 10^9 + 7 之后的结果即可。
 *
 * 示例：
 * 输入1：n = 5
 * 输出1：12
 *
 * 输入1：n = 100
 * 输出1：682289015
 */
public class T1175 {
    /**
     * 自己实现：根据题意，先获取 n 之内的所有质数数量 m （注意 1 不是质数）
     * 则分别计算质数的排列组合数 m! 和非质数的排列组合数 (n-m)!
     * 相乘即可得到所有方案，再根据要求取模： m! * (n-m)! % (10 ^ 9 + 7)
     */
    public int numPrimeArrangements(int n) {
        // 先用埃氏筛选获得 n 以内的质数数量
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (isPrime(i)) {
                count++;
            }
        }

        return (int) (factorial(count) * factorial(n - count) % 1000000007);
    }

    /**
     * 判断一个数是否为质数 n
     * 埃氏筛选
     */
    private boolean isPrime(int n) {
        if (n == 1) {
            return false;
        }
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * 计算阶乘
     */
    public long factorial(int n) {
        long res = 1;
        for (int i = 1; i <= n; i++) {
            res *= i;
            res %= 1000000007;
        }
        return res;
    }
}
