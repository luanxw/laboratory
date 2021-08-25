package com.app.luan.leetcode;

public class 最少组成27元 {

    /**
     * 1、确定状态
     *      最后一步：最优策略中使用的最后一枚硬币
     *      化成自问题：最少硬币拼出前一步，27-K
     * 2、转移方程
     *       f(x) = min{f(x-2)+1,f(x-5)+1,f(x-7)+1}
     * 3、初始化条件
     *      方程中需要，但是方程中又计算不出来。比如：f(0)=0;
     * 4、计算次序
     *      原则：计算到f(x)时，确保之前的已经计算过了。如：f(0),f(1),f(2),f(3)........
     **/

    public int coinChange(int[] A, int M){
        int[] f = new int[M+1];
        f[0]=0;
        int n = A.length;
        // 这一步：枚举：f(1),f(2).....f(x)
        for (int i = 1 ; i < M; i++) {
            //默认第当前为无限大
            f[i] = Integer.MAX_VALUE;
            // 最后一枚硬币
            //f[i] = min{f(i-A[0])+1,f(i-A[1])+1........f(i-A[n-1])+1}
            for (int j = 0; j < n; j++) {
                if (i> A[j] && f[i] != Integer.MAX_VALUE){
                    f[i] = Math.min(f[i-A[j]]+1, f[i]);
                }
            }
        }
        if (f[M] == Integer.MAX_VALUE){
            f[M]=-1;
        }
        return f[M];
    }

    public static int jump(int[] nums) {
        int length = nums.length;
        int[] res = new int[length];
        // 转移方程：f（x）= mix(f(x-1)+1,f(x))
        for (int i = 0; i < length; i++) {
            if (i == 0){
                res[i] = 0;
                continue;
            }
            res[i] = Integer.MAX_VALUE;
            for (int j = 0; j < i; j++) {
//                if (res[j] != Integer.MAX_VALUE &&i-j < nums[j]){
                if (i-j <= nums[j]){
                    res[i] = Math.min(res[i],res[j]+1);
                }
            }
        }
        return res[length-1];
    }

    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4};
        System.out.println(jump(nums));
    }
}
