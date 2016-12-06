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
            throw new RuntimeException("Prioity queue is empty");
        return arr[1];
    }


    public void push(Node node){
        // time stamp
        node.timestamp = timeCounter; // FIX THIS
        timeCounter++;
        // Do something
        // Push new node at the end then sift (percolate) up
        arr[back] = node;
        int current = this.back;
        int parent;
        for (;current > 1;) {
            parent = current / 2;
            if (arr[parent].compare(arr[current])) {
                break;
            } else {
                swap(current, parent);
                current = parent;

            }
        }
        back++;
    }
    public Node pop(){
        // DO SOMETHING
        if(arr[1]==null)
            throw new RuntimeException("Prioity queue is empty");
        // 1. mark the root for return
        Node minItem = top();
        // 2. Replace the last node with the root
        arr[1] = arr[back];
        back--;
        // 3. Sift (percolate) down
        percolateDown(1);
        return minItem; // You may have to fix this line
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
        int child;
        Node tmp = arr[hole];
        for (; hole * 2 <= heapSize; hole = child) {
            child = hole * 2;
            if (arr[child].compare(arr[child+1]))
                child++; 	// smaller child
            if (tmp.compare(arr[child]) )
                arr[hole] = arr[child];
            else
                break;
        }
        arr[hole] = tmp;
    }

    private void enlargeArray(int newSize) {
        Node[] old = arr;
        arr = (Node []) new Comparable[newSize];
        for (int i = 0; i < old.length; i++)
            arr[i] = old[i];
    }


}
