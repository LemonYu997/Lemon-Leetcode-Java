package problems.c0easy;

/**
 * 492 构造矩形 https://leetcode.cn/problems/construct-the-rectangle/
 * 给定一个具体的矩形面积，设计一个长度为L和宽度为W且满足以下要求的矩形：
 *  1、设计的矩形面积必须等于给定的矩形面积
 *  2、宽度W不应大于长度L，即 L >= W
 *  3、长度L和宽度W之间的差距应当尽可能小
 * 返回int[L, W]
 *
 * 示例：
 * 输入1：4
 * 输出1：[2,2]
 *
 * 输入2：area = 37
 * 输出2：[37,1]
 *
 * 输入3：area = 122122
 * 输出3：[427,286]
 */
public class T492 {
    /**
     * 自己实现：根据定义
     * 从 根号area 开始累加，直至能除尽为止
     */
    public int[] constructRectangle(int area) {
        int[] ans = new int[2];
        int n = (int) Math.sqrt(area);

        for (int i = n; i <= area; i++) {
            if (area % i == 0) {
                if (i >= area / i) {
                    ans[0] = i;
                    ans[1] = area / i;
                } else {
                    ans[0] = area / i;
                    ans[1] = i;
                }

                break;
            }
        }

        return ans;
    }

    /**
     * 官方解法：上述代码的优化实现
     */
    public int[] constructRectangle1(int area) {
        int w = (int) Math.sqrt(area);

        //从宽度开始遍历，遍历次数会更少
        while (area % w != 0) {
            w--;
        }

        return new int[]{area / w, w};
    }
}
