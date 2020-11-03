package com.donfaquir.leecode.string;

/**
 * 125. 验证回文串
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 *
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 *
 * 示例 1:
 *
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 * 示例 2:
 *
 * 输入: "race a car"
 * 输出: false
 *
 * @Author caichangqing
 * @Date 2020/11/322:56
 * @Since 1.0
 **/
public class Palindrome {
    public static void main(String[] args) {
//        String str = "A man, a plan, a canal: Panama";
        String str = "a.";
//        String str = "a bb ,-=--=-=a";
        boolean compute = compute(str);
        System.out.println(compute);
    }

    private static boolean compute(String str){
        if(str == null || str.trim().length() == 0){
            return true;
        }
        char[] chars = str.toCharArray();
        int left =-0;
        int right = chars.length -1;
        boolean re = true;
        while(left<=right){
            char l,r;
            while(!Character.isLetterOrDigit(l=chars[left]) && (left < right)){left++;};
            while(!Character.isLetterOrDigit(r=chars[right]) && (left < right)){right--;};
            if(Character.toLowerCase(l)!= Character.toLowerCase(r)){
                re = false;
                break;
            }
            left++;
            right--;
        }
        return re;
    }
}
