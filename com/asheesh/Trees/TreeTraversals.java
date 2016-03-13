package com.asheesh.Trees;

public class TreeTraversals{
	
	public void preOrder(TreeNode root){
		if(root == null){
			return;
		}
		System.out.print(" " + root.data);
		preOrder(root.left);
		preOrder(root.right);
		
	}
	
	public void postOrder(TreeNode root){
		if(root == null){
			return;
		}
		
		postOrder(root.left);
		postOrder(root.right);
		System.out.print(" " + root.data);
		
	}
	
	public void inOrder(TreeNode root){
		if(root == null){
			return;
		}
		inOrder(root.left);
		System.out.print(" " + root.data);
		inOrder(root.right);
		
	}
}
