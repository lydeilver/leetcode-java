package com.lydeliver.algorithm;

/**
 * @ClassName Rotate
 * @Author jonathan
 * @Date 2018/10/5 6:14 PM
 * @Version 1.0
 * @Description TODO
 */
public class Rotate {

    public void rotate(int[][] matrix) {
        int N = matrix.length;
        if(N<2) return;
        for(int i=0;i<N;i++){
            for(int j=0;j<i;j++){
                int  temp =matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        for(int i=0;i<N;i++){
            for(int j=0;j<N/2;j++){
                int temp =matrix[i][j];
                matrix[i][j] = matrix[i][N-1-j];
                matrix[i][N-1-j] = temp;
            }
        }

    }
}
