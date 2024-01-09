package hello.c1algorithm.p1Sort;

/**
 * 堆排序
 * 1、输入数组并建立大顶堆，完成后，最大元素位于堆顶
 * 2、将堆顶元素（第一个元素）与堆底元素（最后一个元素交换），交换后，堆长度减 1，已排序元素数加 1
 * 3、从堆顶元素开始，由顶至底执行堆化操作
 * 4、循环执行
 *
 * 时间复杂度 O(n logn)
 * 空间复杂度 O(1)
 */
public class Demo5HeapSort {
    /**
     * 堆排序
     */
    void heapSort(int[] nums) {
        // 建堆操作：堆化除叶节点以外的其他所有节点
        for (int i = nums.length / 2 - 1; i >= 0; i--) {
            siftDown(nums, nums.length, i);
        }
        // 从堆中提取最大元素，循环 n - 1 轮
        for (int i = nums.length - 1; i >= 0; i--) {
            // 交换根节点与最右叶节点（首元素与尾元素）
            int temp = nums[0];
            nums[0] = nums[i];
            nums[i] = temp;
            // 以根节点为起点，由顶至底执行堆化
            siftDown(nums, nums.length, 0);
        }
    }

    /**
     * 堆的长度为 n，从节点 i 开始，从顶至底堆化
     */
    void siftDown(int[] nums, int n, int i) {
        while (true) {
            // 判断节点 i l r 中的最大节点，记为 ma
            int l = 2 * i + 1;
            int r = 2 * i + 2;
            int ma = i;
            if (l < n && nums[l] > nums[ma]) {
                ma = l;
            }
            if (r < n && nums[r] > nums[ma]) {
                ma = r;
            }
            // 若节点 i 最大或者索引 l、r 越界，无须继续，跳出
            if (ma == i) {
                break;
            }
            // 交换两节点
            int temp = nums[i];
            nums[i] = nums[ma];
            nums[ma] = temp;
            // 循环向下堆化
            i = ma;
        }
    }
}
