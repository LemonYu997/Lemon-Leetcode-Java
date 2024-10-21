package problems.c0easy.t1501t2000;

/**
 * 1732 找到最高海拔
 * 有一个自行车手打算进行一场公路骑行，这条路线总共由 n + 1 个不同海拔的点组成。
 * 自行车手从海拔为 0 的点 0 开始骑行。
 * 给你一个长度为 n 的整数数组 gain ，其中 gain[i] 是点 i 和点 i + 1 的 净海拔高度差（0 <= i < n）。
 * 请你返回 最高点的海拔 。
 *
 * 示例：
 * 输入1：gain = [-5,1,5,0,-7]
 * 输出1:1
 *
 * 输入2：gain = [-4,-3,-2,-1,4,3,2]
 * 输出2:0
 */
public class T1732 {
    /**
     * 自己实现：根据题意，依次遍历相加即可
     * 备注：这也是个简单的前缀和思想，即依次相加每一项并记录
     */
    public int largestAltitude(int[] gain) {
        int ans = 0;
        int high = 0;
        for (int i : gain) {
            high += i;
            ans = Math.max(ans, high);
        }

        return ans;
    }
}
