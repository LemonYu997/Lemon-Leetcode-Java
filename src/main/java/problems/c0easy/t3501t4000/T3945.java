package problems.c0easy.t3501t4000;

/**
 * 3945 计算数字频率得分 https://leetcode.cn/problems/digit-frequency-score/description/
 * 给你一个整数 n。
 * n 的 得分 定义为：对所有 不同 数字 d，计算 d * freq(d) 的总和，其中 freq(d) 表示数字 d 在 n 中出现的次数。
 * 返回一个整数，表示 n 的得分。
 *
 * 示例：
 * 输入1：n = 122
 * 输出1：5
 *
 * 输入2：n = 101
 * 输出2：2
 */
public class T3945 {
    /**
     * 自己实现：根据题意模拟
     */
    public int digitFrequencyScore(int n) {
        // 统计每个数字出现的个数
        int[] count = new int[10];

        while (n > 0) {
            count[n % 10]++;
            n /= 10;
        }

        int sum = 0;
        for (int i = 0; i < count.length; i++) {
            sum += i * count[i];
        }
        return sum;
    }

    /**
     * 社区解法：简化写法，直接求和即可
     */
    public int digitFrequencyScore1(int n) {
        int ans = 0;
        while (n > 0) {
            ans += n % 10;
            n /= 10;
        }
        return ans;
    }
}
