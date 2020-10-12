package com.donfaquir.leecode.array;

/**
 * 169. 多数元素
 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 *
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 *
 *
 *
 * 示例 1:
 *
 * 输入: [3,2,3]
 * 输出: 3
 * 示例 2:
 *
 * 输入: [2,2,1,1,1,2,2]
 * 输出: 2
 * @Author caichangqing
 * @Date 2020/10/1222:39
 * @Since 1.0
 **/
public class MostElements {
    public static void main(String[] args) {
//        int[] nums = {3,2,3};
        int[] nums = {2,2,1,1,1,2,2};
        int compute = compute(nums);
        System.out.println(compute);
    }

    /**
     * 多数元素肯定比其他元素多，删除数组中任意两个不同的元素，多数元素仍然为数组中的多数元素
     * @param nums
     * @return
     */
    private static int compute(int[] nums){
        int num = 0;
        int value = nums[0];
        for (int item : nums) {
            if (num == 0) {
                value = item;
                num++;
                continue;
            }
            if (value == item) {
                num++;
            } else {
                num--;
            }

        }
        return value;
    }
}
