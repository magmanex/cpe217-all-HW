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
public class NodeList extends BTreePrinter{
    public Node r1;
    public Node r2;
    NodeList(){

    }
    public void printTree() {
        System.out.println("R1");
        if (r1 == null) {
            System.out.println("Empty tree!!!");
        } else {
            super.printTree(r1);
        }

        System.out.println("R2");
        if (r2 == null) {
            System.out.println("Empty tree!!!");
        } else {
            super.printTree(r2);
        }
    }
}
