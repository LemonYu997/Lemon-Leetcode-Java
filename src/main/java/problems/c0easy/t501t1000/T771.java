package problems.c0easy.t501t1000;

import java.util.HashSet;
import java.util.Set;

/**
 * 771 宝石与石头 https://leetcode.cn/problems/jewels-and-stones/
 * 给你一个字符串 jewels 代表石头中宝石的类型，另有一个字符串 stones 代表你拥有的石头。
 * stones 中每个字符代表了一种你拥有的石头的类型，你想知道你拥有的石头中有多少是宝石。
 *
 * 字母区分大小写，因此 "a" 和 "A" 是不同类型的石头。
 *
 * 示例：
 * 输入1：jewels = "aA", stones = "aAAbbbb"
 * 输出1：3
 *
 * 输入2：jewels = "z", stones = "ZZ"
 * 输出2：0
 */
public class T771 {
    /**
     * 自己实现：暴力解法
     */
    public int numJewelsInStones(String jewels, String stones) {
        int count = 0;
        int m = jewels.length();
        int n = stones.length();

        //遍历每一块石头，判断是否属于宝石
        for (int i = 0; i < n; i++) {
            char stone = stones.charAt(i);
            for (int j = 0; j < m; j++) {
                char jewel = jewels.charAt(j);
                //如果属于宝石，计数+1，退出循环
                if (stone == jewel) {
                    count++;
                    break;
                }
            }
        }

        return count;
    }

    /**
     * 官方解法：使用HashSet存储宝石
     */
    public int numJewelsInStones1(String jewels, String stones) {
        int count = 0;
        Set<Character> jewelsSet = new HashSet<>();
        int m = jewels.length();
        int n = stones.length();

        //将宝石放入set中
        for (int i = 0; i < m; i++) {
            jewelsSet.add(jewels.charAt(i));
        }

        //遍历石头，判断其是否为宝石
        for (int i = 0; i < n; i++) {
            char c = stones.charAt(i);
            if (jewelsSet.contains(c)) {
                count++;
            }
        }

        return count;
    }

}
