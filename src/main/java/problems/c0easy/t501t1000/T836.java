package problems.c0easy.t501t1000;

/**
 * 836 矩形重叠 https://leetcode.cn/problems/rectangle-overlap/description/\
 * 矩形以列表 [x1, y1, x2, y2] 的形式表示，
 * 其中 (x1, y1) 为左下角的坐标，(x2, y2) 是右上角的坐标。矩形的上下边平行于 x 轴，左右边平行于 y 轴。
 * 如果相交的面积为 正 ，则称两矩形重叠。需要明确的是，只在角或边接触的两个矩形不构成重叠。
 * 给出两个矩形 rec1 和 rec2 。如果它们重叠，返回 true；否则，返回 false 。
 *
 * 示例：
 * 输入1：rec1 = [0,0,2,2], rec2 = [1,1,3,3]
 * 输出1：true
 *
 * 输入2：rec1 = [0,0,1,1], rec2 = [1,0,2,1]
 * 输出2：false
 *
 * 输入3：rec1 = [0,0,1,1], rec2 = [2,2,3,3]
 * 输出3：false
 */
public class T836 {
    /**
     * 官方解法：逆向思维
     * 排除矩阵1在矩阵2四周的情况
     */
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        //矩阵1在矩阵2左侧：rec1的x2 小于等于 rec2的 x1
        //矩阵1在矩阵2右侧：rec1的x1 大于等于 rec2的 x2
        //矩阵1在矩阵2上册：rec1的y1 大于等于 rec2的 y2
        //矩阵1在矩阵2下册：rec1的y2 小于等于 rec2的 y1
        if (rec1[2] <= rec2[0] || rec1[0] >= rec2[2] || rec1[1] >= rec2[3] || rec1[3] <= rec2[1]) {
            return false;
        }

        return true;
    }

    /**
     * 官方解法2：检查区域
     * 如果两个矩形重叠，它们重叠的区域一定也是一个矩形
     * 分别将两个矩形投射到x轴和y轴，判断其线段是否重复，都重复即存在重叠区域
     */
    public boolean isRectangleOverlap1(int[] rec1, int[] rec2) {
        return (Math.min(rec1[2], rec2[2]) > Math.max(rec1[0], rec2[0]) &&
                Math.min(rec1[3], rec2[3]) > Math.max(rec1[1], rec2[1]));
    }
}
