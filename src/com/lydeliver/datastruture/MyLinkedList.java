package com.lydeliver.datastruture;

import java.util.Iterator;

/**
 * @ClassName MyLinkedList
 * @Author jonathan
 * @Date 2018/10/5 11:39 AM
 * @Version 1.0
 * @Description TODO
 */
public class MyLinkedList<T> implements Iterable<T> {

    private int theSize;
    private int modCount=0;
    private Node<T> beginMaker;
    private Node<T> endMaker;


    public MyLinkedList(){
        doClear();
    }

    public void clear(){
        doClear();
    }

    public void doClear(){
        beginMaker = new Node<>(null,null,null);
        endMaker = new Node<>(null,beginMaker,null);
        beginMaker.next=endMaker;
        theSize=0;
        modCount++;
    }

    public void addBefore(Node<T> p,T t) {
        Node<T> newNode = new Node<>(t,p.prev,p);
        newNode.prev.next = newNode;
        p.prev = newNode;
        theSize++;
        modCount++;
    }


    public Node<T> getNode(int idx, int lower, int upper) {
        Node<T> p;

        if (idx < lower || idx > upper) {
            throw new IndexOutOfBoundsException();
        }

        if (idx < size()/2) {
            p = beginMaker.next;
            for (int i = 0; i < idx; i++) {
                p = p.next;
            }
        }else {
            p = endMaker;
            for (int i = size(); i > idx; i--){
                p = p.prev;
            }

        }

        return p;
    }

    public T remove(Node<T> p) {
        p.prev.next=p.next;
        p.next.prev=p.prev;
        theSize--;
        modCount++;

        return p.data;
    }

    public int size() {
        return theSize;
    }

    public boolean isEmppty() {
        return size()==0;
    }




    private static class Node<T> {

        public T data;
        public Node next;
        public Node prev;

        public Node(T data, Node<T> prev, Node<T> next) {
            this.data = data;
            this.next = next;
            this.prev = prev;
        }
    }





    @Override

    public Iterator<T> iterator() {
        return null;
    }
}
