class PriorityHeap {
    public static void main(String[] args) {
        MaxHeap heap = new MaxHeap(6);
        heap.insert(10);
        heap.insert(8);
        heap.insert(5);
        heap.insert(6);
        heap.insert(4);
        heap.insert(3);

        heap.deleteMax();

        heap.printHeap();
    }
}

class MaxHeap {
    private int[] heap;
    private int heapSize;

    public MaxHeap(int maxSize) {
        heap = new int[maxSize];
        heapSize = 0;
    }

    public boolean isEmpty() {
        return heapSize == 0;
    }

    public boolean isFull() {
        return heapSize >= heap.length;
    }

    /************************************************************
     * parent
     *
     * PURPOSE:
     * Returns the index of the parent of the item at index i
     * (doesn't check if there is a parent).
     *
     ************************************************************/
    public static int parent(int i) {
        return (i - 1) / 2;
    }

    /************************************************************
     * rightChild
     *
     * PURPOSE:
     * Returns the index of the right child of the
     * item at index i (doesn't check if there is a
     * right child).
     ************************************************************/
    public static int rightChild(int i) {
        return 2 * i + 2;
    }

    /************************************************************
     * leftChild
     *
     * PURPOSE:
     * Returns the index of the left child of the
     * item at index i (doesn't check if there is a
     * left child).
     ************************************************************/
    public static int leftChild(int i) {
        return 2 * i + 1;
    }

    /*************************************************************
     *
     * insert
     *
     * PURPOSE: Add a new item to the heap.
     *
     ******************************************************************/
    public void insert(int priority) {

        if (!isFull()) {
            heap[heapSize] = priority;
            heapSize++;
            siftUp(heapSize - 1);
        }
    }

    /*************************************************************
     *
     * siftUp
     *
     * PURPOSE:
     * The item at heap[index] may have higher priority
     * than its parent, but no other problems exist in the heap.
     * Restore heap order by repeatedly moving its parent down
     * until either:
     * (1) the root was moved down, or
     * (2) its parent's priority is >= its priority.
     * Put the item into the "hole" created by the item last
     * moved down.
     *
     ******************************************************************/
    private void siftUp(int index) {
        int toSift = heap[index]; // make a "hole" in the heap
        int i = index;
        int iParent = parent(index);

        while (i > 0 && heap[iParent] < toSift) {
            heap[i] = heap[iParent]; // move the "hole" up to the parent
            i = iParent;
            iParent = parent(i);
        } // end while
        heap[i] = toSift; // put the sifted item into the correct position

    } // end siftUp

    public int deleteMax() {
        int valueDeleted = Integer.MIN_VALUE;

        if (!isEmpty()) {
            // swap root with last level's last node
            valueDeleted = heap[0];
            heap[0] = heap[heapSize - 1];
            heapSize = heapSize - 1; // adjust size

            // sift down is needed
            siftDown(0);
        }

        return valueDeleted;
    }

    private void siftDown(int index) {
        int toSift = heap[index]; // make a "hole" in the heap
        int i = index;

        while (leftChild(i) < heapSize) {
            int leftChildIdx = leftChild(i);
            int rightChildIdx = rightChild(i);
            int maxChildIdx = leftChildIdx; // Assume left child is the larger one

            if (rightChildIdx < heapSize && heap[rightChildIdx] > heap[leftChildIdx]) {
                maxChildIdx = rightChildIdx; // Right child is larger
            }

            if (heap[maxChildIdx] <= toSift) {
                break; // The item's priority is greater than both its children, so the heap property
                       // is restored
            }

            heap[i] = heap[maxChildIdx]; // Move the "hole" down to the child
            i = maxChildIdx;
        }

        heap[i] = toSift; // Put the sifted item into the correct position
    }

    public void printHeap() {
        for (int i = 0; i < heapSize; i++) {
            System.out.println(heap[i] + " ");
        }
    }
}