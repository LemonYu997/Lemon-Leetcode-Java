package problems.c0easy.t2501t3000;

/**
 * 2525 根据规则将箱子分类 https://leetcode.cn/problems/categorize-box-according-to-criteria/description/
 * 给你四个整数 length ，width ，height 和 mass ，
 * 分别表示一个箱子的三个维度和质量，请你返回一个表示箱子 类别 的字符串。
 * 如果满足以下条件，那么箱子是 "Bulky" 的：
 * 箱子 至少有一个 维度大于等于 104 。
 * 或者箱子的 体积 大于等于 109 。
 * 如果箱子的质量大于等于 100 ，那么箱子是 "Heavy" 的。
 * 如果箱子同时是 "Bulky" 和 "Heavy" ，那么返回类别为 "Both" 。
 * 如果箱子既不是 "Bulky" ，也不是 "Heavy" ，那么返回类别为 "Neither" 。
 * 如果箱子是 "Bulky" 但不是 "Heavy" ，那么返回类别为 "Bulky" 。
 * 如果箱子是 "Heavy" 但不是 "Bulky" ，那么返回类别为 "Heavy" 。
 * 注意，箱子的体积等于箱子的长度、宽度和高度的乘积。
 *
 * 示例：
 * 输入1：length = 1000, width = 35, height = 700, mass = 300
 * 输出1："Heavy"
 *
 * 输入2：length = 200, width = 50, height = 800, mass = 50
 * 输出2："Neither"
 */
public class T2525 {
    public static void main(String[] args) {
        categorizeBox(2909, 3968, 3272, 727);
    }

    /**
     * 自己实现：根据题意模拟
     */
    public static String categorizeBox(int length, int width, int height, int mass) {
        boolean bulky = false;
        boolean heavy = false;

        // 注意防止体积计算过大超出 int 上限
        if (length >= 10000 || width >= 10000 || height >= 10000
                || (long) length * width * height >= 1000000000) {
            bulky = true;
        }
        if (mass >= 100) {
            heavy = true;
        }

        if (bulky && heavy) {
            return "Both";
        } else if (bulky) {
            return "Bulky";
        } else if (heavy) {
            return "Heavy";
        } else {
            return "Neither";
        }
    }
}
