package com;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

// non-recursive java program for inorder traversal

/* Class containing left and right child of
current node and key value*/
/* Class to print the inorder traversal */
class BinaryTree
{
    Node root;
    void inorder()
    {
        if (root == null)
            return;


        Stack<Node> s = new Stack<Node>();
        Node curr = root;

        // traverse the tree
        while (curr != null || s.size() > 0)
        {

			/* Reach the left most Node of the
			curr Node */
            if(curr != null)
            {
				/* place pointer to a tree node on
				the stack before traversing
				the node's left subtree */
                s.push(curr);
                curr = curr.left;
                continue;
            }

            /* Current must be NULL at this point */
            curr = s.pop();

            System.out.print(curr.data + " ");

			/* we have visited the node and its
			left subtree. Now, it's right
			subtree's turn */
            curr = curr.right;
        }
    }

}

public class InOrderIterative {
    public static void main(String args[])
    {

		/* creating a binary tree and entering
		the nodes */
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.right.left = new Node(4);
        tree.root.right.right = new Node(5);
        tree.inorder();

        LinkedList<Integer> queue = new LinkedList<>();
    }
}

