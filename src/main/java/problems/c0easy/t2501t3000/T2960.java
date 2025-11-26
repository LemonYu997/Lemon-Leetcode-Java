package problems.c0easy.t2501t3000;

/**
 * 2960 统计已测试设备 https://leetcode.cn/problems/count-tested-devices-after-test-operations/description/
 * 给你一个长度为 n 、下标从 0 开始的整数数组 batteryPercentages ，表示 n 个设备的电池百分比。
 * 你的任务是按照顺序测试每个设备 i，执行以下测试操作：
 * 如果 batteryPercentages[i] 大于 0：
 * 增加 已测试设备的计数。
 * 将下标 j 在 [i + 1, n - 1] 的所有设备的电池百分比减少 1，确保它们的电池百分比 不会低于 0 ，
 * 即 batteryPercentages[j] = max(0, batteryPercentages[j] - 1)。
 * 移动到下一个设备。
 * 否则，移动到下一个设备而不执行任何测试。
 * 返回一个整数，表示按顺序执行测试操作后 已测试设备 的数量。
 *
 * 示例：
 * 输入1：batteryPercentages = [1,1,2,1,3]
 * 输出1：3
 *
 * 输入2：batteryPercentages = [0,1,2]
 * 输出2：2
 */
public class T2960 {
    /**
     * 自己实现：根据题意模拟即可
     */
    public int countTestedDevices(int[] batteryPercentages) {
        int ans = 0;
        int n = batteryPercentages.length;

        for (int i = 0; i < n; i++) {
            // 如果当前电量大于0，后续所有设备都 -1
            if (batteryPercentages[i] > 0) {
                // 进行一次测试
                ans++;
                for (int j = i + 1; j < n; j++) {
                    if (batteryPercentages[j] > 0) {
                        batteryPercentages[j]--;
                    }
                }
            }
        }
        return ans;
    }

    /**
     * 官方解法：差分
     */
    public int countTestedDevices1(int[] batteryPercentages) {
        int ans = 0;
        for (int battery : batteryPercentages) {
            // 当前测试的设备掉了多少电，取决于之前测了多少次。
            if (battery > ans) {
                ans++;
            }
        }
        return ans;
    }
}