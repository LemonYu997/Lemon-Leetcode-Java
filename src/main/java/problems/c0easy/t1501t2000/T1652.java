package problems.c0easy.t1501t2000;

/**
 * 1652 拆炸弹 https://leetcode.cn/problems/defuse-the-bomb/description/
 * 你有一个炸弹需要拆除，时间紧迫！你的情报员会给你一个长度为 n 的 循环 数组 code 以及一个密钥 k 。
 * 为了获得正确的密码，你需要替换掉每一个数字。所有数字会 同时 被替换。
 *
 * 如果 k > 0 ，将第 i 个数字用 接下来 k 个数字之和替换。
 * 如果 k < 0 ，将第 i 个数字用 之前 k 个数字之和替换。
 * 如果 k == 0 ，将第 i 个数字用 0 替换。
 * 由于 code 是循环的， code[n-1] 下一个元素是 code[0] ，且 code[0] 前一个元素是 code[n-1] 。
 *
 * 给你 循环 数组 code 和整数密钥 k ，请你返回解密后的结果来拆除炸弹！
 *
 * 示例：
 * 输入1：code = [5,7,1,4], k = 3
 * 输出1：[12,10,16,13]
 *
 * 输入2：code = [1,2,3,4], k = 0
 * 输出2：[0,0,0,0]
 *
 * 输入3：code = [2,4,9,3], k = -2
 * 输出3：[12,5,6,13]
 */
public class T1652 {
    /**
     * 自己实现：创建新数组存储
     */
    public int[] decrypt(int[] code, int k) {
        int n = code.length;
        int[] ans = new int[n];
        if (k == 0) {
            return ans;
        }
        // 向后求和
        if (k > 0) {
            // 计算每一位
            for (int i = 0; i < n; i++) {
                // 计算后几位的和，如果超出了 n，从头开始
                for (int j = 0; j < k; j++) {
                    if (i + j + 1 >= n) {
                        ans[i] += code[i + j + 1 - n];
                    } else {
                        ans[i] += code[i + j + 1];
                    }
                }
            }
        }

        // 向前求和
        if (k < 0) {
            for (int i = 0; i < n; i++) {
                // 计算后几位的和
                for (int j = 0; j < -k; j++) {
                    if (i - j - 1 < 0) {
                        ans[i] += code[i - j - 1 + n];
                    } else {
                        ans[i] += code[i - j - 1];
                    }
                }
            }
        }

        return ans;
    }

    /**
     * 官方解法：滑动窗口
     */
    public int[] decrypt1(int[] code, int k) {
        int n = code.length;
        if (k == 0) {
            return new int[n];
        }

        int[] res = new int[n];
        // 复制原数组两次，方便在超出范围时进行取值
        int[] newCode = new int[n * 2];
        System.arraycopy(code, 0, newCode, 0, n);
        System.arraycopy(code, 0, newCode, n, n);
        code = newCode;

        // 设置左右指针 k > 0时，从前往后，k < 0时
        int l = k > 0 ? 1 : n + k;
        int r = k > 0 ? k : n - 1;
        int w = 0;
        // 初始值
        for (int i = l; i <= r; i++) {
            w += code[i];
        }
        // 更新每个值，指针向前移动
        for (int i = 0; i < n; i++) {
            res[i] = w;
            w -= code[l];
            w += code[r + 1];
            l++;
            r++;
        }

        return res;
    }
}
