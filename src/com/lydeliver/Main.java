package com.lydeliver;

public class Main {

    public static void main(String[] args) {
	// write your code here

        Sqrt sqrt = new Sqrt();
        ThreeSumCloset threeSumCloset = new ThreeSumCloset();
        System.out.println( threeSumCloset.threeSumClosest(new int[]{1,1,1,1},0));

        FourSum fourSum = new FourSum();
    //    System.out.println( fourSum.fourSum1(new int[]{-3,-2,-1,0,0,1,2,3},0));

        NextPermutation nextPermutation = new NextPermutation();
        nextPermutation.nextPermutation(new int[]{1,5,1});
    }/**/
}
