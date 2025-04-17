package problems.c0easy.t2001t2500;

/**
 * 2303 计算应缴税款总额 https://leetcode.cn/problems/calculate-amount-paid-in-taxes/description/
 * 给你一个下标从 0 开始的二维整数数组 brackets ，其中 brackets[i] = [upperi, percenti] ，
 * 表示第 i 个税级的上限是 upperi ，征收的税率为 percenti 。
 * 税级按上限 从低到高排序（在满足 0 < i < brackets.length 的前提下，upperi-1 < upperi）。
 *
 * 税款计算方式如下：
 *
 * 不超过 upper0 的收入按税率 percent0 缴纳
 * 接着 upper1 - upper0 的部分按税率 percent1 缴纳
 * 然后 upper2 - upper1 的部分按税率 percent2 缴纳
 * 以此类推
 * 给你一个整数 income 表示你的总收入。返回你需要缴纳的税款总额。
 * 与标准答案误差不超 10-5 的结果将被视作正确答案。
 *
 * 示例：
 * 输入1：brackets = [[3,50],[7,10],[12,25]], income = 10
 * 输出1：2.65000
 *
 * 输入2：brackets = [[1,0],[4,25],[5,50]], income = 2
 * 输出2：0.25000
 *
 * 输入3：brackets = [[2,50]], income = 0
 * 输出3：0.00000
 */
public class T2303 {
    /**
     * 官方解法：根据题意模拟
     */
    public double calculateTax(int[][] brackets, int income) {
        int ans = 0;
        // 当前计算税率时的低区间
        int lower = 0;

        for (int[] bracket : brackets) {
            // 注意：不超过当前区间的部分按当前区间税率缴纳
            ans += (Math.min(income, bracket[0]) - lower) * bracket[1];
            // 如果不满足当前区间，说明不需要再往后遍历，可以直接退出
            if (income <= bracket[0]) {
                break;
            }
            lower = bracket[0];
        }

        return (double) ans / 100;
    }
}
