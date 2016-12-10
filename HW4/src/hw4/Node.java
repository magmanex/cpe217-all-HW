package hw4;

public class Node extends hw4.BTreePrinter {

        Node left;
        Node right;
        int data;

        public Node(int data) {      
            left = null;            
            right = null;             
            this.data = data;
        }

        public void printTree() {
            super.printTree(this);
        }


        public void printBFT() {
            Queue q = new Queue(50);        
            q.enqueue(this);                
            System.out.print("BFT node sequence [ ");
            do{           
                Node temp = q.dequeue();     
                System.out.print(temp.data+" "); 
                if(temp.left!=null) {        
                    q.enqueue(temp.left);    
                }
                if(temp.right!=null) {        
                    q.enqueue(temp.right);    
                }
            }while(!q.isEmpty() ) ; 
            System.out.println("]");
        }

        public void printDFT() { 
            Stack s = new Stack(50);          
            s.push(this);                     
            System.out.print("DFT node sequence [ ");
            do{
                Node temp = s.pop();          
                System.out.print(temp.data+" "); 
                if(temp.right!=null) {         
                    s.push(temp.right);        
                }
                if(temp.left!=null) {         
                    s.push(temp.left);         
                }
            }while(!s.isEmpty()) ; 
            System.out.println("]");
        }

        public static  Node constructTree1()     
        {
            Node root = new Node(3);
            root.left = new Node(7);
            root.left.left= new Node(2);
            root.left.right= new Node(6);
            root.left.right.left = new Node(1);
            root.left.right.right = new Node(8);
            root.right = new Node(5);
            root.right.right = new Node(9);
            root.right.right.left = new Node(4);
            return root;
        }

        public  static Node constructTree2()     
        {
            Node root = new Node(1);
            root.left = new Node(2);
            root.left.left= new Node(4);
            root.left.right = new Node(5);
            root.left.right.left = new Node(7);
            root.left.right.right = new Node(8);
            root.left.right.right.right = new Node(10);
            root.right = new Node(3);
            root.right.right = new Node(6);
            root.right.right.left = new Node(9);
            return root;
        }
}