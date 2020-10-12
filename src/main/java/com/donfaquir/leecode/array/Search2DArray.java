package com.donfaquir.leecode.array;

/**
 * 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 *
 *  
 *
 * 示例:
 *
 * 现有矩阵 matrix 如下：
 *
 * [
 *   [1,   4,  7, 11, 15],
 *   [2,   5,  8, 12, 19],
 *   [3,   6,  9, 16, 22],
 *   [10, 13, 14, 17, 24],
 *   [18, 21, 23, 26, 30]
 * ]
 * 给定 target = 5，返回 true。
 *
 * 给定 target = 20，返回 false。
 *
 *  
 *
 * 限制：
 *
 * 0 <= n <= 1000
 *
 * 0 <= m <= 1000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author caichangqing
 * @Date 2020/10/1222:50
 * @Since 1.0
 **/
public class Search2DArray {
    public static void main(String[] args) {
        int[][] matrix = {
                {1,   4,  7, 11, 15},
                {2,   5,  8, 12, 19},
                {3,   6,  9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
//        int target = 5;
        int target = 20;
        boolean compute = compute2(matrix, target);
        System.out.println(compute);
    }
    public static boolean compute(int[][] matrix, int target){
        if(matrix.length <= 0){
            return false;
        }
        for(int[] yItem : matrix){
            if(yItem.length <=0 || yItem[0] > target){
                break;
            }
            for(int xItem : yItem){
                if(xItem == target){
                    return true;
                }
                if(xItem > target){
                    break;
                }
            }
        }
        return false;
    }
    public static boolean compute2(int[][] matrix, int target){
        if(matrix == null || matrix.length <= 0 || matrix[0].length <= 0){
            return false;
        }
        int row = 0;
        int col = matrix[0].length - 1;
        while (row < matrix.length && col >= 0 ){
            int val = matrix[row][col];
            if(val == target){
                return true;
            }else if(val > target){
                col--;
            }else{
                row++;
            }
        }
        return false;
    }

}
