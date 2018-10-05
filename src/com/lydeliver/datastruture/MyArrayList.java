package com.lydeliver.datastruture;

import javax.swing.text.html.HTMLDocument;
import java.util.Iterator;

/**
 * @ClassName MyArrayList
 * @Author jonathan
 * @Date 2018/10/5 10:38 AM
 * @Version 1.0
 * @Description TODO
 */
public class MyArrayList<T> implements Iterable<T> {

    public T [] theItems;

    public void emsurCapacity(int newCapacity) {

        T [] old = theItems;
        theItems = (T[])new Object[newCapacity];

    }
    @Override
    public Iterator<T> iterator() {
        return null;
    }

    class Test{
        public <E> E test(E [] arr){
            return arr[0];
        }

    }
}
