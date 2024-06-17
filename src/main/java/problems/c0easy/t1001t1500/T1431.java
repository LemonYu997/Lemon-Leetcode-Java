package problems.c0easy.t1001t1500;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 1431 拥有最多糖果的孩子 https://leetcode.cn/problems/kids-with-the-greatest-number-of-candies/description/
 * 给你一个数组 candies 和一个整数 extraCandies ，
 * 其中 candies[i] 代表第 i 个孩子拥有的糖果数目。
 * 对每一个孩子，检查是否存在一种方案，将额外的 extraCandies 个糖果分配给孩子们之后，
 * 此孩子有 最多 的糖果。注意，允许有多个孩子同时拥有 最多 的糖果数目。
 *
 * 示例：
 * 输入1：candies = [2,3,5,1,3], extraCandies = 3
 * 输出1：[true,true,true,false,true]
 *
 * 输入2：candies = [4,2,1,1,2], extraCandies = 1
 * 输出2：[true,false,false,false,false]
 *
 * 输入3：candies = [12,1,12], extraCandies = 10
 * 输出3：[true,false,true]
 */
public class T1431 {
    /**
     * 自己实现：先找到数组最大值 max，再遍历数组是否加上 extraCandies 是否 >= max
     */
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = Arrays.stream(candies).max().getAsInt();
        List<Boolean> ans = new ArrayList<>();

        for (int candy : candies) {
            if (candy + extraCandies >= max) {
                ans.add(true);
            } else {
                ans.add(false);
            }
        }

        return ans;
    }
}
