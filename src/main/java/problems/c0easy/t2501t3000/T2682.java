package problems.c0easy.t2501t3000;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 2682 找出转圈游戏输家 https://leetcode.cn/problems/find-the-losers-of-the-circular-game/description/
 * n 个朋友在玩游戏。这些朋友坐成一个圈，按 顺时针方向 从 1 到 n 编号。准确的说，
 * 从第 i 个朋友的位置开始顺时针移动 1 步会到达第 (i + 1) 个朋友的位置（1 <= i < n），
 * 而从第 n 个朋友的位置开始顺时针移动 1 步会回到第 1 个朋友的位置。
 * 游戏规则如下：
 * 第 1 个朋友接球。
 * 接着，第 1 个朋友将球传给距离他顺时针方向 k 步的朋友。
 * 然后，接球的朋友应该把球传给距离他顺时针方向 2 * k 步的朋友。
 * 接着，接球的朋友应该把球传给距离他顺时针方向 3 * k 步的朋友，以此类推。
 * 换句话说，在第 i 轮中持有球的那位朋友需要将球传递给距离他顺时针方向 i * k 步的朋友。
 * 当某个朋友第 2 次接到球时，游戏结束。
 * 在整场游戏中没有接到过球的朋友是 输家 。
 * 给你参与游戏的朋友数量 n 和一个整数 k ，请按升序排列返回包含所有输家编号的数组 answer 作为答案。
 *
 * 示例：
 * 输入1：n = 5, k = 2
 * 输出1：[4,5]
 *
 * 输入2：n = 4, k = 4
 * 输出2：[2,3,4]
 */
public class T2682 {
    /**
     * 自己实现：使用Map统计，根据题意模拟
     */
    public int[] circularGameLosers(int n, int k) {
        // 使用map统计传球次数
        Map<Integer, Integer> map = new HashMap<>();
        int index = 1;  // 初始位
        int count = 1;  // 传球次数
        while (true) {
            // 如果进行到第二次传球，则结束循环
            if (map.containsKey(index)) {
                break;
            }
            // 记录接球数
            map.put(index, map.getOrDefault(index, 0) + 1);
            // 顺时针循环，超出的部分要进入下一循环
            index = index + count * k;
            while (index > n) {
                index -= n;
            }
            count++;
        }

        // 记录没有接收过球的人
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (!map.containsKey(i)) {
                list.add(i);
            }
        }

        return list.stream().mapToInt(i -> i).toArray();
    }

    /**
     * 官方解法：优化写法
     */
    public int[] circularGameLosers1(int n, int k) {
        boolean[] visited = new boolean[n];
        // i 是轮数 * k，j 是当前轮所接到球的人
        for (int i = k, j = 0; !visited[j]; i += k) {
            visited[j] = true;
            j = (j + i) % n;
        }

        // 记录没接到过球得到人
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                // 由于人员记录是从 1 开始的，这里要 + 1
                list.add(i + 1);
            }
        }

        return list.stream().mapToInt(i -> i).toArray();
    }
}
