/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Tadeo
 */
public class Nodo {
    

	private String data;
	private Nodo left, right;

	Nodo (String data)
	{
		this.data = data;
		this.left = this.right = null;
	}

	Nodo(String data, Nodo right, Nodo left)
	{
		this.data = data;
		this.left = left;
		this.right = right;
	}

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Nodo getLeft() {
        return left;
    }

    public void setLeft(Nodo left) {
        this.left = left;
    }

    public Nodo getRight() {
        return right;
    }

    public void setRight(Nodo right) {
        this.right = right;
    }
        
}
