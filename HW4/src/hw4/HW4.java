package hw4;


import static hw4.Node.constructTree1;  
import static hw4.Node.constructTree2;  

public class HW4 {

    public static void main(String[] args) {
        Queue q = new Queue(4);
        q.printCircularIndices();
        q.enqueue(new Node(5));
        q.enqueue(new Node(6));
        q.printCircularIndices();
        q.enqueue(new Node(7));
        q.enqueue(new Node(8));
        q.printCircularIndices();
        q.printQueue();
        System.out.println(q.dequeue().data);
        q.printCircularIndices();
        System.out.println(q.dequeue().data);
        q.printCircularIndices();
        System.out.println(q.dequeue().data);
        q.printCircularIndices();
        q.enqueue(new Node(9));
        q.enqueue(new Node(10));
        q.enqueue(new Node(11));
        q.printQueue();
    }



}



