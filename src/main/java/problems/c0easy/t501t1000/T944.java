package problems.c0easy.t501t1000;

/**
 * 944 删列造序 https://leetcode.cn/problems/delete-columns-to-make-sorted/
 * 给你由 n 个小写字母字符串组成的数组 strs，其中每个字符串长度相等。
 * 这些字符串可以每个一行，排成一个网格。例如，strs = ["abc", "bce", "cae"] 可以排列为：
 * abc
 * bce
 * cae
 * 你需要找出并删除 不是按字典序非严格递增排列的 列。在上面的例子（下标从 0 开始）中，
 * 列 0（'a', 'b', 'c'）和列 2（'c', 'e', 'e'）都是按字典序非严格递增排列的，
 * 而列 1（'b', 'c', 'a'）不是，所以要删除列 1 。
 * 返回你需要删除的列数。
 *
 * 示例：
 * 输入1：strs = ["cba","daf","ghi"]
 * 输出1：1
 *
 * 输入2：strs = ["a","b"]
 * 输出2：0
 *
 * 输入3：strs = ["zyx","wvu","tsr"]
 * 输出3：3
 */
public class T944 {
    public static void main(String[] args) {
        String[] strs = {"cba", "daf", "ghi"};
        System.out.println(minDeletionSize(strs));
    }

    /**
     * 自己实现：根据题意，遍历每一列是否顺序一致即可
     */
    public static int minDeletionSize(String[] strs) {
        int n = strs.length;
        int m = strs[0].length();
        int ans = 0;

        for (int j = 0; j < m; j++) {
            for (int i = 0; i + 1 < n; i++) {
                if (strs[i + 1].charAt(j) < strs[i].charAt(j)) {
                    ans++;
                    break;
                }
            }
        }

        return ans;
    }
}
