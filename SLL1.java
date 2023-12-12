class Node{
    Node next;
    int data;
    Node(int data){
        this.next= null;
        this.data=data;
    }
}
public class SLL1{
    Node head;
    SLL1(){
        head=null;
    }

    // For inserting from front

    public void front_insert(int value){
       Node newnode = new Node(value);

       if (head == null) {
        head = newnode;
        return;
       }
       else{
        newnode.next=head;
        head = newnode;
       }
    }

    // for inserting from rear

    public void end_insert(int value){
        Node newnode = new Node(value);
        Node temp = head;

        if(head==null){
            head = newnode;
            return;
        }
        while(temp.next!=null){
            temp = temp.next;
        }
        temp.next = newnode;

    }

    // inserting at specific position

    public void mid_insert(int value,int key){
        Node newnode = new Node(value);
        Node current = head;
        if(head == null)
        {
            head = newnode;
            return;
        }

        while(current.data!=key){
            current = current.next;
        }
        newnode.next = current.next;
        current.next=newnode;
    }

    // Deleting from front

    public void del_front(){
        if(head == null)
        {
            System.out.println("No element available to be deleted !");
            return;
        }
        Node del_node = head;
        head = head.next;
    }

    // Deleting from end
    
    public void del_end(){
        if(head == null)
        {
            System.out.println("No element available to be deleted !");
            return;
        }

        Node temp;
        Node prev = null;
        temp = head;
        while(temp.next!=null){
            prev = temp;
            temp = temp.next;
        }

        prev.next = null;
        
    }

    // Deleting a specfic node

    public void spec_del(int to_del){
        Node temp = head;
        Node prev = null;

        while(temp.data!=to_del){
            prev = temp;
            temp = temp.next;
        }
        prev.next = temp.next;
        temp.next = null;
    }

    // For displaying linked list

    public void display(){
        Node temp = head;

        while(temp!=null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }

    }

    public static void main(String[] args) {
        SLL1 s1 = new SLL1();

        // inserting values from front
        s1.front_insert(25);
        s1.front_insert(20);
        s1.front_insert(15);
        s1.front_insert(10);
        s1.front_insert(5);
        System.out.print("After inserting from front\nLinked list => ");
        s1.display();
        System.out.println();

        // inserting values from rear
        s1.end_insert(30);
        s1.end_insert(35);
        s1.end_insert(40);
        System.out.println("\nAfter inserting from end ");
        System.out.print("Linked List => ");
        s1.display();
        System.out.println();

        // inserting values at specific position
        System.out.println("\nAfter inserting after '15' and '30' ");
        s1.mid_insert(69, 15);
        s1.mid_insert(100, 30);
        System.out.print("Linked List => ");
        s1.display();
        System.out.println();
        
        // Deleting from front
        System.out.println("\nDeleting a node from front ");
        s1.del_front();
        s1.display();
        System.out.println();

        // Deleting from rear
        System.out.println("\nDeleting a node from end ");
        s1.del_end();
        s1.display();
        System.out.println();
        
        // Deleting a specific element
        System.out.println("\nDeleting a node -> '100' ");
        s1.spec_del(100);
        s1.display();
        System.out.println();
    }
}