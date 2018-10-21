package com.lydeliver.issues.queue;

import com.sun.javafx.scene.control.skin.DoubleFieldSkin;
import com.sun.tools.javac.util.GraphUtils;

import java.util.Queue;
import java.util.Stack;

/**
 * @ClassName StackQueue
 * @Author jonathan
 * @Date 2018/10/16 6:30 PM
 * @Version 1.0
 * @Description
 *
 * 包含了stack 和 quere 的相关问题
 * 用链表实现了statck & queue
 *
 */
public  class StackQueue<T >{


    private static class Node<T>{
        T t;
        Node<T> next;
        public Node(T t){
            this.t = t;

        }

    }
    private  class Stack<T extends  Comparable<? super T>>{
         Node<T> node;

        void push(T t){
            if(node ==null){
                node = new Node<>(t);
            }else{
                Node<T> before = new Node<T>(t);
                before.next =node;
                node =before;
            }

        }

         T pop(){
            if(node ==null)return null;
            Node<T> tmp = node;
            node =node.next;
            return tmp.t;
        }

         T peek(){
            return node.t;
        }

    }





    private static class Queue<T>{
        Node<T> first,last;

        void enqueue(T t) {
            if (first == null) {
                last = new Node<>(t);
                first = last;
            }else{
                last.next = new Node(t);
                last = last.next;
            }
        }

        T dequeue(){
            if (first == null) {
                return null;
            }
            T res = first.t;
            first = first.next;
            return res;
        }
    }


    /**
     * 用一个数组构造是那个stack
     */
    private T [] nums =(T[])new Object[DEFAULT_SIZE*3];
    private static final int DEFAULT_SIZE = 100;
    int [] stackPointer = {-1,-1,-1};


    void push(int stackNum,T t) throws Exception{
        if(stackPointer[stackNum]+1>DEFAULT_SIZE){
            throw new Exception("out of space");

        }
        stackPointer[stackNum]++;
        nums[stackNum*DEFAULT_SIZE+stackPointer[stackNum]]=t;
    }

    T pot(int stackNum) throws Exception{
        if(stackPointer[stackNum]==-1){
            throw new Exception("stack is null!");
        }
        return nums[stackNum*DEFAULT_SIZE+stackPointer[stackNum--]];
    }

}



/**
 * 设计一个stack满了时可以自增的stack
 *
 * ArrayList<Stack> array = new ArrayList<Stack>
 */
class SetOfStacks{

    private static final int DEFAULT_SIZE =10;

    private Node stack;
    private int length;

    public SetOfStacks() {
        newNode();
    }

    public void push(Integer value) {

        if (stack.pointer + 1 == DEFAULT_SIZE) {
            newNode();
        }
        stack.nums[++stack.pointer] = value;

    }

    public int pop() {
        if (stack.pointer == -1 && stack.next == null) {
            return 0;
        }
        return stack.nums[stack.pointer--];

    }

    private void newNode() {
        int[] nums = new int[DEFAULT_SIZE];
        if(stack == null){
            stack = new Node(nums, null,-1);
        }else{
            Node n = new Node(nums, null,-1);
            n.next = stack;
            stack =n;
        }
        length++;
    }

    public int popAt(int index) {
        if (index > length) {
            return 0;
        }
        Node tmp =stack;
        for (int i = 0; i < length - index + 1; i++) {
            tmp = tmp.next;
        }
        return tmp.nums[tmp.pointer--];
    }


    private class Node{
        int [] nums;
        Node next;
        int pointer;

        public Node(int[] nums, Node next,int pointer) {
            this.nums = nums;
            this.next = next;
            this.pointer =pointer;
        }
    }

}



