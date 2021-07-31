public interface SearchTree<E extends Comparable<E>> {

    /**
     * Returns the number of occurrences of the item after insertion
     * @param item The item to be added
     * @return the number of occurrences of the item after insertion
     */
    int add(E item);

    /**
     * Returns the number of occurrences of the item after removal
     * @param item The item to be removed
     * @return the number of occurrences of the item after removal
     */
    int remove(E item);

    /**
     * Returns the number of occurrences of the item in the BSTHeapTree
     * @param item The item to be found
     * @return the number of occurrences of the item
     */
    int find(E item);

    /**
     * Returns the value in the BSTHeapTree that occurs most frequently.
     * @return the value that occurs most frequently
     */
    E find_mode();
}
