package com.lydeliver.issues.stack;

import java.util.Stack;

/**
 * @ClassName SortStack
 * @Author jonathan
 * @Date 2018/10/17 5:19 PM
 * @Version 1.0
 * @Description TODO
 */
public class SortStack {

    public Stack<Integer> sort(Stack<Integer> stack){
        Stack<Integer> tmp = new Stack<>();
        while(!stack.isEmpty()){
            int val = stack.pop();
            if(tmp.isEmpty()){
                tmp.push(val);
            }else{
                while(tmp.peek()>val){
                    stack.push(tmp.pop());
                }
                tmp.push(val);
            }
        }
        return tmp;
    }
}
