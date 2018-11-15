package com.lydeliver.datastruture;

import java.util.LinkedList;

/**
 * @ClassName ListDG
 * @Author jonathan
 * @Date 2018/10/19 11:18 AM
 * @Version 1.0
 * @Description 邻接有向
 */
public class ListDG {

    private int size;

    private Vertex[] vertexs;

    private class Vertex {
        char ch;
        Vertex next;

        Vertex(char ch) {
            this.ch = ch;
        }

        void add(char ch) {
            Vertex node = this;
            while (node.next != null) {
                node = node.next;
            }
            node.next = new Vertex(ch);
        }

    }

    public void DFS() {
        boolean[] flag = new boolean[size];

        for (int i = 0; i < size; i++) {
            if (!flag[i]) {
                DFS(i, flag);
            }
        }
    }

    private void DFS(int i, boolean[] flag) {

        flag[i] = true;
        System.out.println(vertexs[i]);
        Vertex v = vertexs[i];
        while (v != null) {
            if (!flag[getPosition(v.ch)]) {
                DFS(getPosition(v.ch), flag);
            }
            v = v.next;
        }
    }

    public void BFS() {
        boolean[] flag = new boolean[size];
        LinkedList<Integer> queue = new LinkedList<>();

        for (int i = 0; i < size; i++) {

            if (!flag[i]) {
                System.out.println(vertexs[i].ch);
                flag[i] = true;
                queue.add(i);

                while (!queue.isEmpty()) {

                    int pos = queue.poll();
                    Vertex v = vertexs[pos];
                    while (v != null) {
                        int k = getPosition(v.ch);
                        if (!flag[k]) {
                            System.out.println(v.ch);
                            flag[k] = true;
                            queue.add(k);
                        }
                        v = v.next;
                    }

                }
            }
        }
    }


    public ListDG(char[] vertex, char[][] edges) {
        this.size = vertex.length;
        vertexs = new Vertex[size];
        for (int i = 0; i < size; i++) {
            vertexs[i] = new Vertex(vertex[i]);
        }
        for (char[] edge : edges) {
            int p1 = getPosition(edge[0]);
            vertexs[p1].add(edge[1]);
        }
    }


    private int getPosition(char ch) {
        for (int i = 0; i < size; i++) {
            if (vertexs[i].ch == ch) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 查找两个节点之间是否存在一条路径
     * 用BFS或者DFS都可以
     * @param a
     * @param c
     * @return
     */
    public boolean isContected(char a, char c) {

        LinkedList<Integer> queue = new LinkedList<>();
        boolean[] flag = new boolean[size];

        int p1 = getPosition(a);
        queue.add(p1);
        flag[p1]=true;
        while (!queue.isEmpty()) {
            int p = queue.poll();
            Vertex v = vertexs[p];
            while (v != null) {
                if (v.ch == c) {
                    return true;
                }
                int tmp = getPosition(v.ch);
                if (!flag[tmp]) {
                    queue.add(tmp);
                    flag[tmp] =true;
                }
                v = v.next;

            }
        }
        return false;
    }

    public void println() {
        for(Vertex v : vertexs){
            while (v != null) {
                System.out.print(v.ch+" ");
                v = v.next;
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

        ListDG pG;


        pG = new ListDG(vexs, edges);

        pG.println();
        System.out.println(pG.isContected('E','F'));


    }
}

