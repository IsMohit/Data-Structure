import java.util.*;
public class Binary_tree{

    // creating the node ..

    public static class Node{
        int value;
        Node left , right ;

        // Initialize the class variable...
        
        Node(int value){
            this.value = value;
            left=right=null;
        }
    }

    // Creating a root ... 
    Node root;

    // initialize the root

    Binary_tree(){
        root = null;
    }

    // Create a method to insert the data

    public void insert(int data){
        root = insert_here(root,data);
    }

    // Validating for insert method using insert_here()

    public Node insert_here(Node root , int data){

        // Check if root is null , if yes then create a new node and make it as root
        if(root == null ){ 
            root = new Node(data);
            return root;
        }
        
        // If data is less than the root.value than insert new node to left else to the right
        if(data < root.value)
        root.left = insert_here(root.left,data);
        else if(data > root.value)
        root.right = insert_here(root.right,data);
        return root;
    }

    // Preorder traversal .. so Root - Left - Right

    public static void preorder(Node temp)
    {
        if(temp == null){
            return;
        }

        System.out.print(temp.value+"  ");
        preorder(temp.left);
        preorder(temp.right);
    }
    
    // Inorder Traversal .. so Left - Root - Right
    
    public static void inorder(Node temp)
    {
        if(temp == null){
            return;
        }

        inorder(temp.left);
        System.out.print(temp.value+"  ");
        inorder(temp.right);
    }
    // Postorder Traversal .. so Left - Right - Root
    
    public static void postorder(Node temp)
    {
        if(temp == null){
            return;
        }

        postorder(temp.left);
        postorder(temp.right);
        System.out.print(temp.value+" ");
    }

    Node search(Node root, int key) {

        if (root == null || root.value == key)
            return root;
 

        if (root.value < key)
            return search(root.right, key);
 

        return search(root.left, key);
    }



    public static void main(String[] args) {
        Binary_tree b = new Binary_tree();
        Scanner s = new Scanner(System.in);
        int key;
        System.out.print("Please Enter the number of nodes to store  -- > ");
        int len = s.nextInt();
        System.out.println();

        
        for(int i = 0 ; i < len ; i++ ){
            if(i == 0)
            System.out.println("Enter the nodes here : ");
            System.out.print("Node["+(i+1)+"] = ");
            key = s.nextInt();
            b.insert(key);
        }
        System.out.println();

        for(int j = 0 ; j < 3 ; j++)
        {

            // TRAVERSAL CHOICE ..

            System.out.println("Which Traversal to Perform : \nPress 1 -> Preorder , 2 -> Inorder , 3 -> Postorder ");
            int choice = s.nextInt();
            System.out.println("-----------------------------------------------------");
            switch(choice){
                case 1 :
            System.out.print("Preorder ==> ");
            preorder(b.root);
            System.out.println();
            break;

            case 2 :
            System.out.print("Inorder ==> ");
            inorder(b.root);
            System.out.println();
            break;

            case 3 : 
            System.out.print("Postorder ==> ");
            postorder(b.root);
            System.out.println();
            break;

            default:
            System.out.println("Please Enter a Available value from (1 , 2 or 3)!!");
            
        }
        if(j == 2)
        break;

        System.out.print("\nDO YOU WANT TO CONTINUE ? (yes : y / no : n) => ");
        char ans = s.next().charAt(0);
        if(ans == 'n' || ans == 'N')
        break;

        System.out.println("\n--------------------------------------------------------");
    }

        System.out.print("\nEnter an Element to search in tree : ");
        int find = s.nextInt();
        if (b.search(b.root, find) == null)
            System.out.println(find + " is not present in the current tree !!");
        else
            System.out.println(find + " is present in the current tree !! ");



        System.out.println();
        s.close();
    }


}