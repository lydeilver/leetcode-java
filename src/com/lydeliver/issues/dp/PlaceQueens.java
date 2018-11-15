package com.lydeliver.issues.dp;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName PlaceQueens
 * @Author jonathan
 * @Date 2018/10/25 9:17 PM
 * @Version 1.0
 * @Description TODO
 */
public class PlaceQueens {

    private static int SIZE = 8;
    public void placeQueens(int row, Integer [] colums, List<Integer []> res) {
        if (row == SIZE) {
            res.add(colums.clone());
            return;
        }

        for (int i = 0; i < SIZE; i++) {
            if (vaildPosition(colums, i, row)) {
                colums[row]=i;
                placeQueens(row + 1, colums, res);
            }
        }
    }

    private boolean vaildPosition(Integer [] colums,int col,int row) {

        for (int i = 0; i < row; i++) {
            if (colums[i] == col) {
                return false;
            }

            int colOffset = Math.abs(colums[i] - col);
            int rowOffset = row - i;
            if (colOffset == rowOffset) {
                return false;
            }
        }
        List<Integer> list = new ArrayList<>();
        list.stream().reduce(0,(x,y)->x+y);


        return true;
    }
}
