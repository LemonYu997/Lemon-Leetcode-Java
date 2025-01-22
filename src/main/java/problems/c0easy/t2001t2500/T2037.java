package problems.c0easy.t2001t2500;

import java.util.Arrays;

/**
 * 2037 使每位学生都有座位的最少移动次数 https://leetcode.cn/problems/minimum-number-of-moves-to-seat-everyone/description/
 * 一个房间里有 n 个 空闲 座位和 n 名 站着的 学生，房间用一个数轴表示。给你一个长度为 n 的数组 seats ，
 * 其中 seats[i] 是第 i 个座位的位置。同时给你一个长度为 n 的数组 students ，其中 students[j] 是第 j 位学生的位置。
 * 你可以执行以下操作任意次：
 * 增加或者减少第 i 位学生的位置，每次变化量为 1 （也就是将第 i 位学生从位置 x 移动到 x + 1 或者 x - 1）
 * 请你返回使所有学生都有座位坐的 最少移动次数 ，并确保没有两位学生的座位相同。
 * 请注意，初始时有可能有多个座位或者多位学生在 同一 位置。
 *
 * 示例：
 * 输入1：seats = [3,1,5], students = [2,7,4]
 * 输出1：4
 *
 * 输入2：seats = [4,1,5,9], students = [1,3,2,6]
 * 输出2：7
 *
 * 输入3：seats = [2,2,6,6], students = [1,3,2,6]
 * 输出3：4
 */
public class T2037 {
    /**
     * 自己实现：排序后，相加绝对差值即可
     */
    public int minMovesToSeat(int[] seats, int[] students) {
        Arrays.sort(seats);
        Arrays.sort(students);

        int ans = 0;
        for (int i = 0; i < seats.length; i++) {
            ans += Math.abs(seats[i] - students[i]);
        }

        return ans;
    }
}
