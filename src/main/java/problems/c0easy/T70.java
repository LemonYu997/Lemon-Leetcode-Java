package problems.c0easy;

import java.util.Scanner;

/**
 * 70  爬楼梯  https://leetcode.cn/problems/climbing-stairs/
 * 假设正在爬楼梯，需要 N 阶才能爬到楼顶，每次可以爬 1 到 2 阶
 * 求有多少种方法可以爬到楼顶
 *
 * 示例1：
 * 输入：n = 2
 * 输出：2
 * 解释：两种：1+1、2
 *
 * 示例2：
 * 输入：n = 3
 * 输出：3
 * 解释：1+1+1、1+2、2+1
 */
public class T70 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine().trim();

        System.out.println(climbStairs1(Integer.parseInt(s)));
    }

    /**
     * 官方解法：动态规划
     * 列公式：f(x) = f(x-1) + f(x-2) 逆向思维，上一步只能是爬一阶或者爬两阶
     * 边界条件：
     *      f(0) = 1    这里只是人为定义，因为实际不可能只爬零层
     *      f(1) = 1
     * 根据上边公式可以算得：f(2) = 2, f(3) = 3, f(4) = 5
     */
    public static int climbStairs1(int n) {
        //使用滚动数组写法，因为上边的公式实际上只有三个变量
        //核心还是动态规划，只是定义一个数组
        int p = 0;
        int q = 0;
        int r = 1;

        //最少爬一阶
        for (int i = 1; i <= n; i++) {
            p = q;
            q = r;
            r = p + q;
        }

        return r;
    }

    /**
     * 参考解法：动态规划 五步法
     * 1、确定dp[i]的下标以及dp值的含义：爬到第 i 阶，有 dp[i] 种方法
     * 2、确定动态规划的递推公式：dp[i] = dp[i-1] + dp[i-2]
     * 3、dp数组初始化：因为 1 <= n <= 45，所以可设置初始值 dp[1] = 1, dp[2] = 2
     * 4、确定遍历顺序：从前往后
     * 5、输出dp数组，观察计算结果是否正确
     */
    public static int climbStairs2(int n) {
        if (n <= 1) {
            return n;
        }

        //数组长度定义为 n+1，索引只到 n
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[n];
    }
}
