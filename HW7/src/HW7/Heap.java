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
        node.timestamp = timeCounter++;

        int posback = back;
        arr[back] = node;
        while(posback > 1 && arr[posback].compare(arr[posback/2]))// do percolate up until found collect position
        {
            swap(posback, posback/=2);
        }
        back++;
    }
    public Node pop(){
        if(back == 1 ) return null;
        // 1. mark the root for return
        Node Returned = top();
        // 2. Replace the last node with the root
        if(back == 2) // if has only 1 buyer
        {
            arr[--back] = null;
        }
        else
        {
            arr[1] = arr[--back];
        }

        // 3. Sift (percolate) down
        percolateDown(1);


        return Returned;
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

        while(hole <= back-1)  //do until last position
        {
            int Tmp;
            if(hole*2 <= back-1 && arr[hole*2] != null) //check 1st child
            {
                Tmp = hole*2;
            }
            else  if(hole*2+1 <= back-1 && arr[hole*2+1] != null) //check 2nd child
            {
                if(arr[hole*2].compare(arr[hole*2+1]))
                {
                    Tmp = hole*2;
                }
                else Tmp = hole*2+1;
            }
            else
                break;

            if(arr[Tmp].compare(arr[hole]))
            {
                swap(Tmp, hole);
                hole = Tmp;
            }
            else
                break;
        }
    }


}
