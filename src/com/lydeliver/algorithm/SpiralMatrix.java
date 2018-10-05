package com.lydeliver.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName SpiralMatrix
 * @Author jonathan
 * @Date 2018/10/5 7:11 PM
 * @Version 1.0
 * @Description TODO
 */


public class SpiralMatrix {

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res =new ArrayList<>();
        int row =0,col=-1;
        if (matrix.length == 0 || matrix[0].length == 0) return res;
        int m=matrix[0].length,n=matrix.length;
        while(true){
            for(int i=0;i<m;i++)
                res.add(matrix[row][++col]);
            if(--n==0)break;
            for(int i=0;i<n;i++)
                res.add(matrix[++row][col]);
            if(--m==0) break;
            for(int i=0;i<m;i++)
                res.add(matrix[row][--col]);
            if(--n==0)break;
            for(int i=0;i<n;i++)
                res.add(matrix[--row][col]);
            if(--m==0) break;

        }
        return res;
    }
}
