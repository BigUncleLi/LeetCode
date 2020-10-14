package lizbyu.binary.tree;

import lizbyu.utils.log.LogUtils;
import lizbyu.utils.node.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class BinaryTreeLevelOrderTraversalII {
    private static final String TAG = "BinaryTreeLevelOrderTraversalII";

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null) {
            return null;
        }
        LinkedList<List<Integer>> valList = new LinkedList<List<Integer>>();
        addValList(valList, root, 0);
        return valList;
    }

    private void addValList(LinkedList<List<Integer>> valList, TreeNode root, int deep) {
        if (root == null) {
            return;
        }
        if (deep >= valList.size()) {
            valList.addFirst(new LinkedList<Integer>());
        }

        addValList(valList, root.left, deep + 1);
        addValList(valList, root.right, deep + 1);
        valList.get(valList.size() - 1 - deep).add(root.val);
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(9);
        TreeNode node3 = new TreeNode(20);
        TreeNode node4 = new TreeNode(15);
        TreeNode node5 = new TreeNode(7);

        node1.left = node2;
        node1.right = node3;
        node3.left = node4;
        node3.right = node5;

        LogUtils.d(TAG, "start");
        LogUtils.d(TAG, new BinaryTreeLevelOrderTraversalII().levelOrderBottom(node1));
    }
}
