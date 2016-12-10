/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hw5;

/**
 *
 * @author Asuka
 */
public class Hw5 {

    public static void printNodeKey(Node node){
        if(node == null)
            System.out.println("Node not found!!!");
        else
            System.out.println(node.key);
    }
    public static void main(String[] args) {
        Tree tree = new Tree();
        int[] keyList = {5, 2, 3, 9, 1, 10, 8, 7};
        for (int i=0; i<keyList.length; i++)
            tree.insert(keyList[i]);
        tree.printTree();
        System.out.println(tree.depth());
        System.out.println(tree.height());
        Node node = tree.find(9);
        System.out.println(node.depth(tree));
        System.out.println(node.height());
        node = tree.findMax();
        printNodeKey(node);
        node = tree.findMin();
        printNodeKey(node);
        node = tree.findKthSmallest(6);
        printNodeKey(node);
        node = tree.findKthSmallest(3);
        printNodeKey(node);
    }
    
}
