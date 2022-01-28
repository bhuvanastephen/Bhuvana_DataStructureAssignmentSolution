package com.greatlearning.model;
public class Node
{
    public int value;
    public Node left, right;
    
    public Node(int item)
    {
        value = item;
        left = null;
        right = null;
    }
}