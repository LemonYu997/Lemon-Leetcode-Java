package hello.c0datastructure.p2HashTable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 哈希表 https://www.hello-algo.com/chapter_hashing/hash_map/
 * 存储 key-value 键值对
 *
 * 常见操作：
 * 1、查找元素   时间复杂度O(1)
 * 2、添加元素   时间复杂度O(1)
 * 3、删除元素   时间复杂度O(1)
 */
public class Demo0HashMap {
    public static void main(String[] args) {
        //初始化
        Map<Integer, String> map = new HashMap<>();

        //添加元素   时间复杂度O(1)
        map.put(12836, "小哈");
        map.put(15937, "小啰");
        map.put(16750, "小算");
        map.put(13276, "小法");
        map.put(10583, "小鸭");
        System.out.println(map);    //{15937=小啰, 12836=小哈, 10583=小鸭, 13276=小法, 16750=小算}

        //查询操作   时间复杂度O(1)
        String s = map.get(15937);
        System.out.println(s);      //小啰

        //删除元素   时间复杂度O(1)
        map.remove(10583);
        System.out.println(map);    //{15937=小啰, 12836=小哈, 13276=小法, 16750=小算}

        //遍历哈希表
        //遍历键值对
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
        //遍历key
        for (Integer key : map.keySet()) {
            System.out.println(key);
        }
        //遍历value
        for (String value : map.values()) {
            System.out.println(value);
        }
    }

    /* 键值对 */
    class Pair {
        public int key;
        public String val;

        public Pair(int key, String val) {
            this.key = key;
            this.val = val;
        }
    }

    /**
     * 使用数组简单实现哈希表
     */
    public class ArrayHashMap {
        private List<Pair> buckets;

        //初始化数组，包含100个桶
        public ArrayHashMap() {
            buckets = new ArrayList<>();
            for (int i = 0; i < 100; i++) {
                buckets.add(null);
            }
        }

        //哈希函数  简单取余
        private int hashFunc(int key) {
            int index = key % 100;
            return index;
        }

        //查询操作
        public String get(int key) {
            int index = hashFunc(key);
            Pair pair = buckets.get(index);
            if (pair == null) {
                return null;
            }
            return pair.val;
        }

        //添加操作
        public void put(int key, String val) {
            Pair pair = new Pair(key, val);
            int index = hashFunc(key);
            buckets.set(index, pair);
        }

        //获取所有键值对
        public List<Pair> pairSet() {
            List<Pair> pairSet = new ArrayList<>();
            for (Pair pair : buckets) {
                if (pair != null) {
                    pairSet.add(pair);
                }
            }

            return pairSet;
        }

        //获取所有键
        public List<Integer> keySet() {
            List<Integer> keySet = new ArrayList<>();
            for (Pair pair : buckets) {
                if (pair != null) {
                    keySet.add(pair.key);
                }
            }
            return keySet;
        }

        //获取所有值
        public List<String> valueSet() {
            List<String> valueSet = new ArrayList<>();
            for (Pair pair : buckets) {
                if (pair != null) {
                    valueSet.add(pair.val);
                }
            }
            return valueSet;
        }

        //打印哈希表
        public void print() {
            for (Pair pair : pairSet()) {
                System.out.println(pair.key + " -> " + pair.val);
            }
        }
    }
}
