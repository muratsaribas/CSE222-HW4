public interface HeapInterface<E extends Comparable> {
    /**
     * Insert an item into the heap
     * @param item The item to be inserted
     * @return always true
     */
    boolean add(E item);

    /**
     * Remove the smallest item from the heap
     * @return The item with the smallest value or null if empty
     */
    E remove();

    /**
     * Remove the specified item from the heap
     * @param item The item to be removed from the heap, if present
     */
    void remove(E item);

    /**
     * Get the current size of the heap
     * @return The current size of the heap
     */
    int size();

    /**
     * Search the specified item in the heap
     * @param item The item to be searched
     * @return index
     */
    int search(E item);

    /**
     * Merge with another heap
     * @param heap Another heap to be merged
     */
    void merge(HeapStruct heap);

    /**
     * Remove ith largest element in the heap
     * @param i ith largest element to be removed
     * @return the removed element
     */
    E removeLargestElement(int i);

}
