/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hw6;

/**
 *
 * @author Asuka
 */
public class Node extends BTreePrinter{
    Node left;
    Node right;
    Node parent;
    int key;
    
    public void printTree()
    {
        if(this == null)
        {
            System.out.println("Empty tree!!!");
        }
        else
        {
            super.printTree(this);
        }
    }
    public Node(int data){
        this.key = data;
    }

    // To simplify the problem, Please use 'height(node)' to evaluate height of the node
    public static int height(Node node){
        if (node == null)
            return -1;
        else
            return 1 + Math.max(height(node.left), height(node.right));
    }

    public boolean isImbalance(){
        return Math.abs(height(this.left) - height(this.right)) > 1; // fix this
    }
}
