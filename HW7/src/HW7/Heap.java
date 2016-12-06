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
public class Heap {
    boolean isMinHeap; // true if minHeap, false if maxHeap
    int heapSize;
    Node[] arr;//Array as a complete binary tree
    int back;
    // For each node to be inserted into the heap, timeCounter will increase by 1
    int timeCounter;
    public Heap(boolean isMinHeap, int size){
        arr = new Node[size+1];
        heapSize = size;
        back = 1;
        this.isMinHeap = isMinHeap;
        timeCounter = 0;
    }

    public boolean isEmpty() { return heapSize == 0; }


    public Node top(){
        if (isEmpty())
            return null;
        return arr[1];
    }


    public void push(Node node){
        // time stamp
        node.timestamp = back; // FIX THIS
        timeCounter++;
        // Do something
        // Push new node at the end then sift (percolate) up
        arr[back] = node;
        back++;
        if(isMinHeap){
            for(;arr[(int) node.timestamp/2] != null && arr[(int) node.timestamp/2].price > node.price;){
                long tmp = node.timestamp;
                swap((int) tmp,(int) tmp/2);
                arr[(int) tmp].timestamp = tmp;
                node.timestamp = (int) tmp/2;
            }
        }else{
            for(;arr[(int) node.timestamp/2] != null && arr[(int) node.timestamp/2].price < node.price;){
                long tmp = node.timestamp;
                swap((int) tmp,(int) tmp/2);
                arr[(int) tmp].timestamp = tmp;
                node.timestamp = (int) tmp/2;
            }
        }
    }
    public Node pop(){
        // DO SOMETHING
        if(back == 1 ) return null;
        else{
            // 1. mark the root for return
            Node minTerm = top();
            // 2. Replace the last node with the root
            back--;
            arr[1] = arr[back-1];
            if (arr[1] != null){

                arr[1].timestamp = 1;
                // 3. Sift (percolate) down
                percolateDown(1);
            }
            return minTerm; // You may have to fix this line
        }
    }

    // Optional: If you do not know what this function does, you do not have to use it
    public void swap(int index1, int index2){
        Node temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

    // Optional: If you do not know what this function does, you do not have to use it
    public void printArray(){
        System.out.print("[");
        for (int i=1; i<back; i++){
            System.out.print(arr[i].price);
            if (i<back-1)
                System.out.print(", ");
        }
        System.out.println("]");
    }

    private void percolateDown(int hole) { // start percolating at hole

        while (arr[hole * 2] != null) {
            swap(hole, 2 * hole);
            hole *= 2;
            arr[hole].timestamp = hole;
        }
    }


}
