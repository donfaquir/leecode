package com.donfaquir.leecode.substring;

/**
 * 求子串问题
 * <p>
 * 给定字符串J 代表石头中宝石的类型，和字符串 S代表你拥有的石头。 S 中每个字符代表了一种你拥有的石头的类型，你想知道你拥有的石头中有多少是宝石。
 *
 * J 中的字母不重复，J 和 S中的所有字符都是字母。字母区分大小写，因此"a"和"A"是不同类型的石头。
 *
 * 示例 1:
 *
 * 输入: J = "aA", S = "aAAbbbb"
 * 输出: 3
 * 示例 2:
 *
 * 输入: J = "z", S = "ZZ"
 * 输出: 0
 * 注意:
 *
 * S 和 J 最多含有50个字母。
 *  J 中的字符不重复。
 *
 * </p>
 * @Author caichangqing
 * @Date 2020/10/210:32
 * @Since 1.0
 **/
public class GamNum {
    public static void main(String[] args) {
//        String j = "aA";
//        String s = "aAAbbbb";
//        String j = "z";
//        String s = "ZZ";
        String j = "abc";
        String s = "abc";
        int compute = compute(j, s);
        System.out.println(compute);
    }

    private static int compute(String j, String s){
        long tmp = 0L;
        for(int i=0; i<j.length(); i++){
            tmp |= 1L << (j.charAt(i) - 'A');
        }
        int sum = 0;
        for(int i=0; i<s.length(); i++){
            long a = 1L << (s.charAt(i) - 'A');
            if((tmp & a) != 0){
                sum ++;
            }
        }
        return sum;
    }
}
