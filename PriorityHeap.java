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