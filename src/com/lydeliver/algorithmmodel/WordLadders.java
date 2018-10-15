package com.lydeliver.algorithmmodel;

import java.util.*;

/**
 * @ClassName WordLadders
 * @Author jonathan
 * @Date 2018/10/14 3:31 PM
 * @Version 1.0
 * @Description 计算梯词，我们可以通过一系列单字母的替换将zero 转换成five
 * zero hero here hire fire five
 *
 * 本质上是无权最短路径问题
 */
public class WordLadders {

    public static List<String> findChain(Map<String,List<String>> adjacentWords, String first, String second){
        Map<String, String> previousWords = new HashMap<>();
        LinkedList<String> q = new LinkedList<>();

        q.addLast(first);

        while (!q.isEmpty()) {
            String s = q.removeFirst();
            List<String> words =adjacentWords.get(s);
            if (words != null) {
                for (String adj : words) {
                    if (previousWords.get(adj) == null) {
                        previousWords.put(adj, s);
                        q.addLast(adj);
                    }
                }
            }
        }

        previousWords.put(first, null);



        return getChainFromPreviousMap(previousWords, first, second);
    }

    private static List<String> getChainFromPreviousMap(Map<String, String> previousWords, String first, String second) {
        List<String> result =null;
        if (previousWords.get(second) != null) {
            result = new LinkedList<>();
            for(String str =previousWords.get(second);str!=null; str= previousWords.get(str) ){
                ((LinkedList<String>) result).addFirst(str);
            }
        }
        return result;

    }
}
