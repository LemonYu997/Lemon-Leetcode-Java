package hello.c0datastructure.p0arrayAndLinked;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 列表 https://www.hello-algo.com/chapter_array_and_linkedlist/list/
 * 元素的有序集合
 *
 * 常见操作：
 * 1、初始化
 * 2、访问元素
 * 3、插入与删除元素
 * 4、遍历列表
 * 5、拼接列表
 * 6、排序列表
 */
public class Demo2List {
    public static void main(String[] args) {
        //初始化列表——无初始值
        List<Integer> nums1 = new ArrayList<>();
        //初始化列表——有初始值
        Integer[] numbers = new Integer[] {1, 3, 2, 5, 4};
        List<Integer> nums = new ArrayList<>(Arrays.asList(numbers));

        // 访问元素 时间复杂度 O(1)
        Integer num = nums.get(1);
        System.out.println(num);    //3

        //更新元素 时间复杂度 O(1)
        nums.set(1, 0); //将索引 1 处的元素改为 0
        System.out.println(nums);   //[1, 0, 2, 5, 4]

        //清空列表
        nums.clear();

        //在尾部添加元素 时间复杂度O(1)
        nums.add(1);
        nums.add(3);
        nums.add(2);
        nums.add(5);
        nums.add(4);

        //在中间插入元素 时间复杂度O(n)
        nums.add(3, 6); //在索引 3 处插入数字 6
        System.out.println(nums);   //[1, 3, 2, 6, 5, 4]

        //删除元素 时间复杂度O(n)
        nums.remove(3);     //删除索引 3 处的元素
        System.out.println(nums);   //[1, 3, 2, 5, 4]

        //根据索引遍历元素
        int count = 0;
        for (int i = 0; i < nums.size(); i++) {
            count += nums.get(i);
        }

        //直接遍历元素
        for (Integer n : nums) {
            count += n;
        }

        // 拼接两个列表
        List<Integer> another = new ArrayList<>(Arrays.asList(6, 8, 7, 10, 9));
        nums.addAll(another);
        System.out.println(nums);   //[1, 3, 2, 5, 4, 6, 8, 7, 10, 9]

        //列表排序
        Collections.sort(nums);
        System.out.println(nums);   //[1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
    }

    /**
     * 列表实现
     */
    class MyList {
        // 数组（存储列表元素）
        private int[] arr;
        //列表容量
        private int capacity = 10;
        //列表长度 （当前元素数量）
        private int size = 0;
        //每次列表扩容的倍数
        private int extendRatio = 2;

        //构造方法
        public MyList() {
            //初始为容量 10 的数组
            arr = new int[capacity];
        }

        //获取列表长度
        public int size() {
            return size;
        }

        //获取列表容量
        public int capacity() {
            return capacity;
        }

        //访问元素
        public int get(int index) {
            //索引如果越界抛出异常，下同
            if (index < 0 || index >= size) {
                throw new IndexOutOfBoundsException("索引越界");
            }
            return arr[index];
        }

        //更新元素
        public void set(int index, int num) {
            if (index < 0 || index >= size) {
                throw new IndexOutOfBoundsException("索引越界");
            }
            arr[index] = num;
        }

        //在尾部添加元素
        public void add(int num) {
            //元素数量超过容量时，触发扩容机制
            if (size == capacity()) {
                extendCapacity();
            }
            arr[size] = num;
            size++; //更新元素数量
        }

        //在中间插入元素
        public void insert(int index, int num) {
            if (index < 0 || index >= size) {
                throw new IndexOutOfBoundsException("索引越界");
            }
            //元素数量超出容量时，触发扩容机制
            if (size == capacity()) {
                extendCapacity();
            }
            //将索引 index 以及之后的元素都向后移动一位
            for (int i = size - 1; i >= index; i--) {
                arr[i + 1] = arr[i];
            }
            arr[index] = num;
            //更新元素数值
            size++;
        }

        //删除元素
        public int remove(int index) {
            if (index < 0 || index >= size) {
                throw new IndexOutOfBoundsException("索引越界");
            }
            int num = arr[index];
            // 将索引 index 之后的元素都向前移动一位
            for (int i = index; i < size - 1; i++) {
                arr[i] = arr[i + 1];
            }
            // 更新元素数量
            size--;
            // 返回被删除元素
            return num;
        }

        //扩容
        private void extendCapacity() {
            //新建一个长度为原数组 extendRatio 倍的新数组，并将原数组拷贝到新数组
            arr = Arrays.copyOf(arr, capacity() * extendRatio);
            //更新列表容量
            capacity = arr.length;
        }

        //列表转数组
        public int[] toArray() {
            int size = size();
            //仅转换有效长度内的元素
            int[] arr = new int[size];
            for (int i = 0; i < size; i++) {
                arr[i] = get(i);
            }
            return arr;
        }
    }
}
