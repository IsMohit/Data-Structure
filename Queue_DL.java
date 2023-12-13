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

public class Queue_DL {
    DNode front , rear;
    Queue_DL(){
        front=rear=null;
    }

    public void enqueue(int value){
        DNode newnode = new DNode(value);
        if(rear == null){
            front=rear=newnode;
            return;
        }
        rear.next = newnode;
        newnode.prev = rear;
        rear = newnode;
    }

    public void dequeue(){
        if(front == null || rear == null){
            System.out.println("Queue is Empty !");
            return;
        }
        front = front.next;
        front.prev = null;
    }

    public void display(){
        DNode temp = front;
        System.out.print("\nQueue => ");
        while (temp!=null) {
            System.out.print("["+temp.data+"] ");
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        Queue_DL q = new Queue_DL();
        q.enqueue(25);
        q.enqueue(35);
        q.enqueue(45);
        q.enqueue(55);
        q.enqueue(65);
        q.enqueue(75);
        q.display();

        System.out.println("\n\nAfter Dequeuing ");
        q.dequeue();
        q.display();
    }
}
