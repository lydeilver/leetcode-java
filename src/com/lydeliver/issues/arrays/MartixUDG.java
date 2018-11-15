package com.lydeliver.issues.arrays;

import java.security.InvalidParameterException;
import java.util.LinkedList;


/**
 * @ClassName MartixUDG
 * @Author jonathan
 * @Date 2018/10/27 6:09 PM
 * @Version 1.0
 * @Description
 */
public class MartixUDG {


    private int size;
    private Vertex [] vertexs;
    private int [][] martix;

    private void initMartix(Vertex [] vertex,char[][] edges) {
        this.size =vertex.length;
        this.vertexs =vertex;

        martix = new int[size][size];
        for (char[] c : edges) {
            int p1= getPosition(c[0]);
            int p2= getPosition(c[1]);

            martix[p1][p2]=1;
            vertex[p2].indegree++;
        }
    }


    int findMaxWeightWays(Vertex [] vexs,char[][] edges,char start) {

        initMartix(vexs,edges);

        LinkedList<Vertex> q = new LinkedList<>();
        int counter =0;
        int max =0;
        for (Vertex vex : vertexs) {
            if (vex.indegree == 0) {
                q.add(vex);
            }
        }

        while (!q.isEmpty()){
            Vertex v = q.removeFirst();
            //判断起始位置
            if (v.vex == start || max != 0) {
                max+=v.weight;
            }
            v.topNum = ++counter;

            for (int i = 0; i < size; i++) {
                if(martix[getPosition(v.vex)][i]==1 && --vertexs[i].indegree==0){
                    q.add(vertexs[i]);
                }
            }

        }
        if (counter != size) {
            throw new InvalidParameterException("cycle founded!");
        }
        return max;
    }




    private int getPosition(char c) {
        for (int i = 0; i < size; i++) {
            if (vertexs[i].vex == c) {
                return i;
            }
        }
        return -1;
    }


    public static void main(String[] args) {

        Vertex [] vertex = {new Vertex('A',1),
                new Vertex('B',2),
                new Vertex('C',3),
                new Vertex('D',4),
                new Vertex('E',5),
                new Vertex('F',6)
        };
        char [][] edges={{'A','B'},{'B','C'},{'C','D'},{'D','E'},{'E','F'},{'C','F'},{'A','C'},{'C','E'},{'D','B'}};

        MartixUDG matrixDG = new MartixUDG();

        matrixDG.findMaxWeightWays(vertex,edges,'E');

    }
}

class Vertex{
    char vex;
    int weight;
    int indegree=0;
    int topNum=0;

    public Vertex(char vex, int weight) {
        this.vex =vex;
        this.weight=weight;
    }
}
