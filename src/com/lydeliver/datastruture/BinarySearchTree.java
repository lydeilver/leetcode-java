package com.lydeliver.datastruture;

/**
 * @ClassName BinarySearchTree
 * @Author jonathan
 * @Date 2018/10/6 11:33 AM
 * @Version 1.0
 * @Description TODO
 */
public class BinarySearchTree<T extends Comparable<? super T>> {

    private BinaryNode<T> root;

    public boolean contains(T x) {
       return contains(x, root);
    }


    //中序遍历
    private void printTree(BinaryNode<T> binaryNode) {
        if (binaryNode != null) {
            printTree(binaryNode.lt);
            System.out.println(binaryNode.t);
            printTree(binaryNode.rt);
        }
    }

    //求树的高
    private int height(BinaryNode<T> binaryNode) {
        if (binaryNode == null) {
            return -1;
        }else{
            return 1 + Math.max(height(binaryNode.lt), height(binaryNode.rt));
        }
    }
    private BinaryNode<T>  findmin(BinaryNode<T> t) {
        if (t == null) {
           return null;
        } else if (t.lt == null) {
            return t;
        }

        return findmin(t.lt);
    }

    private BinaryNode<T>  findmax(BinaryNode<T> t) {
        if (t == null) {
            return null;
        } else if (t.rt == null) {
            return t;
        }

        return findmin(t.rt);
    }

    private BinaryNode<T> insert(T x, BinaryNode<T> tBinaryNode) {
        if (tBinaryNode == null) {
            return new BinaryNode<T>(x, null, null);
        }

        int compareResult = x.compareTo(tBinaryNode.t);

        if (compareResult < 0) {
            tBinaryNode.lt = insert(x, tBinaryNode.lt);
        }else if (compareResult > 0){
            tBinaryNode.rt =insert(x, tBinaryNode.rt);
        }

        return tBinaryNode;
    }



    private BinaryNode<T> remove(T x,BinaryNode<T> binaryNode) {
        if (binaryNode == null) {
            return binaryNode;
        }

        int compareResult = x.compareTo(binaryNode.t);

        if (compareResult < 0) {
            binaryNode.lt = remove(x, binaryNode.lt);
        } else if (compareResult > 0) {
            binaryNode.rt = remove(x, binaryNode.rt);
        } else if (binaryNode.lt != null && binaryNode.rt != null) {
            binaryNode.t = findmin(binaryNode.rt).t;
            binaryNode.rt = remove(binaryNode.t, binaryNode.rt);
        }else{
            binaryNode = (binaryNode.lt != null) ? binaryNode.lt : binaryNode.rt;
        }

        return binaryNode;


    }
    private boolean contains(T x,BinaryNode<T> t){
        if (t == null) {
            return false;
        }

        int compareResult = x.compareTo(t.t);
        if (compareResult < 0) {
            return contains(x, t.lt);
        }else if( compareResult >0){
            return contains(x, t.rt);
        }else {
            return true;
        }
    }

    private static class BinaryNode<T>{

        public BinaryNode(T t) {
            this(t, null, null);
        }

        public BinaryNode(T t, BinaryNode lt, BinaryNode rt) {
            this.t =t;
            this.lt =lt;
            this.rt =rt;
        }
        T t;
        BinaryNode<T> lt;
        BinaryNode<T> rt;
    }
}
