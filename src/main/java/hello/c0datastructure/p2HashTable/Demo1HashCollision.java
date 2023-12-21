package hello.c0datastructure.p2HashTable;

import java.util.ArrayList;
import java.util.List;

/**
 * hash冲突 https://www.hello-algo.com/chapter_hashing/hash_collision/
 *
 * 解决方案：
 * 1、链式地址 使用链表存储键值对节点
 * 2、开放寻址 不引入新的数据结构，通过多次探测找到可以插入的位置
 * 常用的方法：
 *  线性探测：通过哈希函数计算桶索引，若发现桶内已有元素，则从冲突位置向后线性遍历，步数为1
 *  平方探测：按平方数为步数进行探测，如1、4、9
 *  多次哈希：出现冲突时使用新的哈希函数
 */
public class Demo1HashCollision {
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
     * 链式地址哈希表
     */
    public class HashMapChaining {
        int size;           //键值对数量
        int capacity;       //哈希表容量
        double loadThres;   //触发扩容的负载因子阈值
        int extendRatio;    //扩容倍数
        List<List<Pair>> buckets;   //桶数组

        //构造方法
        public HashMapChaining() {
            size = 0;
            capacity = 4;
            loadThres = 2.0 / 3.0;  //负载因子0.66
            extendRatio = 2;
            buckets = new ArrayList<>(capacity);
            for (int i = 0; i < capacity; i++) {
                buckets.add(new ArrayList<>());
            }
        }

        //哈希函数
        int hashFunc(int key) {
            return key % capacity;
        }

        //负载因子
        double loadFactor() {
            return (double) size / capacity;
        }

        //查询操作
        String get(int key) {
            int index = hashFunc(key);
            List<Pair> bucket = this.buckets.get(index);
            //遍历桶，找到 key 则返回 val
            for (Pair pair : bucket) {
                if (pair.key == key) {
                    return pair.val;
                }
            }
            //没找到则返回 false
            return null;
        }

        //添加操作
        void put(int key, String val) {
            //负载因子超过阈值时，进行扩容
            if (loadFactor() > loadThres) {
                extend();
            }
            int index = hashFunc(key);
            List<Pair> bucket = buckets.get(index);
            //遍历桶，如果找到指定 key，则更新 val
            for (Pair pair : bucket) {
                if (pair.key == key) {
                    pair.val = val;
                    return;
                }
            }
            //没有时则添加这个 key 对应的键值对到尾部
            Pair pair = new Pair(key, val);
            bucket.add(pair);
            size++;
        }

        //删除操作
        void remove(int key) {
            int index = hashFunc(key);
            List<Pair> bucket = buckets.get(index);
            //遍历桶，从中删除
            for (Pair pair : bucket) {
                if (pair.key == key) {
                    bucket.remove(pair);
                    size--;
                    break;
                }
            }
        }

        //扩容哈希表
        void extend() {
            //暂存原哈希表
            List<List<Pair>> bucketsTmp = buckets;
            //初始化扩容后的新哈希表
            capacity *= extendRatio;
            buckets = new ArrayList<>(capacity);
            for (int i = 0; i < capacity; i++) {
                buckets.add(new ArrayList<>());
            }
            size = 0;
            //将键值对从原哈希表搬运至新哈希表
            for (List<Pair> bucket : bucketsTmp) {
                for (Pair pair : bucket) {
                    put(pair.key, pair.val);
                }
            }
        }

        //打印哈希表
        void print() {
            for (List<Pair> bucket : buckets) {
                List<String> res = new ArrayList<>();
                for (Pair pair : bucket) {
                    res.add(pair.key + " -> " + pair.val);
                }
                System.out.println(res);
            }
        }
    }

    //开放寻址：线性探测哈希表
    public class HashMapOpenAddressing {
        private int size;           //键值对数量
        private int capacity = 4;   //哈希表容量
        private final double loadThres = 2.0 / 3.0; //触发扩容的负载因子阈值
        private final int extendRatio = 2;  //扩容倍数
        private Pair[] buckets;     //桶数组
        private final Pair TOMBSTONE = new Pair(-1, "-1");  //删除标记

        //构造方法
        public HashMapOpenAddressing() {
            size = 0;
            buckets = new Pair[capacity];
        }

        //哈希函数
        private int hashFunc(int key) {
            return key % capacity;
        }

        //负载因子
        private double loadFactor() {
            return (double) size / capacity;
        }

        //搜索key对应的桶索引
        private int findBucket(int key) {
            int index = hashFunc(key);
            int firstTombStone = -1;
            //线性探测，遇到空桶时跳出
            while (buckets[index] != null) {
                //遇到key，返回桶索引
                if (buckets[index].key == key) {
                    //若之前遇到了删除标记，则将键值对移动至该索引
                    if (firstTombStone != -1) {
                        buckets[firstTombStone] = buckets[index];
                        buckets[index] = TOMBSTONE;
                        return firstTombStone;  //返回移动后的桶索引
                    }
                    return index;
                }
                //记录遇到的首个删除标志
                if (firstTombStone == -1 && buckets[index] == TOMBSTONE) {
                    firstTombStone = index;
                }
                //计算桶索引，越过尾部返回头节点
                index = (index + 1) % capacity;
            }
            //若key不存在，则返回添加点的索引
            return firstTombStone == -1 ? index : firstTombStone;
        }

        //查询操作
        public String get(int key) {
            // 搜索key对应的桶索引
            int index = findBucket(key);
            // 若找到键值对，则返回对应val
            if (buckets[index] != null && buckets[index] != TOMBSTONE) {
                return buckets[index].val;
            }
            //若键值对不存在，返回null
            return null;
        }

        //添加操作
        public void put(int key, String val) {
            //当负载因子超过阈值时，进行扩容
            if (loadFactor() > loadThres) {
                extend();
            }
            //搜索key对应的桶索引
            int index = findBucket(key);
            //若找到key，则更新val
            if (buckets[index] != null && buckets[index] != TOMBSTONE) {
                buckets[index].val = val;
                return;
            }
            //若键值对不存在，则添加
            buckets[index] = new Pair(key, val);
            size++;
        }

        //删除操作
        public void remove(int key) {
            //搜索 key 对应的桶索引
            int index = findBucket(key);
            //若找到键值对，则用删除标志覆盖它
            if (buckets[index] != null && buckets[index] != TOMBSTONE) {
                buckets[index] = TOMBSTONE;
                size--;
            }
        }

        //哈希表扩容
        private void extend() {
            //暂存原哈希表
            Pair[] bucketsTmp = buckets;
            //初始化扩容后的新哈希表
            capacity *= extendRatio;
            buckets = new Pair[capacity];
            size = 0;
            //将键值对从原哈希表搬运至新哈希表
            for (Pair pair : bucketsTmp) {
                if (pair != null && pair != TOMBSTONE) {
                    put(pair.key, pair.val);
                }
            }
        }

        //打印哈希表
        public void print() {
            for (Pair pair : buckets) {
                if (pair == null) {
                    System.out.println("null");
                } else if (pair == TOMBSTONE) {
                    System.out.println("TOMBSTONE");
                } else {
                    System.out.println(pair.key + " -> " + pair.val);
                }
            }
        }
    }

}
