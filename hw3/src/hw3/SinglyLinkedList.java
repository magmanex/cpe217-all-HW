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
public class SinglyLinkedList {
    private Node head = null;
    private String listName;
    
    public SinglyLinkedList(String name)
    {
        this.listName = name;
    }
    
    public void popBack() {
        if (isEmpty())
        {
            System.out.println("ERROR");
        }
        else{
            Node current = head;
            Node previous = null;
            while (true)
            {
                if(current.next == null)
                {
                    if(current == head)
                    {
                        head = null;
                        break;
                    }
                    else
                    {
                        previous.next = null;
                        break;
                    }
                }
                previous = current;
                current = current.next;
            }
        }
    }
    
    public void popFront(){
        if (isEmpty()){
            System.out.println("ERROR");
 
        }else{
            if(head.next == null)
            {
                head = null;
            }
            else
            {
                head = head.next;
            }
        }
    }
    
    public Node topFront(){
        if (isEmpty()){
            System.out.println("ERROR");
            return new Node("Empty List!");
        } 
        else 
        {
            return head;
        }
    }
    
    public Node topBack() {

        if (isEmpty()) {
            System.out.println("ERROR");
            return new Node("Empty List!");
        } else 
        {

           Node tmp = head;
            while (true)
            {
                if(tmp.next == null)
                {
                    return tmp;
                }
                tmp = tmp.next;
            }
        }
    }
    
    public void pushFront(Node node){
        if (isEmpty())
        {
            head = node;
        }
        else{
            node.next = head;
            head = node;
        }
    }
    
    public void pushBack(Node node) {
        if (isEmpty()){
            head = node;

        } else {
            Node tmp = head;
            while (tmp.next != null)
            {
                tmp = tmp.next;
            }
            tmp.next = node;
        }
    }

    public Node findNode(int id){

        if (isEmpty()){

            return  new Node("Empty List");

        } else {
            Node tmp = head ;
            while(tmp!=null){
                if (tmp.student_id == id){
                    return  tmp ;
                }
                tmp = tmp.next ;
            }
            return new Node("Not Found!");
        }
    }
    
    public Node eraseNode(int id){

        if (isEmpty()){
            System.out.println("ERROR");
            return new Node("Empty List!");
        } else {
            Node current =head;
            Node previous =null;
            while (current != null)
            {
                if(head.student_id == id)
                {
                    Node temp;
                    temp = head;
                    head = current.next;
                    return temp;
                }
                if(current.student_id==id)
                {
                    Node temp = current;
                    previous.next = current.next;
                    return temp;
                }
                previous = current;
                current = current.next;
            }
            return new Node("Not found");
        }
    }
    
    public void addNodeAfter(Node node1, Node node2) {
        node2.next = node1.next;
        node1.next = node2;
    }
    public void addNodeBefore(Node node1, Node node2){

        Node current = head;
        while (true)
        {
            if(node1 == head)
            {
                node2.next = node1;
                head = node2;
                break;
            }
            if(current.next == node1)
            {
                node2.next = node1;
                current.next = node2;
                break;
            }
            current = current.next;
        }
    }
    
    public boolean isEmpty()
    {
    if(head == null)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    public void merge(SinglyLinkedList list){
        Node current = this.head;
        while (current.next != null)
        {
            current = current.next;
        }
        current.next = list.head;
    }
    
    public void printStructure(){
        if(isEmpty())
        {
            System.out.println(this.listName+": head -> null");
        }
        else
        {
            Node current = head;
            System.out.print(this.listName + ": head -> ");
            while (true) {
                System.out.print("{" + current.student_id + "} -> ");
                if (current.next == null) {
                    System.out.println(" null");
                    break;
                }
                current = current.next;
            }
        }
    }
    
    public Node whoGotHighestGPA(){
        if (isEmpty())
        {
            return new Node("Empty List!");
        }
        else {
            Node current = head;
            Node tmp = null;
            double highGPA = 0;
            while (current != null)
            {
                if(highGPA <= current.gpa)
                {
                    highGPA = current.gpa;
                    tmp = current;
                }
                current = current.next;
            }
            return tmp;
        }
    }
}