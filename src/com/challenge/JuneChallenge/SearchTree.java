package com.challenge.JuneChallenge;

/**
 * Search in a Binary Search Tree
 *
 * Solution
 * Given the root node of a binary search tree (BST) and a value. You need to find the node in the BST that the node's value equals the given value. Return the subtree rooted with that node. If such node doesn't exist, you should return NULL.
 *
 * For example,
 *
 * Given the tree:
 *         4
 *        / \
 *       2   7
 *      / \
 *     1   3
 *
 * And the value to search: 2
 * You should return this subtree:
 *
 *       2
 *      / \
 *     1   3
 * In the example above, if we want to search the value 5, since there is no node with value 5, we should return NULL.
 *
 * Note that an empty tree is represented by NULL, therefore you would see the expected output (serialized tree format) as [], not null.
 */
public class SearchTree {
    static Node root;
    public static class Node {
        public Node left;
        public Node right;
        public int data;
        Node (int data) {
            this.left = null;
            this.right = null;
            this.data = data;
        }
    }

    //search a node and return node onwards tree
    Node searchNode(Node root, int val) {
        if(root==null||root.data==val)
            return root;
        else if(root.data > val)
            return searchNode(root.left, val);
        else if(root.data < val)
            return searchNode(root.right, val);
        return null;
    }

    //Construct BST
    Node sortedArrayToBST(int arr[], int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        Node node = new Node(arr[mid]);
        node.left = sortedArrayToBST(arr, start, mid - 1);
        node.right = sortedArrayToBST(arr, mid + 1, end);
        return node;
    }

    //display tree in preorder
    void preOrder(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.data + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    public static void main(String args[])
    {
        SearchTree tree = new SearchTree();
        int arr[] = new int[]{1, 2, 3, 4, 5, 6, 7};
        int n = arr.length;
        root = tree.sortedArrayToBST(arr, 0, n - 1);
        System.out.println(tree.searchNode(root, 4));
    }

}
