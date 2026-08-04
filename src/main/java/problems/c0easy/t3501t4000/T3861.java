package problems.c0easy.t3501t4000;

/**
 * 3861 容量最小的箱子 https://leetcode.cn/problems/minimum-capacity-box/description/
 * 给你一个整数数组 capacity，其中 capacity[i] 表示第 i 个箱子的容量，以及一个整数 itemSize，表示一个物品的大小。
 * 如果第 i 个箱子的容量满足 capacity[i] >= itemSize，那么该箱子可以存放该物品。
 * 要求返回可以存放该物品的容量 最小 的箱子的下标。如果有多个这样的箱子，返回下标 最小 的一个。
 * 如果没有任何箱子可以存放该物品，则返回 -1。
 *
 * 示例：
 * 输入1：capacity = [1,5,3,7], itemSize = 3
 * 输出1：2
 *
 * 输入2：capacity = [3,5,4,3], itemSize = 2
 * 输出2：0
 *
 * 输入3：capacity = [4], itemSize = 5
 * 输出3：-1
 */
public class T3861 {
    /**
     * 自己实现：顺序遍历，找到符合要求的最小值及其最小索引
     */
    public int minimumIndex(int[] capacity, int itemSize) {
        int minV = -1;
        int minI = -1;

        for (int i = 0; i < capacity.length; i++) {
            if (capacity[i] >= itemSize) {
                if (minV == -1) {
                    minV = capacity[i];
                    minI = i;
                } else {
                    if (capacity[i] < minV) {
                        minV = capacity[i];
                        minI = i;
                    }
                }
            }
        }

        return minI;
    }


    /**
     * 社区解法：优化写法
     */
    public int minimumIndex1(int[] capacity, int itemSize) {
        int minC = Integer.MAX_VALUE;
        int ans = -1;
        for (int i = 0; i < capacity.length; i++) {
            int c = capacity[i];
            if (c >= itemSize && c < minC) {
                minC = c;
                ans = i;
            }
        }
        return ans;
    }
}