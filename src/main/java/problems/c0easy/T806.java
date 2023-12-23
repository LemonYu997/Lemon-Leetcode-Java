package problems.c0easy;

/**
 * 806 写字符串需要的行数 https://leetcode.cn/problems/number-of-lines-to-write-string/
 * 把给定的字符串 S 从左到右写到每一行上，每一行的最大宽度为100个单位，
 * 如果在写某个字母的时候会使这行超过了 100 个单位，那么我们应该把这个字母写到下一行。
 * 我们给定了一个数组 widths ，这个数组 widths[0] 代表 'a' 需要的单位，
 * widths[1] 代表 'b' 需要的单位，...， widths[25] 代表 'z' 需要的单位。
 *
 * 至少多少行能放下S，以及最后一行使用的宽度是多少个单位？将答案作为长度为2的整数列表返回
 *
 * 示例：
 * 输入1：widths = [10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10]
 * S = "abcdefghijklmnopqrstuvwxyz"
 * 输出1：[3, 60]
 * 备注：所有的字符拥有相同的占用单位10。所以书写所有的26个字母，需要2个整行和占用60个单位的一行。
 *
 * 输入2：widths = [4,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10]
 * S = "bbbcccdddaaa"
 * 输出2：[2, 4]
 * 备注：除去字母'a'所有的字符都是相同的单位10，并且字符串 "bbbcccdddaa" 将会覆盖 9 * 10 + 2 * 4 = 98 个单位.
 * 最后一个字母 'a' 将会被写到第二行，因为第一行只剩下2个单位了。
 * 所以，这个答案是2行，第二行有4个单位宽度。
 */
public class T806 {
    /**
     * 自己实现：根据题意模拟
     */
    public int[] numberOfLines(int[] widths, String s) {
        //当前行的宽度，如果超过100重置为0
        int count = 0;
        int n = 1;  //行数 默认从第一行开始

        //遍历每一个字符，并找到其所需要的长度
        for (int i = 0; i < s.length(); i++) {
            //当前字符
            char c = s.charAt(i);
            //所需要的长度
            int l = widths[c - 'a'];

            //如果当前行宽度超过100，行数+1，并将该字符写入下一行
            if (count + l > 100) {
                n++;
                count = l;
            } else {
                //否则将该字符长度加入当前行长度上
                count += l;
            }
        }

        return new int[]{n, count};
    }
}
