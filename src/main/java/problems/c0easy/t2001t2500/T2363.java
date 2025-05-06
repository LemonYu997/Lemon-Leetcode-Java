package problems.c0easy.t2001t2500;

import java.util.*;

/**
 * 2363 合并相似的物品 https://leetcode.cn/problems/merge-similar-items/description/
 * 给你两个二维整数数组 items1 和 items2 ，表示两个物品集合。每个数组 items 有以下特质：
 * items[i] = [valuei, weighti] 其中 valuei 表示第 i 件物品的 价值 ，
 * weighti 表示第 i 件物品的 重量 。
 * items 中每件物品的价值都是 唯一的 。
 * 请你返回一个二维数组 ret，其中 ret[i] = [valuei, weighti]，
 * weighti 是所有价值为 valuei 物品的 重量之和 。
 *
 * 注意：ret 应该按价值 升序 排序后返回。
 *
 * 示例：
 * 输入1：items1 = [[1,1],[4,5],[3,8]], items2 = [[3,1],[1,5]]
 * 输出1：[[1,6],[3,9],[4,5]]
 *
 * 输入2：items1 = [[1,1],[3,2],[2,3]], items2 = [[2,1],[3,2],[1,3]]
 * 输出2：[[1,4],[2,4],[3,4]]
 *
 * 输入3：items1 = [[1,3],[2,2]], items2 = [[7,1],[2,2],[1,4]]
 * 输出3：[[1,7],[2,4],[7,1]]
 */
public class T2363 {
    /**
     * 自己实现：使用 Map 统计 并排序
     */
    public List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
        // key 为价值，value 为重量，使用 TreeMap 可以实现自动排序
        Map<Integer, Integer> map = new TreeMap<>();
        for (int[] item : items1) {
            map.put(item[0], map.getOrDefault(item[0], 0) + item[1]);
        }
        for (int[] item : items2) {
            map.put(item[0], map.getOrDefault(item[0], 0) + item[1]);
        }

        List<List<Integer>> ans = new ArrayList<>();
        // 根据 key 排序后重新放入
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            List<Integer> temp = new ArrayList<>();
            temp.add(entry.getKey());
            temp.add(entry.getValue());
            ans.add(temp);
        }

        return ans;
    }

    /**
     * 官方解法：使用List排序
     */
    public List<List<Integer>> mergeSimilarItems1(int[][] items1, int[][] items2) {
        // key 为价值，value 为重量，使用 TreeMap 可以实现自动排序
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] item : items1) {
            map.put(item[0], map.getOrDefault(item[0], 0) + item[1]);
        }
        for (int[] item : items2) {
            map.put(item[0], map.getOrDefault(item[0], 0) + item[1]);
        }

        List<List<Integer>> ans = new ArrayList<>();
        // 根据 key 排序后重新放入
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            List<Integer> temp = new ArrayList<>();
            temp.add(entry.getKey());
            temp.add(entry.getValue());
            ans.add(temp);
        }
        ans.sort((a, b) -> a.get(0) - b.get(0));

        return ans;
    }
}
