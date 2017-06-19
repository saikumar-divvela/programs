package com.sss.algo;
class TreeNode{
	int data;
	TreeNode left;
	TreeNode right;
	TreeNode parent;
	
	public TreeNode(){
		parent = left = right = null;
	}
	
	public TreeNode(int i){
		data = i;
		parent = left = right = null;
	}
	
	public int getBalance(){
		int leftHeight = (left==null)?0:left.height();
		int rightHeight = (right==null)?0:right.height();
		return leftHeight-rightHeight;
	}
	
	public int height(){
		int leftHeight = (left==null)?0:left.height();
		int rightHeight = (right==null)?0:right.height();
		return 1+Math.max(leftHeight, rightHeight);
	}
	public void display(){
		inOrder(this);
	}
	
	private void inOrder(TreeNode temp){
		if(temp==null) return;
		inOrder(temp.left);
		System.out.print(" "+temp.data+" ");
		inOrder(temp.right);
	}
}

public class Tree {
	
	TreeNode root;
	
	public Tree(){
		
	}
	
	public Tree(int[] dataArray){
		for(int i=0;i<dataArray.length;i++){
			addNode(dataArray[i]);
		}
	}
	
	public TreeNode getNode(int data){
		return new TreeNode(data);
	}
	
	public void addNode(int data){
		TreeNode newNode = getNode(data);
		if(root == null){ // handle first node
			root = newNode;
			return ;
		} 
		TreeNode temp = root;
		TreeNode temp1 = null;
		while(temp!=null){
			temp1 = temp; 
			if(data<=temp.data){
				temp = temp.left;
			} else {
				temp = temp.right;
			}
		}
		if(data<=temp1.data){
			temp1.left = newNode;
			newNode.parent = temp1;
			
		} else {
			temp1.right = newNode;
			newNode.parent =  temp1;
		}
		//balanceTree();
	}
	
	private void balanceTree() {
		TreeNode p = findUnbalancedNode();
		while(p!=null) {
		int leftHeight = p.left.height();
		int rightHeight = p.right.height();
		
		if(leftHeight-rightHeight == -2){
			if((p.right.left.height()-p.right.right.height()) == -1){ 
				// right right case needs single left rotation
				rotateLeft(p);
			} else if((p.right.left.height()-p.right.right.height()) == 1){ 
				// right left case needs right rotation and left rotation
				//right rotation
				rotateRight(p.right);
				rotateLeft(p);
				
			}
		} else if(leftHeight-rightHeight==2) {
			if((p.left.left.height()-p.left.right.height()) == 1){
				// left left case needs single right rotation
				rotateRight(p);
				
			} else if((p.right.left.height()-p.right.right.height()) == -1){
				// left right case needs left rotation and right rotation
				rotateLeft(p.left);
				rotateRight(p);
			}
		 }
			p = findUnbalancedNode();
		}
	}
	
	private void rotateLeft(TreeNode p){
		TreeNode temp1 = p.right;
		TreeNode temp2 = temp1.left;
		p.right = temp2;
		if(temp2!=null)temp2.parent = p;
		temp1.left = p;
		if(p.parent==null){
			root = temp1;
		} else if(p.parent.left==p){
			p.parent.left = temp1;
		} else if(p.parent.right ==p){
			p.parent.right = temp1;
		}
		temp1.parent = p.parent;
		p.parent = temp1;
	}
	
	private void rotateRight(TreeNode r){
		//TreeNode r = p.right;
		TreeNode temp1 = r.left;
		r.left = temp1.right; 
		if(r.left!=null){r.left.parent = r;}
		if(r.parent==null){ root = temp1 ;} 
		else if(r.parent.left==r){
			r.parent.left = temp1;
		} else if(r.parent.right ==r){
			r.parent.right = temp1;
		}
		temp1.parent = r.parent;
		temp1.right = r;
		r.parent = temp1;
	}
	
	public int find(int data){
		TreeNode temp = findNode(root,data);
		if(temp == null){
			System.out.println("Element "+data+" not found");
			return -1;
		}
		System.out.println("Element "+data+" found");
		return temp.data;
	}
	
	
	public TreeNode findNode(TreeNode root,int data){
		if(root == null){
			return null;
		}
		if(root.data == data){
			return root;
		} else if(data < root.data){
			return findNode(root.left,data);
		} else{
			return findNode(root.right,data);
		}
	}
	
	public void findLowestCommonAncestor(int value1,int value2){
		TreeNode temp = root;
		while(temp!=null){
			int value = temp.data;
			if(value < value1 && value < value2 ){
				temp = temp.right;
			} else if(value > value1 && value > value2){
				temp = temp.left;
			} else {
			  System.out.println("\n Common ancestor for "+value1+" and "+value2+ " is "+value);
			  return;
			}
		}
		System.out.println("\n No common ancestor found for "+value1+" and "+value2);
	}
	
	public void displayNodes(){
		root.display();
	}
	
	public int height(){
		return root.height();
	}
	
	public boolean isBalanced(){
		return (isBalanced(root)==null);
	}
	
	private TreeNode findUnbalancedNode(){
		return isBalanced(root);
	}
	
	
	public TreeNode isBalanced(TreeNode root){
		
		if(root==null){
			return null;
		} 
		int lh =(root.left==null)?0:root.left.height();
		int rh = (root.right==null)?0:root.right.height();
		if( isBalanced(root.left) ==null && isBalanced(root.right)==null && Math.abs(lh-rh) <=1 ){
			return null;
		}
		return root;
	}
	
	
	/*
	 *  Visits self , then left and right node. In other wards 
	 *  Node is always visited before the children.
	 */
	public void preOrder(TreeNode root){
		if(root ==  null){
			return;
		}
		System.out.print(root.data+" ");
		preOrder(root.left);
		preOrder(root.right);
	}
	
	/*
	 * Visits left node,then right node and finally root
	 * In other words a node is visited after its descendants are vissted 
	 */
	public void postOrder(TreeNode root){
		if(root ==  null){
			return;
		}
		postOrder(root.left);
		postOrder(root.right);
		System.out.print(root.data+" ");
	}
	
		
	/*
	 *  Visits left descendants, then root and finally right descendants.
	 *  In other words left subrtee is visited first then root and finally right subtree 
	 */
	public void inOrder(TreeNode root){
		if(root ==  null){
			return;
		}
		inOrder(root.left);
		System.out.print(root.data+" ");
		inOrder(root.right);
	}
	
	public static void main(String args[]) throws Exception{
		//Tree tree = new Tree(new int[]{50,60,55,70,80,90,100,40,30,20,10});
		//Tree tree = new Tree(new int[]{30,10,100,15,5,80,110,70,75});
		//Tree tree = new Tree(new int[]{1,2,3,4,5});
		Tree tree = new Tree(new int[]{5,4,3,2,1,6});
		tree.displayNodes();
		System.out.println("\n Height of tree is "+tree.height());
		System.out.println("IS balanced:"+tree.isBalanced());
	}
	
	
}
