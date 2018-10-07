package com.lydeliver.datastruture;

/**
 * @ClassName AvlBinarySearchTree
 * @Author jonathan
 * @Date 2018/10/6 1:27 PM
 * @Version 1.0
 * @Description TODO
 */
public class AvlBinarySearchTree<T extends Comparable<? super T>> {




    private AvlNode<T> root;
    private static final int ALLOW_IMBALANCE = 1;

    private int height(AvlNode<T> t) {
        return t == null ? null : t.hegiht;
    }


    private AvlNode<T> insert(T x,AvlNode<T> avlNode) {
        if (avlNode == null) {
            return new AvlNode<T>(x);
        }

        int compareResult = x.compareTo(avlNode.element);
        if (compareResult < 0) {
            avlNode.left = insert(x, avlNode.left);
        } else if (compareResult > 0) {
            avlNode.right = insert(x, avlNode.right);
        }

        return balance(avlNode);
    }

    //平衡
    private AvlNode<T> balance(AvlNode<T> avlNode) {
        if (avlNode == null) {
            return avlNode;
        }

        if (height(avlNode.left) - height(avlNode.right) > ALLOW_IMBALANCE) {
            if(height(avlNode.left.left)>= height(avlNode.left.right)){
                rotateWithLeftChild(avlNode);//左左
            }else {
                doubleWithLeftChild(avlNode);//左右
            }
        }else if (height(avlNode.right) - height(avlNode.left) > ALLOW_IMBALANCE){
            if(height(avlNode.right.right)>= height(avlNode.right.left)){
                rotateWithRightChild(avlNode);//右右
            }else {
                doubleWithRightChild(avlNode);//右左
            }
        }

        avlNode.hegiht = Math.max(height(avlNode.left),height(avlNode.right))+1;

        return avlNode;
    }

    private AvlNode<T> remove(T t, AvlNode<T> avlNode) {
        if (avlNode == null) {
            return avlNode;
        }

        int compareResult = t.compareTo(avlNode.element);
        if (compareResult < 0) {
            avlNode.left = remove(t, avlNode.left);
        } else if (compareResult > 0) {
            avlNode.right = remove(t, avlNode.right);
        } else if (avlNode.left != null && avlNode.right != null) {
            avlNode.element = findmin(avlNode.right).element;
            avlNode.right = remove( avlNode.element,avlNode.right);
        }else {
            avlNode = (avlNode.left==null)?avlNode.left:avlNode.right;
        }

        return balance(avlNode);
    }

    private AvlNode<T> findmin(AvlNode<T> avlNode) {
        if (avlNode == null) {
            return avlNode;
        } else if (avlNode.left == null) {
            return avlNode;
        }
        return findmin(avlNode);
    }
    /**
     * 左单旋转
     * @param k2
     * @return
     *
     *       k2           k1
     *      |  |         |  |
     *     k1  z   -->   x  k2
     *     | |             |  |
     *     x  y            y  z
     */

    private AvlNode<T> rotateWithLeftChild(AvlNode<T> k2) {
        AvlNode<T> k1 =k2.left;
        k2.left=k1.right;
        k1.right=k2;
        k2.hegiht = Math.max(k2.left.hegiht,k2.right.hegiht)+1;
        k1.hegiht=Math.max(k1.left.hegiht,k1.right.hegiht)+1;

        return k1;
    }

    //右单旋转
    private AvlNode<T> rotateWithRightChild(AvlNode<T> k1) {
        AvlNode<T> k2 =k1.right;
        k1.right=k2.left;
        k2.left=k1;
        k2.hegiht = Math.max(k2.left.hegiht,k2.right.hegiht)+1;
        k1.hegiht=Math.max(k1.left.hegiht,k1.right.hegiht)+1;

        return k1;
    }

    /**
     * 双旋转
     * @param k3
     * @return
     *
     *            k3                k2
     *        |        |          |     |
     *        k1       D          k1    k3
     *       |  |                |  |   |  |
     *       A  k2               A  B   C  D
     *         |  |
     *         B  c
     */
    private AvlNode<T> doubleWithLeftChild(AvlNode<T> k3) {
        k3.left = rotateWithRightChild(k3.left);
        return rotateWithLeftChild(k3);
    }

    private AvlNode<T> doubleWithRightChild(AvlNode<T> k3) {
        k3.right = rotateWithLeftChild(k3.right);
        return rotateWithRightChild(k3);
    }


    private static class AvlNode<T>{
        public AvlNode(T element) {
            this(element, null, null);
        }
        public AvlNode(T element,AvlNode<T> left,AvlNode<T> right) {
            this.element = element;
            this.left = left;
            this.right = right;
            this.hegiht=0;
        }
        T element;
        AvlNode<T> left;
        AvlNode<T> right;
        int hegiht;
    }
}
