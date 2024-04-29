public class MyMinHeap<T> {
    private final MyArrayList<T> heap;

    public MyMinHeap() {
        this.heap = new MyArrayList<>();
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public int size() {
        return heap.size();
    }

    public T getMin(){
        if (isEmpty()){
            return null;
        }
       return heap.getFirst();
    }

    public T extractMin(){
        if (isEmpty()){
            return null;
        }
        T temp = heap.getFirst();
        heap.set(0, heap.getLast());
        heap.removeLast();
        heapify(0);
        return temp;
    }

    public void insert(T value){
        heap.addLast(value);
        traverseUP(heap.size() - 1);
    }

    @SuppressWarnings("unchecked")
    private void heapify(int index){
        if(index >= size())return;
        if(leftChild(index) < size() && ((Comparable<T>)heap.get(rightChild(index))).compareTo(heap.get(leftChild(index))) > 0){
            if(((Comparable<T>)heap.get(index)).compareTo(heap.get(leftChild(index))) > 0){
                swap(index, leftChild(index));
                heapify(leftChild(index));
            }
        }
        else {
            if(rightChild(index) < size() && ((Comparable<T>)heap.get(index)).compareTo(heap.get(rightChild(index))) > 0){
                swap(index, rightChild(index));
                heapify(rightChild(index));
            }
        }
    }

    @SuppressWarnings("unchecked")
    private void traverseUP(int index){
        if(((Comparable<T>)heap.get(index)).compareTo(heap.get(parentOf(index))) < 0){
            swap(index, parentOf(index));
            traverseUP(parentOf(index));
        }
    }

    private int leftChild(int index){
        return index * 2 + 1;
    }

    private int rightChild(int index){
        return index * 2 + 2;
    }

    private int parentOf(int index){
        return (index - 1) / 2;
    }

    private void swap(int index1, int index2){
        T temp = heap.get(index1);
        heap.set(index1, heap.get(index2));
        heap.set(index2, temp);
    }
}