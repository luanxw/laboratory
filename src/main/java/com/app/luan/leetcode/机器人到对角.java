package com.app.luan.leetcode;

public class 机器人到对角 {

    //计算公式：f[m][n] = f[m-1][n]+f[m][n-1]
    public int moveCount(int m, int n){
        int[][] f = new int[m][n];
        for (int i = 0; i < m; i++) {
            f[i][0] = 0;
            for (int j = 0; j < n; j++) {
                if (i==0 || j==0){
                    f[i][j]=1;
                }
                f[i][j] = f[i-1][j]+f[i][j-1];
            }
        }
        return f[m-1][m-1];
    }
}
