// Priority Queue implementation in Java
import java.util.*;
import java.util.ArrayList;

class Heap1 {
  // Function to heapify the tree in Max heap
  void Maxheapify(ArrayList<Integer> hT, int i) {
    int size = hT.size();
    // Find the largest among root, left child and right child
    int largest = i;
    int l = 2 * i + 1;
    int r = 2 * i + 2;
    if (l < size && hT.get(l) > hT.get(largest))
      largest = l;
    if (r < size && hT.get(r) > hT.get(largest))
      largest = r;

    // Swap and continue heapifying if root is not largest
    if (largest != i) {
      int temp = hT.get(largest);
      hT.set(largest, hT.get(i));
      hT.set(i, temp);

      Maxheapify(hT, largest);
    }
  }
  // Function to heapify the tree in Min heap
  void Minheapify(ArrayList<Integer> hT, int i) {
    int size = hT.size();
    // Find the smallest among root, left child and right child
    int smallest = i;
    int l = 2 * i + 1;
    int r = 2 * i + 2;
    if (l < size && hT.get(l) < hT.get(smallest))
      smallest = l;
    if (r < size && hT.get(r) < hT.get(smallest))
      smallest = r;

    // Swap and continue heapifying if root is not largest
    if (smallest != i) {
      int temp = hT.get(smallest);
      hT.set(smallest, hT.get(i));
      hT.set(i, temp);

      Minheapify(hT, smallest);
    }
  }


  // Function to insert an element into the tree
  void Maxinsert(ArrayList<Integer> hT, int newNum) {
    int size = hT.size();
    if (size == 0) {
      hT.add(newNum);
    } else {
      hT.add(newNum);
      for (int i = size / 2 - 1; i >= 0; i--) {
        Maxheapify(hT, i);
      }
    }
  }

  // Function to delete an element from the tree
  void MaxdeleteNode(ArrayList<Integer> hT, int num) {
    int size = hT.size();
    int i;
    for (i = 0; i < size; i++) {
      if (num == hT.get(i))
        break;
    }

    int temp = hT.get(i);
    hT.set(i, hT.get(size - 1));
    hT.set(size - 1, temp);

    hT.remove(size - 1);
    for (int j = size / 2 - 1; j >= 0; j--) {
      Maxheapify(hT, j);
    }
  }

// Function to insert an element into the tree
  void Mininsert(ArrayList<Integer> hT, int newNum) {
    int size = hT.size();
    if (size == 0) {
      hT.add(newNum);
    } else {
      hT.add(newNum);
      for (int i = size / 2 - 1; i >= 0; i--) {
        Minheapify(hT, i);
      }
    }
  }

  // Function to delete an element from the tree
  void MindeleteNode(ArrayList<Integer> hT, int num) {
    int size = hT.size();
    int i;
    for (i = 0; i < size; i++) {
      if (num == hT.get(i))
        break;
    }

    int temp = hT.get(i);
    hT.set(i, hT.get(size - 1));
    hT.set(size - 1, temp);

    hT.remove(size - 1);
    for (int j = size / 2 - 1; j >= 0; j--) {
      Minheapify(hT, j);
    }
  }

  // Print the tree
  void printArray(ArrayList<Integer> array, int size) {
    for (Integer i : array) {
      System.out.print(i + " ");
    }
    System.out.println();
  }

  // Driver code
  public static void main(String args[]) {

    ArrayList<Integer> array = new ArrayList<Integer>();
    int size = array.size();

    Heap1 h = new Heap1();
    Scanner sc= new Scanner(System.in);
    System.out.println("which operations would you like to perform:");
    int b= sc.nextInt();
    switch(b){
         case 1 :
            h.Maxinsert(array, 3);
            h.Maxinsert(array, 4);
            h.Maxinsert(array, 9);
            h.Maxinsert(array, 5);
            h.Maxinsert(array, 2);

            System.out.println("Max-Heap array: ");
            h.printArray(array, size);

            h.MaxdeleteNode(array, 4);
            System.out.println("After deleting an element: ");
            h.printArray(array, size);
            break;
         case 2:
            h.Mininsert(array, 3);
            h.Mininsert(array, 4);
            h.Mininsert(array, 9);
            h.Mininsert(array, 5);
            h.Mininsert(array, 2);

            System.out.println("Min -Heap array: ");
            h.printArray(array, size);

            h.MindeleteNode(array, 4);
            System.out.println("After deleting an element: ");
            h.printArray(array, size);
            break;
         default :
            System.out.println("entered wrong choice");
            break;

    }

    
  }
}