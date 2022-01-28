package com.greatlearning.service;

import com.greatlearning.model.Node;
public class BSTToSkewedTreeService {
	public static Node node;
	public Node prevNode = null;
	public Node headNode = null;
   

	public void inOrderOfBST(Node root)
    {
		Node rightNode =null;
        if(root == null)
        {
            return;
        }
 
        inOrderOfBST(root.left);
        rightNode = root.right;

        if(headNode == null)
        {
            headNode = root;
            root.left = null;
            prevNode = root;
        }else
        {
            prevNode.right = root;
            root.left = null;
            prevNode = root;
        }

        inOrderOfBST(rightNode);
    }			
}
