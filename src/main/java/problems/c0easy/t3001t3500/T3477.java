package problems.c0easy.t3001t3500;

/**
 * 3477 水果成篮 II https://leetcode.cn/problems/fruits-into-baskets-ii/description/
 * 给你两个长度为 n 的整数数组，fruits 和 baskets，其中 fruits[i] 表示第 i 种水果的 数量，baskets[j] 表示第 j 个篮子的 容量。
 * 你需要对 fruits 数组从左到右按照以下规则放置水果：
 * 每种水果必须放入第一个 容量大于等于 该水果数量的 最左侧可用篮子 中。
 * 每个篮子只能装 一种 水果。
 * 如果一种水果 无法放入 任何篮子，它将保持 未放置。
 * 返回所有可能分配完成后，剩余未放置的水果种类的数量。
 *
 * 示例：
 * 输入1：fruits = [4,2,5], baskets = [3,5,4]
 * 输出1：1
 *
 * 输入2：fruits = [3,6,1], baskets = [6,4,7]
 * 输出2：0
 */
public class T3477 {
    /**
     * 官方解法：模拟
     */
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int count = 0;
        int n = baskets.length;
        for (int fruit : fruits) {
            int unset = 1;
            for (int i = 0; i < n; i++) {
                if (fruit <= baskets[i]) {
                    baskets[i] = 0;
                    unset = 0;
                    break;
                }
            }
            count += unset;
        }
        return count;
    }
}
