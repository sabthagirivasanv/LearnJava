package com.leetcode;

class Median {
    AVLTree avl;
    Node root;

    public Median(){
        avl = new AVLTree();
    }

    public void addNum(int num) {
        root = avl.insert(root, num);
    }

    public double findMedian() {
        return root.value;
    }

    public static void main(String[] args) {
        Median median = new Median();
        median.addNum(1);
        median.addNum(2);
        median.addNum(3);
        median.addNum(4);
    }
}


class Node{
    int value;
    Node left, right;
    int height;
    int count;

    public Node(int value, int count){
        this.value = value;
        this.count = count;
    }

}

class AVLTree{


    int getBalance(Node N) {
        if (N == null)
            return 0;

        return height(N.left) - height(N.right);
    }

    int height(Node N) {
        if (N == null)
            return 0;

        return N.height;
    }

    int count(Node N) {
        if (N == null)
            return 0;

        return N.count;
    }

    int max(int a, int b) {
        return Math.max(a, b);
    }

    Node rightRotate(Node y) {
        Node x = y.left;
        Node T2 = x.right;

        // Perform rotation
        x.right = y;
        y.left = T2;

        // Update heights
        y.height = max(height(y.left), height(y.right)) + 1;
        x.height = max(height(x.left), height(x.right)) + 1;

        y.count = 1+ count(y.left) + count(y.right);
        x.count = 1+ count(x.left) + count(x.right);

        // Return new root
        return x;
    }

    // A utility function to left rotate subtree rooted with x
    // See the diagram given above.
    Node leftRotate(Node x) {
        Node y = x.right;
        Node T2 = y.left;

        // Perform rotation
        y.left = x;
        x.right = T2;

        //  Update heights
        x.height = max(height(x.left), height(x.right)) + 1;
        y.height = max(height(y.left), height(y.right)) + 1;

        y.count = 1+ count(y.left) + count(y.right);
        x.count = 1+ count(x.left) + count(x.right);

        // Return new root
        return y;
    }

    Node insert(Node node, int key) {

        /* 1.  Perform the normal BST insertion */
        if (node == null)
            return new Node(key, 1);

        if (key < node.value)
            node.left = insert(node.left, key);
        else node.right = insert(node.right, key);

        /* 2. Update height of this ancestor node */
        node.height = 1 + max(height(node.left),
                height(node.right));

        node.count = 1 + count(node.left) + count(node.right);

        /* 3. Get the balance factor of this ancestor
              node to check whether this node became
              unbalanced */
        int balance = getBalance(node);

        // If this node becomes unbalanced, then there
        // are 4 cases Left Left Case
        if (balance > 1 && key < node.left.value)
            return rightRotate(node);

        // Right Right Case
        if (balance < -1 && key > node.right.value)
            return leftRotate(node);

        // Left Right Case
        if (balance > 1 && key > node.left.value) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        // Right Left Case
        if (balance < -1 && key < node.right.value) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        /* return the (unchanged) node pointer */
        return node;
    }
}



/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
