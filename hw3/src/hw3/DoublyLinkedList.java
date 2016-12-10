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
public class DoublyLinkedList {

    private Node head = null;
    private Node tail = null;
    private String listName;
    
    public DoublyLinkedList(String name){

        listName = name ;

    }
    
    public void popBack() {
      if (isEmpty()){
          System.out.println("ERROR");
 
        }else{
            if(head==tail){
                head =null;
            }else{
                tail = tail.previous ;
                tail.next = null ;
            }

        }
    }
    
    public void popFront(){
        if (isEmpty()){
            System.out.println("ERROR");
 
        }else{
            this.head = this.head.next;
            this.head.previous = null;
        }
    }
    
    public Node topFront(){
        if (isEmpty()){
            System.out.println("ERROR");
            return new Node("Empty List!");
        } else {
            return this.head ;
        }
    }
    
    public Node topBack(){
        if (isEmpty())
        {
            System.out.println("ERROR");
            return new Node("Empty List!");
        } 
        else 
        {
            return this.tail;
        }
    }
    
    public void pushFront(Node node){
        if (isEmpty()){
            head = node ;
            tail = node ;
        }else{
            node.next = this.head ;
            this.head.previous = node ;
            this.head = node ;    
        }
    }
    
    public void pushBack(Node node) {
        if (isEmpty()) {
            this.head = node ;
            this.tail = node ;
        } else {
            tail.next = node ;
            node.previous = tail ;
            tail = node ;

        }
    }

    public Node findNode(int id){
        if (isEmpty()){
            return new Node("Empty List");
        } else {
            Node tmp = head ;

            while (tmp!=null){
                if(tmp.student_id == id){
                    return tmp ;
                }
                    tmp = tmp.next ;
                
            }
            return  new Node("Student not found!");
        }
    }
    
    public Node eraseNode(int id){
        if (isEmpty()){
            System.out.println("ERROR");
            return new Node("Empty List!");
        } else {
            Node tmp = findNode(id);
            if("Student not found!".equals(tmp.name)){
                return  tmp ;

            }else {
                if(tmp == head ){
                    popFront();


                } else if(tmp == tail){
                    popBack();

                }else if(head == tail){
                    popBack();

                }else {
                    tmp.previous.next = tmp.next ;
                    tmp.next.previous = tmp.previous ;

                }

                return tmp;
            }
        }
    }
    
    public void addNodeAfter(Node node1, Node node2){
        if(node1==tail){
            node1.next = node2;
            node2.previous = node1;
            tail = node2;

        }else {
            node2.next = node1.next;
            node2.previous = node1;
            node1.next.previous = node2;
            node1.next = node2;
            
        }


    }
    
    public void addNodeBefore(Node node1, Node node2){
        if(node1==head){
            node2.next = node1;
            node1.previous = node2;
            head = node2;
        }else{
            node2.next = node1 ;
            node2.previous = node1.previous ;
            node1.previous = node2 ;
            node1.previous.next = node2;

        }

    }
    
    public boolean isEmpty()//empty or not
    {
        if(head == null) return true;
        else return false;
    }
    public void merge(DoublyLinkedList list) {
        this.tail.next = list.head;
        list.head.previous = this.tail;
        this.tail = list.tail;
    }
    public void printStructure(){
        Node current=head;
        if(isEmpty())
        {
            System.out.println("head <-> tail");
        }
        else
        {
        System.out.print(listName + ": head <-> ");
        while(current!=null){
            System.out.print("{" + current.student_id + "} <-> ");
            current = current.next;
        }
        System.out.println("tail");
        }
    }
    
    // This may be useful for you for implementing printStructure()
    public void printStructureBackward(){ 
        Node current=tail;
        System.out.print(listName + ": tail <-> ");
        while(current!=null){
            System.out.print("{" + current.student_id + "} <-> ");
            current = current.previous;
        }
        System.out.println("head");
    }
    
    public Node whoGotHighestGPA(){
        if (isEmpty())
        {
            return new Node("Empty List!");
        }
        else
        {
            Node current = tail;
            Node tmp = null;
            double max = 0;
            while (current!=null)
            {
                if(max < current.gpa)
                {
                    max = current.gpa;
                    tmp = current;
                }
                current = current.previous;
            }
            return tmp;
        }
    
    }
}