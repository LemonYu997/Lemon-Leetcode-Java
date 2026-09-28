package problems.c0easy.t4001t4500;

/**
 * 4020 电梯请求 I https://leetcode.cn/problems/elevator-requests-i/description/
 * 给你一个整数 n ，表示一栋楼房的楼层数，楼层编号从 0 到 n - 1 。
 * 同时给你一个整数数组 requests ，其中 requests 表示楼层请求的序列。
 * 一部电梯初始在 0 层，遵循以下规则：
 * 电梯每秒移动一层。
 * 电梯按给定的顺序处理请求。
 * 如果电梯已经在请求的楼层，则不需要移动。
 * 处理完一个请求后，电梯立即开始向下一个请求的楼层移动。
 * 返回处理所有请求所需的 总时间 （以秒为单位）。
 *
 * 示例：
 * 输入1：n = 5, requests = [2,1,4,3]
 * 输出1：7
 *
 * 输入2：n = 3, requests = [2,0,0]
 * 输出2：4
 */
public class T4020 {
    /**
     * 自己实现：相邻元素差值求和即可
     */
    public int elevatorRequests(int n, int[] requests) {
        int ans = requests[0] - 1;
        for (int i = 1; i < requests.length; i++) {
            ans += Math.abs(requests[i] - requests[i - 1]);
        }
        return ans;
    }

    /**
     * 社区解法：优化写法
     */
    public int elevatorRequests1(int n, int[] requests) {
        int ans = 0;
        int pre = 0;
        for (int req : requests) {
            ans += Math.abs(pre - req);
            pre = req;
        }
        return ans;
    }
}