import java.util.*;
class Bnode{
    Bnode left , right;
    int data;
    Bnode(int data){
        this.data=data;
        this.left=null;
        this.right=null;
    }
}

public class Binary_tree {
    Bnode root;
    Binary_tree(){
        root = null;
    }

    public void insert(int value){
        root = insertNode(root,value);
    }

    public Bnode insertNode(Bnode root , int value){
        if(root == null){
            root = new Bnode(value);
            return root;
        }

        if(value < root.data){
            root.left = insertNode(root.left, value);
        }
        else if(value > root.data){
            root.right = insertNode(root.right, value);
        }
        return root;
    }

    public static void preorder(Bnode temp){
        if(temp == null){
            return;
        }
        System.out.print("["+temp.data+"] ");
        preorder(temp.left);
        preorder(temp.right);
    } 
    
    public static void inorder(Bnode temp){
        if(temp == null){
            return;
        }
        inorder(temp.left);
        System.out.print("["+temp.data+"] ");
        inorder(temp.right);
    } 
    
    public static void postorder(Bnode temp){
        if(temp == null){
            return;
        }
        postorder(temp.left);
        postorder(temp.right);
        System.out.print("["+temp.data+"] ");
    } 

    public Bnode search(Bnode root , int key){
        if(root == null || root.data == key){
            return root;
        }

        if(key < root.data)
            return search(root.left, key);
        
        return search(root.right, key);
        
    }
    
    public static void main(String[] args) {
        Binary_tree b = new Binary_tree();
        b.insert(55);
        b.insert(35);
        b.insert(75);
        b.insert(25);
        b.insert(45);
        b.insert(65);
        b.insert(85);
        System.out.print("\nPreorder => ");
        preorder(b.root);
        System.out.print("\nInorder => ");
        inorder(b.root);
        System.out.print("\nPostorder => ");
        postorder(b.root);

        System.out.print("\n\nEnter a key to find : ");
        Scanner sc = new Scanner(System.in);
        int key = sc.nextInt();
        if(b.search(b.root, key) == null){
            System.out.println(key+" is not Present in tree");
        }
        else{
            System.out.println(key+" is Present in tree");
        }
        sc.close();
    }
}
