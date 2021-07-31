import java.util.*;

public class HeapStruct<E extends Comparable> implements HeapInterface<E> {

    /** The list to hold the data */
    private List<E> theData;

    /**
     * Constructor
     */
    public HeapStruct(){
        theData = new ArrayList<E>();
    }

    /**
     * Insert an item into the heap
     * @param item The item to be inserted
     * @return always true
     */
    @Override
    public boolean add(E item) {
        if (theData.contains(item))
            return true;
        theData.add(item);
        int child = theData.size() - 1;
        up(child);
        return true;
    }

    /**
     * Remove the smallest item from the heap
     * @return The item with the smallest value or null if empty
     */
    @Override
    public E remove() {
        if (theData.isEmpty())
            return null;
        E result = theData.get(0);
        if (theData.size() == 1){
            theData.remove(0);
            return result;
        }
        theData.set(0, theData.remove(theData.size()-1));
        down(0);
        return result;
    }

    /**
     * Remove the specified item from the heap
     * @param item The item to be removed from the heap, if present
     */
    @Override
    public void remove(E item) {
        if (theData.isEmpty())
            return;

        int index = theData.indexOf(item);
        if (index == -1)
            return;
        if (size() == 1 && index==0){
            theData.remove(0);
            return;
        }
        if (index == size()-1){
            swap(0, index);
            remove();
            return;}
        theData.set(index, theData.remove(theData.size()-1));
        fixHeap(index);
    }


    /**
     * Get the current size of the heap
     * @return The current size of the heap
     */
    @Override
    public int size() {
        return theData.size();
    }

    /**
     * Search the specified item in the heap
     * @param item The item to be searched
     * @return index
     */
    @Override
    public int search(E item) {
        return theData.indexOf(item);
    }

    /**
     * Merge with another heap
     * @param heap Another heap to be merged
     */
    @Override
    public void merge(HeapStruct heap) {
        List<E> otherData = heap.getTheData();
        for (int i=0; i<otherData.size(); i++)
            add(otherData.get(i));
    }


    /**
     * Remove ith largest element in the heap
     * @param ith ith largest element to be removed
     * @return the removed element
     */
    @Override
    public E removeLargestElement(int ith) {
        if (ith <= 0)
            return null;
        if (ith > theData.size())
            return null;

        List<E> arr = getTheData();
        boolean sorted = false;
        E temp;
        while(!sorted) {
            sorted = true;
            for (int i = 0; i < arr.size() - 1; i++) {
                if (compare(arr.get(i),arr.get(i+1))>0) {
                    temp = arr.get(i);
                    arr.set(i, arr.get(i+1));
                    arr.set(i+1, temp);
                    sorted = false;
                }
            }
        }
        temp = arr.get(size()-ith);
        remove(temp);
        return temp;
    }

    /**
     * Returns an iterator
     * @return an iterator
     */
    public HeapIterator<E> iterator(){
        return new Iter();
    }

    /**
     * Getter for the data
     * @return the data
     */
    private List<E> getTheData(){
        return theData;
    }

    /**
     * Compare the two item
     * @param left first item
     * @param right second item
     * @return 1 if left > right, 0 if left==right otherwise -1.
     */
    private int compare(E left, E right){
        return left.compareTo(right);
    }

    /**
     * Swap the values
     * @param a first index
     * @param b second index
     */
    private void swap(int a, int b){
        E temp = theData.get(a);
        theData.set(a, theData.get(b));
        theData.set(b, temp);
    }


    /**
     * Fix the heap(downside)
     * If parent < child(left or right) swap the values until parent > child
     * or parent is a leaf.
     * @param i parent index
     */
    private void down(int i){
        int parent = i;
        int left = 2*parent+1;
        int right = left + 1;
        int smallest;

        if (left <= size()-1 && compare(theData.get(left), theData.get(i))<0)
            smallest = left;
        else
            smallest = i;

        if (right <= size()-1 && compare(theData.get(right),theData.get(smallest))<0)
            smallest = right;

        if (smallest != i){
            swap(i, smallest);
            down(smallest);
        }
    }

    /**
     * Fix the heap(upside)
     * If child < parent swap the values until parent < child
     * @param index child index
     */
    private void up(int index){
        int child = index;
        int parent = (child - 1) / 2;

        while ( parent >= 0 &&
                compare(theData.get(parent), theData.get(child)) > 0){
            swap(parent, child);
            child = parent;
            parent = (child - 1) / 2;
        }
    }

    /**
     * Fix the heap
     * @param index child index
     */
    private void fixHeap(int index){
        int parent = (index - 1) / 2;

        if ( index == 0 || compare(theData.get(parent), theData.get(index))<0)
            down(index);
        else
            up(index);

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
     * Pre-order traverse on the heap
     * @return pre-order traverse
     */
    @Override
    public String toString(){
        if (theData.isEmpty()){
            return "EMPTY HEAP";
        }
        else {
            StringBuilder sb = new StringBuilder();
            preOrderTraverse(0,1,sb);
            return sb.toString();
        }
    }


    private class Iter implements HeapIterator<E>{
        private E lastItemReturned;
        private int index = 0;

        /**
         * Returns true if the iteration has more elements.
         * @return true if the iteration has more elements
         */
        @Override
        public boolean hasNext() {
            return index < size();
        }

        /**
         * Returns the next element in the iteration.
         *
         * @return the next element in the iteration
         * @throws NoSuchElementException if the iteration has no more elements
         */
        @Override
        public E next() {
            if (!hasNext())
                throw new NoSuchElementException();
            lastItemReturned = theData.get(index++);
            return lastItemReturned;
        }

        /**
         * Set the value of the last element returned by the next() method
         * @param item The item to be set instead lastItemReturned.
         */
        @Override
        public void set(E item){
            if (lastItemReturned == null)
                throw new IllegalStateException();
            if(theData.contains(item)){
                System.out.println("The item is already exist in the heap!!");
                return;
            }
            int idx = index - 1;
            theData.set(idx, item);
            fixHeap(idx);
        }
    }
}
