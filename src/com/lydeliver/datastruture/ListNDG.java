package com.lydeliver.datastruture;

/**
 * @ClassName ListNDG
 * @Author jonathan
 * @Date 2018/10/19 10:55 AM
 * @Version 1.0
 * @Description 无向邻接表
 */
public class ListNDG {

    private int size;
    private Vertex [] vertexLists;

    private class Vertex {
         char ch;
         Vertex next;

        Vertex(char ch) {
            this.ch =ch;

        }

        void add(char ch) {
            Vertex node =this;
            while (node.next != null) {
                node = node.next;
            }
            node.next = new Vertex(ch);
        }
    }

    public ListNDG(char [] vertexs,char [][] edges) {
        this.size = vertexs.length;

        vertexLists = new Vertex[size];
        for (int i=0;i<size;i++) {
            vertexLists[i] = new Vertex(vertexs[i]);
        }

        for (char[] ch : edges) {
           int p1 = getPosition(ch[0]);
           int p2 = getPosition(ch[1]);

           vertexLists[p1].add(ch[1]);
           vertexLists[p2].add(ch[0]);
        }

    }




    private int getPosition(char ch) {
        for (int i = 0; i < size; i++) {
            if(vertexLists[i].ch ==ch){
                return i;
            }
        }
        return -1;
    }
}

