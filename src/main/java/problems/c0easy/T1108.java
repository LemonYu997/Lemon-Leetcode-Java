package problems.c0easy;

/**
 * 1108 IP 地址无效化 https://leetcode.cn/problems/defanging-an-ip-address/description/
 * 给你一个有效的 IPv4 地址 address，返回这个 IP 地址的无效化版本。
 * 所谓无效化 IP 地址，其实就是用 "[.]" 代替了每个 "."。
 *
 * 示例：
 * 输入1：address = "1.1.1.1"
 * 输出1："1[.]1[.]1[.]1"
 *
 * 输入2：address = "255.100.50.0"
 * 输出2："255[.]100[.]50[.]0"
 */
public class T1108 {
    /**
     * 自己实现：直接替换
     */
    public String defangIPaddr(String address) {
        return address.replaceAll("\\.", "[.]");
    }
}
