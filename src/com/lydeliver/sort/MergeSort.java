package com.lydeliver.sort;

/**
 * @ClassName MergeSort
 * @Author jonathan
 * @Date 2018/10/10 6:21 PM
 * @Version 1.0
 * @Description TODO
 */
public class MergeSort {

    public <T extends Comparable<? super T>> void merge(T [] ts,T [] tmps,int ls,int le,int re) {
        int rs = le+1;
        int i =0;
        int numElements = re-ls+1;
        while (ls <= le && rs <= re) {
            if (ts[ls].compareTo(ts[rs])<0) {
                tmps[i++] = ts[ls++];
            }else{
                tmps[i++] = ts[rs++];
            }
        }

        while (ls <= le) {
            tmps[i++] = ts[ls++];
        }
        while (rs <= re) {
            tmps[i++] = ts[rs++];
        }

        for (int j = 0; i < numElements; j++, i--) {
            ts[i]=tmps[i];
        }


    }

    public <T extends Comparable<? super T>> void mergeSort(T [] ts) {

        T [] tmps = (T[])new Object[ts.length];
        mergeSort(ts,tmps,0,ts.length-1);
    }

    private <T extends Comparable<? super T>> void mergeSort(T [] ts,T [] tmps,int left,int right) {
        if (left < right) {
            int mid = left+right/2;
            mergeSort(ts,tmps,left,mid);
            mergeSort(ts,tmps,mid+1,right);
            merge(ts,tmps,left,mid,right);
        }
    }

    public void merge(int []nums,int [] tmp,int start,int end){
        if (start >= end) {
            return;
        }
        int mid =(start+end)/2;
        merge(nums,tmp,start,mid-1);
        merge(nums, tmp, mid + 1, end);
        merges(nums, tmp, start, mid, end);
    }
    private void merges(int []nums,int [] tmp,int start,int mid,int end){
        int ls =start;
        int rs =mid+1;
        int ts=start;
        int pos = end-start+1;

        while (ls <= mid && rs <= end) {
            if(nums[ls]<nums[rs]){
                tmp[ts++]=nums[ls++];
            }else{
                tmp[ts++]=nums[rs++];
            }
        }

        while (ls <= mid) {
            tmp[ts++]=nums[ls++];
        }
        while (rs <= mid) {
            tmp[ts++]=nums[rs++];
        }
        for (int i = 0; i < pos; i++, end--) {
            nums[end] = tmp[end];
        }
    }


}
