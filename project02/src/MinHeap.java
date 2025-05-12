import java.util.*;

public class MinHeap {

    public Consignment peek() {
        Consignment popped = Heap[0]; //o(1)
        return popped;
    }

    private Consignment[] Heap;
    private int index;
    private int size;

    public MinHeap(int size) {
        this.size = size;
        this.index = 0;
        Heap = new Consignment[size];
    }

    private int parent(int i) {
        return (i - 1) / 2;
    }

    private int leftChild(int i) {
        return (i * 2) + 1;
    }

    private int rightChild(int i) {
        return (i * 2) + 2;
    }

    private boolean isLeaf(int i) {
        if(2*i+1 >= index)
            return true;
        return false;
    }

    public void insert(Consignment element) {
        if (index >= size) {
            return;
        }
        Heap[index] = element;
        int current = index;

        while (Heap[current].Compare(Heap[parent(current)]) == -1) {
            swap(current, parent(current));
            current = parent(current);
        }
        index++;
    }

    // removes and returns the minimum element from the heap
    public Consignment remove() {
        // since its a min heap, so root = minimum
        Consignment popped = Heap[0];
        Heap[0] = Heap[--index];
        minHeapify(0);
        return popped;
    }

    // heapify the node at i
    private void minHeapify(int i) {
        // If the node is a non-leaf node and any of its child is smaller
        if (!isLeaf(i)) {
            if (Heap[i].Compare(Heap[leftChild(i)]) == 1 && rightChild(i) >= index){
                swap(i , leftChild(i));
                minHeapify(leftChild(i));
            }
            else if (Heap[i].Compare(Heap[leftChild(i)]) == 1 || Heap[i].Compare(Heap[rightChild(i)]) == 1) {
                if (Heap[leftChild(i)].Compare(Heap[rightChild(i)]) == -1) {
                    swap(i, leftChild(i));
                    minHeapify(leftChild(i));
                } else {
                    swap(i, rightChild(i));
                    minHeapify(rightChild(i));
                }
            }
        }
    }



    // swaps two nodes of the heap
    private void swap(int x, int y) {
        Consignment tmp;
        tmp = Heap[x];
        Heap[x] = Heap[y];
        Heap[y] = tmp;
    }


}
