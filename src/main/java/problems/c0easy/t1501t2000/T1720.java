package problems.c0easy.t1501t2000;

/**
 * 1720 解码异或后的数组 https://leetcode.cn/problems/decode-xored-array/description/
 * 未知 整数数组 arr 由 n 个非负整数组成。
 * 经编码后变为长度为 n - 1 的另一个整数数组 encoded ，其中 encoded[i] = arr[i] XOR arr[i + 1] 。
 * 例如，arr = [1,0,2,1] 经编码后得到 encoded = [1,2,3] 。
 * 给你编码后的数组 encoded 和原数组 arr 的第一个元素 first（arr[0]）。
 * 请解码返回原数组 arr 。可以证明答案存在并且是唯一的。
 *
 * 示例：
 * 输入1：encoded = [1,2,3], first = 1
 * 输出1：[1,0,2,1]
 *
 * 输入2：encoded = [6,2,7,3], first = 4
 * 输出2：[4,2,0,7,4]
 */
public class T1720 {
    /**
     * 自己实现：根据题意模拟
     */
    public int[] decode(int[] encoded, int first) {
        int n = encoded.length;
        int[] ans = new int[n + 1];
        ans[0] = first;

        // 再异或回去得到下一个数
        // 因为 encoded[i - 1] = ans[i - 1] ^ ans[i]，所以 ans[i] = encoded[i - 1] ^ ans[i - 1]
        for (int i = 1; i < n + 1; i++) {
            ans[i] = ans[i - 1] ^ encoded[i - 1];
        }

        return ans;
    }
}
