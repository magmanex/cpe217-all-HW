package hw5;


public class Tree extends BTreePrinter{//(extends BTreePrinter) for receive class public and protect from BTreePrinter 
    Node root;
    
    public Tree(){
        root = null;
    }
    
    public Tree(Node root){
        this.root = root;
    }
    
    public void printTree(){
        if(root == null)    //check data is it empty?
        {
            System.out.println("Empty tree!!!");
            return;
        }
        super.printTree(root); //use from BTreePrinter (protected void printTree(Node node))
    }

    public Node find(int search_key){
        return find(root, search_key);
    }
    
    public static Node find(Node node, int search_key){
        while(node != null && node.key != search_key)
        {
            if(search_key > node.key)
                node = node.right;
            else
                node = node.left;
        }
        if(node == null)//return null if postion at leaf's child
            return null; 
        return node;
    }
    
    public Node findClosest(int search_key){
        Node find = find(root ,search_key);
        if(find != null)
            return find;
        else
            return findClosest(root, search_key);
    }
    
    public static Node findClosest(Node node, int search_key) {
        if (node.key < search_key) {
            while (node.right != null && node.key < search_key) {
                
                node = node.right;
            }
            if(node.key > search_key)
                if (node.left != null && node.left.key < search_key)
                    node = findClosest(node.left, search_key);
        } else
        {
            while (node.left != null && node.key > search_key)
            {
                
                node = node.left;
            }
            if(node.key < search_key)
                if(node.right != null && node.right.key > search_key)
                    node = findClosest(node.right, search_key);
        }
        return node;
    }
    
    public Node findMin(){
        return findMin(root);
    }
    
    public static Node findMin(Node node){
        if(node == null)
            return node;
        while(node.left != null)//go to left until finish
            node = node.left;
        return node;
    }
    
    public Node findMax(){
        return findMax(root);
    }
    
    public static Node findMax(Node node){
        if(node == null)
            return node;
        while(node.right != null)//go to right until finish
            node = node.right;
        return node;
    }
    
    public Node findKthSmallest(int k){
        return findKthSmallest(root, k);
    }
    
    public static Node findKthSmallest(Node node, int k){
        int size;
        if(node.left != null)
            size = node.left.size()+1;
        else
            size = 1;

        if(k == size) 
            return node;
        else if(k < size) 
            return findKthSmallest(node.left, k);
        else 
            return findKthSmallest(node.right, k-size);
    }
    
    public List rangeSearch(int x, int y){
        List list = new List(100);
        Node n = findClosest(x);
        while (n.key <= y)
        {
            if(n.key >= x)
                list.append(n);
            if(n.right != null)
            {
                x = n.key;
                n = findClosest(++x);
            }
            else
                n = n.parent;
        }
        return list;
    }
    
    public void printPreOrderDFT(){
        System.out.print("PreOrder DFT node sequence [ ");
        printPreOrderDFT(root);
        System.out.println("]");
    }
    
    public static void printPreOrderDFT(Node node){
        if(node == null)
            return;
        else
        {
            System.out.print(node.key+" ");
            printPreOrderDFT(node.left);
            printPreOrderDFT(node.right);
        }
    }
    
    public void printInOrderDFT(){
        System.out.print("InOrder DFT node sequence [ ");
        printInOrderDFT(root);
        System.out.println("]");
    }
    
    public static void printInOrderDFT(Node node){
        if(node == null)
            return;
        else
        {
            printInOrderDFT(node.left);
            System.out.print(node.key+" ");
            printInOrderDFT(node.right);
        }
    }
    
    public void printPostOrderDFT(){
        System.out.print("PostOrder DFT node sequence [ ");
        printPostOrderDFT(root);
        System.out.println("]");
    }
    
    public static void printPostOrderDFT(Node node){
        if(node == null)
            return;
        else
        {
            printPostOrderDFT(node.left);
            printPostOrderDFT(node.right);
            System.out.print(node.key+" ");
        }
    }
    
    public void insert(int key) {
        if (root == null) {
            root = new Node(key);
            //fix if tree is empty
        }
        else
        {
            //fix if tree is empty (from upper)
            Node node = root;
            while(node != null)
            {
                if(node.key > key)
                {
                    if(node.left == null)
                    {
                        node.left = new Node(key);
                        node.left.parent = node;
                        return;
                    }
                    else
                        node = node.left;
                }
                else if(node.key < key)
                {
                    if(node.right == null)
                    {
                        node.right = new Node(key);
                        node.right.parent = node;
                        return;
                    }
                    else
                        node = node.right;
                }
                else
                {
                    System.out.println("Duplicated key!!!");
                    return;
                }
            }
        }
    }
    
    public void delete(int key) {
        if (root == null) {
            System.out.println("Empty Tree!!!");
        } else if (root.key == key) { 
            if(root.left == null && root.right == null)
                root = null;
            else if (root.right == null)
            {
                Node replace = findMax(root.left);
                key = replace.key;
                delete(replace);
                replace = new Node(key);
                replace(root, replace);
                root = replace;
            }
            else
            {
                Node replace = findMin(root.right);
                key = replace.key;
                delete(replace);
                replace = new Node(key);
                replace(root, replace);
                root = replace;
            }
        } else { 
            Node toBeDeleted = find(key);
            if(toBeDeleted == null)
                System.out.println("Key not found!!!");
            else
                delete(toBeDeleted);
        }
    }
    
    public static void delete(Node node){
        if(!(node.right == null || node.left == null))
        {
            Node replace = findMin(node.left);
            int key = replace.key;
            delete(replace);
            replace = new Node(key);
            replace(node, replace);
        }
        else if(!(node.right == null && node.left == null))
        {
            if(node.right != null)
            {
                if(node.parent.left == node)
                {
                    node.parent.left = node.right;
                    node.right.parent = node.parent;
                }
                else
                {
                    node.parent.right = node.right;
                    node.right.parent = node.parent;
                }
            }
            else
            {
                if(node.parent.left == node)
                {
                    node.parent.left = node.left;
                    node.left.parent = node.parent;
                }
                else
                {
                    node.parent.right = node.left;
                    node.left.parent = node.parent;
                }
            }
        }
        else
        {
            if(node.parent.left == node)
            {
                node.parent.left = null;
                node.parent = null;
            }
            else
            {
                node.parent.right = null;
                node.parent = null;
            }
        }
    }
    
    public static void replace(Node node1, Node node2){ 
        if ((node1.left != null) && (node1.left != node2)){
            node2.left = node1.left;
            node1.left.parent = node2;
        }
        if ((node1.right != null) && (node1.right != node2)){
            node2.right = node1.right;
            node1.right.parent = node2;
        }
        if ((node1.parent != null) && (node1.parent != node2)){
            node2.parent = node1.parent;
            if (node1.parent.key > node1.key){
                node1.parent.left = node2;
            }else{
                node1.parent.right = node2;
            }
        }
    }
    
    public int height(){
        return root.height();
    }
    
    public int depth(){

        return root.height();
    }
    
    public int size(){
        return root.size();
    }
}