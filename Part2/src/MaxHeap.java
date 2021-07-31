import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class MaxHeap<E extends Comparable<E>> implements Comparable<MaxHeap<E>> {

    protected List< HeapNode<E> > theData;

    /**
     * Constructor
     */
    public MaxHeap(){
        theData = new ArrayList<>();
    }

    /**
     * Insert an item into the heap
     * @param item The item to be inserted
     * @return always true
     */
    public int add(E item){
        HeapNode<E> heapNode = new HeapNode<>(item);
        int idx = theData.indexOf(heapNode);
        //If the item exist in the heap, its count increased by 1.
        if (idx != -1){
            theData.get(idx).increaseCount();
            return theData.get(idx).count;
        }
        theData.add(heapNode);
        int child = theData.size() - 1;
        up(child);
        return 1;
    }

    /**
     * Remove the largest item from the heap
     */
    public void remove(){
        if (theData.isEmpty())
            return;
        if (theData.size() == 1){
            theData.remove(0);
            return;
        }
        if (theData.get(size()-1).count>1)
            theData.get(size()-1).decreaseCount();
        else {
            theData.set(0, theData.remove(theData.size()-1));
            down(0);
        }
    }

    /**
     * Remove the specified item from the heap
     * @param item The item to be removed from the heap, if present
     */
    public void remove(E item){
        if (theData.isEmpty())
            return;
        HeapNode<E> heapNode = new HeapNode<>(item);
        int idx = theData.indexOf(heapNode);
        if (idx == -1)
            return;
        //If the item is root node and heap contains only 1 node.
        if (size() == 1 && idx == 0){
            if (theData.get(0).count > 1)
                theData.get(0).decreaseCount();
            else
                theData.remove(0);
            return;
        }
        if (theData.get(idx).count>1)
            theData.get(idx).decreaseCount();
        else {
            //If the item is last node
            if (idx == size() -1)
                remove();
            else {
                theData.set(idx, theData.remove(theData.size()-1));
                fixHeap(idx);
            }
        }
    }

    /**
     * Get the current size of the heap
     * @return The current size of the heap
     */
    public int size(){
        return theData.size();
    }

    /**
     * Return the index of the specified item in the heap, if present
     * otherwise return -1
     * @param item - Target item
     * @return index of the target item if present, otherwise return -1
     */
    public int indexOf(E item){
        for (int i=0; i< theData.size();i++){
            int compResult = item.compareTo(theData.get(i).getData());
            if (compResult == 0)
                return i;
        }
        return -1;
    }

    /**
     * Fix the heap
     * @param index child index
     */
    private void fixHeap(int index){
        int parent = (index - 1) / 2;

        if ( index == 0 || compare(theData.get(parent), theData.get(index))>0)
            down(index);
        else
            up(index);
    }


    /**
     * Compare the two item
     * @param left first item
     * @param right second item
     * @return 1 if left > right, 0 if left == right, otherwise -1
     */
    private int compare(HeapNode<E> left, HeapNode<E> right){
        return left.data.compareTo(right.data);
    }

    /**
     * Swap the values
     * @param a first index
     * @param b second index
     */
    private void swap(int a, int b){
        HeapNode<E> temp = theData.get(a);
        theData.set(a, theData.get(b));
        theData.set(b, temp);
    }

    /**
     * Fix the heap(downside)
     * If parent > child(left or right) swap the values until parent < child
     * or parent is a leaf.
     * @param i parent index
     */
    private void down(int i){
        int parent = i;
        int left = 2*parent+1;
        int right = left +1;
        int largest;

        if ( left <= size()-1 &&
                compare(theData.get(left), theData.get(i))>0)
            largest = left;
        else
            largest = i;

        if ( right <= size()-1 &&
                compare(theData.get(right), theData.get(largest))>0)
            largest = right;
        if (largest != i){
            swap(i, largest);
            down(largest);
        }
    }

    /**
     * Fix the heap(upside)
     * If child > parent swap the values until parent > child
     * @param index child index
     */
    private void up(int index){
        int child = index;
        int parent = (child - 1) / 2;

        while ( parent >= 0 &&
                compare(theData.get(parent), theData.get(child)) < 0){
            swap(parent, child);
            child = parent;
            parent = (child - 1) / 2;
        }
    }


    /**
     * Perform a preorder traversal.
     * @param parent The root
     * @param depth The depth
     * @param sb The string buffer to save the output
     */
    private void preOrderTraverse(int parent, int depth,
                                  StringBuilder sb) {
        int left =  2*parent+1;
        int right = left+1;
        for (int i = 1; i < depth; i++) {
            sb.append("  ");
        }
        sb.append(theData.get(parent).toString());
        sb.append("\n");
        if (left <= size()-1)
            preOrderTraverse(left, depth + 1, sb);
        if (right <= size()-1)
            preOrderTraverse(right, depth + 1, sb);
    }

    /**
     * Compare the two heaps' root
     * @param o other heap
     * @return 1, 0 or -1
     */
    @Override
    public int compareTo(MaxHeap<E> o) {
        if (theData.isEmpty() || o.size() == 0)
            throw new NoSuchElementException();
        return compare(theData.get(0),o.theData.get(0));
    }

    /**
     * Pre-order traverse on the heap
     * @return pre-order traverse
     */
    @Override
    public String toString(){
        if (theData == null){
            return "EMPTY HEAP";
        }
        else {
            StringBuilder sb = new StringBuilder();
            preOrderTraverse(0,1,sb);
            return sb.toString();
        }
    }


    protected static class HeapNode<E extends Comparable>{
        private E data;
        private int count;


        private HeapNode(E item){
            data = item;
            count = 1;
        }

        public void increaseCount(){
            count++;
        }

        public void decreaseCount(){
            count--;
        }

        public E getData(){
            return data;
        }

        public int getCount(){return count;}

        @Override
        public boolean equals(Object obj) {
            if (obj == this)
                return true;
            if (!(obj instanceof HeapNode))
                return false;
            HeapNode h = (HeapNode) obj;
            return data.equals(h.data);
        }

        @Override
        public String toString() {
            return "("+data +","+count+')';
        }
    }

}
