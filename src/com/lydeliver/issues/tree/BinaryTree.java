package com.lydeliver.issues.tree;

import apple.laf.JRSUIUtils;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @ClassName BinaryTree
 * @Author jonathan
 * @Date 2018/10/18 4:47 PM
 * @Version 1.0
 * @Description TODO
 */

public class BinaryTree<T extends Comparable<? super T>>{

    TreeNode<T> node ;

    //检查是否平衡，不平衡返回-1，平衡返回height
    public int checkHeight(TreeNode<T> node){
        if(node == null){
            return 0;
        }


        if(checkHeight(node.lt)==-1){
            return -1;
        }

        if(checkHeight(node.rt)==-1){
            return -1;
        }

        int heightDiff = Math.abs(checkHeight(node.lt)-checkHeight(node.rt));
        if(heightDiff>1){
            return -1;
        }
        return Math.max(checkHeight(node.lt),checkHeight(node.rt));

    }
    public boolean isBalanced(TreeNode<T> node){
        if(node==null){
            return true;
        }

        int heightDiff =Math.abs(height(node.lt)-height(node.rt));
        if(heightDiff>1){
            return false;
        }else{
            return isBalanced(node.lt)&&isBalanced(node.rt);
        }
    }

    public TreeNode<T> insert(T t,TreeNode<T> node){
        if(node == null){
            return new TreeNode<T>(t);
        }

        int compareResult = t.compareTo(node.data);
        if(compareResult<0){
            node.lt = insert(t,node.lt);
        }else if (compareResult>0){
            node.rt = insert(t,node.rt);
        }
        return node;
    }

    public TreeNode<T> remove(T t,TreeNode<T> node){
        if(node ==null){
            return null;
        }

        int compareResult = t.compareTo(node.data);
        if(compareResult>0){
            node.rt = remove(t,node.rt);
        }else if(compareResult<0){
            node.lt = remove(t,node.lt);
        }else if(node.lt!=null& node.rt!=null){
            node.data = findMin(node.rt).data;
            node.rt = remove(node.data,node.rt);
        }else{
            node = (node.lt==null)? node.rt:node.lt;
        }
        return node;
    }

    public TreeNode<T> findMin(TreeNode<T> node){
        if(node==null){
            return node;
        }else if(node.lt==null){
            return node;
        }
        return findMin(node.lt);
    }

    public TreeNode<T> findMax(TreeNode<T> node){
        if(node==null){
            return null;
        }else if (node.rt == null){
            return node;
        }
        return findMax(node.rt);
    }

    public boolean contains(T t,TreeNode<T> node){
        if(node == null){
            return false;
        }
        if(node.data.compareTo(t)>0){
            contains(t,node.lt);
        }else if(node.data.compareTo(t)<0){
            contains(t,node.rt);
        }
            return true;
    }

    public int height(TreeNode<T> node){
        if(node==null){
            return -1;
        }else{
            return 1+Math.max(height(node.lt),height(node.rt));
        }
    }

    public void printTree(TreeNode<T> node){
        if(node!=null){
            printTree(node.lt);
            System.out.println(node.data);
            printTree(node.rt);
        }
    }

    public LinkedList<T> find(TreeNode<T> node , int deep) {
        LinkedList<T> list = new LinkedList<>();
        find(list, node, deep);
        return list;
    }
    private void find(LinkedList<T> list, TreeNode<T> node , int deep){
        if(deep==0){
            list.add(node.data);
            return;
        }
        if(node==null){
            return;
        }
        find(list,node.lt,deep--);
        find(list,node.rt,deep--);
    }



    private static class TreeNode<T>{
        T data;
        TreeNode<T> lt;
        TreeNode<T> rt;

        public TreeNode(T data){
            this(data,null,null);
        }

        public TreeNode(T data,TreeNode<T> lt,TreeNode<T> rt){
            this.data =data;
            this.lt =lt;
            this.rt =rt;
        }



    }


    /**
     * 4.3 给定一个有序数组，创建一颗高度最小二叉查找树（BST)
     * @param arrs
     * @param start
     * @param end
     * @return
     */
    public TreeNode<T> createMinimalBST(T [] arrs,int start,int end)
    {
        if(start>end){
            return null;
        }

        int mid = (start+end)/2;
        TreeNode<T> node = new TreeNode<>(arrs[mid]);
        node.lt=createMinimalBST(arrs,start,mid-1);
        node.rt=createMinimalBST(arrs,mid+1,end);
        return node;
    }

    /**
     * 创建含有某一个深度上所有节点的链表
     * BFS 变种
     * @param root
     * @return
     */
    public ArrayList<LinkedList<TreeNode>> createLevelLinkedList(TreeNode root){
        ArrayList<LinkedList<TreeNode>> result = new ArrayList<LinkedList<TreeNode>>();
        LinkedList<TreeNode> current = new LinkedList<>();

        if(root!=null){
            current.add(root);
        }
        while(!current.isEmpty()){
            result.add(current);
            LinkedList<TreeNode> parents = current;
            current = new LinkedList<TreeNode>();
            for(TreeNode parent : parents){
                if(parent.lt!=null){
                    current.add(parent.lt);
                }
                if(parent.rt!=null){
                    current.add(parent.rt);
                }
            }
        }
        return result;
    }


    /**
     * method2
     * 前序遍历变种
     * @param
     */

    public void createLevelLinkedList(ArrayList<LinkedList<TreeNode>> lists,TreeNode root,int level){
        if (root == null) {
            return ;
        }
        LinkedList<TreeNode> list =null;
        if (level == lists.size()) {
            list = new LinkedList<>();
            lists.add(list);
        }else{
            list = lists.get(level);
        }
        list.add(root);

        createLevelLinkedList(lists, root.lt, level++);
        createLevelLinkedList(lists, root.rt, level++);



    }

    public boolean checkBST(TreeNode<T> root,T min,T max){

        if(root==null){
            return true;
        }

        if(root.data.compareTo(min)<0 || root.data.compareTo(max)>0){
            return false;
        }

        return checkBST(root.lt,min,root.data)&&checkBST(root.rt,root.data,max);


    }

    public static void main(String[] args) {
        BinaryTree<Integer> treeNode = new BinaryTree<>();
        Integer [] arrs ={1,2,3,4,6,7,8,9,10,11,12};
        TreeNode<Integer> node = treeNode.createMinimalBST(arrs,0, 10);
        LinkedList<Integer> res = treeNode.find(node,3);
        System.out.println(res);
    }

}



