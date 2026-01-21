package problems.c0easy.t3001t3500;

/**
 * 3168 候诊室中的最少椅子数 https://leetcode.cn/problems/minimum-number-of-chairs-in-a-waiting-room/description/
 * 给你一个字符串 s，模拟每秒钟的事件 i：
 * 如果 s[i] == 'E'，表示有一位顾客进入候诊室并占用一把椅子。
 * 如果 s[i] == 'L'，表示有一位顾客离开候诊室，从而释放一把椅子。
 * 返回保证每位进入候诊室的顾客都能有椅子坐的 最少 椅子数，假设候诊室最初是 空的 。
 *
 * 示例：
 * 输入1：s = "EEEEEEE"
 * 输出1：7
 *
 * 输入2：s = "ELELEEL"
 * 输出2：2
 *
 * 输入3：s = "ELEELEELLL"
 * 输出3：3
 */
public class T3168 {
    /***
     * 自己实现：根据题意模拟队列，找到椅子数（队列大小）最大的时候的情况
     */
    public int minimumChairs(String s) {
        int count = 0;
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'E') {
                count++;
                ans = Math.max(ans, count);
            } else {
                count--;
            }
        }
        return ans;
    }
}
