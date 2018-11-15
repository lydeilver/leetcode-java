package com.lydeliver.oodesgin.fileSystem;

/**
 * @ClassName Entry
 * @Author jonathan
 * @Date 2018/11/8 12:15 PM
 * @Version 1.0
 * @Description TODO
 */
public abstract class Entry {

    protected Directory parent;
    protected long created;
    protected long lastUpdated;
    protected long lastAccessed;
    protected String name;

    abstract int size();
}
