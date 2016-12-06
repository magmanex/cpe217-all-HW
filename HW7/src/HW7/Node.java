/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HW7;

/**
 *
 * @author Asuka
 */
public class Node {
    double price;
    int investorID;
    int amount;
    long timestamp; // Heap.push() is the only function that modify this variable
    boolean isMinHeap;
    public Node(double price, int investorID, int amount, boolean isMinHeap){
        this.price = price;
        this.investorID = investorID;
        this.amount = amount;
        this.isMinHeap = isMinHeap;
    }

    // return true if Priority(thisNode) > Priority(rightNode) and vice versa
    // minHeap: the lower the price, the higher the priority and vice versa
    // maxHeap: the lower the price, the lower the priority and vice versa
    //
    // You may create your own function if you do not understand my code
    public boolean compare(Node rightNode){
        if (this.price == rightNode.price) {
            if(this.timestamp < rightNode.timestamp)
                return true;
            return false;
        }else{
            if (isMinHeap){
                if(this.price < rightNode.price)
                    return true;
                return false; // FIX THIS
            }else{
                if(this.price> rightNode.price)
                    return true;
                return false; // FIX THIS
            }
        }
    }
}

