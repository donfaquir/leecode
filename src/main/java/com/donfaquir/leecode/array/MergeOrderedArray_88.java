package com.donfaquir.leecode.array;

/**
 * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
 * 说明：
 *
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 *  
 * 示例：
 *
 * 输入：
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 *
 * 输出：[1,2,2,3,5,6]
 *  
 * 提示：
 *
 * -10^9 <= nums1[i], nums2[i] <= 10^9
 * nums1.length == m + n
 * nums2.length == n
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author caichangqing
 * @Date 2020/10/1223:26
 * @Since 1.0
 **/
public class MergeOrderedArray_88 {
    public static void main(String[] args) {
        int[] nums1 = {4,5,6,0,0,0}; int m = 3;
        int[] nums2 = {1,2,3};      int n = 3;
        merge(nums1,m,nums2,n);
        for(int item : nums1){
            System.out.print(item);
            System.out.print(",");
        }
    }

    /**
     * 数组只是说有序，没说正序还是倒序
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    private static void merge(int[] nums1, int m, int[] nums2, int n ){
        if(nums1 == null || nums1.length <= 0 || nums2 == null || nums2.length <=0){
            return;
        }
        int x = m -1;
        int y = n -1;
        int z = m + n -1;
        while (x >= 0 || y >= 0){
            if(y<0){
                break;
            }
            if(x < 0){
                nums1[z--] = nums2[y--];
                continue;
            }
            if(nums1[x] > nums2[y]){
                nums1[z--] = nums1[x--];
            }else{
                nums1[z--] = nums2[y--];
            }
        }
    }
}
