public class Hashtable {
    int capacity;
    int table[];
    int size;

    Hashtable(int capacity){
        this.capacity = capacity;
        this.table = new int[capacity];
        this.size = 0;
    }

    int hash(int key){
        return key%capacity;
    }

    public void insert(int key){
        if(size == capacity){
            System.out.println("Hash table is full . Cannot insert key : "+key);
            return;
        }

        int index = hash(key);

        while(table[index] != 0){
            index = (index+1)%capacity;
        }
        table[index] = key;
        size++;
    }

    public boolean search(int key){
        int index = hash(key);
        while(table[index]!=0){
            if(table[index] == key){
                return true;
            }
            index = (index + 1)%capacity;
        }
        return false;
    }

    public void display(){
        System.out.println("Hash Table : ");
        for(int i = 0; i < capacity; i++){
            System.out.println("Index "+i+": "+table[i]);
        }
    }

    public static void main(String[] args) {
        Hashtable ht = new Hashtable(10);
        ht.insert(5);
        ht.insert(25);
        ht.insert(15);
        ht.insert(35);
        ht.insert(31);
        ht.display();

        System.out.println("Search for key 15 : "+ht.search(15));
        System.out.println("Search for key 10 : "+ht.search(10));
    }
    
}
