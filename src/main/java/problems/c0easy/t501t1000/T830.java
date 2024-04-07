package problems.c0easy.t501t1000;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 830 较大分组的位置 https://leetcode.cn/problems/positions-of-large-groups/
 * 在一个由小写字母构成的字符串 s 中，包含由一些连续的相同字符所构成的分组。
 * 例如，在字符串 s = "abbxxxxzyy" 中，就含有 "a", "bb", "xxxx", "z" 和 "yy" 这样的一些分组。
 * 分组可以用区间 [start, end] 表示，其中 start 和 end 分别表示该分组的起始和终止位置的下标。
 * 上例中的 "xxxx" 分组用区间表示为 [3,6]
 *
 * 所有包含大于或等于三个连续字符的分组为 较大分组
 * 找到每一个 较大分组 的区间，按起始位置下标递增顺序排序后，返回结果。
 *
 * 示例：
 * 输入1：s = "abbxxxxzzy"
 * 输出1：[[3,6]]
 * 备注："xxxx" 是一个起始于 3 且终止于 6 的较大分组。
 *
 * 输入2：s = "abc"
 * 输出2：[]
 * 备注："a","b" 和 "c" 均不是符合要求的较大分组。
 *
 * 输入3：s = "abcdddeeeeaabbbcd"
 * 输出3：[[3,5],[6,9],[12,14]]
 * 备注：较大分组为 "ddd", "eeee" 和 "bbb"
 */
public class T830 {
    /**
     * 自己实现：根据题意模拟
     */
    public List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> ans = new ArrayList<>();

        int n = s.length();

        int[] temp = new int[2];
        int i = 1;  //从第二个字符开始遍历
        int l = 1;  //带上第一个字符，所以初始长度为1

        //结尾字符也要判断是否符合条件，所以 <= n
        while (i <= n) {
            //到结尾字符 n - 1之后，下一次循环就进入结果判断
            if (i != n && s.charAt(i) == s.charAt(i - 1)) {
                //如果当前字符与前一个字符相等，更新长度和结束位置
                l++;
                temp[1] = i;
            } else {
                //如果不一致 判断上个字符串是否满足较大分组条件
                if (l >= 3) {
                    //较大分组 放入结果
                    List<Integer> list = new ArrayList<>(2);
                    list.add(temp[0]);
                    list.add(temp[1]);
                    ans.add(list);
                }

                //重置l和temp
                l = 1;
                temp[0] = i;
                temp[1] = i;
            }

            i++;
        }

        return ans;
    }

    /**
     * 官方解法：使用for循环
     */
    public List<List<Integer>> largeGroupPositions1(String s) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        int n = s.length();
        int num = 1;
        for (int i = 0; i < n; i++) {
            if (i == n - 1 || s.charAt(i) != s.charAt(i + 1)) {
                if (num >= 3) {
                    //记录索引
                    ret.add(Arrays.asList(i - num + 1, i));
                }
                //重置
                num = 1;
            } else {
                num++;
            }
        }
        return ret;
    }
}
