package problems.c0easy.t1501t2000;

import java.util.Arrays;

/**
 * 1700 无法吃午餐的学生数量 https://leetcode.cn/problems/number-of-students-unable-to-eat-lunch/description/
 *学校的自助午餐提供圆形和方形的三明治，分别用数字 0 和 1 表示。所有学生站在一个队列里，每个学生要么喜欢圆形的要么喜欢方形的。
 * 餐厅里三明治的数量与学生的数量相同。所有三明治都放在一个 栈 里，每一轮：
 *
 * 如果队列最前面的学生 喜欢 栈顶的三明治，那么会 拿走它 并离开队列。
 * 否则，这名学生会 放弃这个三明治 并回到队列的尾部。
 * 这个过程会一直持续到队列里所有学生都不喜欢栈顶的三明治为止。
 *
 * 给你两个整数数组 students 和 sandwiches ，其中 sandwiches[i] 是栈里面第 i 个三明治的类型（i = 0 是栈的顶部），
 * students[j] 是初始队列里第 j 名学生对三明治的喜好（j = 0 是队列的最开始位置）。请你返回无法吃午餐的学生数量。
 *
 * 示例：
 * 输入1：students = [1,1,0,0], sandwiches = [0,1,0,1]
 * 输出1：0
 *
 * 输入2：students = [1,1,1,0,0,1], sandwiches = [1,0,0,0,1,1]
 * 输出2：3
 */
public class T1700 {
    /**
     * 官方解法：根据题意模拟
     * 只要还有对应学生喜欢的三明治，那就能吃完
     * 只需要计算还留下没有三明治吃的学生数即可
     */
    public int countStudents(int[] students, int[] sandwiches) {
        // 喜欢方形和圆形的学生数
        int s1 = Arrays.stream(students).sum();
        int s0 = students.length - s1;
        for (int i = 0; i < sandwiches.length; i++) {
            // 当前三明治为圆形，且还有喜欢圆形的学生
            if (sandwiches[i] == 0 && s0 > 0) {
                s0--;
            } else if (sandwiches[i] == 1 && s1 > 0) {
                s1--;
            } else {
                break;
            }
        }

        // 剩下没有吃到喜欢的三明治的学生数
        return s0 + s1;
    }
}
