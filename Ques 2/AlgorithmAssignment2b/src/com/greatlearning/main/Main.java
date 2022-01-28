package com.greatlearning.main;

import java.util.Scanner;
import com.greatlearning.model.Node;
import com.greatlearning.service.*;


public class Main {

	private static Scanner sc =new Scanner(System.in);
	private static BSTToSkewedTreeService convertBST = null;
	private static PrintSkewedTreeService traverse = null;
	private Node node = null;
	public static void main (String[] args)
	{

		Main tree = new Main();
		//Hard-Coded tree
		tree.node = new Node(50);
		tree.node.left = new Node(30);
		tree.node.right = new Node(60);
		tree.node.left.left = new Node(10);
		tree.node.right.left= new Node(55);
		
		//Convert BST to Skewed Tree
		convertBST=new BSTToSkewedTreeService();
		convertBST.inOrderOfBST(tree.node);
		
		//Print Skewed Tree
		traverse=new PrintSkewedTreeService();
		traverse.printRightSkewed(convertBST.headNode);
	}
}
