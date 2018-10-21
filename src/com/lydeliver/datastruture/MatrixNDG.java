package com.lydeliver.datastruture;

/**
 * @ClassName MatrixNDG
 * @Author jonathan
 * @Date 2018/10/19 10:15 AM
 * @Version 1.0
 * @Description 邻接矩阵无向图
 */
public class MatrixNDG {

    private int size;
    private char [] vertex;
    private int [][] matrix;

    public MatrixNDG(char[] vertex, char[][] edges) {
       size = vertex.length;
       matrix = new int[size][size];
       this.vertex=vertex;
        for (char[] c : edges) {//设置矩阵值
           int p1 = getPosition(c[0]);//根据顶点名称确定对应矩阵下标
           int p2 = getPosition(c[1]);

           matrix[p1][p2]=1;//无向图，在两个对称位置存储
           matrix[p2][p1]=1;
        }

    }

    public void print() {
        for (int[] i : matrix) {
            for (int j : i) {
                System.out.print(j+" ");
            }
            System.out.println();
        }

    }


    private int getPosition(char v) {
        for (int i=0;i<size;i++) {

            if (vertex[i] ==v) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {

        char [] vertex = {'A','B','C','D','E','F','G'};
        char [][] edges={{'A','B'},{'B','C'},{'C','D'},{'D','E'},{'E','F'},{'F','G'},{'G','A'},{'B','D'},{'E','C'}};

        MatrixNDG matrixNDG = new MatrixNDG(vertex,edges);

        matrixNDG.print();

    }
}
