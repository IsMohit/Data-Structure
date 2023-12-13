class DNode{
    DNode next;
    DNode prev;
    int data;

    DNode(int data){
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}

public class DLL1 {
    DNode head;
    DLL1(){
        head = null;
    }
    
    //insert from front 
    public void insert_front(int value){
        DNode newNode = new DNode(value);
        if(head == null){
            head = newNode;
            return;
        }
        else{
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }

    // insert from end

    public void insert_end(int value){
        DNode newNode = new DNode(value);
        DNode temp = head;
        if(head == null){
            head = newNode;
            return;
        }
        while (temp.next!=null) {
            temp=temp.next;
        }
        temp.next = newNode;
        newNode.prev = temp;
    }

    // insert at specific position
    
    public void insert_mid(int value , int key){
        DNode newNode = new DNode(value);
        if(head == null){
            head = newNode;
            return;
        }
        DNode temp = head;
        DNode nextnode = null;
        while(temp.data!=key){
            temp = temp.next;
        }
        nextnode = temp.next;
        newNode.next = nextnode;
        nextnode.prev = newNode;
        temp.next = newNode;
        newNode.prev = temp;

    }

    // Delete from front

    public void del_front(){
        if (head == null) {
            System.out.println("Cannot Delete , LinkedList is Empty !! ");
            return;
        }
        head = head.next;
        head.prev =null;
    }
    
    // Delete from end
    
    public void del_end(){
        if (head == null) {
            System.out.println("Cannot Delete , LinkedList is Empty !! ");
            return;
        }
        DNode temp =head;
        DNode old = null;
        while(temp.next!=null){
            old = temp;
            temp = temp.next;
        }
        old.next = null;
        temp.prev = null; 
    }
    
    // Delete a specific node
    public void del_node(int to_del){
        if (head == null) {
            System.out.println("Cannot Delete , LinkedList is Empty !! ");
            return;
        }
        DNode temp =head;
        DNode old = null;
        while(temp.data!=to_del){
            old = temp;
            temp = temp.next;
        }
        DNode nextnode = temp.next;
        old.next = nextnode;
        nextnode.prev = old;

    }

    // Display in linear and reverse
    
    public void display(){
        DNode temp = head;
        DNode curr = null;
        System.out.print("Traverse => ");
        while(temp!=null){
            System.out.print("["+temp.data+"] ");
            curr=temp;
            temp=temp.next;
        }
        temp = curr;
        System.out.print("\nReverse => ");
        while (temp!=null) {
            System.out.print("["+temp.data+"] ");
            temp = temp.prev;
        }
    }

   
    public static void main(String[] args) {
        DLL1 d = new DLL1();
        d.insert_front(25);
        d.insert_front(35);
        d.insert_front(45);
        d.insert_front(55);
        d.insert_front(65);
        d.insert_front(75);
        System.out.println("\nInserting from Front ");
        d.display();

        System.out.println("\n\nInserting from End");
        d.insert_end(15);
        d.insert_end(5);
        d.display();
        
        System.out.println("\n\nInserting at speciic position after 55 and 35");
        d.insert_mid(100, 35);
        d.insert_mid(200, 55);
        d.display();
        
        System.out.println("\n\nDeleting a Node from front");
        d.del_front();
        d.display();

        System.out.println("\n\nDeleting a Node from End");
        d.del_end();
        d.display();
        
        System.out.println("\n\nDeleting a Node from a specific position ");
        d.del_node(100);
        d.display();

        System.out.println("\n");

    }

}
