package com.lydeliver.issues.arrays;


import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import com.google.common.base.Strings;

import java.util.*;

/**
 * @ClassName DictSer
 * @Author jonathan
 * @Date 2018/10/27 6:02 PM
 * @Version 1.0
 * @Description
 * Dictionary serialization
 * use guava
 *
 */
public class DictSer {


    private static final String EMPTY_STR = "";
    private static final String VALUE_SPILT = "=";
    private static final String ELEMENT_SPILT = ";";
    private static final String ARRAY_SPILT = "\n";



    public String store(Map<String,String> [] dictionaries) {

        if (dictionaries == null || dictionaries.length==0) {
            return EMPTY_STR;
        }

        List<String> str = new ArrayList<>();
        for (Map<String, String> map : dictionaries) {
            str.add(Joiner.on(ELEMENT_SPILT)
                    .withKeyValueSeparator(VALUE_SPILT)
                    .join(map));
        }
        return Joiner.on(ARRAY_SPILT).skipNulls().join(str);
    }



    public Map<String,String> [] load(String str) {

        if (Strings.isNullOrEmpty(str)) {
            return null;
        }

        List<Map<String, String>> res = new ArrayList<>();
        Iterable<String>  tmp= Splitter.on(ARRAY_SPILT)
                                        .trimResults()
                                        .omitEmptyStrings()
                                        .split(str);

        Iterator<String> iterator =tmp.iterator();

        while(iterator.hasNext()) {
            String s = iterator.next();
            res.add(Splitter.on(ELEMENT_SPILT).withKeyValueSeparator(VALUE_SPILT).split(s));
        }

        return res.toArray(new Map[res.size()]);
    }


    public static void main(String[] args) {

        DictSer dictSer = new DictSer();
        String s = "k1=v1;k2=v2\nn1=s1;n2=s2";

        Map<String, String>[] res = dictSer.load(s);
        String  storeResult = dictSer.store(res);
        System.out.println(storeResult);
    }


}


