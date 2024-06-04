package problems.c0easy.t1001t1500;

import java.util.HashMap;
import java.util.Map;

/**
 * 1394 找出数组中的幸运数 https://leetcode.cn/problems/find-lucky-integer-in-an-array/description/
 * 在整数数组中，如果一个整数的出现频次和它的数值大小相等，我们就称这个整数为「幸运数」。
 * 给你一个整数数组 arr，请你从中找出并返回一个幸运数。
 * 如果数组中存在多个幸运数，只需返回 最大 的那个。
 * 如果数组中不含幸运数，则返回 -1 。
 *
 * 示例：
 * 输入1：arr = [2,2,3,4]
 * 输出1：2
 *
 * 输入2：arr = [1,2,2,3,3,3]
 * 输出2：3
 *
 * 输入3：arr = [2,2,2,3,3]
 * 输出3：-1
 *
 * 输入4：arr = [5]
 * 输出4：-1
 *
 * 输入5：arr = [7,7,7,7,7,7,7]
 * 输出5：7
 */
public class T1394 {
    /**
     * 自己实现：使用 Map 统计数字出现次数
     */
    public int findLucky(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        // 查找是否有幸运数，有的话寻找最大的一个
        int ans = -1;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getKey().equals(entry.getValue())) {
                ans = Math.max(ans, entry.getKey());
            }
        }
        return ans;
    }
}
