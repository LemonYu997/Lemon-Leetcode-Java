package problems.c0easy.t3501t4000;

import java.util.*;

/**
 * 3842 切换打开灯泡 https://leetcode.cn/problems/toggle-light-bulbs/description/
 * 给你一个整数数组 bulbs，其中每个元素的取值范围为 1 到 100。
 * 有 100 个电灯泡，按从 1 到 100 编号，初始时所有灯泡均为关闭状态。
 * 对于数组 bulbs 中的每一个元素 bulbs[i]，执行以下操作：
 * 如果第 bulbs[i] 个灯泡当前是关闭状态，将其打开。
 * 如果第 bulbs[i] 个灯泡当前是打开状态，将其关闭。
 * 返回一个整数列表，表示最终处于打开状态的灯泡编号，按升序排列。如果没有灯泡是打开的，返回一个空列表。
 *
 * 示例：
 * 输入1：bulbs = [10,30,20,10]
 * 输出1：[20,30]
 *
 * 输入2：bulbs = [100,100]
 * 输出2：[]
 */
public class T3842 {
    /**
     * 社区解法：统计哪些数出现了奇数次
     */
    public List<Integer> toggleLightBulbs(List<Integer> bulbs) {
        Map<Integer, Integer> map = new HashMap<>();
        for (Integer bulb : bulbs) {
            map.merge(bulb, 1, Integer::sum);
        }

        List<Integer> ans = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() % 2 > 0) {
                ans.add(entry.getKey());
            }
        }
        Collections.sort(ans);
        return ans;
    }
}
