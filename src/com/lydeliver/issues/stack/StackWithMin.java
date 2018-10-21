package com.lydeliver.issues.stack;

import java.util.Stack;

/**
 * @ClassName StackWithMin
 * @Author jonathan
 * @Date 2018/10/17 3:43 PM
 * @Version 1.0
 * @Description 能返回剩余stack最小值的stack，时间复杂度为O(1)
 */
class NodeWithMin  {
    int v;
    int min;

    NodeWithMin(int value, int min) {
        this.v =value;
        this.min=min;
    }


}

public class StackWithMin extends Stack<NodeWithMin> {

    public void push(int v){
        int newMin = Math.min(v, min());
        super.push(new NodeWithMin(v,newMin));
    }

    public NodeWithMin pop() {
        return super.pop();
    }

    public int min() {
        if (this.isEmpty()) {
            return Integer.MAX_VALUE;
        }
        return peek().min;
    }



}

/**
 * 用另一个stack来存储最小值，
 * 注意继承与重写。
 */
class StackWithMin2 extends Stack<Integer>{
    Stack<Integer> s2;

    public StackWithMin2() {
        s2 = new Stack<>();
    }

    public Integer push(Integer value) {
        if (value <= min()) {
            s2.push(value);
        }
        return super.push(value);
    }

    public Integer pop() {
        int value = super.pop();
        if (value == min()) {
            s2.pop();
        }
        return value;
    }

    public int min() {
        if (s2.isEmpty()) {
            return Integer.MAX_VALUE;
        }else {
            return s2.peek();
        }
    }
}