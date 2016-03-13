package com.asheesh.Trees;

public class AVLTree{
	
	public TreeNode leftRotate(TreeNode X){
		TreeNode W = X.left;
		X.left = W.right;
		W.right = X;
		X.height = max(height(X.left),height(X.right)) + 1;
		W.height = max(height(W.left) , height(X)) + 1;
		return W;
	}
	
	public TreeNode rightRotate(TreeNode W){
		TreeNode X = W.right;
		W.right= X.left;
		X.left = W;
		W.height = max(height(W.left), height(W.right)) + 1;
		X.height = max(height(W), height(X.right)) + 1;
		return X;
	}
	
	// for inserting into right of left
	public TreeNode doubleRotateLeft(TreeNode Z){
		Z.left = rightRotate(Z.left);
		return leftRotate(Z);
	}
	
	// for inserting into left of right
	public TreeNode doubleRotateRight(TreeNode X){
		X.right = leftRotate(X.right);
		return rightRotate(X);
	}
	
	public TreeNode insert(TreeNode root, int data){
		if(root == null){
			root = new TreeNode();
			root.data = data;
			root.height = 0;
			root.left = null;
			root.right = null;
		} else if(data < root.data){
			root.left = insert(root.left, data);
			if((height(root.left)- height(root.right)) == 2){
				if(data < root.left.data){
					root = leftRotate(root);
				}else{
					root = doubleRotateLeft(root);
				}
			}
		} else if(data > root.data){
			root.right = insert(root.right, data);
			if((height(root.right)- height(root.left)) == 2){
				if(data > root.right.data){
					root = rightRotate(root);
				}else{
					root = doubleRotateRight(root);
				}
			}
		}
		
		root.height = max(height(root.left), height(root.right)) + 1;
		return root;
	}
	
	public int height(TreeNode root){
		if(root == null){
			return 0;
		}
		else{
			return root.height;
		}
	}
	
	public int max(int a, int b){
		if(a>b){
			return a;
		}
		return b;
	}
}