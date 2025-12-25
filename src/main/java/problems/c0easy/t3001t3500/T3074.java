package problems.c0easy.t3001t3500;

import java.util.Arrays;

/**
 * 3074 重新分装苹果 https://leetcode.cn/problems/apple-redistribution-into-boxes/description/
 * 给你一个长度为 n 的数组 apple 和另一个长度为 m 的数组 capacity 。
 * 一共有 n 个包裹，其中第 i 个包裹中装着 apple[i] 个苹果。同时，
 * 还有 m 个箱子，第 i 个箱子的容量为 capacity[i] 个苹果。
 * 请你选择一些箱子来将这 n 个包裹中的苹果重新分装到箱子中，返回你需要选择的箱子的 最小 数量。
 * 注意，同一个包裹中的苹果可以分装到不同的箱子中。
 *
 * 示例：
 * 输入1：apple = [1,3,2], capacity = [4,3,1,5,2]
 * 输出1：2
 *
 * 输入2：apple = [5,5,5], capacity = [2,4,2,7]
 * 输出2：4
 */
public class T3074 {
    /**
     * 自己实现：根据题意模拟
     */
    public int minimumBoxes(int[] apple, int[] capacity) {
        // 计算苹果总数
        int all = 0;
        for (int i : apple) {
            all += i;
        }

        // 找到最小的箱子数
        Arrays.sort(capacity);
        int n = capacity.length;
        int ans = 0;
        int sum = 0;

        for (int i = n - 1; i >= 0; i--) {
            sum += capacity[i];
            ans++;
            if (sum >= all) {
                return ans;
            }
        }

        return ans;
    }
}
