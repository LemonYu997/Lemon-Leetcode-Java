package problems.c0easy.t1001t1500;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 1200 最小绝对差 https://leetcode.cn/problems/minimum-absolute-difference/description/
 * 给你个整数数组 arr，其中每个元素都 不相同。
 * 请你找到所有具有最小绝对差的元素对，并且按升序的顺序返回。
 * 每对元素对 [a,b] 如下：
 *  1、a , b 均为数组 arr 中的元素
 *  2、a < b
 *  3、b - a 等于 arr 中任意两个元素的最小绝对差
 *
 * 输入1：arr = [4,2,1,3]
 * 输出1：[[1,2],[2,3],[3,4]]
 *
 * 输入2：arr = [1,3,6,10,15]
 * 输出2：[[1,3]]
 *
 * 输入3：arr = [3,8,-10,23,19,-4,-14,27]
 * 输出3：[[-14,-10],[19,23],[23,27]]
 */
public class T1200 {
    /**
     * 自己实现：遍历，找到最小差值及其对应的元素对
     * 会超时
     */
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>> ans = new ArrayList<>();

        int n = arr.length;
        // 最小差值
        int minDiff = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int diff = Math.abs(arr[j] - arr[i]);
                if (diff <= minDiff) {
                    if (diff < minDiff) {
                        // 如果差值更小，就清空 List
                        ans.clear();
                    }
                    List<Integer> temp = new ArrayList<>();
                    if (arr[i] < arr[j]) {
                        temp.add(arr[i]);
                        temp.add(arr[j]);
                    } else {
                        temp.add(arr[j]);
                        temp.add(arr[i]);
                    }
                    ans.add(temp);
                    // 更新最小差值
                    minDiff = diff;
                }
            }
        }

        // 将 ans 中对 List<Integer>(0) 进行排序
        ans = ans.stream().sorted(Comparator.comparing(list -> list.get(0))).collect(Collectors.toList());
        return ans;
    }

    /**
     * 官方解法：排序加一次遍历
     */
    public List<List<Integer>> minimumAbsDifference1(int[] arr) {
        int n = arr.length;
        Arrays.sort(arr);
        // 最小差值
        int best = Integer.MAX_VALUE;
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        for (int i = 0; i < n - 1; i++) {
            // 当前差值
            int delta = arr[i + 1] - arr[i];
            // 更新最小差值
            if (delta < best) {
                best = delta;
                ans.clear();
                List<Integer> pair = new ArrayList<>();
                pair.add(arr[i]);
                pair.add(arr[i + 1]);
                ans.add(pair);
            } else if (delta == best) {
                List<Integer> pair = new ArrayList<>();
                pair.add(arr[i]);
                pair.add(arr[i + 1]);
                ans.add(pair);
            }
        }

        return ans;
    }
}
