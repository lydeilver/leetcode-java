package com.lydeliver.datastruture;

import java.util.TreeMap;

/**
 * @ClassName TreeNode
 * @Author jonathan
 * @Date 2018/10/6 11:08 AM
 * @Version 1.0
 * @Description TODO
 */
public class TreeNode<T> {

    public TreeNode(T t) {
        this(t, null, null);
    }
    public TreeNode(T t,TreeNode<T> lt,TreeNode<T> rt ){
        this.element =t;
        this.firstChild = lt;
        this.leftChild = rt;
    }

    T element;
    TreeNode<T> firstChild;
    TreeNode<T> leftChild;

}
