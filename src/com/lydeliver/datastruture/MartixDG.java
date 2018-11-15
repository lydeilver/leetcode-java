package com.lydeliver.datastruture;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName MartixDG
 * @Author jonathan
 * @Date 2018/10/19 10:30 AM
 * @Version 1.0
 * @Description 有向邻接矩阵实现
 */
public class MartixDG {


    private int size;
    private char [] vertex;
    private int [][] martix;

    public MartixDG(char [] vertex,char[][] edges) {
        this.size =vertex.length;
        this.vertex =vertex;

        martix = new int[size][size];
        for (char[] c : edges) {
            int p1= getPosition(c[0]);
            int p2= getPosition(c[1]);

            martix[p1][p2]=1;
        }
    }

    public void DFS() {
        boolean  [] flag = new boolean[size];

        for (int i = 0; i < size; i++) {
            if (!flag[i])
                DFS(i,flag);

        }
    }


    public void BFS() {
        boolean[] flag = new boolean[size];

        LinkedList<Integer> link = new LinkedList<>();

        for (int i = 0; i < size; i++) {
            if (!flag[i]) {
                flag[i] =true;
                System.out.println(vertex[i]);
                link.add(i);
                while (!link.isEmpty()) {
                    link.pollFirst();
                    for (int j = 0; j < size; j++) {
                        if(martix[i][j]==1&&!flag[j]){
                            flag[j]=true;
                            System.out.println(vertex[j]);
                            link.add(j);
                        }
                    }
                }
            }
        }

    }


    private void DFS(int i,boolean [] flag) {

        flag[i] =true;
        System.out.println(vertex[i]);

        int [] nums = martix[i];
        for (int j = 0; j < nums.length; j++) {
            if(!flag[j] && nums[j]==1 ){
                DFS(j, flag);
            }
        }
    }





    private int getPosition(char c) {
        for (int i = 0; i < size; i++) {
            if (vertex[i] == c) {
                return i;
            }
        }
        return -1;
    }

    private void print() {
        for (int[] i : martix) {
            for (int j : i) {
                System.out.print(j+ " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        char [] vertex = {'A','B','C','D','E','F','G'};
        char [][] edges={{'A','B'},{'B','C'},{'C','D'},{'D','E'},{'E','F'},{'F','G'},{'G','A'},{'B','D'},{'E','C'}};

        MartixDG matrixDG = new MartixDG(vertex,edges);

        matrixDG.print();
        //matrixDG.DFS();
        matrixDG.BFS();



    }
}
