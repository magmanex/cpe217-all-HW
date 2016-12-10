/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hw3;

/**
 *
 * @author Patiwet
 */
public class Node {
    public int student_id;
    public String name;
    public double gpa;

    public Node next=null;
    public Node previous=null;

    // Constructor 1
    public Node(int id, String name, double gpa)
    {
        this.student_id = id;
        this.name = name;
        this.gpa = gpa;
    }
    // Constructor 2
    public Node(String name)
    {
        this.name = name;
    }
    // Constructor 3 (dummy)
    public Node()
    {
        // You can leave this function blank
        // ok prof.Patiwet :D
    }

    public void printIDName()
    {
        System.out.println("StudentID: " + student_id + " , Name: " + name);
    }
}
