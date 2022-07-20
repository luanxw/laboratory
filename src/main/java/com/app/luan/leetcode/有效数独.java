package com.app.luan.leetcode;

import java.util.HashMap;
import java.util.Map;

public class 有效数独 {

    public static boolean isValidSudoku(char[][] board) {

        Map<Character,Integer> table = new HashMap<>(9);
        //先判断每行是否有重复的
        for (int m = 0; m < 9; m++) {
            for (int i = 0; i < 9; i++) {
                if (board[m][i] == '.'){
                    continue;
                }
                if (table.get(board[m][i]) != null){
                    return false;
                }
                table.put(board[m][i], i);
            }
            table.clear();
        }
        //判断列是否存在重复数据
        for (int m = 0; m < 9; m++) {
            for (int i = 0; i < 9; i++) {
                if (board[i][m] == '.'){
                    continue;
                }
                if (table.get(board[i][m]) != null){
                    return false;
                }
                table.put(board[i][m], m);
            }
            table.clear();
        }
        int[] begin  = {0,3,6};
        //判断九宫格是否满足, 三行九宫格的遍历
        for (int q = 0; q < 3; q++) {
            //每行三个九宫格的遍历
            for (int k = 0; k < 3; k++) {
                //每个九宫格的遍历
                for (int i = begin[q]; i < begin[q]+3; i++) {
                    for (int j = begin[k]; j < begin[k]+3; j++) {
                        if (board[i][j] == '.'){
                            continue;
                        }
                        if (table.get(board[i][j]) != null){
                            return false;
                        }
                        table.put(board[i][j],i);
                    }
                }
                table.clear();
            }

        }
    return true;
    }

    public static void main(String[] args) {
//        char[][] sudu = {{'5','3','.','.','7','.','.','.','.'} ,{'6','.','.','1','9','5','.','.','.'} ,{'.','9','8','.','.','.','.','6','.'} ,{'8','.','.','.','6','.','.','.','3'} ,{'4','.','.','8','.','3','.','.','1'} ,{'7','.','.','.','2','.','.','.','6'} ,{'.','6','.','.','.','.','2','8','.'} ,{'.','.','.','4','1','9','.','.','5'} ,{'.','.','.','.','8','.','.','7','9'}};
        char[][] sudu = {{'5','3','.','.','7','.','.','.','.'},{'6','.','.','1','9','5','.','.','.'},{'.','9','8','.','.','.','.','6','.'},{'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','6'},{'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},{'.','.','.','.','8','.','.','7','9'}};
        System.out.println(isValidSudoku(sudu));
    }
}
