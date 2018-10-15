package com.lydeliver.datastruture;

/**
 * @ClassName ListUDG
 * @Author jonathan
 * @Date 2018/10/13 7:53 PM
 * @Version 1.0
 * @Description TODO
 */
public class ListUDG {

    private static final  int INF = Integer.MAX_VALUE;

    private class ENode {
         ENode nextEdge; //指向下一条边
         int weight; // 权重
         int viex; // 该边所指向顶点的位置
    }

    private class VNode{
         char data; //顶点值
         ENode firstEdge; //该顶点第一条边
    }


    private static class EData{
        char start;
        char end;
        int weight;

        public EData(char start, char end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }
    }

    private int mEdgeNum; //边的数量
    private VNode [] mVexs; //顶点数组

    public ListUDG(char [] vexs,EData [] edges) {
        //初始化 顶点数和边数
        int vlen = vexs.length;
        int elen = edges.length;

        mVexs = new VNode[vlen];
        for (int i=0;i<mVexs.length;i++) {
            mVexs[i] = new VNode();
            mVexs[i].data = vexs[i];
        }
        mEdgeNum = elen;
        for (int i = 0; i < elen; i++) {
            char c1 = edges[i].start;
            char c2 = edges[i].end;
            int weight = edges[i].weight;

            int p1 = getPosition(c1);
            int p2 = getPosition(c2);

            ENode node1 = new ENode();
            node1.viex = p2;
            node1.weight = weight;
            if (mVexs[p1].firstEdge == null) {
                mVexs[p1].firstEdge = node1;
            }else{
                linkLast(mVexs[p1].firstEdge, node1);
            }

            // 初始化node2
            ENode node2 = new ENode();
            node2.viex = p1;
            node2.weight = weight;
            // 将node2链接到"p2所在链表的末尾"
            if(mVexs[p2].firstEdge == null)
                mVexs[p2].firstEdge = node2;
            else
                linkLast(mVexs[p2].firstEdge, node2);

        }
    }

    private int getWeight(int start, int end) {
        if (start == end) {
            return 0;
        }
        ENode edge = mVexs[start].firstEdge;
        while (edge != null) {
            if (edge.viex == end) {
                return edge.weight;
            }
            edge = edge.nextEdge;
        }

        return INF;
    }
    private void linkLast(ENode edge,ENode newEdge) {
        ENode p = edge;
        while (p.nextEdge != null) {
            p = p.nextEdge;
        }
        p.nextEdge = newEdge;
    }

    private int getPosition(char ch) {
        for (int i = 0; i < mVexs.length; i++) {
            if (ch == mVexs[i].data) {
                return i;
            }
        }
        return -1;
    }

    /**
     *
     *  Dijkstra最短路径。
     *  * 即，统计图中"顶点vs"到其它各个顶点的最短路径。
     *  *
     *  * 参数说明：
     *  *       vs -- 起始顶点(start vertex)。即计算"顶点vs"到其它顶点的最短路径。
     *  *     prev -- 前驱顶点数组。即，prev[i]的值是"顶点vs"到"顶点i"的最短路径所经历的全部顶点中，位于"顶点i"之前的那个顶点。
     *  *     dist -- 长度数组。即，dist[i]是"顶点vs"到"顶点i"的最短路径的长度。
     */
    public void dijkstra(int vs, int[] prev, int[] dist) {
        Boolean [] flag = new Boolean[mVexs.length];
        for (int i = 0; i < mVexs.length; i++) {
            flag[i] = false;
            dist[i] = getWeight(vs, i);
            prev[i] =0;
        }

        flag[vs] = true;
        int k=0;
        for (int i = 1; i < mVexs.length; i++) {

            int min =INF;
            for (int j = 0; j < mVexs.length; j++) {
                if (flag[j] == false && dist[j] < min) {
                    min = dist[j];
                    k = j;
                }
            }
            flag[k] = true;
            for (int j = 0; j < mVexs.length; j++) {
                int tmp = getWeight(k, j);
                tmp = (tmp == INF ? INF : tmp + min);
                if (flag[j] == false && dist[j] > tmp) {
                    dist[j] = tmp;
                    prev[j] =k;
                }
            }
        }

        // 打印dijkstra最短路径的结果
        System.out.printf("dijkstra(%c): \n", mVexs[vs].data);
        for (int i = 0; i < mVexs.length; i++)
            System.out.printf("  shortest(%c, %c)=%d\n", mVexs[vs].data, mVexs[i].data, dist[i]);



    }


    public static void main(String[] args) {
        char[] vexs = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        EData[] edges = {
                // 起点 终点 权
                new EData('A', 'B', 12),
                new EData('A', 'F', 16),
                new EData('A', 'G', 14),
                new EData('B', 'C', 10),
                new EData('B', 'F',  7),
                new EData('C', 'D',  3),
                new EData('C', 'E',  5),
                new EData('C', 'F',  6),
                new EData('D', 'E',  4),
                new EData('E', 'F',  2),
                new EData('E', 'G',  8),
                new EData('F', 'G',  9),
        };
        ListUDG pG;

        pG = new ListUDG(vexs, edges);
        int[] prev = new int[pG.mVexs.length];
        int[] dist = new int[pG.mVexs.length];
        // dijkstra算法获取"第4个顶点"到其它各个顶点的最短距离
        pG.dijkstra(3, prev, dist);
    }

}
