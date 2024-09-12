package problems.c0easy.t1501t2000;

/**
 * 1629 按键持续时间最长的键 https://leetcode.cn/problems/slowest-key/description/
 * 给你一个长度为 n 的字符串 keysPressed ，其中 keysPressed[i] 表示测试序列中第 i 个被按下的键。
 * releaseTimes 是一个升序排列的列表，其中 releaseTimes[i] 表示松开第 i 个键的时间。
 * 字符串和数组的 下标都从 0 开始 。第 0 个键在时间为 0 时被按下，
 * 接下来每个键都 恰好 在前一个键松开时被按下。
 *
 * 测试人员想要找出按键 持续时间最长 的键。
 * 第 i 次按键的持续时间为 releaseTimes[i] - releaseTimes[i - 1] ，
 * 第 0 次按键的持续时间为 releaseTimes[0] 。
 * 注意，测试期间，同一个键可以在不同时刻被多次按下，而每次的持续时间都可能不同。
 * 请返回单次按键 持续时间最长 的键，如果有多个这样的键，则返回 按字母顺序排列最大 的那个键。
 *
 * 示例：
 * 输入1：releaseTimes = [9,29,49,50], keysPressed = "cbcd"
 * 输出1："c"
 *
 * 输入2：releaseTimes = [12,23,36,46,62], keysPressed = "spuda"
 * 输出2："a"
 */
public class T1629 {
    /**
     * 自己实现：遍历一次
     */
    public char slowestKey(int[] releaseTimes, String keysPressed) {
        int n = keysPressed.length();
        // 可以把第一个字符作为初始值
        int max = releaseTimes[0];
        char ans = keysPressed.charAt(0);

        // 从第二个开始遍历
        for (int i = 1; i < n; i++) {
            int temp = releaseTimes[i] - releaseTimes[i - 1];
            char tempc = keysPressed.charAt(i);
            // 更新最大字符
            if (temp > max) {
                max = temp;
                ans = tempc;
            } else if (temp == max) {
                // 如果长度一致，选择按字母顺序排列最大的那个键
                if (tempc > ans) {
                    ans = tempc;
                }
            }
        }

        return ans;
    }
}
