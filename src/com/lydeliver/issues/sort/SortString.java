package com.lydeliver.issues.sort;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @ClassName sortString
 * @Author jonathan
 * @Date 2018/11/4 5:04 PM
 * @Version 1.0
 * @Description TODO
 */
public class SortString {

    public void sort(String[] strs) {
        Arrays.sort(strs, new StringComparator());
    }

}

class StringComparator implements Comparator<String> {

    public String sortChars(String s) {
        char [] str = s.toCharArray();
        Arrays.sort(str);
        return new String(str);
    }
    @Override
    public int compare(String o1, String o2) {
        return sortChars(o1).compareTo(sortChars(o2));
    }
}