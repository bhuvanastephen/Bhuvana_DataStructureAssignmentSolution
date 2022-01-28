package com.greatlearning.service;

import com.greatlearning.model.Node;

public class PrintSkewedTreeService {

	public PrintSkewedTreeService() {
		// TODO Auto-generated constructor stub
	}
	public void printRightSkewed(Node root)
    {
        if(root == null)
        {
            return;
        }
        System.out.print(root.value + " ");
        printRightSkewed(root.right);       
    }
}
