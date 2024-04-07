package problems.c0easy.t501t1000;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * 705 设计哈希集合 https://leetcode.cn/problems/design-hashset/
 * 不使用任何内建的哈希表库设计一个哈希集合（HashSet）。
 * void add(key) 向哈希集合中插入值 key 。
 * bool contains(key) 返回哈希集合中是否存在这个值 key 。
 * void remove(key) 将给定值 key 从哈希集合中删除。
 * 如果哈希集合中没有这个值，什么也不做。
 *
 * 示例：
 * 输入1：["MyHashSet", "add", "add", "contains", "contains", "add", "contains", "remove", "contains"]
 * [[], [1], [2], [1], [3], [2], [2], [2], [2]]
 * 输出1：[null, null, null, true, false, null, true, null, false]
 */
public class T705 {
    /**
     * 自己实现：使用数组实现
     */
    class MyHashSet {
        // 第一层是哈希桶，第二层是具体的数据
        private List<List<Integer>> list;

        // 假设使用10个桶
        public MyHashSet() {
            list = new ArrayList<>(10);
            for (int i = 0; i < 10; i++) {
                list.add(new LinkedList<>());
            }
        }

        // 使用取余作为哈希函数
        public void add(int key) {
            if (!list.get(key % 10).contains(key)) {
                list.get(key % 10).add(key);
            }
        }

        public void remove(int key) {
            Iterator<Integer> iterator = list.get(key % 10).iterator();
            while (iterator.hasNext()) {
                if (iterator.next() == key) {
                    iterator.remove();
                }
            }
        }

        public boolean contains(int key) {
            return list.get(key % 10).contains(key);
        }
    }

    /**
     * 官方解法：链式地址法
     */
    class MyHashSet2 {
        private static final int BASE = 769;
        private LinkedList[] data;

        /**
         * 哈希函数
         */
        private int hash(int key) {
            return key % BASE;
        }

        public MyHashSet2() {
            data = new LinkedList[BASE];
            for (int i = 0; i < BASE; i++) {
                data[i] = new LinkedList<Integer>();
            }
        }

        public void add(int key) {
            int h = hash(key);
            Iterator<Integer> iterator = data[h].iterator();
            while (iterator.hasNext()) {
                Integer next = iterator.next();
                if (next == key) {
                    return;
                }
            }
            data[h].offerLast(key);
        }

        public void remove(int key) {
            int h = hash(key);
            Iterator<Integer> iterator = data[h].iterator();
            while (iterator.hasNext()) {
                Integer next = iterator.next();
                if (next == key) {
                    iterator.remove();
                    return;
                }
            }
        }

        public boolean contains(int key) {
            int h = hash(key);
            Iterator<Integer> iterator = data[h].iterator();
            while (iterator.hasNext()) {
                Integer next = iterator.next();
                if (next == key) {
                    return true;
                }
            }
            return false;
        }
    }

}
