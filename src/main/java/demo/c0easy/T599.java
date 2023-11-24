package demo.c0easy;

import java.util.*;

/**
 * 599 两个列表的最小索引总和 https://leetcode.cn/problems/minimum-index-sum-of-two-lists/
 * 从两个字符串列表中找到索引和最小的相同的字符串
 *
 * 示例：
 * 输入1：list1 = ["Shogun", "Tapioca Express", "Burger King", "KFC"]，
 * list2 = ["Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"]
 * 输出1：["Shogun"]
 *
 * 输入2：list1 = ["Shogun", "Tapioca Express", "Burger King", "KFC"]，
 * list2 = ["KFC", "Shogun", "Burger King"]
 * 输出2：["Shogun"]
 */
public class T599 {
    /**
     * 自己实现：HashMap 暴力解法
     */
    public String[] findRestaurant(String[] list1, String[] list2) {
        int l1 = list1.length;
        int l2 = list2.length;
        Map<String, Integer> map = new HashMap<>();

        //记录每一个相同字符串及他们的索引和
        for (int i = 0; i < l1; i++) {
            for (int j = 0; j < l2; j++) {
                if (list1[i].equals(list2[j])) {
                    map.put(list1[i], i + j);
                }
            }
        }

        //初始化为最大值
        int sum = l1 + l2;
        int count = 0;
        String[] ans = new String[map.size()];

        //遍历每一个字符串，如果索引和最小，就重置ans
        for (String s : map.keySet()) {
            int v = map.get(s);
            if (v < sum) {
                sum = v;
                count = 0;
                ans[count] = s;
                count++;
            } else if (v == sum) {
                //如果索引和相等，就追加
                ans[count] = s;
                count++;
            }
        }

        //剔除多余的空数组
        return Arrays.copyOfRange(ans, 0, count);
    }

    /**
     * 官方解法：Hash表，先将list1放入hash表，再遍历list2中是否有相同元素
     * 计算索引和，如果比最小索引小，则更新结果
     */
    public String[] findRestaurant1(String[] list1, String[] list2) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < list1.length; i++) {
            map.put(list1[i], i);
        }

        List<String> ans = new ArrayList<>();
        int indexSum = Integer.MAX_VALUE;
        for (int i = 0; i < list2.length; i++) {
            //优化，当前索引超过最小索引和，可以直接退出了
            if (i > indexSum) {
                break;
            }
            if (map.containsKey(list2[i])) {
                int j = map.get(list2[i]);
                if (i + j < indexSum) {
                    ans.clear();
                    ans.add(list2[i]);
                    indexSum = i + j;
                } else if (i + j == indexSum) {
                    ans.add(list2[i]);
                }
            }
        }

        return ans.toArray(new String[ans.size()]);
    }
}
