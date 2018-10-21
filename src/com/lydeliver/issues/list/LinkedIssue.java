package com.lydeliver.issues.list;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @ClassName LinkedIssue
 * @Author jonathan
 * @Date 2018/10/16 10:02 AM
 * @Version 1.0
 * @Description TODO
 */
public class LinkedIssue<T extends Comparable<? super T>> {

    private static class Node<T>{
        T t;
        Node<T> next;
        public Node(T t){
            this.t = t;
        }

    }

    //2.1 移除未排序链表中重复节点
    public void deleteDups(Node<T> node){
        if (node == null) {
            return;
        }

        while (node != null) {
            Node<T> tmp = node;
            while (tmp.next != null) {
                if(node.t.compareTo(node.next.t)==0){
                    tmp.next = tmp.next.next;
                }else{
                    tmp = tmp.next;
                }
            }
            node = node.next;
        }
    }

    public void deleteDups2(Node<T> node){
        if(node == null){
            return;
        }
        Map<T,T> map = new HashMap<>();
        Node pre =null;
        while(node!=null){
            if(map.containsKey(node.t)){
                pre.next = node.next;
            }else{
                map.put(node.t,node.t);
                pre = node;
            }
            node =node.next;
        }
    }


    public Node<T> findK(Node<T> node,int k){

        if(node == null)
            return null;

        int len=1;
        Node<T> tmp = node;
        while(tmp.next !=null){
            tmp = tmp.next;
            len++;
        }

        while(len != len-k){
            node=node.next;
            len--;
        }
        return node;

    }

    //递归法
    public Node<T> findK2(Node<T> node ,int k,int i){
        if(node == null){
            return null;
        }
        Node<T> head = findK2(node.next ,k,i);
        i+=1;
        if(i==k){
            return node;
        }
        return head;
    }

    //双指针法
    public Node<T> findK3(Node<T> node ,int k){
        Node<T> p1 = node;
        Node<T> p2 = node;
        int i=0;
        while(i!=k){
            if(p2.next==null) return null;
            p2 = p2.next;
            i++;
        }

        while(p2.next==null){
            p1=p1.next;
            p2=p2.next;
        }
        return p1;
    }


    //2.3 删除单项链表中的某个节点，你只能访问该节点
    //把后面的节点复制到当前节点，在删除后面节点即可，如果节点为末尾节点，则无解。
    public boolean deleteNode(Node<T> node){
        if(node==null&&node.next ==null) return false;
        Node<T> nextNode = node.next;
        node.t = nextNode.t;
        node.next = nextNode.next;
        return true;
    }


    //2.4给定值x分割链表为大小两部分
    public Node<T> spiltNode(Node<T> node,T x){
        Node<T> min = new Node<>(x);
        Node<T> max = new Node<>(x);
        Node<T> tmpMin = min;
        Node<T> tmpMax = max;
        while(node!=null){
            if(x.compareTo(node.t)>0){
                tmpMin.next = new Node<T>(node.t);
                tmpMin = tmpMin.next;

            }else{
                tmpMax.next = new Node<T>(node.t);
                tmpMax = tmpMax.next;

            }
            node =node.next;
        }
        tmpMin.next = max.next;
        return min.next;

    }
    //方法2，将节点加在链表前端
    public Node<T> spiltNode2(Node<T> node,T x){
        Node<T> beforeNode =null;
        Node<T> afterNode = null;
        while(node!=null){
            Node<T> next = node.next;
            if(x.compareTo(node.t)>0){
                node.next=beforeNode;
                beforeNode =node;
            }else{
                node.next=afterNode;
                afterNode =node;
            }
            node = next;
        }
        if (beforeNode == null) {
            return afterNode;
        }
        Node<T> head = beforeNode;
        while (beforeNode.next != null) {
            beforeNode = beforeNode.next;
        }
        beforeNode.next=afterNode;

        return head;
    }

    //2.5 链表相加
    public Node<Integer> add(Node<Integer> node1,Node<Integer> node2){

        if(node1==null){
            return node2;
        }else if(node2 == null){
            return node1;
        }
        int count =0;
        Node<Integer> res = new Node<>(0);
        Node<Integer> tmp =res;
        while(node1!=null && node2!=null){
            int val = node1.t+node2.t+count;
            count = val/10;
            tmp.next = new Node(val%10);
            tmp = tmp.next;
            node1 = node1.next;
            node2 = node2.next;
        }

        while(node1!=null){
            int val = node1.t+count;
            count = val/10;
            tmp.next = new Node(val%10);
            tmp = tmp.next;
            node1 = node1.next;
        }
        while(node2!=null){
            int val = node2.t+count;
            count = val/10;
            tmp.next = new Node(val%10);
            tmp = tmp.next;
            node2 =node2.next;
        }
        if(count!=0){
            tmp.next = new Node(count);
        }
        return res.next;
    }

    public static void main(String[] args) {
/*        Node node = new Node(1);
        node.next = new Node(9);
        node.next.next = new Node(4);
        Node node2 = new Node(1);
        node2.next = new Node(3);
        node2.next.next= new Node(6);
        node2.next.next.next= new Node(9);

        LinkedIssue linkedIssue = new LinkedIssue();
        linkedIssue.add(node,node2);*/


        Node node = new Node(1);
        node.next = new Node(2);
        node.next.next = new Node(3);
        node.next.next.next = new Node(2);
        node.next.next.next.next= new Node(1);
        LinkedIssue linkedIssue = new LinkedIssue();
        linkedIssue.isPalindrome(node);
    }



    public Node<Integer> addLists(Node<Integer> node1,Node<Integer> node2,int carry){
        if(node1==null && node2==null && carry==0)
            return null;

        Node<Integer> res = new Node<>(0);
        int value = carry;
        if(node1!=null)
            value+=node1.t;

        if(node2!=null)
            value+=node2.t;

        res.t = value%10;

        Node<Integer> more = addLists(node1==null?null:node1.next
                ,node2==null?null:node2.next,value/10);
        res.next = more;
        return res;
    }


    /**  2.6 实现算法返回环路开头节点
      *  Warn  比较两个节点相等应该用 ==
      *  链表无非是 两个指针循环，递归去解决
      */
    public Node<T> findBeginging(Node<T> node){

        Node<T> slow = node;
        Node<T> fast = node;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                break;
            }
        }

        slow = node;
        while(slow==fast){
            slow=slow.next;
            fast= fast.next;
        }

        return slow;

    }


    /**
     * 2.7 判断是否是回文
     * myway 反转整个链表，判断新旧是否一样
     * @param node
     * @return
     */
    public boolean isPalindrome(Node<T> node){
        if(node == null) return false;
        Node<T> reverse = new Node<>(node.t);
        Node<T> tmp = node.next;
        while(tmp!=null){
            Node<T> n = new Node<>(tmp.t);
            n.next =reverse;
            reverse = n;
            tmp = tmp.next;
        }

        while(node!=null){
            if(node.t.compareTo(reverse.t)!=0){
                return false;
            }
            node=node.next;
            reverse=reverse.next;
        }
        return true;
    }

    public boolean isPalindrome2(Node<T> node) {
        Node<T> slow =node;
        Node<T> fast =node;
        Stack<T> stack = new Stack<>();
        while (fast != null && fast.next != null) {
            stack.push(slow.t);
            slow=slow.next;
            fast=fast.next.next;
        }
        if(fast!=null){
            slow = slow.next;
        }

        while (slow != null) {
            if (slow.t.compareTo(stack.pop()) != 0) {
                return false;
            }
        }
        return true;

    }


}