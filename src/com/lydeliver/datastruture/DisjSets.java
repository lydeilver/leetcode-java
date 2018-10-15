package com.lydeliver.datastruture;

import java.util.Queue;

/**
 * @ClassName DisjSets
 * @Author jonathan
 * @Date 2018/10/13 9:34 AM
 * @Version 1.0
 * @Description 不相交集合
 *
 * 用树表示
 *
 * -1 -1 -1 4 -3 4 -4 6
 *0 1  2  3 4  5 6  7 8
 *
 *
 */
public class DisjSets {

    public DisjSets(int nums) {
        s = new int[nums];
        for (int i = 0; i < nums; i++) {
            s[i] = -1;
        }
    }

    public void uniou(int root1, int root2) {
        if (s[root2] < s[root1]) {
            s[root1] = root2;
        }else {
            if (s[root1] == s[root2]) {
                s[root1]--;
            }
            s[root2]=root1;
        }
    }

    public int find(int x) {
        if (s[x] < 0) {
            return x;
        }else {
            return s[x] =find(s[x]);
        }
    }

    public int [] s;

    public static void main(String[] args) {
        DisjSets disjSets = new DisjSets(15);
        for (int i = 0; i < 8; i++) {
            disjSets.uniou(i,i+1);
        }
        disjSets.find(14);
    }

}
