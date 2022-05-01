package com.glearning.pg.client;
import java.util.*;
 
		//	Question 2) Find a pair with a given sum in Binary Search Tree


// A class to store a BST node
class Node
{
    int data;
    Node left = null, right = null;
 
    Node(int data) {
        this.data = data;
    }
}

public class SumInBST {
	
	static int cntr = 0;
	
	// Function to insert a key as node into a BST
	// if root = null form create new node
	// if root is not null and key < root the add it to left
	// if root is not null and key > root the add it to right
    public static Node insert(Node root, int nodeValue)
    {
        if (root == null) {
            return new Node(nodeValue);
        }
 
        if (nodeValue < root.data) {
            root.left = insert(root.left, nodeValue);
        }
        else {
            root.right = insert(root.right, nodeValue);
        }
 
        return root;
    }
 
    // Function to find a pair with a given sum in the BST
    public static boolean findPair(Node root, int sumValue, Set<Integer> set)
    {
        if (root == null) {   						// if root is null then Pair cannot be found
            return false;
        }
 
        if (findPair(root.left, sumValue, set)) {	//  Navigate to left subtree and if pair is found return true	
            return true;
        }
 
        if (set.contains(sumValue - root.data))		// Pair is found
        {
        	cntr = cntr +1;
        	System.out.println("Pair " + cntr + " found (" + (sumValue - root.data) + ", " + root.data + ")");
        }
        else {	
            set.add(root.data);						 // Add current node's value into the set
        }
 
        return findPair(root.right, sumValue, set);	// Navigate in the right subtree
    }
    
    public static void main(String[] args)
    {
        int[] nodeValues = { 40, 20, 60, 10, 30, 50, 70 };
        Node root = null;
        
        Scanner scanner = new Scanner(System.in);
        
        for(int index =0; index < nodeValues.length; index++) {
        	root = insert(root, nodeValues[index]);
        }
 
        System.out.println("Enter the value to verify: ");
        int sumValue= scanner.nextInt();
        
        Set<Integer> set = new HashSet<>();
 
        if (!findPair(root, sumValue, set) && cntr == 0) {
        		System.out.println("Nodes are not found ");
        } 
        
        scanner.close();
    }
}
