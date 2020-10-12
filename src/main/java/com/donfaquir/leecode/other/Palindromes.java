package com.donfaquir.leecode.other;

/**
 * 给定一个整数 n ，你需要找到与它最近的回文数（不包括自身）。
 *
 * “最近的”定义为两个整数差的绝对值最小。
 *
 * 示例 1:
 *
 * 输入: "123"
 * 输出: "121"
 * 注意:
 *
 * n 是由字符串表示的正整数，其长度不超过18。
 * 如果有多个结果，返回最小的那个。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-the-closest-palindrome
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author caichangqing
 * @Date 2020/10/714:42
 * @Since 1.0
 **/
public class Palindromes {

    public static void main(String[] args) {
//        String n = "15244";
//        String n = "1234"; // 1221
        String n = "999"; // 999
//        String n = "1000"; // 1001
//        String n = "12932"; // 12921
//        String n = "298"; // 303
//        String n = "998"; // 999
//        String n = "12120"; // 12121
//        String n = "1"; // 0
//        String n = "10"; // 0
//        String n = "99"; // 0
        String compute = compute(n);
        System.out.println(compute);
    }

    /**
     * 1. 字符串长度超过18，使用Long型即可
     * 2. 回文中不能修改中位值之前的数字
     * 3. 中位值可能不变，也可能加1， 也可能减1
     * @param n
     * @return
     */
    private static String compute(String n){

        int length = n.length();
        long aLong = Long.parseLong(n);
        if(aLong <= 10L){
            return String.valueOf(Math.abs( aLong - 1));
        }
        char[] chars = n.toCharArray();

        int left = 0;
        // 1. 如果length是偶数
        int m;
        int difValue = Integer.MAX_VALUE;
        if(length % 2 == 0){
            left = length/2 -1;
            int x = chars[left] - 48;
            int y = chars[left+1] - 48;
            m = x;
            for(int i=-1;i<2;i++){
                int tmp = (x + i)%10;
                int i1 = (x - tmp) * 10 + y - tmp;
                // 不包括自身
                if(i1 == 0){
                    continue;
                }
                if(Math.abs(i1) < difValue){
                    m = tmp;
                    difValue = Math.abs(i1);
                }
            }
            chars[left] = (char)(m+48);
            chars[left + 1] = (char)(m+48);
        }else{
            left = length /2;
            int x = chars[left] - 48;
            int y = chars[left+1] - 48;
            int z = chars[left - 1] - 48;
            m = x;
            int h = z;
            for(int i=-1;i<2;i++){
                int tmp = (x + i);
                int i1;
                if(tmp >= 10){
                    if(z == 9){
                        // 此时进位肯定不是最下回文
                        continue;
                    }
                    tmp = (x + i)%10;
                    h = (z + 1)%10;
                    i1 = (z - h)*100 + (x - tmp) * 10 + y - h ;
                }else{
                   i1 = (x - tmp) * 10 + y - z;
                }
                if(Math.abs(i1) < difValue){
                    m = tmp;
                    difValue = Math.abs(i1);
                }
            }
            chars[left] = (char)(m+48);
            chars[left + 1] = (char)(h+48);
            chars[left - 1] = (char)(h+48);
        }

        int i=0;
        while (i<length/2-1){
            chars[length-1-i] = chars[i];
            i++;
        }
        return new String(chars);

    }
}
