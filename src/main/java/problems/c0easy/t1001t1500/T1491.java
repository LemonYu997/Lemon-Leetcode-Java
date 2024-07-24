package problems.c0easy.t1001t1500;

import java.util.Arrays;

/**
 * 1491 去掉最低工资和最高工资后的工资平均值 https://leetcode.cn/problems/average-salary-excluding-the-minimum-and-maximum-salary/description/
 * 给你一个整数数组 salary ，数组里每个数都是 唯一 的，
 * 其中 salary[i] 是第 i 个员工的工资。
 * 请你返回去掉最低工资和最高工资以后，剩下员工工资的平均值。
 *
 * 示例：
 * 输入1：salary = [4000,3000,1000,2000]
 * 输出1：2500.00000
 *
 * 输入2：salary = [1000,2000,3000]
 * 输出2：2000.00000
 *
 * 输入3：salary = [6000,5000,4000,3000,2000,1000]
 * 输出3：3500.00000
 *
 * 输入4：salary = [8000,9000,2000,3000,6000,1000]
 * 输出4：4750.00000
 */
public class T1491 {
    /**
     * 自己实现：先排序再计算
     */
    public double average(int[] salary) {
        Arrays.sort(salary);
        int n = salary.length;
        int sum = 0;

        for (int i = 1; i < n - 1; i++) {
            sum += salary[i];
        }
        return (double) sum / (n - 2);
    }

    /**
     * 官方解法：计算所有数的和并减去最大值和最小值
     */
    public double average1(int[] salary) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int sum = 0;

        for (int num : salary) {
            sum += num;
            max = Math.max(num, max);
            min = Math.min(num, min);
        }

        return (double) (sum - max - min) / (salary.length - 2);
    }
}
