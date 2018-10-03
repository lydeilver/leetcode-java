package com.lydeliver;

/**
 * @ClassName NextPermutation
 * @Author jonathan
 * @Date 2018/10/3 6:33 PM
 * @Version 1.0
 * @Description 注意 关键操作是：
 * 在从右侧扫描数字时，我们只是继续递减索引直到我们找到 a[i]a[i] 和 a[i-1]a[i−1] 这对数。
 * 其中，a[i] &gt; a[i-1]a[i]>a[i−1]。因此，a[i-1]a[i−1] 右边的所有数字都已按降序排序。
 * 此外，交换 a[i-1]a[i−1] 和 a[j]a[j] 并未改变该顺序。因此，我们只需要反转 a[i-1]a[i−1] 之后的数字，以获得下一个最小的字典排列。
 */
public class NextPermutation {

    public void nextPermutation(int[] nums) {
        int i = nums.length-2;
        while(i>=0 && nums[i+1]<=nums[i])
            i--;

        if(i>=0){
            int j = nums.length-1;
            while(j>=0 && nums[j]<=nums[i])
                j--;
            swap(i,j,nums);
        }

        int l=i+1,r=nums.length-1;
        while(l<r){
            swap(l,r,nums);
            l++;
            r--;
        }


    }


    public void swap(int a,int b,int [] nums){
        int temp = nums[a];
        nums[a]=nums[b];
        nums[b]=temp;
    }
}
