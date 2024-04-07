package problems.c0easy.t501t1000;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 682 棒球比赛 https://leetcode.cn/problems/baseball-game/
 * 根据操作字符串列表ops计算总得分，ops[i]的各个含义如下：
 *  1、整数 x - 表示本回合新获得分数 x
 *  2、"+" - 表示本回合新获得的得分是前两次得分的总和。题目数据保证记录此操作时前面总是存在两个有效的分数。
 *  3、"D" - 表示本回合新获得的得分是前一次得分的两倍。题目数据保证记录此操作时前面总是存在一个有效的分数。
 *  4、"C" - 表示前一次得分无效，将其从记录中移除。题目数据保证记录此操作时前面总是存在一个有效的分数。
 *
 * 示例：
 * 输入1：ops = ["5","2","C","D","+"]
 * 输出1：30
 * 备注：
 * "5" - 记录加 5 ，记录现在是 [5]
 * "2" - 记录加 2 ，记录现在是 [5, 2]
 * "C" - 使前一次得分的记录无效并将其移除，记录现在是 [5].
 * "D" - 记录加 2 * 5 = 10 ，记录现在是 [5, 10].
 * "+" - 记录加 5 + 10 = 15 ，记录现在是 [5, 10, 15].
 * 所有得分的总和 5 + 10 + 15 = 30
 *
 * 输入2：ops = ["5","-2","4","C","D","9","+","+"]
 * 输出2：27
 * 备注：
 * "5" - 记录加 5 ，记录现在是 [5]
 * "-2" - 记录加 -2 ，记录现在是 [5, -2]
 * "4" - 记录加 4 ，记录现在是 [5, -2, 4]
 * "C" - 使前一次得分的记录无效并将其移除，记录现在是 [5, -2]
 * "D" - 记录加 2 * -2 = -4 ，记录现在是 [5, -2, -4]
 * "9" - 记录加 9 ，记录现在是 [5, -2, -4, 9]
 * "+" - 记录加 -4 + 9 = 5 ，记录现在是 [5, -2, -4, 9, 5]
 * "+" - 记录加 9 + 5 = 14 ，记录现在是 [5, -2, -4, 9, 5, 14]
 * 所有得分的总和 5 + -2 + -4 + 9 + 5 + 14 = 27
 */
public class T682 {
    /**
     * 自己实现：使用栈
     */
    public int calPoints(String[] operations) {
        Deque<Integer> stack = new LinkedList<>();

        for (String s : operations) {
            //移除上一次得分，直接出栈
            if (s.equals("C")) {
                stack.pop();
            } else if (s.equals("D")) {
                //是前一次得分的两倍，先出栈计算，记得放回去
                int n = stack.pop();
                stack.push(n);
                stack.push(n * 2);
            } else if (s.equals("+")) {
                //前两次得分记录之和，先出栈取数据，记得按原顺序放回去
                int n1 = stack.pop();
                int n2 = stack.pop();
                stack.push(n2);
                stack.push(n1);
                stack.push(n1 + n2);
            } else {
                //数字得分
                stack.push(Integer.valueOf(s));
            }
        }

        //对栈求和
        int ans = 0;
        while (stack.size() > 0) {
            ans += stack.pop();
        }

        return ans;
    }

    /**
     * 官方解法：用数组模拟栈
     */
    public int calPoints1(String[] operations) {
        int n = operations.length;
        int[] nums = new int[n];
        int index = 0;

        for (String operation : operations) {
            switch (operation) {
                case "+":
                    nums[index] = nums[index - 1] + nums[index - 2];
                    break;
                case "D":
                    nums[index] = nums[index - 1] * 2;
                    break;
                case "C":
                    //移除当前位和上一位
                    index -= 2;
                    break;
                default:
                    nums[index] = Integer.parseInt(operation);
                    break;
            }
            index++;
        }

        //计算结果 因为上边遍历的时候最后一次index会多加1，所以这里只用<
        int ans = 0;
        for (int i = 0; i < index; i++) {
            ans += nums[i];
        }
        return ans;
    }
}
