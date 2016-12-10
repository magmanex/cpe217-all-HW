/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hw2;

/**
 *
 * @author Patiwet
 */
public class DynamicArray {

    private int[] arr;
    private int capacity;
    private int size; // Last element can be indexed at size-1

    public DynamicArray(int cap) { // Class Constructor
        arr = new int[cap];
        capacity = cap;
    }

    public void pushBack(int data) {
        if (size < capacity) {
            arr[size] = data;
        } else {
            int[] BU_arr = arr; //BU=Backup
            capacity *= 2;
            arr = new int[capacity];
            for (int i = 0; i < BU_arr.length; i++) {
                arr[i] = BU_arr[i];
            }
            arr[size] = data;
        }
        size++;

    }

    public int popBack() {
        if (size > 0) {
            int result = arr[size--];
            return result;
        } else {
            System.out.println("ERROR");
            return 0;
        }

    }

    public int get(int i) {
        if (i < size - 1 && i >= 0) {
            return arr[i];
        } else {
            System.out.println("ERROR");
        }
        return 0;
    }

    public void set(int i, int value) {
        if (i < size - 1 && i >= 0) {
            arr[i] = value;
        } else {
            System.out.println("ERROR");
        }
    }

    public void remove(int i) {
        if (i < size - 1 && i >= 0) {
            int BU = 0;
            while (BU < size && BU == i - i) {
                arr[BU] = arr[BU + 1];
                BU++;
            }
            size--;
        } else {
            System.out.println("ERROR");
        }
    }

    public boolean isEmpty() {
        return !(size > 0);
    }

    public int getSize() {
        return size;
    }

    public void printStructure() {
        System.out.print("Size = " + size + ", Cap = " + capacity + ", arr = [ ");
        for (int i = 0; i < size; i++) {
            if (arr[i] > 0) {
                System.out.print(arr[i]);
                if (i < size - 1) {
                    System.out.print(",");
                }
            }
        }
        System.out.println(" ]");
    }

}
