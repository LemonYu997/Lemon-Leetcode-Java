package problems.c0easy.t2001t2500;

/**
 * 2469 温度转换 https://leetcode.cn/problems/convert-the-temperature/description/
 * 给你一个四舍五入到两位小数的非负浮点数 celsius 来表示温度，以 摄氏度（Celsius）为单位。
 * 你需要将摄氏度转换为 开氏度（Kelvin）和 华氏度（Fahrenheit），
 * 并以数组 ans = [kelvin, fahrenheit] 的形式返回结果。
 * 返回数组 ans 。与实际答案误差不超过 10-5 的会视为正确答案。
 *
 * 开氏度 = 摄氏度 + 273.15
 * 华氏度 = 摄氏度 * 1.80 + 32.00
 *
 * 示例：
 * 输入1：celsius = 36.50
 * 输出1：[309.65000,97.70000]
 *
 * 输入2：celsius = 122.11
 * 输出2：[395.26000,251.79800]
 */
public class T2469 {
    /**
     * 自己实现：根据题意计算即可
     */
    public double[] convertTemperature(double celsius) {
        double[] ans = new double[2];

        ans[0] = celsius + 273.15;
        ans[1] = celsius * 1.8 + 32;

        return ans;
    }
}
