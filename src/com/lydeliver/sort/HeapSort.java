package com.lydeliver.sort;

/**
 * @ClassName HeapSort
 * @Author jonathan
 * @Date 2018/10/10 1:01 PM
 * @Version 1.0
 * @Description 堆排序，只用数组而不用额外的ADT
 * 数组从0开始
 * leftchild = i*2+1;
 * rightchild= i*2+2;
 * 先初始化数组变成最大值在跟上的堆
 * 然后每次首位节点互换位置，在做下虑，最终达到全排序目的
 * 时间复杂度O(NlogN)
 */
public class HeapSort {

    public  int leftChild(int i) {
        return i*2+1;
    }



    public  <T extends Comparable<? super T>> void  percDown(T [] nums,int i,int n){


        T tmp = nums[i];
        int child;
        for (; i < n / 2; i=child) {
            child = leftChild(i);
            if (child < n && nums[child].compareTo(nums[child + 1]) < 0) {
                child++;
            }
            if (tmp.compareTo(nums[child]) < 0) {
                nums[i] = nums[child];
            }else {
                break;
            }
        }
        nums[i] = tmp;

    }


    public <T extends Comparable<? super T>> void heapSort(T [] nums) {
        if (nums == null) {
            return;
        }
        for (int i = nums.length/2-1; i >=0 ; i--) {
            percDown(nums, i,nums.length);
        }

        for (int i = nums.length - 1; i > 0; i--) {
            swapReferences(nums,0,1);
            percDown(nums, 0,1);

        }
    }

    private <T> void swapReferences(T [] nums,int a,int b) {
        T tmp = nums[a];
        nums[a] =nums[b];
        nums[b] =tmp;
    }

}
