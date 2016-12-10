package hw4;

public class Queue {
    Node[] arr; 
    int capacity;
    int front;
    int back;
    int size;

    public Queue(int cap){
        arr = new Node[cap];                   
        capacity = cap;
        front = 0;                              
        back = 0;                               
        size = 0;                               
    }

    public void enqueue(Node node){
        if (!isFull()){                       
            arr[back++] = node;                  
            size++;                                                
            if(back == capacity){              
                back = 0;                     
            }
        }else{                                 
            System.out.println("Queue Overflow!!!");
        }
    }

    public Node dequeue(){

        if (!isEmpty()){                      

            --size;
            return arr[front++];
        }
        else{
            System.out.println("Queue Underflow!!!");
        }
        return null; 
    }

    public boolean isEmpty(){
        if(size != 0){                          
            return false;
        }else return true;
    }

    public boolean isFull(){
        if(size != capacity){                  
            return false;
        }else return true;
    }

    public void printCircularIndices(){
        System.out.println("Front index = " + front + " Back index = " + back);
    }

    public void printQueue(){
        if (!isEmpty()){                                
            System.out.print("[Front] ");
            int cap = capacity , checkback = back;
            for(int i = front; i < cap+checkback ; i++){   
                if(arr[i]!=null)                            
                {
                    System.out.print(arr[i].data+" ");
                }
                if(checkback==capacity-1)                    
                {
                    cap = front;        
                    checkback = 0;         
                    i = -1;             
                }
                else if(checkback!=0)                          
                {
                    checkback++;                               
                }
            }
            System.out.println("[Back]");
        }else{
            System.out.println("Empty Queue!!!");
        }
    }
}
