package demo.c0easy;

import java.util.Arrays;

/**
 * 88  合并两个有序数组  https://leetcode.cn/problems/merge-sorted-array/
 * 给定两个非递减顺序排列数组 nums1 和 nums2，以及两个整数 m 和 n 表示两个数组中的元素数。
 * 将 nums2 合并到 nums1 中，按非递减顺序排列
 * 这个数组不返回，而是会校验 nums1 ，其初始长度为 m + n，超出的数据为 0
 *
 * 示例1：
 * 输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
 * 输出：[1,2,2,3,5,6]
 *
 * 示例2：
 * 输入：nums1 = [1], m = 1, nums2 = [], n = 0
 * 输出：[1]
 *
 * 示例3：
 * 输入：nums1 = [0], m = 0, nums2 = [1], n = 1
 * 输出：[1]
 */
public class T88 {
    /**
     * 自己实现：暴力法，将nums2全部数据先放到 nums1 后边，再重新排序
     */
    public void merge1(int[] nums1, int m, int[] nums2, int n) {
        //将nums2放入nums1中
        for (int i = m; i < m + n; i++) {
            nums1[i] = nums2[i - m];
        }

        //对nums1重新排序，调用API
//        Arrays.sort(nums1);

        //冒泡排序
        bubbleSort(nums1);
    }

    /**
     * 官方实现：双指针，因为原始的两个数组已经被排好序，只需要分别遍历两个数组即可
     */
    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        //第一个数组的指针
        int p1 = 0;
        //第二个数组的指针
        int p2 = 0;
        //存放结果
        int[] sorted = new int[m + n];
        //当前数
        int cur;
        //遍历两个数组，直到两个数组都被遍历完
        while (p1 < m || p2 < n) {
            //如果第一个数组已经遍历完了，就把第二个数组剩下的元素添加到后边
            if (p1 == m) {
                cur = nums2[p2++];
            } else if (p2 == n) {
                //如果第二个数组已经遍历完了，就把第一个数组剩下的元素添加到后边
                cur = nums1[p1++];
            } else if (nums1[p1] < nums2[p2]) {
                //如果第一个元素当前数比第二个元素当前数小，采用第一个数组的当前数
                cur = nums1[p1++];
            } else {
                cur = nums2[p2++];
            }

            //将当前应该放入的数放入结果数组，注意索引位置
            sorted[p1 + p2 - 1] = cur;
        }

