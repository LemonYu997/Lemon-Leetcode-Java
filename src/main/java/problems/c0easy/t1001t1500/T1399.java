package problems.c0easy.t1001t1500;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 1399 统计最大组的数目 https://leetcode.cn/problems/count-largest-group/description/
 * 给你一个整数 n 。请你先求出从 1 到 n 的每个整数 10 进制表示下的数位和
 * （每一位上的数字相加），然后把数位和相等的数字放到同一个组中。
 * 请你统计每个组中的数字数目，并返回数字数目并列最多的组有多少个。
 *
 * 示例：
 * 输入1：n = 13
 * 输出1：4
 *
 * 输入2：n = 2
 * 输出2：2
 *
 * 输入3：n = 15
 * 输出3：6
 *
 * 输入4：n = 24
 * 输出4：5
 */
public class T1399 {
    /**
     * 自己实现：使用 Map 统计分类种数
     */
    public int countLargestGroup(int n) {
        Map<Integer, Integer> map = new HashMap<>();
        int maxValue = 0;
        for (int i = 1; i <= n; i++) {
            int key = 0;
            int num = i;
            while (num > 0) {
                key += num % 10;
                num /= 10;
            }
            // 更新当前数统计值和最大值
            map.put(key, map.getOrDefault(key, 0) + 1);
            maxValue = Math.max(maxValue, map.get(key));
        }

        int ans = 0;
        // 找到出现次数最多的数字次数
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == maxValue) {
                ans++;
            }
        }
        return ans;
    }
}
