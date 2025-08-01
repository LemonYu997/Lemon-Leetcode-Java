package problems.c0easy.t2501t3000;

/**
 * 2582 递枕头 https://leetcode.cn/problems/pass-the-pillow/description/
 * n 个人站成一排，按从 1 到 n 编号。最初，排在队首的第一个人拿着一个枕头。每秒钟，
 * 拿着枕头的人会将枕头传递给队伍中的下一个人。一旦枕头到达队首或队尾，
 * 传递方向就会改变，队伍会继续沿相反方向传递枕头。
 *
 * 例如，当枕头到达第 n 个人时，TA 会将枕头传递给第 n - 1 个人，
 * 然后传递给第 n - 2 个人，依此类推。
 * 给你两个正整数 n 和 time ，返回 time 秒后拿着枕头的人的编号。
 *
 * 示例：
 * 输入1：n = 4, time = 5
 * 输出1：2
 *
 * 输入3：n = 3, time = 2
 * 输出3：3
 */
public class T2582 {
    /**
     * 自己实现：根据题意计算即可
     */
    public int passThePillow(int n, int time) {
        // 先计算可以进行的遍历次数（初始第一次遍历为0）
        int count = time / (n - 1);
        // 如果是奇数则最后一次为反向遍历，如果为偶数则最后一次为正向遍历
        if (count % 2 == 0) {
            // 正向遍历
            return 1 + (time % (n - 1));
        } else {
            // 反向遍历
            return n - (time % (n - 1));
        }
    }
}
