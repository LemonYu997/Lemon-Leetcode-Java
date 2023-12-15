package problems.c0easy;

import java.util.ArrayList;
import java.util.List;

/**
 * 401 二进制手表 https://leetcode.cn/problems/binary-watch/
 * 二进制手表顶部有4个LED表示小时，底部有6个LED表示分钟
 * 每个LED代表一个0或1，最低位在右侧
 * 给定一个整数turnedOn，表示当前亮着的的LED数量，返回可能表示的所有时间
 *
 * 示例：
 * 输入1：turnedOn = 1
 * 输出1：["0:01","0:02","0:04","0:08","0:16","0:32","1:00","2:00","4:00","8:00"]
 *
 * 输入2：turnedOn = 9
 * 输出2：[]
 */
public class T401 {
    /**
     * 官方解法：遍历所有情况
     */
    public List<String> readBinaryWatch1(int turnedOn) {
        List<String> ans = new ArrayList<>();
        for (int h = 0; h < 12; h++) {
            for (int m = 0; m < 60; m++) {
                //Integer.bitCount()用来获取二进制整数中有多少个1
                if (Integer.bitCount(h) + Integer.bitCount(m) == turnedOn) {
                    ans.add(h + ":" + (m < 10 ? "0" : "") + m);
                }
            }
        }

        return ans;
    }
}
