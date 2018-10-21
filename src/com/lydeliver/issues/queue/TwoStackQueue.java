package com.lydeliver.issues.queue;

import java.util.Stack;

/**
 * @ClassName TwoStackQueue
 * @Author jonathan
 * @Date 2018/10/17 3:37 PM
 * @Version 1.0
 * @Description use two stack implements queue
 */
public class TwoStackQueue {


    private Stack<Integer> s1;
    private Stack<Integer> s2;
    public TwoStackQueue(){
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    public void add(Integer val){
        s1.push(val);
    }

    public Integer remove(){
        while(!s1.empty()){
            s2.push(s1.pop());
        }
        return s2.pop();
    }

    public Integer peek(){
        while(!s1.empty()){
            s2.push(s1.pop());
        }
        return s2.peek();
    }
}
