package problems.c0easy.t1501t2000;

import java.util.Arrays;

/**
 * 1710 卡车上的最大单元数 https://leetcode.cn/problems/maximum-units-on-a-truck/description/
 * 请你将一些箱子装在 一辆卡车 上。给你一个二维数组 boxTypes ，其中 boxTypes[i] = [numberOfBoxesi, numberOfUnitsPerBoxi] ：
 *
 * numberOfBoxesi 是类型 i 的箱子的数量。
 * numberOfUnitsPerBoxi 是类型 i 每个箱子可以装载的单元数量。
 * 整数 truckSize 表示卡车上可以装载 箱子 的 最大数量 。
 * 只要箱子数量不超过 truckSize ，你就可以选择任意箱子装到卡车上。
 *
 * 返回卡车可以装载 单元 的 最大 总数。
 *
 * 示例：
 * 输入1：boxTypes = [[1,3],[2,2],[3,1]], truckSize = 4
 * 输出1:8
 *
 * 输入2：boxTypes = [[5,10],[2,5],[4,7],[3,9]], truckSize = 10
 * 输出2：91
 */
public class T1710 {
    /**
     * 官方解法：根据题意，优先选择单元数最大的箱子
     * 将 boxTypes[i][j] 根据 j 逆序排序即可
     */
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a, b) -> b[1] - a[1]);
        int res = 0;
        for (int[] boxType : boxTypes) {
            int numberOfBoxes = boxType[0];
            int numberOfUnitsPerBox = boxType[1];
            if (numberOfBoxes < truckSize) {
                res += numberOfBoxes * numberOfUnitsPerBox;
                truckSize -= numberOfBoxes;
            } else {
                res += truckSize * numberOfUnitsPerBox;
                break;
            }
        }
        return res;
    }
}