package com.lydeliver.datastruture;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName SeparateChiningHashTable
 * @Author jonathan
 * @Date 2018/10/7 2:26 PM
 * @Version 1.0
 * @Description 实现分离链接法
 */
public class SeparateChiningHashTable<T> {

    private static final int DEFAULT_TABLE_SIZE=101;

    private List<T>[] theList;
    private int currentSize;



    public SeparateChiningHashTable() {
        this(DEFAULT_TABLE_SIZE);
    }

    public SeparateChiningHashTable(int size) {
        theList = new LinkedList[nextPrime(size)];
        for (int i = 0; i < theList.length; i++) {
            theList[i] = new LinkedList<>();
        }
    }

    public void makeEmpty() {
        for (int i = 0; i < theList.length; i++) {
            theList[i].clear();
        }
        currentSize=0;
    }

    public boolean contains(T t) {

        List<T> whichList = theList[myHash(t)];
        return whichList.contains(t);
    }

    public void insert(T t) {
        List<T> whichList = theList[myHash(t)];
        if (!whichList.contains(t)) {
            whichList.add(t);

            if (++currentSize > theList.length) {
                rehash();
            }
        }
    }

    public void remove(T t) {
        List<T> whichList = theList[myHash(t)];
        if(whichList.contains(t)){
            whichList.remove(t);
            currentSize--;
        }
    }

    private void rehash() {
        List<T> [] oldList = theList;

        theList = new List[nextPrime(2*theList.length)];

        for (int j = 0; j < theList.length; j++) {
            theList[j] = new LinkedList<>();
        }
        currentSize=0;
        for (int i = 0; i < oldList.length; i++) {
            for(T t : oldList[i]){
                insert(t);
            }

        }
    }

    private static int nextPrime( int n )
    {
        if( n % 2 == 0 )
            n++;

        for( ; !isPrime( n ); n += 2 )
            ;

        return n;
    }

    /**
     * Internal method to test if a number is prime.
     * Not an efficient algorithm.
     * @param n the number to test.
     * @return the result of the test.
     */
    private static boolean isPrime( int n )
    {
        if( n == 2 || n == 3 )
            return true;

        if( n == 1 || n % 2 == 0 )
            return false;

        for( int i = 3; i * i <= n; i += 2 )
            if( n % i == 0 )
                return false;

        return true;
    }
    private int myHash(T t) {
        int hasVal = t.hashCode();

        hasVal %= theList.length;

        if (hasVal < 0) {
            hasVal+=theList.length;
        }

        return hasVal;

    }
}
