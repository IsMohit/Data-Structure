class DNode{
    DNode next;
    DNode prev;
    int data;
    DNode(int data){
        this.data= data;
        this.next = null;
        this.prev = null;
    }
}

public class Stack_DL {
    DNode top;
    Stack_DL(){
        top = null;
    }

    public void push(int value){
        DNode newnode = new DNode(value);
        if(top == null)
        {
            top = newnode;
            return;
        }
        newnode.next = top;
        top.prev = newnode;
        top = newnode;
    }

    public void pop(){
        if(top == null) {
          System.out.println("Stack is Empty");
          return;  
        }
        top = top.next;
        top.prev = null;
    }

    public void peek(){
        if (top == null) {
            System.out.println("Stack is Empty");
            return;
        }
        else{
            System.out.println("\nTop Element => "+top.data);
        }
    }

    public void display(){
        DNode temp = top;
        System.out.print("\nStack => ");
        while(temp!=null){
            System.out.print("["+temp.data+"] ");
            temp = temp.next;
        }
    }
    
    public static void main(String[] args) {
        Stack_DL s = new Stack_DL();
        s.push(25);
        s.push(35);
        s.push(45);
        s.push(55);
        s.push(65);
        s.push(75);
        s.push(85);
        s.push(95);
        s.push(105);
        System.out.print("\nInitially");
        s.display();
        s.peek();

        System.out.print("\nAfter Poping 2 elements");
        s.pop();
        s.pop();
        s.display();
        s.peek();

        System.out.println();
    }
}
