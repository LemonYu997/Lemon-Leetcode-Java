package problems.c0easy.t1001t1500;

import java.util.ArrayList;
import java.util.List;

/**
 * 1436 旅行终点站 https://leetcode.cn/problems/destination-city/description/
 * 给你一份旅游线路图，该线路图中的旅行线路用数组 paths 表示，
 * 其中 paths[i] = [cityAi, cityBi] 表示该线路将会从 cityAi 直接前往 cityBi 。
 * 请你找出这次旅行的终点站，即没有任何可以通往其他城市的线路的城市。
 * 题目数据保证线路图会形成一条不存在循环的线路，因此恰有一个旅行终点站。
 *
 * 示例：
 * 输入1：paths = [["London","New York"],["New York","Lima"],["Lima","Sao Paulo"]]
 * 输出1："Sao Paulo"
 *
 * 输入2：paths = [["B","C"],["D","B"],["C","A"]]
 * 输出2："A"
 *
 * 输入3：paths = [["A","Z"]]
 * 输出3："Z"
 */
public class T1436 {
    /**
     * 自己实现：[["B","C"],["D","B"],["C","A"]]
     * 只需要找出只在 String[i][1] 中存在的地点即可
     */
    public String destCity(List<List<String>> paths) {
        List<String> temp = new ArrayList<>();
        for (List<String> path : paths) {
            temp.add(path.get(0));
        }

        for (List<String> path : paths) {
            if (!temp.contains(path.get(1))) {
                return path.get(1);
            }
        }
        return "";
    }
}
