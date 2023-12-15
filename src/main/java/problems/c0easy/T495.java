package problems.c0easy;

/**
 * 495 提莫攻击 https://leetcode.cn/problems/teemo-attacking/
 * 提莫攻击会使对方进入中毒状态，持续 duration 秒
 * 提莫在时间 t 发起攻击，则对方会在 [t, t + duration - 1] 时间范围内中毒，在中毒结束前再次攻击会重置这个区间
 * 给定一个非递减整数数组 timeSeries，其中 timeSeries[i] 表示提莫在 timeSeries[i] 时发起攻击
 * 返回对方处于中毒状态的总秒数
 *
 * 示例1：
 * 输入1：timeSeries = [1,4], duration = 2
 * 输出1：4
 * 备注：
 * 第 1 秒，提莫攻击敌人并使其立即中毒。中毒状态会维持 2 秒，即第 1 秒和第 2 秒。
 * 第 4 秒，提莫再次攻击敌人，敌人中毒状态又持续 2 秒，即第 4 秒和第 5 秒。
 * 敌人在第 1、2、4、5 秒处于中毒状态，所以总中毒秒数是 4 。
 *
 * 输入2：timeSeries = [1,2], duration = 2
 * 输出2：3
 */
public class T495 {
    /**
     * 自己实现：根据定义
     */
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int count = 0;

        for (int i = 1; i < timeSeries.length; i++) {
            //如果两次攻击时间间隔 >= duration，则可以完全加上
            if (timeSeries[i] - timeSeries[i - 1] >= duration) {
                count += duration;
            } else {
                //否则就只持续两次攻击间隔时间
                count += timeSeries[i] - timeSeries[i - 1];
            }
        }

        //最后一次攻击肯定能加一个完整的duration
        return count + duration;
    }
}
