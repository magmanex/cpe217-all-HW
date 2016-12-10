package hw5;

import java.util.Objects;

public class Node{
    Node left;
    Node right;
    Node parent;
    int key;
    
    public Node(int data){
        key = data;
        left = null;
        right = null;
        parent = null;
    }
    
    public int height(){
        return height(this);
    }
    
    public static int height(Node node){
        if(node == null)
            return -1;
        else
            return 1 + Integer.max(height(node.left), height(node.right));
        
    }

    public int size(){
        return size(this);
    }
    
    public static int size(Node node){
        if(node == null)
            return 0;
        else
            return size(node.left) + 1 + size(node.right);
    }
    
    public Node findNext(){
        if(this.right == null)
            return rightAncestor(this);
        return leftDescendant(this.right);
    }
    
    public static Node leftDescendant(Node node){
        Node loopNode = node;
        while(loopNode.left != null)
            loopNode = loopNode.left;
        return loopNode;
    }
    
    public static Node rightAncestor(Node node) {
        Node loopNode = node;
        while(loopNode.parent != null && loopNode.key > loopNode.parent.key)
        {
            loopNode = loopNode.parent;
        }
        if(loopNode.parent == null)
            return null;
        return loopNode.parent;
    }
    
    public int depth(Tree tree){
        Node node = tree.root;
        int depth = 0;
        while(node != null && node.key != this.key)
        {
            if(node.key > this.key)
                node = node.left;
            else
                node = node.right;
            depth++;
        }
        if(node == null)
            return -1;
        return depth;
    }
 
}