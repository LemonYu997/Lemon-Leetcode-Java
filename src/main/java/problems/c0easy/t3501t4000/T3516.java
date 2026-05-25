package problems.c0easy.t3501t4000;

/**
 * 3516 找到最近的人 https://leetcode.cn/problems/find-closest-person/description/
 * 给你三个整数 x、y 和 z，表示数轴上三个人的位置：
 * x 是第 1 个人的位置。
 * y 是第 2 个人的位置。
 * z 是第 3 个人的位置，第 3 个人 不会移动 。
 * 第 1 个人和第 2 个人以 相同 的速度向第 3 个人移动。
 * 判断谁会 先 到达第 3 个人的位置：
 * 如果第 1 个人先到达，返回 1 。
 * 如果第 2 个人先到达，返回 2 。
 * 如果两个人同时到达，返回 0 。
 * 根据上述规则返回结果。
 *
 * 示例：
 * 输入1：x = 2, y = 7, z = 4
 * 输出1：1
 *
 * 输入2：x = 2, y = 5, z = 6
 * 输出2：2
 *
 * 输入3：x = 1, y = 5, z = 3
 * 输出3：0
 */
public class T3516 {
    /**
     * 自己实现：判断谁离得近即可
     */
    public int findClosest(int x, int y, int z) {
        int xz = Math.abs(x - z);
        int yz = Math.abs(y - z);

        if (xz < yz) {
            return 1;
        } else if (xz == yz) {
            return 0;
        } else {
            return 2;
        }
    }
}
