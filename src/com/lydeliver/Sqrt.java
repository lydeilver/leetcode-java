package com.lydeliver;

import java.util.NoSuchElementException;

/**
 * @ClassName Sqrt
 * @Author jonathan
 * @Date 2018/10/2 3:33 PM
 * @Version 1.0
 * @Description : solution binary search
 *
 **/

public class Sqrt {

    public int sqrtX(int x){

        int left =1,right = x-1;
        if (x < 2) {
            return x;
        }
        while (left <= right) {
            int mid = left+(right-left)/2;
            if (x / mid == mid) {
                return mid;
            }
            if (x / mid > mid) {
                left = mid + 1;
            }else {
                right = mid -1;
            }
        }
        return right;
    }

    /**
     * force
     * @param x
     * @return
     */
    public int sqrtX2(int x) {
        for (int i = 0; i < x / 2; i++) {
            if (x / i < i) {
                return i-1;
            }
        }
        throw new NoSuchElementException();
    }
}
