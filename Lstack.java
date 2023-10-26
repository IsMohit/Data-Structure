public class Lstack{
    private class Node{
        int value;
        Node next;

    }

    Node top;
    Lstack(){
        top = null;
    }

    public void push(int data){
        Node tmp = new Node();
        if(tmp == null){
            System.out.println("Heap overflow");
            return;
        }

        tmp.value =data;
        tmp.next = top;
        top = tmp;

    }

    public boolean isEmpty(){
        return top == null;
    }


    public int peak(){
        if (!isEmpty()) {
            return top.value;
        }
        else {
            System.out.println("Stack is empty");
            return -1;
        }
    }

    public void pop(){
        if(top == null){
            System.out.println("stack underflow ");
            return;
        }

        top = top.next;

    }

    public void display(){
        if(top == null){
            System.out.println("stack underflow");
            return;
        }
        else{
            Node temp = top;
            while(temp != null){
                System.out.print(temp.value+" ");

                temp = temp.next;

            }
        }
    }

    public static void main(String[] args) {
        Lstack l = new Lstack();
        l.push(25);
        l.push(35);
        l.push(15);
        l.push(55);

        l.display();

        System.out.println();
        System.out.println("top element "+l.peak());
        
        l.pop();
        l.pop();
        l.display();
        System.out.println();
        
        System.out.println("top element "+l.peak());
    }
}