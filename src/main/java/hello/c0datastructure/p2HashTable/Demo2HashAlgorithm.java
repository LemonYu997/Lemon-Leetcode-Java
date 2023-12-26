package hello.c0datastructure.p2HashTable;

import hello.c0datastructure.p0ArrayAndLinked.Demo1LinkedList;

import java.util.Arrays;

/**
 * Hash算法 https://www.hello-algo.com/chapter_hashing/hash_algorithm/
 * 常见简单哈希算法 大质数取余
 */
public class Demo2HashAlgorithm {
    public static void main(String[] args) {
        //各类型内置hash值
        int num = 3;
        int hashNum = Integer.hashCode(num);
        System.out.println(hashNum);    //3

        boolean bol = true;
        int hashBol = Boolean.hashCode(bol);
        System.out.println(hashBol);    //1231

        double dec = 3.14159;
        int hashDec = Double.hashCode(dec);
        System.out.println(hashDec);    //-1340954729

        String str = "Hello 算法";
        int hashStr = str.hashCode();
        System.out.println(hashStr);    //-727081396

        Object[] arr = {12386, "小哈"};
        int hashTup = Arrays.hashCode(arr);
        System.out.println(hashTup);    //1137208

        Demo1LinkedList.ListNode obj = new Demo1LinkedList.ListNode(0);
        int hashObj = obj.hashCode();
        System.out.println(hashObj);    //460141958
    }

    //加法哈希
    int addHash(String key) {
        long hash = 0;
        final int MODULUS = 1000000007;
        for (char c : key.toCharArray()) {
            hash = (hash + (int) c) % MODULUS;
        }
        return (int) hash;
    }

    //乘法哈希
    int mulHash(String key) {
        long hash = 0;
        final int MODULUS = 1000000007;
        for (char c : key.toCharArray()) {
            hash = (31 * hash + (int) c) % MODULUS;
        }
        return (int) hash;
    }

    //异或哈希
    int xorHash(String key) {
        int hash = 0;
        final int MODULUS = 1000000007;
        for (char c : key.toCharArray()) {
            hash ^= (int) c;
        }
        return hash & MODULUS;
    }

    //旋转哈希
    int rotHash(String key) {
        long hash = 0;
        final int MODULUS = 1000000007;
        for (char c : key.toCharArray()) {
            hash = ((hash << 4) ^ (hash >> 28) ^ (int) c) % MODULUS;
        }
        return (int) hash;
    }
}
