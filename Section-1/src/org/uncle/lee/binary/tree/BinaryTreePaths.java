package org.uncle.lee.binary.tree;

import java.util.ArrayList;
import java.util.List;

import org.uncle.lee.log.LogUtils;
import org.uncle.lee.util.TreeNode;

public class BinaryTreePaths {
	private static final String TAG = "BinaryTreePaths";
	private static List<String> list;
	
	public List<String> binaryTreePaths(TreeNode root) {
		if(root == null){
			return new ArrayList<String>();
		}

		list = new ArrayList<String>();
		getPaths(root, new StringBuffer());
		return list;
	}
	
	private void getPaths(TreeNode root, StringBuffer sb){
		sb.append(root.val + "->");
		
		if (root.left == null && root.right == null){
			sb.delete(sb.length() - 2, sb.length());
			list.add(new String(sb));
		} else if (root.left != null && root.right == null) {
			getPaths(root.left, new StringBuffer(new String(sb)));
		} else if (root.left == null && root.right != null) {
			getPaths(root.right, new StringBuffer(new String(sb)));
		} else {
			getPaths(root.left, new StringBuffer(new String(sb)));
			getPaths(root.right, new StringBuffer(new String(sb)));
		}
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
//		TreeNode root1 = new TreeNode(2);
//		TreeNode root2 = new TreeNode(5);
//		TreeNode root3 = new TreeNode(3);
//		
//		root.left = root1;
//		root.right = root3;
//		root1.right = root2;
		
		LogUtils.d(TAG, new BinaryTreePaths().binaryTreePaths(root));
	}
}
