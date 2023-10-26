public class Lque{
    private class Node{
        int value;
        Node next;
        Node(int x )
        {
            value = x ;
            next = null;
        }
    }

    Node front , rear;

    Lque(){
        front = rear = null;
    }

    public void enqueue(int data){
        Node tmp = new Node(data);  

        if(rear == null){
            front = rear = tmp;
            return;
        }

        rear.next = tmp;
        rear = tmp;
    }

    public void dequeue(){
        if(front == null){
            return;
        }

        Node tmp = front;
        front = front.next;

        if(front == null)
        {
            rear = null;
        }

    }

    public void display(){
        Node tmp = front;

        while(tmp != null){
            System.out.print(tmp.value+" ");
            tmp = tmp.next;
        }
    }

    public static void main(String[] args) {
        Lque q = new Lque();
        q.enqueue(25);
        q.enqueue(35);
        q.enqueue(5);
        q.enqueue(65);
        q.enqueue(75);
        q.display();
        System.out.println();
        
        q.dequeue();
        q.display();
        System.out.println();
        q.enqueue(95);
        q.display();
    }
}