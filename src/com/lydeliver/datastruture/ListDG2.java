package com.lydeliver.datastruture;

import javax.print.DocFlavor;
import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName ListDG2
 * @Author jonathan
 * @Date 2018/10/19 11:29 AM
 * @Version 1.0
 * @Description 用链表实现有向邻接表
 */
public class ListDG2 {

    private int size;
    private LinkedList<Character> [] vertexList;

    public ListDG2(char [] vertex ,char [][] edges) {
        this.size = vertex.length;
        vertexList = new LinkedList[size];

        for (int i = 0; i < size; i++) {
            vertexList[i] = new LinkedList<>();
            vertexList[i].add(vertex[i]);
        }

        for (char[] c : edges) {
            int p1 = getPosition(c[0]);
            vertexList[p1].addLast(c[1]);
        }
    }

    private int getPosition(char ch) {
        for (int i = 0; i < size; i++) {
            if (vertexList[i].getFirst() == ch) {
                return i;
            }
        }

        return -1;
    }



    public void DFS() {

        boolean[] flag = new boolean[size];
        for (int i = 0; i < size; i++) {
            if(!flag[i])
            DFS(i,flag);
        }

    }

    private void DFS(int i,boolean [] flag) {

        flag[i] = true;
        System.out.print(vertexList[i].getFirst()+ " ");

        LinkedList<Character> vertex = vertexList[i];
        int j=0;
        while (j<vertex.size()) {

            if(!flag[getPosition(vertex.get(j))]){
                DFS(getPosition(vertex.get(j)), flag);
            }
            j++;
        }

    }

    public void println() {
        for(LinkedList<Character> v : vertexList){
            for (int i = 0; i < v.size(); i++) {
                System.out.print(v.get(i)+" ");
            }
            System.out.println();
        }

    }
    public static void main(String[] args) {
        char[] vexs = {'A', 'B', 'C', 'D', 'E', 'F', 'G','H','I','J','K'};
        char[][] edges = new char[][]{
                {'A', 'C'},
                {'A', 'D'},
                {'A', 'F'},
                {'B', 'C'},
                {'C', 'D'},
                {'E', 'G'},
                {'D', 'G'},
                {'I','J'},
                {'J','G'},};

        ListDG2 pG;


        pG = new ListDG2(vexs, edges);

        pG.println();
        pG.DFS();

    }
}
