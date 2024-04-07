package problems.c0easy.t1001t1500;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 1207 独一无二的出现次数 https://leetcode.cn/problems/unique-number-of-occurrences/description/
 * 给你一个整数数组 arr，请你帮忙统计数组中每个数的出现次数。
 * 如果每个数的出现次数都是独一无二的，就返回 true；否则返回 false。
 *
 * 示例：
 * 输入1：arr = [1,2,2,1,1,3]
 * 输出1：true
 *
 * 输入2：arr = [-3,0,1,-3,1,1,1,-3,10,0]
 * 输出2：true
 */
public class T1207 {
    /**
     * 自己实现：先用 Map 统计每个数的出现个数，再用 set 查询是否存在重复的次数
     * 判断 Set 长度和 map 长度是否一致即可
     */
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        // 先用 Map 统计每个数的出现个数
        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        // 再用 set 查询是否存在重复的次数
        Set<Integer> set = new HashSet<>(map.values());
        // 判断 Set 长度和 map 长度是否一致即可
        return set.size() == map.size();
    }
}
