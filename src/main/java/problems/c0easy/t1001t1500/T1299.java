package problems.c0easy.t1001t1500;

/**
 * 1299 将每个元素替换为右侧最大元素 https://leetcode.cn/problems/replace-elements-with-greatest-element-on-right-side/description/
 * 给你一个数组 arr ，请你将每个元素用它右边最大的元素替换，
 * 如果是最后一个元素，用 -1 替换。
 * 完成所有替换操作后，请你返回这个数组。
 *
 * 示例：
 * 输入1：arr = [17,18,5,4,6,1]
 * 输出1：[18,6,6,6,1,-1]
 *
 * 输入2：arr = [400]
 * 输出2：[-1]
 */
public class T1299 {
    /**
     * 自己实现：遍历
     */
    public int[] replaceElements(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            // 最后一个元素为 -1，当遍历到最后一个元素时会直接跳过下边的循环
            int max = -1;
            // 找到右边最大的元素
            for (int j = i + 1; j < n; j++) {
                if (arr[j] > max) {
                    max = arr[j];
                }
            }
            arr[i] = max;
        }

        return arr;
    }

    /**
     * 官方解法：倒序遍历
     */
    public int[] replaceElements1(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        ans[n - 1] = -1;

        // 倒序遍历
        for (int i = n - 2; i >= 0; i--) {
            // 因为右边的数字已经是最大的，只需要与当前位数字比较饥渴
            ans[i] = Math.max(ans[i + 1], arr[i + 1]);
        }

        return ans;
    }
}
