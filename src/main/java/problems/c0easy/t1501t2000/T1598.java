package problems.c0easy.t1501t2000;

/**
 * 1598 文件夹操作日志搜集器 https://leetcode.cn/problems/crawler-log-folder/description/
 * 每当用户执行变更文件夹操作时，LeetCode 文件系统都会保存一条日志记录。
 * 下面给出对变更操作的说明：
 *  "../" ：移动到当前文件夹的父文件夹。如果已经在主文件夹下，则 继续停留在当前文件夹 。
 *   "./" ：继续停留在当前文件夹。
 *  "x/" ：移动到名为 x 的子文件夹中。题目数据 保证总是存在文件夹 x 。
 *  给你一个字符串列表 logs ，其中 logs[i] 是用户在 ith 步执行的操作。
 * 文件系统启动时位于主文件夹，然后执行 logs 中的操作。
 * 执行完所有变更文件夹操作后，请你找出 返回主文件夹所需的最小步数 。
 *
 * 示例：
 * 输入1：logs = ["d1/","d2/","../","d21/","./"]
 * 输出1：2
 *
 * 输入2：logs = ["d1/","d2/","./","d3/","../","d31/"]
 * 输出2：3
 *
 * 输入3：logs = ["d1/","../","../","../"]
 * 输出3：0
 */
public class T1598 {
    /**
     * 自己实现：遍历一遍统计即可
     * 遇到 ../ 次数减 1，遇到 ./ 次数不变，遇到其他 次数加 1
     */
    public int minOperations(String[] logs) {
        int ans = 0;
        for (String log : logs) {
            // 如果结果已经为 0 了就不会再减
            if ("../".equals(log) && ans > 0) {
                ans--;
            } else if (!"./".equals(log) && !"../".equals(log)) {
                ans++;
            }
        }
        return ans;
    }
}
