package hello.c0datastructure.p4Heap;

import java.util.*;

/**
 * 堆 https://www.hello-algo.com/chapter_heap/heap/
 * 一种特殊的完全二叉树：
 *  小顶堆：任意节点值 <= 子节点值
 *  大顶堆：任意节点值 >= 子节点值
 *
 *  一般用优先队列实现，等同于堆
 */
public class Demo0Heap {
    public static void main(String[] args) {
        //初始化小顶堆，用优先队列实现
        Queue<Integer> minHeap = new PriorityQueue<>();
        //初始化大顶堆，用优先队列实现 使用 lambda 表达式修改 Comparator 即可
        Queue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

        //元素入堆 时间复杂度 O(log n)
        maxHeap.offer(1);
        maxHeap.offer(3);
        maxHeap.offer(2);
        maxHeap.offer(5);
        maxHeap.offer(4);
        System.out.println(maxHeap);    //[5, 4, 2, 1, 3]

        //获取堆顶元素 时间复杂度 O(1)
        Integer peek = maxHeap.peek();
        System.out.println(peek);       //5

        //堆顶元素出堆  时间复杂度 O(log n)
        Integer p1 = maxHeap.poll();
        System.out.println(p1);         //5
        Integer p2 = maxHeap.poll();
        System.out.println(p2);         //4
        Integer p3 = maxHeap.poll();
        System.out.println(p3);         //3
        Integer p4 = maxHeap.poll();
        System.out.println(p4);         //2
        Integer p5 = maxHeap.poll();
        System.out.println(p5);         //1

        //获取堆大小 时间复杂度 O(1)
        int size = maxHeap.size();
        System.out.println(size);       //0

        //判断堆是否为空 时间复杂度 O(1)
        boolean empty = maxHeap.isEmpty();
        System.out.println(empty);      //true

        //输入列表并建堆
        minHeap = new PriorityQueue<>(Arrays.asList(1, 3, 2, 5, 4));
        System.out.println(minHeap);    //[1, 3, 2, 5, 4]
    }

    //使用数组实现大顶堆
    class MaxHeap {
        private List<Integer> maxHeap;

        //构造函数 初始化堆
        public MaxHeap() {
            this.maxHeap = new ArrayList<>();
        }

        // 大小
        int size() {
            return maxHeap.size();
        }

        //是否为空
        boolean isEmpty() {
            return size() == 0;
        }

        // 获取左子节点的索引
        int left(int i) {
            return 2 * i + 1;
        }

        // 获取右子节点的索引
        int right(int i) {
            return 2 * i + 2;
        }

        // 获取父节点的索引
        int parent(int i) {
            // 向下整除
            return (i - 1) / 2;
        }

        //访问堆顶元素 即列表的首个元素
        int peek() {
            return maxHeap.get(0);
        }

        //元素入堆（底部） 由底至顶进行堆化（根据大小与顶部交换）
        void push(int val) {
            // 添加节点
            maxHeap.add(val);
            // 从底至顶堆化
            siftUp(size() - 1);
        }

        // 从节点 i 开始，从底至顶堆化
        void siftUp(int i) {
            while (true) {
                // 获取节点 i 的父节点
                int p = parent(i);
                // 当越过根节点或者节点无须修复时，结束堆化
                if (p < 0 || maxHeap.get(i) <= maxHeap.get(p)) {
                    break;
                }
                //交换两节点
                swap(i, p);
                //循环向上堆化
                i = p;
            }
        }

        //交换 i 和 p
        void swap(int i, int p) {
            int temp = maxHeap.get(i);
            maxHeap.set(i, maxHeap.get(p));
            maxHeap.set(p, temp);
        }

        /**
         * 堆顶元素出堆
         * 1、先交换堆顶和堆底元素（根节点和最右叶节点）
         * 2、删除堆底元素
         * 3、从堆顶开始，由顶至底进行堆化
         */
        int pop() {
            // 判空处理
            if (isEmpty()) {
                throw new IndexOutOfBoundsException();
            }
            // 交换根节点与最右叶子节点
            swap(0, size() - 1);
            // 删除最底节点
            Integer val = maxHeap.remove(size() - 1);
            // 从顶至底堆化
            siftDown(0);
            // 返回堆顶元素
            return val;
        }

        //由顶至底进行堆化
        void siftDown(int i) {
            while (true) {
                // 判断节点 i l r 中的最大节点，记为 ma
                int l = left(i);
                int r = right(i);
                int ma = i;
                if (l < size() && maxHeap.get(l) > maxHeap.get(ma)) {
                    ma = l;
                }
                if (r < size() && maxHeap.get(r) > maxHeap.get(ma)) {
                    ma = r;
                }
                // 若节点 i 最大或索引 l, r 越界，则无须继续堆化，跳出
                if (ma == i) {
                    break;
                }
                // 交换两节点
                swap(i, ma);
                // 循环向下堆化
                i = ma;
            }
        }

        /**
         * 建堆操作 使用已有数组建堆 时间复杂度 O(n)
         * 倒序遍历堆（层序遍历的倒序），依次对每个非叶节点执行“从顶至底堆化”
         */
        public MaxHeap(List<Integer> nums) {
            // 将列表元素原封不动添加到堆
            maxHeap = new ArrayList<>(nums);
            // 倒序遍历堆 堆化除叶节点以外的其他所有节点
            for (int i = parent(size() - 1); i >= 0; i--) {
                siftDown(i);
            }
        }
    }
}
