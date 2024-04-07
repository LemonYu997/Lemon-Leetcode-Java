package problems.c0easy.t1001t1500;

/**
 * 1103 分糖果2 https://leetcode.cn/problems/distribute-candies-to-people/description/
 * 买了一些糖果 candies，打算把它们分给排好队的 n = num_people 个小朋友。
 * 给第一个小朋友 1 颗糖果，第二个小朋友 2 颗，依此类推，直到给最后一个小朋友 n 颗糖果。
 * 然后，我们再回到队伍的起点，给第一个小朋友 n + 1 颗糖果，第二个小朋友 n + 2 颗，依此类推，
 * 直到给最后一个小朋友 2 * n 颗糖果。
 * 重复上述过程（每次都比上一次多给出一颗糖果，当到达队伍终点后再次从队伍起点开始），
 * 直到我们分完所有的糖果。注意，就算我们手中的剩下糖果数不够（不比前一次发出的糖果多），
 * 这些糖果也会全部发给当前的小朋友。
 * 返回一个长度为 num_people、元素之和为 candies 的数组，
 * 以表示糖果的最终分发情况（即 ans[i] 表示第 i 个小朋友分到的糖果数）。
 *
 * 示例：
 * 输入1：candies = 7, num_people = 4
 * 输出1：[1,2,3,1]
 *
 * 输入2：candies = 10, num_people = 3
 * 输出2：[5,2,3]
 */
public class T1103 {
    /**
     * 自己实现：根据题意模拟
     */
    public int[] distributeCandies(int candies, int num_people) {
        int[] ans = new int[num_people];

        int i = 0;  // 遍历的索引
        int n = 1;  // 当前给出的糖果
        while (true) {
            // 如果遍历一圈那就重头开始
            i = i % num_people;

            // 如果剩余糖果不够，就全给当前人，然后退出循环
            if (candies - n <= 0) {
                ans[i] += candies;
                break;
            }
            candies -= n;
            ans[i] += n;
            n++;
            i++;
        }

        return ans;
    }
}
