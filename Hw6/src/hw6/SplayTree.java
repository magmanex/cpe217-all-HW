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
public class SplayTree extends BTreePrinter{
    Node root;
    
    public SplayTree(){
        
    }
    
    public SplayTree(Node root){
        
        if (root.parent!=null){ // To make sure the root has no parent
            if (root.key < root.parent.key){
                root.parent.left = null;
            }else{
                root.parent.right = null;
            }
            root.parent = null;
        }
        this.root = root;
    }
    
    public void printTree(){
        super.printTree(root);
    }
    
    public Node find(int search_key) {
        splay(findWithoutSplaying(search_key));
        return root; // fix this
    }

    // This function is already complete, no need to modify
    public Node findWithoutSplaying(int search_key) {
        return find(root, search_key);
    }
    
    // This function is already complete, no need to modify
    private static Node find(Node node, int search_key) {
        if (search_key == node.key) {
            return node;
        } else if ((search_key < node.key) && (node.left != null)) {
            return find(node.left, search_key);
        } else if ((search_key > node.key) && (node.right != null)) {
            return find(node.right, search_key);
        } else {
            return null;
        }
    }
    
    // This function is already complete, no need to modify
    private Node findMin() {
        return findMin(root);
    }

    // This function is already complete, no need to modify
    private static Node findMin(Node node) {
        if (node.left == null) {
            return node;
        } else {
            return findMin(node.left);
        }
    }
    
    // This function is already complete, no need to modify
    public void insert(int key) {
        if (root == null) {
            root = new Node(key);
        } else {
            insert(this, root, key);
        }
    }

    // Fix this function to have splaying feature
    private static void insert(SplayTree tree, Node node, int key) {
        if (key == node.key) {
            System.out.println("Duplicated key:" + key);
        } else if (key < node.key) {//Go left
            if (node.left == null) {
                node.left = new Node(key);
                node.left.parent = node;
                tree.splay(node.left);
            } else {
                insert(tree, node.left, key);
            }
        } else{ // Go right
            if (node.right == null) {
                node.right = new Node(key);
                node.right.parent = node;
                tree.splay(node.right);
            } else {
                insert(tree, node.right, key);
            }
        }
    }
    
    
    public void delete(int key) {
        if(find(key) == null)
        {
            System.out.println("Node not found");
        }
        SplayTree tree = new SplayTree(root.right);
        tree.splay(tree.findMin());
        tree.root.left = this.root.left;
        root = tree.root;
        // To delete a key in a splay tree, do the following steps
        // 1. splay node with the key to the root of tree1
        // 2. create another tree using the node of the right-subtree (tree2)
        // 3. Find min of the right-subtree and splay to the root
        // 4. Take left-subtree of the tree1 and hang as the left subtree of the tree2
        // 5. Reassign a new root (root of the tree2)
    }
    
    // Use this function to call zigzig or zigzag
    public void splay(Node node){
        if (node!=null && node != root){
            if (node.parent == root){
                zig(node);
                // Do something (just add one line of code)
            }else{
                if (node.key < node.parent.key){
                    if (node.parent.key < node.parent.parent.key){
                        // Left outer case
                        zigzig(node);
                        // Do something (just add one line of code)
                    }else{
                        // Left inner case
                        zigzag(node);
                        // Do something (just add one line of code)
                    }
                }else{
                    if (node.parent.key > node.parent.parent.key){
                        // Right outer case
                        zigzig(node);
                        // Do something (just add one line of code)
                    }else{
                        zigzag(node);
                        // Do something (just add one line of code)
                    }
                }
                // Do something (just add one line of code)
                splay(node);
            }
        }
    }
    
    // Use this function to call zig
    public void zigzig(Node node){ // Move two nodes up along the Outer path
        zig(node.parent);
        zig(node);
        // Do something
    }
    
    // Use this funciton to call zig
    public void zigzag(Node node){ // Move two nodes up along the Inner path
        zig(node);
        zig(node);
        // Do something
    }
    
    // This function should be called by zigzig or zigzag
    public void zig(Node node){// Move up one step
        if (node.parent == null){
            System.out.println("Cannot perform Zig operation on the root node");
        }else if (node.parent == root){ // If the node is a child of the root
            if (node.key<node.parent.key)
            {// Zig from left
                root.left = node.right;
                if(node.right != null)
                    node.right.parent = root;
                node.right = root;
            }
            else
            { // Zig from right
                root.right = node.left;
                if(node.left != null)
                    node.left.parent = root;
                node.left = root;
            }
            node.parent = null;
            root.parent = node;
            root = node;
        }else{// if the node is not a child of the root
            Node p = node.parent;
            if (node.key<node.parent.key)
            {
                p.left = node.right;
                if(node.right != null)
                    node.right.parent = p;
                node.right = p;
            }
            else
            {
                p.right = node.left;
                if(node.left != null)
                    node.left.parent = p;
                node.left = p;
            }
            node.parent = p.parent;
            if(p.parent.key > p.key)
            {
                p.parent.left = node;
            }
            else
            {
                p.parent.right = node;
            }
            p.parent = node;
        }
    }
}

