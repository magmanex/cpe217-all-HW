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
public class Main {
public static void main(String[] args) {         Node node; 
SinglyLinkedList list1 = new SinglyLinkedList("list1");    
node = new Node(5806001, "Matthew", 3.50);   
list1.pushFront(node);      
node = new Node(5806002, "Mark", 2.75);      
list1.pushFront(node);            
node = new Node(5806003, "Luke", 3.00);   
list1.pushFront(node);     
node = new Node(5806004, "John", 3.75);      
list1.pushFront(node);       
list1.printStructure();     
SinglyLinkedList  list2 = new SinglyLinkedList ("list2"); 

        list2.pushBack(new Node(5806005, "James", 3.25));      
        list2.pushBack(new Node(5806006, "Peter", 2.85));     
        list2.pushBack(new Node(5806007, "John", 2.50));  
        list2.pushBack(new Node(5806008, "Jude", 3.15));  
        list2.printStructure();      
        list1.merge(list2);      
        list1.printStructure(); } }