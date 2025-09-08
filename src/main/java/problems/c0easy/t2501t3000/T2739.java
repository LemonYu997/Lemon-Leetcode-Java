package problems.c0easy.t2501t3000;

/**
 * 2739 总行驶距离 https://leetcode.cn/problems/total-distance-traveled/description/
 * 卡车有两个油箱。给你两个整数，mainTank 表示主油箱中的燃料（以升为单位），
 * additionalTank 表示副油箱中的燃料（以升为单位）。
 * 该卡车每耗费 1 升燃料都可以行驶 10 km。每当主油箱使用了 5 升燃料时，
 * 如果副油箱至少有 1 升燃料，则会将 1 升燃料从副油箱转移到主油箱。
 * 返回卡车可以行驶的最大距离。
 * 注意：从副油箱向主油箱注入燃料不是连续行为。这一事件会在每消耗 5 升燃料时突然且立即发生。
 *
 * 示例：
 * 输入1：mainTank = 5, additionalTank = 10
 * 输出1：60
 *
 * 输入2：mainTank = 1, additionalTank = 2
 * 输出2：10
 */
public class T2739 {
    /**
     * 自己实现：根据题意模拟即可
     */
    public int distanceTraveled(int mainTank, int additionalTank) {
        int ans = 0;
        int temp = 0;
        while (mainTank > 0) {
            mainTank--;
            temp++;
            if (temp == 5 && additionalTank > 0) {
                temp = 0;
                mainTank++;
                additionalTank--;
            }
            ans += 10;
        }

        return ans;
    }
}
