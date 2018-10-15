package com.lydeliver.datastruture;

import com.sun.corba.se.spi.orbutil.proxy.CompositeInvocationHandlerImpl;

import java.util.PriorityQueue;

/**
 * @ClassName BinaryHeap
 * @Author jonathan
 * @Date 2018/10/8 12:52 PM
 * @Version 1.0
 * @Description 完全二叉树（二叉堆）的实现
 */
public class BinaryHeap<T extends Comparable<? super T>> {

    private static final int DEFAULT_CAPACITY = 10;

    private T [] array;
    private int currentSize;

    public BinaryHeap() {
        for (int i = currentSize / 2; i > 0; i--) {
            percolateDown(i);
        }
    }
    public BinaryHeap(int size) {
        array = (T[])new Object[size];
    }

    public BinaryHeap(T[] t) {
        currentSize = t.length;
        array = (T[])new Comparable[(currentSize+2)*11/10];
        int i=1;

        for (T ts : t) {
            array[i++] = ts;
        }
    }

    public void insert(T t){

        if (currentSize == array.length - 1) {
            enlargeArray(array.length*2+1);
        }
        int position = currentSize+1;

        for (;t.compareTo(array[position / 2]) < 0; position /= 2)
            array[position] = array[position/2];
       array[position] = t;
    }

    public T deleteMin() {
        if (isEmpty()) {
            throw new RuntimeException();
        }

        T min = findMin();
        array[1] = array[currentSize--];
        percolateDown(1);

        return min;

    }

    //堆排序核心
    public void percolateDown(int hole) {
        int child;
        T t = array[hole];
        for (; hole * 2 <= currentSize; hole = child) {
            child=hole*2;
            if (child != currentSize && array[child + 1].compareTo(array[child]) < 0) {
                child++;
            }
            if (array[child].compareTo(t)<0) {
                array[hole] = array[child];
            }else {
                break;
            }
        }
        array[hole] = t;
    }

    private T findMin() {
        return array[1];
    }

    public boolean isEmpty() {
        return currentSize==0;
    }

    private void enlargeArray(int newSize) {

    }

    private void swap(int a, int b) {
        T temp = array[a];
        array[b]=array[a];
        array[b]=temp;
    }

}
