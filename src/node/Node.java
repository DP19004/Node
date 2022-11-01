/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package node;
import java.util.Stack;

// Data structure to store a binary tree node
class Node
{
	char data;
	Node left, right;

	Node(char data)
	{
		this.data = data;
		this.left = this.right = null;
	}

	Node(char data, Node left, Node right)
	{
		this.data = data;
		this.left = left;
		this.right = right;
	}
}