package com.lydeliver.issues.stack;

/**
 * @ClassName Hanoi
 * @Author jonathan
 * @Date 2018/10/17 3:41 PM
 * @Version 1.0
 * @Description hanoi issue
 */
public class Hanoi {

    /**
     * 3.4 汉诺塔问题
     * 最经典递归解法
     * 先把a上的最上面n-1个盘移动到中间
     * 再把a上最后一个圆盘（n==1）移动到最右边
     * 再把中间的塔的圆盘都移动到最右边
     */
    public void dotower(int n, String a, String b, String c) {
        if (n == 1) {
            System.out.println("put "+n+" from "+a+" to "+c);
        }else{
            dotower(n - 1, a, c, b);
            System.out.println("put "+n+" from "+a+" to "+c);
            dotower(n - 1, b, a, c);
        }

    }

    /**
     * 汉诺塔问题 stack解法
     *
     */
    private class Tower{
        java.util.Stack<Integer> disks;
        int index;

        public Tower(int index) {
            disks = new java.util.Stack<>();
            this.index =index;
        }

        int index() {
            return index;
        }

        public void add(int d) {
            if( !disks.isEmpty() && disks.pop()<=d){
                System.out.println("error");
            }else {
                disks.push(d);
            }
        }

        public void moveTopTo(Tower tower) {
            int top = disks.pop();
            tower.add(top);

        }

        public void moveDisks(int n, Tower d,Tower buffer) {
            if (n > 0) {
                moveDisks(n - 1, buffer, d);
                moveTopTo(d);
                buffer.moveDisks(n-1,d,this);
            }
        }

    }

}