        //将遍历后的结果复制回去
        for (int i = 0; i < m + n; i++) {
            nums1[i] = sorted[i];
        }
    }

    /**
     * 冒泡排序
     */
    public void bubbleSort(int[] arr) {
        int len = arr.length;
        if (len < 2) {
            return;
        }

        int temp = 0;

        //遍历每个元素，比较相邻的元素，如果第一个比第二个大，就进行交换
        //每轮循环结束后最大的那个元素就会放在最后
        for (int i = 0; i < len - 1; i++) {
            for (int j = 0; j < len - 1 - i; j++) {
                //将大的元素向后放
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    /**
     * 快速排序 将数组分成左右两个区间，左边都比基数小，右边都比基数大，然后重复该操作
     */
    public void quickSort(int[] arr, int start, int end) {
        int len = arr.length;
        if (len < 2) {
            return;
        }

        //把数组首位作为基数
        int stand = arr[start];
        //记录需要排序的下标
        int low = start;
        int high = end;

        //循环找到比基数大的数和比基数小的数
        while (low < high) {
            //右边的数字比基数大
            while (low < high && arr[high] >= stand) {
                high--;
            }
            //使用右边的数替换左边的书
            arr[low] = arr[high];
            //左边的数字比基数小
            while (low < high && arr[low] <= stand) {
                low++;
            }
            //使用左边的数替换右边的数
            arr[high] = arr[low];
        }

        //把标准值赋给下标重合的位置
        arr[low] = stand;
        //处理所有小的数字
        quickSort(arr, start, low);
        //处理所有大的数字
        quickSort(arr, low + 1, end);
    }

    public static void main(String[] args) {
        int[] arr = new int[6];
        arr[0] = 4;
        arr[1] = 5;
        arr[2] = 6;
        arr[3] = 1;
        arr[4] = 2;
        arr[5] = 3;

        selectSort(arr);

        System.out.println(Arrays.toString(arr));
    }

    /**
     * 直接插入排序
     */
    public static void insertSort(int[] arr) {
        //如果只有两位，就比较前两位
        if (arr.length == 2) {
            if (arr[0] > arr[1]) {
                int temp = arr[0];
                arr[0] = arr[1];
                arr[1] = temp;
            }
        }

        //遍历第二位后的所有数字
        for (int i = 1; i < arr.length; i++) {
            //如果当前数字比前一个数字小，就将其往前排
            if (arr[i] < arr[i - 1]) {
                int j;
                //临时存储当前数字
                int temp = arr[i];
                //将前边所有比当前数字大的数向后挪一位
                for (j = i - 1; j >= 0 && arr[j] > temp; j--) {
                    //向后挪一位
                    arr[j + 1] = arr[j];
                }

                //否则arr[j + 1]已经为比临时变量小的元素了，因为前边 j--
                arr[j + 1] = temp;
            }
        }
    }

    /**
     * 简单选择排序
     * 在未排序列表中找到最小的元素，放到排序序列的起始位置
     * 再从剩余排序元素中继续找到最小的元素，放在已排序序列的末尾，知道所有元素排序完毕
     */
    public static void selectSort(int[] arr) {
        //如果只有两位，就比较前两位
        if (arr.length == 2) {
            if (arr[0] > arr[1]) {
                int temp = arr[0];
                arr[0] = arr[1];
                arr[1] = temp;
            }
        }

        //遍历所有数
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            //把当前数和后边所有数进行比较，记录最小的数坐标
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    //更新最小数坐标
                    minIndex = j;
                }
            }

            //如果最小数坐标和当前数不一致，就交换
            if (i != minIndex) {
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
        }
    }

    /**
     * 归并排序：分治思想
     * 将一组序列分成两组，并分别进行排序，根据递归思想，将子序列再往下分，直到不可分为止
     * 最后进行合并：创建临时数组，
     */
    public void sortIntegers(int[] arr) {
        //处理边界条件
        if (arr == null || arr.length == 0) {
            return;
        }
        //临时数组，用来存储结果
        int[] temp = new int[arr.length];
        mergeSort(arr, 0, arr.length - 1, temp);
    }

    public void mergeSort(int[] arr, int start, int end, int[] temp) {
        if (start >= end) {
            return;
        }
        //处理左半区间——递归调用
        mergeSort(arr, start, (start + end) / 2, temp);
        //处理右半区间——递归调用
        mergeSort(arr, (start + end) / 2 + 1, end, temp);
        //合并排序数组
        merge(arr, start, end, temp);
    }

    //合并操作——因为是递归，所以实际是从已经细分到最小的数组开始一步一步合并回来的
    public void merge(int[] arr, int start, int end, int[] temp) {
        int middle = (start + end) / 2;
        //第一个数组中需要遍历的起始下标
        int leftIndex = start;
        //第二个数组中需要遍历的起使下标
        int rightIndex = middle + 1;
        //存放在临时数组的起使下标
        int index = start;

        //遍历两个数组，依次取出较小的数字，并放入临时数组
        while (leftIndex <= middle && rightIndex <= end) {
            //如果第一个数组的当前值比第二个数组的当前值小，将小的数字放入临时数组
            if (arr[leftIndex] < arr[rightIndex]) {
                //temp作为临时数组用来存储合并后的结果，并++将索引向后一位
                temp[index++] = arr[leftIndex++];
            } else {
                temp[index++] = arr[rightIndex++];
            }
        }

        //如果第一个数组还有剩余数据，将其放入临时数组中
        while (leftIndex <= middle) {
            temp[index++] = arr[leftIndex++];
        }

        //如果第二个数组还有剩余数据，将其放入临时数组中
        while (rightIndex <= end) {
            temp[index++] = arr[rightIndex++];
        }

        //将临时数组的数据放回原数组中，相当于已经排好序了，继续处理接下来的递归
        for (int i = start; i <= end; i++) {
            arr[i] = temp[i];
        }
    }

}
