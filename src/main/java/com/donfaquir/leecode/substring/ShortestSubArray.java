package com.donfaquir.leecode.substring;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

/**
 * <p>
 *     返回 A 的最短的非空连续子数组的长度，该子数组的和至少为 K 。
 * 如果没有和至少为 K 的非空子数组，返回 -1 。

 *
 * 示例 1：
 *
 * 输入：A = [1], K = 1
 * 输出：1
 * 示例 2：
 *
 * 输入：A = [1,2], K = 4
 * 输出：-1
 * 示例 3：
 *
 * 输入：A = [2,-1,2], K = 3
 * 输出：3
 *  
 *
 * 提示：
 *
 * 1 <= A.length <= 50000
 * -10 ^ 5 <= A[i] <= 10 ^ 5
 * 1 <= K <= 10 ^ 9
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shortest-subarray-with-sum-at-least-k
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * </p>
 * @Author caichangqing
 * @Date 2020/10/512:27
 * @Since 1.0
 **/
public class ShortestSubArray {
    public static void main(String[] args) {
//        int[] arr = {1,2,3,4,5,6,7};
//        int k = 5;
//        int[] arr = {1};
//        int k = 1;
//        int[] arr = {2,-1,2};
//        int k = 3;
//        int[] arr = {84,-37,32,40,95};
//        int k = 167;
// int[] arr = {-28,81,-20,28,-29};
//        int k = 89;
//int[] arr = {-36,10,-28,-42,17,83,87,79,51,-26,33,53,63,61,76,34,57,68,1,-30};
//        int k =484;
//int[] arr = {84,-37,32,40,95};
//        int k =167;
int[] arr = {-34,37,51,3,-12,-50,51,100,-47,99,34,14,-13,89,31,-14,-44,23,-38,6};
        int k =151;

        int compute = compute1(arr, k);
//        int compute = compute(arr, k);
//        int compute = shortestSubarray(arr, k);
        System.out.println(compute);
    }

    /**
     * 以此累加数组中的元素:
     * <p>
     *     1. 如果累加值小于零，说明此之前的所有值，对于后面的是无意义的，不可能是最短子串的内容，排除掉
     *     2. 维护一个递增数组，从第一个和大于零开始，如果累加和小于零，应将此下标之前的所有下标从递增数组中排除掉
     *     3. 如果找到符合条件的子串，应首先计算最长的数组（从第一个累加和大于零的下标起，到累加和大于K），然后再从递增数组中找最下子串）
     * </p>
     * @param A
     * @param K
     * @return
     */
    private static int compute1(int[] A, int K){
        long sum = 0L;
        int  minLen = 50000;
        int left = 0;
        long[] sums = new long[A.length];
        LinkedList<Integer> list = new LinkedList<>();
        for(int right =0; right<A.length; right++){
            if(A[right] >= K){
                return 1;
            }
            sum = sum + (long)A[right];
            sums[right] = sum;
            // 1. 维护递增数组
            while (!list.isEmpty() && sums[list.getLast()] >= sum){
                list.removeLast();
            }
            list.addLast(right);
            // 2. 如果累加和小于零
            if(sum <= 0){
                // 不考虑数组越界问题
                left = right+1;
                sum = 0;
                // 从递增数组中排除之前的下标
                while (!list.isEmpty() && list.getFirst() < right) {
                   list.removeFirst();
                }
                continue;
            }
            // 3. 发现符合条件的子串
            if(sum >= K){
                // 计算最长子串
                minLen = Math.min(minLen, (right - left +1));
                // 寻找最短子串
                while (!list.isEmpty() && sum >= (sums[list.getFirst()] + (long) K)) {
                    minLen = Math.min(minLen, (right - list.removeFirst()));
                }
            }
        }
        return minLen == 50000 ? -1 : minLen;
    }

    private static int compute(int[] A, int K){
        // index
        int left = 0;
        long sum = 0L;
        int  minLen = 50000;
        long[] sums = new long[A.length];
        for(int right =0; right<A.length; right++){
            if(A[right] >= K){
                return 1;
            }
            sum = sum + (long)A[right];
            sums[right] = sum;
            if(sum <= 0){
                sum = 0;
                left = right + 1;
                continue;
            }
            if(sum >= K){
//                int tmpLeft = right;
//                while (A[right] - sums[tmpLeft] < 0){
//                    if(tmpLeft > left){
//                        tmpLeft--;
//                    }else{
//                        break;
//                    }
//                }

                int tmpLeft = right;
                int tmpSum = 0;
                while((tmpSum += A[tmpLeft]) < K){
                    if(tmpLeft > left){
                        tmpLeft--;
                    }else{
                        break;
                    }
                }
                sum = tmpSum;

                left = tmpLeft;
                int newMinLen = right - left + 1;
                if (minLen > newMinLen) {
                    minLen = newMinLen;
                }
            }
        }
        // 没有子串
        if(minLen == 50000){
            minLen = -1;
        }
        return minLen;
    }

    public static int shortestSubarray(int[] A, int K) {
        int N = A.length;
        long[] P = new long[N+1];
        for (int i = 0; i < N; ++i)
            P[i+1] = P[i] + (long) A[i];

        // Want smallest y-x with P[y] - P[x] >= K
        int ans = N+1; // N+1 is impossible
        Deque<Integer> monoq = new LinkedList(); //opt(y) candidates, as indices of P

        for (int y = 0; y < P.length; ++y) {
            // Want opt(y) = largest x with P[x] <= P[y] - K;
            while (!monoq.isEmpty() && P[y] <= P[monoq.getLast()])
                monoq.removeLast();
            while (!monoq.isEmpty() && P[y] >= P[monoq.getFirst()] + K)
                ans = Math.min(ans, y - monoq.removeFirst());

            monoq.addLast(y);
        }

        return ans < N+1 ? ans : -1;
    }


}
