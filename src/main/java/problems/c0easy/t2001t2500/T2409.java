package problems.c0easy.t2001t2500;

/**
 * 2409 统计共同度过的日子数 https://leetcode.cn/problems/count-days-spent-together/description/
 * Alice 和 Bob 计划分别去罗马开会。
 *
 * 给你四个字符串 arriveAlice ，leaveAlice ，arriveBob 和 leaveBob 。
 * Alice 会在日期 arriveAlice 到 leaveAlice 之间在城市里（日期为闭区间），
 * 而 Bob 在日期 arriveBob 到 leaveBob 之间在城市里（日期为闭区间）。
 * 每个字符串都包含 5 个字符，格式为 "MM-DD" ，对应着一个日期的月和日。
 *
 * 请你返回 Alice和 Bob 同时在罗马的天数。
 *
 * 你可以假设所有日期都在 同一个 自然年，而且 不是 闰年。每个月份的天数分别为：
 * [31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31] 。
 *
 * 示例：
 * 输入1：arriveAlice = "08-15", leaveAlice = "08-18", arriveBob = "08-16", leaveBob = "08-19"
 * 输出1：3
 *
 * 输入2：arriveAlice = "10-01", leaveAlice = "10-31", arriveBob = "11-01", leaveBob = "12-31"
 * 输出2：0
 */
public class T2409 {
    /**
     * 自己实现：计算 arriveBob 和 leaveAlice 之间的日期差值即可
     */
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        // 月份天数
        int[] days = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        // 计算月份前缀和 初始为 0 月 0 天，方便后边进行计算
        int[] allDays = new int[13];

        for (int i = 1; i < 13; i++) {
            allDays[i] = days[i - 1] + allDays[i - 1];
        }

        int aA = getDays(arriveAlice, allDays);
        int lA = getDays(leaveAlice, allDays);
        int aB = getDays(arriveBob, allDays);
        int lB = getDays(leaveBob, allDays);

        return Math.max(0, Math.min(lA, lB) - Math.max(aA, aB) + 1);
    }

    /**
     * 计算当前日期在当前年共多少天
     * 官方解法的 substring 性能消耗更小，效率更高
      */
    public int getDays(String s, int[] allDays) {
        String[] split = s.split("-");
        return allDays[Integer.parseInt(split[0]) - 1] + Integer.parseInt(split[1]);
    }

    /**
     * 官方解法：
     */
    public int countDaysTogether1(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        int[] datesOfMonths = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int[] prefixSum = new int[13];
        for (int i = 0; i < 12; i++) {
            prefixSum[i + 1] = prefixSum[i] + datesOfMonths[i];
        }

        int arriveAliceDay = calculateDayOfYear(arriveAlice, prefixSum);
        int leaveAliceDay = calculateDayOfYear(leaveAlice, prefixSum);
        int arriveBobDay = calculateDayOfYear(arriveBob, prefixSum);
        int leaveBobDay = calculateDayOfYear(leaveBob, prefixSum);
        return Math.max(0, Math.min(leaveAliceDay, leaveBobDay) - Math.max(arriveAliceDay, arriveBobDay) + 1);
    }

    public int calculateDayOfYear(String day, int[] prefixSum) {
        int month = Integer.parseInt(day.substring(0, 2));
        int date = Integer.parseInt(day.substring(3));
        return prefixSum[month - 1] + date;
    }

}
