package problems.c0easy;

/**
 * 696 计数二进制子串 https://leetcode.cn/problems/count-binary-substrings/
 * 给定一个字符串s，统计并返回具有相同数量0和1的非空连续子字符串的数量，并且这些
 * 子字符串中的所有0和1都是组成连续的。
 * 重复出现（不同位置）的子串也要统计它们出现的次数。
 *
 * 示例：
 * 输入1：s = "00110011"
 * 输出1：6
 * 备注：6 个子串满足具有相同数量的连续 1 和 0 ："0011"、"01"、"1100"、"10"、"0011" 和 "01" 。
 * 注意，一些重复出现的子串（不同位置）要统计它们出现的次数。
 * 另外，"00110011" 不是有效的子串，因为所有的 0（还有 1 ）没有组合在一起。
 *
 * 输入2：s = "10101"
 * 输出2：4
 * 备注：有 4 个子串："10"、"01"、"10"、"01" ，具有相同数量的连续 1 和 0
 */
public class T696 {
    /**
     * 官方解法：字符串分组
     * 如 00111011，可以分组为 counts = {2, 3, 1, 2}
     * 则相邻的两个数字 u 和 v 中一定可以组成 min(u, v)个子串
     * 例如上边的 {2, 3}，可以组成 01、0011 两个子串
     * 只需要遍历 counts 并求 相邻最小值 的和即可
     */
    public int countBinarySubstrings(String s) {
        int i = 0;
        int n = s.length();
        int pre = 0;    //list中上一个的值
        int ans = 0;

        while (i < n) {
            //记录连续相同字符的长度
            char c = s.charAt(i);
            int count = 0;
            while (i < n && c == s.charAt(i)) {
                i++;
                count++;
            }

            //求 相邻最小值 的和
            ans += Math.min(count, pre);
            pre = count;
        }

        return ans;
    }

    /**
     * 评论解法1：中心扩展法
     */
    public int countBinarySubstrings1(String s) {
        char[] chars = s.toCharArray();
        int n = chars.length;
        int ans = 0;
        int l;  //左边界
        int r;  //右边界
        //因为子串最少长度为2，所以起始点 l < n - 1
        for (int i = 0; i < n - 1; i++) {
            l = i;
            r = l + 1;

            char cl = chars[l]; //左边扩展
            char cr = chars[r]; //右边扩展
            //如果是 00 或 11，不符合条件，直接下一次循环
            if (cl == cr) {
                continue;
            }
            //向左扩展和向右扩展，判断是否一致
            //如 cl = 0, 则向左扩展后判断是否仍未0
            while (r < n && l >= 0 && cl == chars[l] && cr == chars[r]) {
                ans++;
                l--;
                r++;
            }
        }

        return ans;
    }
}
