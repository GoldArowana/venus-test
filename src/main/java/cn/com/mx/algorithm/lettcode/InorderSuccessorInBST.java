package cn.com.mx.algorithm.lettcode;

import com.freetymekiyan.algorithms.utils.Utils.TreeNode;

/**
 * Given a binary search tree and a node in it, find the in-order successor of that node in the BST.
 * <p>
 * Note: If the given node has no in-order successor in the tree, return null.
 * <p>
 * Company Tags: Pocket Gems, Microsoft, Facebook
 * Tags: Tree
 * Similar Problems: (M) Binary Tree Inorder Traversal, (M) Binary Search Tree Iterator
 */
public class InorderSuccessorInBST {

    /**
     * Tree, recursive.
     * In BST, root is the largest of left subtree, smallest of right subtree.
     * In-order successor is the smallest of all node's larger than p.
     * Then we can do a binary search like recurse to search the result.
     * <p>
     * If p's val < root's , p's inorder successor can be in the left subtree or is root.
     * | If left subtree recursive call returns null, return root.
     * | Otherwise return the left subtree result.
     * If p's >= root's val, p's inorder successor is in the right subtree.
     * Base case:
     * If root == null, root is null or reach a null node, just return null.
     */
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null) {
            return null;
        }
        if (p.val < root.val) {
            TreeNode succ = inorderSuccessor(root.left, p);
            // If not found in left subtree, it's root.
            return succ == null ? root : succ;
        } else {
            return inorderSuccessor(root.right, p);
        }
    }

    /**
     * Tree, iterative.
     * If p's val < root's, go to the left subtree and update root as a candidate result.
     * If p's val >= root's, go to the right subtree.
     */
    public TreeNode inorderSuccessorB(TreeNode root, TreeNode p) {
        if (p.right != null) { // Pruning, if p has right subtree.
            for (TreeNode cur = p.right; cur != null; cur = cur.left) {
                p = cur; // Successor will be leftmost leaf of right subtree.
            }
            return p;
        }
        TreeNode succ = null;
        while (root != null) {
            if (p.val < root.val) {
                succ = root;
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return succ;
    }

}
