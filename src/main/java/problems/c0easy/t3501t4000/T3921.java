package problems.c0easy.t3501t4000;

/**
 * 3921 分数验证器 https://leetcode.cn/problems/score-validator/description/
 * 给你一个字符串数组 events。
 * 一开始，score = 0 且 counter = 0。events 中的每个元素为以下之一：
 * "0", "1", "2", "3", "4", "6"：将该值加到总得分中。
 * "W"：计数器加 1。不增加得分。
 * "WD"：总得分加 1。
 * "NB"：总得分加 1。
 * 从左到右处理数组。当满足以下任一条件时停止处理：
 * events 中的所有元素都已处理完毕，或
 * 计数器变为 10。
 * 返回一个整数数组 [score, counter]，其中：
 * score 是最终的总得分。
 * counter 是最终的计数器值。
 *
 * 示例：
 * 输入1：events = ["1","4","W","6","WD"]
 * 输出1：[12,1]
 *
 * 输入2：events = ["WD","NB","0","4","4"]
 * 输出2：[10,0]
 *
 * 输入3：events = ["W","W","W","W","W","W","W","W","W","W","W"]
 * 输出3：[0,10]
 */
public class T3921 {
    /**
     * 自己实现：根据题意模拟
     */
    public int[] scoreValidator(String[] events) {
        int score = 0;
        int counter = 0;
        for (String event : events) {
            if ("1".equals(event) || "2".equals(event) || "3".equals(event)
                    || "4".equals(event) || "5".equals(event) || "6".equals(event)) {
                score += Integer.parseInt(event);
            }
            if ("WD".equals(event) || "NB".equals(event)) {
                score++;
            }
            if ("W".equals(event)) {
                counter++;
            }
            if (counter == 10) {
                return new int[]{score, counter};
            }
        }
        return new int[]{score, counter};
    }

    /**
     * 社区解法：优化写法
     */
    public int[] scoreValidator1(String[] events) {
        int score = 0;
        int counter = 0;

        for (String s : events) {
            if (s.equals("W")) {
                counter++;
                if (counter == 10) {
                    break;
                }
            } else if (s.length() > 1) { // "WD" "NB"
                score++;
            } else { // 数字
                score += s.charAt(0) - '0';
            }
        }

        return new int[]{score, counter};
    }
}