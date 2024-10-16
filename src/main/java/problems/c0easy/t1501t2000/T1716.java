package problems.c0easy.t1501t2000;

/**
 * 1716 计算力扣银行的钱 https://leetcode.cn/problems/calculate-money-in-leetcode-bank/description/
 * Hercy 想要为购买第一辆车存钱。他 每天 都往力扣银行里存钱。
 * 最开始，他在周一的时候存入 1 块钱。从周二到周日，他每天都比前一天多存入 1 块钱。
 * 在接下来每一个周一，他都会比 前一个周一 多存入 1 块钱。
 *
 * 给你 n ，请你返回在第 n 天结束的时候他在力扣银行总共存了多少块钱。
 *
 * 示例：
 * 输入1：n = 4
 * 输出1：10
 *
 * 输入2：n = 4
 * 输出2：37
 *
 * 输入3：n = 20
 * 输出3：96
 */
public class T1716 {
    /**
     * 自己实现：根据题意模拟
     */
    public int totalMoney(int n) {
        int ans = 0;

        for (int i = 0; i <= n; i++) {
            // 如果当天是本周最后一天，需要加上当前周数和7天
            if (i % 7 == 0) {
                ans += (i / 7 - 1) + 7;
            } else {
                // 平时是第几周 + 本周第几天
                ans += i / 7 + i % 7;
            }
        }

        return ans;
    }

    /**
     * 官方解法：模拟
     */
    public int totalMoney1(int n) {
        int week = 1;
        int day = 1;
        int res = 0;

        for (int i = 0; i < n; i++) {
            res += week + day - 1;
            day++;
            // 下一周时
            if (day == 8) {
                day = 1;
                week++;
            }
        }

        return res;
    }

    /**
     * 官方解法：等差数列
     * 每周存钱数比上一周多 7 块钱
     */
    public int totalMoney2(int n) {
        // 所有完整的周数
        int weekNumber = n / 7;
        // 第一周存的钱
        int firstWeekMoney = (1 + 7) * 7 / 2;
        // 最后一周存的钱
        int lastWeekMoney = firstWeekMoney + 7 * (weekNumber - 1);
        // 所有完整周存的钱总和
        int weekMoney = (firstWeekMoney + lastWeekMoney) * weekNumber / 2;
        // 剩下的不足完整周的天数
        int dayNumber = n % 7;
        int firstDayMoney = 1 + weekNumber;
        int lastDayMoney = firstDayMoney + dayNumber - 1;
        int dayMoney = (firstDayMoney + lastDayMoney) * dayNumber / 2;
        return weekMoney + dayMoney;
    }
}
