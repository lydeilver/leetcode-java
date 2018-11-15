package com.lydeliver.oodesgin.fileSystem;

import java.util.ArrayList;

/**
 * @ClassName Directory
 * @Author jonathan
 * @Date 2018/11/8 12:16 PM
 * @Version 1.0
 * @Description TODO
 */
public class Directory extends Entry {

    protected ArrayList<Entry> contents;
    @Override
    int size() {
        return 0;
    }
}
