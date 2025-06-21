public class BST{
    class Node{
        int data;
        Node left, right;
        
        Node(int value){
            this.data = value;
        }
    }
    Node root = null;
    
    /* ------------------------------------------------- */
    
    // INSERTION
    void insert(int data){
        root = insert(root, data);
    }
    
    Node insert(Node root, int value){
        if(root == null)
            root = new Node(value); // As root is returned at last, updating root here or returning a new root node works the same
//            return new Node(value);
        else if(value < root.data)
            root.left = insert(root.left, value);
        else
            root.right = insert(root.right, value);
        
        return root;
    }
    
    /* ------------------------------------------------- */
    
    // DELETION
    public void delete(int key){
        root = delete(root, key);
        
    }
    
    private Node delete(Node root, int key){
        if(root == null)
            return null;
        
        if (key < root.data) // Delete in the left subtree
            root.left = delete(root.left, key);
        else if (key > root.data) // Delete in the right subtree
            root.right = delete(root.right, key);
        else { // Can use condition if(key == root.data). But it's the only remaining condition.
            // Deleting the node
            if(root.left == null) // Deleting node in case it has either left or right or none but not both children
                root = root.right;
            else if(root.right == null)
                root = root.left;
            else{ // Deleting in case it has both left and right children
                Node t = root.right; // Selecting the left most from the right subtree
                while(t.left != null)
                    t = t.left;
                // Swapping the values with the left most leaf node in the right subtree
                int temp = root.data;
                root.data = t.data;
                t.data = temp;
                // Now, deleting in the right subtree as key is passed somewhere in the right subtree
                root.right = delete(root.right, key);
            }
        }
        return root;
    }
    
    /* ------------------------------------------------- */
    
    // TRAVERSAL METHODS
    void inOrderTraversal(){
        inOrderTraversal(root);
    }
    
    private void inOrderTraversal(Node root){
        if(root == null)
            return;
        
        inOrderTraversal(root.left);
        System.out.print(root.data + " ");
        inOrderTraversal(root.right);
    }
    
    void preOrderTraversal(){
        preOrderTraversal(root);
    }
    
    private void preOrderTraversal(Node root){
        if(root == null)
            return;
        
        System.out.print(root.data + " ");
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }
    
    void postOrderTraversal(){
        postOrderTraversal(root);
    }
    
    private void postOrderTraversal(Node root){
        if(root == null)
            return;
        
        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.print(root.data + " ");
    }
    
    void levelOrderTraversal(){
        levelOrderTraversal(root);
    }
    
    private void levelOrderTraversal(Node root){
        if(root == null){
            System.out.println("No tree");
            return;
        }
        
        QueueUsingLL<Node> q = new QueueUsingLL<>();

        q.enqueue(root);
        q.enqueue(null); // Insertion of null in the queue means end of a level
        int level = 0;
        System.out.println("Level "+level);
        while(!q.isEmpty()){
            Node n = q.dequeue();
            if(n == null) { // In case end of level
                level++;
                if(q.isEmpty()) // Check if the queue is empty after level ends
                    break;
                else{
                    System.out.println("\nLevel "+level);
                    q.enqueue(null);
                }
            } else {
                System.out.print(n.data + " ");
                // Avoiding scenarios where either left or right child of a node is null
                // Don't add left or right child in case there's none
                if(n.left != null)
                    q.enqueue(n.left);
                if(n.right != null)
                    q.enqueue(n.right);
            }
        }
    }
    
    /* ------------------------------------------------- */
    
    // SEARCHING
    void search(int key){
        SinglyLinkedList<Integer> l = new SinglyLinkedList<>();
        
        if(search(root, key, l)){
            System.out.print("\nElement found. Path : ");
            l.traverse();
        }
         else
            System.out.println("\nElement not found.");
    }
    
    private boolean search(Node root, int key, SinglyLinkedList<Integer> l){
        boolean status;
        if(root != null){
            l.insertAtEndM2(root.data);
            if(root.data == key)
                return true;
            
            if(key < root.data)
                status = search(root.left, key, l);
            else
                status = search(root.right, key, l);
            return status;
        } else
            return false;
    }
}
