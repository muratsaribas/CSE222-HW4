import java.util.NoSuchElementException;

public interface HeapIterator<E>{
    /**
     * Returns true if the iteration has more elements.
     * @return true if the iteration has more elements
     */
    boolean hasNext();

    /**
     * Returns the next element in the iteration.
     *
     * @return the next element in the iteration
     * @throws NoSuchElementException if the iteration has no more elements
     */
    E next();

    /**
     * Set the value of the last element returned by the next() method
     * @param item The item to be set instead lastItemReturned.
     */
    void set(E item);
}
