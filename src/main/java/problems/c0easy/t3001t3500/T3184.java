package problems.c0easy.t3001t3500;

/**
 * 3184 构成整天的下标对数目 I https://leetcode.cn/problems/count-pairs-that-form-a-complete-day-i/description/
 * 给你一个整数数组 hours，表示以 小时 为单位的时间，
 * 返回一个整数，表示满足 i < j 且 hours[i] + hours[j] 构成 整天 的下标对 i, j 的数目。
 * 整天 定义为时间持续时间是 24 小时的 整数倍 。
 * 例如，1 天是 24 小时，2 天是 48 小时，3 天是 72 小时，以此类推。
 *
 * 示例：
 * 输入1：hours = [12,12,30,24,24]
 * 输出1：2
 *
 * 输入2：hours = [72,48,24,3]
 * 输出2：3
 */
public class T3184 {
    /**
     * 自己实现：根据题意模拟
     */
    public int countCompleteDayPairs(int[] hours) {
        int ans = 0;
        for (int i = 0; i < hours.length; i++) {
            for (int j = i + 1; j < hours.length; j++) {
                if ((hours[i] + hours[j]) % 24 == 0) {
                    ans++;
                }
            }
        }
        return ans;
    }
}
