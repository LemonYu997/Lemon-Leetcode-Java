package problems.c0easy.t501t1000;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 888 公平的糖果交换 https://leetcode.cn/problems/fair-candy-swap/
 * 爱丽丝和鲍勃拥有不同总数量的糖果，给定两个数组 aliceSizes 和 bobSizes ，
 * aliceSizes[i] 是爱丽丝拥有的第 i 盒糖果中的糖果数量，
 * bobSizes[j] 是鲍勃拥有的第 j 盒糖果中的糖果数量。
 *
 * 两人想要互相交换一盒糖果，这样在交换之后，他们就可以拥有相同总数量的糖果。
 * 一个人拥有的糖果总数量是他们每盒糖果数量的总和。
 *
 * 返回一个整数数组 answer，其中 answer[0] 是爱丽丝必须交换的糖果盒中的糖果的数目，
 * answer[1] 是鲍勃必须交换的糖果盒中的糖果的数目。
 * 如果存在多个答案，你可以返回其中 任何一个 。题目测试用例保证存在与输入对应的答案。
 *
 * 示例：
 * 输入1：aliceSizes = [1,1], bobSizes = [2,2]
 * 输出1：[1,2]
 *
 * 输入2：aliceSizes = [1,2], bobSizes = [2,3]
 * 输出2：[1,2]
 *
 * 输入3：aliceSizes = [2], bobSizes = [1,3]
 * 输出3：[2,3]
 *
 * 输入4：aliceSizes = [1,2,5], bobSizes = [2,4]
 * 输出4：[5,4]
 */
public class T888 {
    /**
     * 自己实现：先各自遍历求和，再取两和的平均数，为目标数
     * 遍历交换两者盒子，到两者均满足目标数为止
     */
    public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
        int aliceSum = sum(aliceSizes);
        int bobSum = sum(bobSizes);
        // 取两和的平均数，为目标数
        int target = (aliceSum + bobSum) / 2;

        int[] ans = new int[2];

        // 遍历交换两者盒子，到两者均满足目标数为止
        for (int aliceSize : aliceSizes) {
            for (int bobSize : bobSizes) {
                if (aliceSum - aliceSize + bobSize == target &&
                        bobSum - bobSize + aliceSize == target) {
                    ans[0] = aliceSize;
                    ans[1] = bobSize;
                }
            }
        }
        return ans;
    }

    int sum (int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return sum;
    }

    /**
     * 官方解法：哈希表
     * 根据题意有以下条件成立：
     *  sumA - x + y = sumB + x - y
     * 即：
     *  x = y + (sumA - sumB) / 2
     * 若存在这样的 x、y，即可返回
     */
    public int[] fairCandySwap1(int[] aliceSizes, int[] bobSizes) {
        int sumA = Arrays.stream(aliceSizes).sum();
        int sumB = Arrays.stream(bobSizes).sum();
        int delta = (sumA - sumB) / 2;
        Set<Integer> rec = new HashSet<>();
        for (int num : aliceSizes) {
            rec.add(num);
        }

        int[] ans = new int[2];
        for (int y : bobSizes) {
            int x = y + delta;
            if (rec.contains(x)) {
                ans[0] = x;
                ans[1] = y;
                break;
            }
        }
        return ans;
    }
}
