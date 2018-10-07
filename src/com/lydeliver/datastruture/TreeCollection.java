package com.lydeliver.datastruture;

import sun.misc.ASCIICaseInsensitiveComparator;

import java.util.Set;
import java.util.TreeSet;

/**
 * @ClassName TreeCollection
 * @Author jonathan
 * @Date 2018/10/7 1:18 PM
 * @Version 1.0
 * @Description TODO
 */
public class TreeCollection {

    public static void main(String[] args) {
        Set<String> s = new TreeSet<>(new ASCIICaseInsensitiveComparator());
        s.add("Hello");
        s.add("HELLO");
        System.out.println(s);
    }
}
