package problems.c0easy.t1501t2000;

import java.util.HashMap;
import java.util.Map;

/**
 * 1640 能否连接形成数组 https://leetcode.cn/problems/check-array-formation-through-concatenation/description/
 * 给你一个整数数组 arr ，数组中的每个整数 互不相同 。
 * 另有一个由整数数组构成的数组 pieces，其中的整数也 互不相同 。
 * 请你以 任意顺序 连接 pieces 中的数组以形成 arr 。
 * 但是，不允许 对每个数组 pieces[i] 中的整数重新排序。
 * 如果可以连接 pieces 中的数组形成 arr ，返回 true ；否则，返回 false 。
 *
 * 示例：
 * 输入1：arr = [15,88], pieces = [[88],[15]]
 * 输出1：true
 *
 * 输入2：arr = [49,18,16], pieces = [[16,18,49]]
 * 输出2：false
 *
 * 输入3：arr = [91,4,64,78], pieces = [[78],[4,64],[91]]
 * 输出3：true
 */
public class T1640 {
    /**
     * 官方解法：使用map
     */
    public boolean canFormArray(int[] arr, int[][] pieces) {
        int n = arr.length;
        int m = pieces.length;
        // key 是 pieces[i]的第一个数字，value是索引 i
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < m; i++) {
            map.put(pieces[i][0], i);
        }

        // 尝试组合出 arr
        for (int i = 0; i < n;) {
            // 如果 map 中不包含该数字，直接返回 false
            if (!map.containsKey(arr[i])) {
                return false;
            }
            // 如果找到了，匹配 pieces[i]中的数组能否匹配 arr
            int j = map.get(arr[i]);
            int len = pieces[j].length;
            for (int k = 0; k < len; k++) {
                if (arr[i + k] != pieces[j][k]) {
                    return false;
                }
            }

            i = i + len;
        }

        return true;
    }
}
