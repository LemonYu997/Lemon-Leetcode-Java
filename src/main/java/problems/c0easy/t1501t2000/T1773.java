package problems.c0easy.t1501t2000;

import java.util.HashMap;
import java.util.List;

/**
 * 1773 统计匹配检索规则的物品数量 https://leetcode.cn/problems/count-items-matching-a-rule/description/
 * 给你一个数组 items ，其中 items[i] = [typei, colori, namei] ，
 * 描述第 i 件物品的类型、颜色以及名称。
 * 另给你一条由两个字符串 ruleKey 和 ruleValue 表示的检索规则。
 * 如果第 i 件物品能满足下述条件之一，则认为该物品与给定的检索规则 匹配 ：
 *
 * ruleKey == "type" 且 ruleValue == typei 。
 * ruleKey == "color" 且 ruleValue == colori 。
 * ruleKey == "name" 且 ruleValue == namei 。
 * 统计并返回 匹配检索规则的物品数量 。
 *
 * 示例：
 * 输入1：items = [["phone","blue","pixel"],
 * ["computer","silver","lenovo"],
 * ["phone","gold","iphone"]],
 * ruleKey = "color", ruleValue = "silver"
 * 输出1:1
 *
 * 输入2：items = [["phone","blue","pixel"],
 * ["computer","silver","phone"],
 * ["phone","gold","iphone"]],
 * ruleKey = "type", ruleValue = "phone"
 * 输出2:2
 */
public class T1773 {
    /**
     * 自己实现：根据题意模拟，遍历所有 items
     */
    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int ans = 0;
        for (List<String> item : items) {
            if ("type".equals(ruleKey)) {
                if (ruleValue.equals(item.get(0))) {
                    ans++;
                }
            } else if ("color".equals(ruleKey)) {
                if (ruleValue.equals(item.get(1))) {
                    ans++;
                }
            } else {
                if (ruleValue.equals(item.get(2))) {
                    ans++;
                }
            }
        }

        return ans;
    }

    /**
     * 官方解法：根据题意模拟，使用 map
     */
    public int countMatches1(List<List<String>> items, String ruleKey, String ruleValue) {
        int index = new HashMap<String, Integer>() {{
            put("type", 0);
            put("color", 1);
            put("name", 2);
        }}.get(ruleKey);

        int res = 0;
        for (List<String> item : items) {
            if (item.get(index).equals(ruleValue)) {
                res++;
            }
        }

        return res;
    }
}
