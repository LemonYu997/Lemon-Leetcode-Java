package problems.c0easy;

/**
 * 1089 复写零 https://leetcode.cn/problems/duplicate-zeros/description/
 * 给你一个长度固定的整数数组 arr ，请你将该数组中出现的每个零都复写一遍，并将其余的元素向右平移。
 * 注意：请不要在超过该数组长度的位置写入元素。
 * 请对输入的数组 就地 进行上述修改，不要从函数返回任何东西。
 *
 * 示例：
 * 输入1：arr = [1,0,2,3,0,4,5,0]
 * 输出1：[1,0,0,2,3,0,0,4]
 *
 * 输入2：arr = [1,2,3]
 * 输出2：[1,2,3]
 */
public class T1089 {
    /**
     * 官方解法：双指针
     */
    public void duplicateZeros(int[] arr) {
        int n = arr.length;
        int top = 0;
        int i = -1;
        while (top < n) {
            i++;
            if (arr[i] != 0) {
                top++;
            } else {
                top += 2;
            }
        }
        int j = n - 1;
        if (top == n + 1) {
            arr[j] = 0;
            j--;
            i--;
        }
        while (j >= 0) {
            arr[j] = arr[i];
            j--;
            if (arr[i] == 0) {
                arr[j] = arr[i];
                j--;
            }
            i--;
        }
    }
}
