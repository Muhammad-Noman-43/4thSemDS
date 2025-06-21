public class AVL_Tree {
    class Node{
        int data;
        Node left, right;
        
        Node(int value){
            this.data = value;
        }
    }
    
    Node root = null;
    
    /* ------------------------------ */
    
    // INSERTION
    void insert(int data){
        root = insert(root, data);
    }
    
    public Node insert(Node root, int value){
        if(root == null)
            root = new Node(value); // As root is returned at last, updating root here or returning a new root node works the same
//            return new Node(value);
        else if(value < root.data)
            root.left = insert(root.left, value);
        else
            root.right = insert(root.right, value);
        
        // After insertion, check if the node or the subtree where inserted is balanced.
        root = balanceTree(root);
        return root;
    }
    
    /* ------------------------------ */
    
    // DELETION
    public void delete(int key){
        root = delete(root, key);
        
    }
    
    private Node delete(Node root, int key){
        if(root == null)
            return null;
        
        if (key < root.data)
            root.left = delete(root.left, key);
        else if (key > root.data)
            root.right = delete(root.right, key);
        else { // Can use condition if(key == root.data). But it's the only remaining condition.
            if(root.left == null)
                root = root.right;
            else if(root.right == null)
                root = root.left;
            else{
                Node t = root.right;
                while(t.left != null)
                    t = t.left;
                int temp = root.data;
                root.data = t.data;
                t.data = temp;
                root.right = delete(root.right, key);
            }
        }
        // Before deletion, check for any unbalanced-tree
        root = balanceTree(root);
        return root;
    }
    
    /* ------------------------------ */
    
    // TRAVERSAL
    void inOrderTraversal(){
        inOrderTraversal(root);
    }
    
    void inOrderTraversal(Node root){
        if(root == null)
            return;
        
        inOrderTraversal(root.left);
        System.out.print(root.data + " ");
        inOrderTraversal(root.right);
    }
    
    void preOrderTraversal(){
        preOrderTraversal(root);
    }
    
    void preOrderTraversal(Node root){
        if(root == null)
            return;
        
        System.out.print(root.data + " ");
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }
    
    void postOrderTraversal(){
        postOrderTraversal(root);
    }
    
    void postOrderTraversal(Node root){
        if(root == null)
            return;
        
        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.print(root.data + " ");
    }
    
    void levelOrderTraversal(){
        if(root == null){
            System.out.println("No tree");
            return;
        }
        
        QueueUsingLL<Node> q = new QueueUsingLL<>();
        
        q.enqueue(root);
        q.enqueue(null);
        int level = 0;
        System.out.println("Level "+level);
        while(!q.isEmpty()){
            Node n = q.dequeue();
            if(n == null) {
                level++;
                if(q.isEmpty())
                    break;
                else{
                    System.out.println("\nLevel "+level);
                    q.enqueue(null);
                }
            } else {
                System.out.print(n.data + " ");
                if(n.left != null)
                    q.enqueue(n.left);
                if(n.right != null)
                    q.enqueue(n.right);
            }
        }
    }
    
    /* ------------------------------ */
    
    // Balancing unbalanced tree/subtree
    
    private Node balanceTree(Node root){
        if(root == null)
            return null;
        if(balanceFactor(root) >= 2){
            if(balanceFactor(root.left) < 0)
                root.left = rotateLeft(root.left);
            root = rotateRight(root);
        }
        else if(balanceFactor(root) <= -2) {
            if (balanceFactor(root.right) > 0)
                root.right = rotateRight(root.right);
            root = rotateLeft(root);
        }
        
        return root;
    }
    
    Node rotateLeft(Node root){
        Node tempRoot = root;
        Node extraNode = root.right.left;
        
        root = root.right;
        root.left = tempRoot;
        tempRoot.right = extraNode;
        
        return root;
    }
    
    Node rotateRight(Node root){
        Node tempRoot = root;
        Node extraNode = root.left.right;
        
        root = root.left;
        root.right = tempRoot;
        tempRoot.left = extraNode;
        
        return root;
    }
    
    int height(Node n){
        if(n == null)
            return -1;
        return Math.max(height(n.left), height(n.right)) + 1;
    }
    
    
    int balanceFactor(Node n){
        return height(n.left) - height(n.right);
    }
    
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
