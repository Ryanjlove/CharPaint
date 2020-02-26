package CharPaint;
//package CharPaint;

/**
 * Queue interface
 */
public interface Queue<T> {
    
    /**
     * Add the object to the queue. Throw IllegalStateException if add fails.
     * @param obj
     * @return 
     */
    public boolean add(T obj);
    
    /**
     * Retrieve, but do not remove, the object in the front of the queue.
     * Throw NoSuchElementException if queue is empty.
     * @return 
     */
    public T element();
    
    /**
     * Add the object to the queue. Return false if the add fails.
     * @param obj
     * @return 
     */
    public boolean offer(T obj);
    
    /**
     * Retrieve, but do not remove, the object in the front of the queue.
     * Return null if the queue is empty.
     * @return 
     */
    public T peek();
    
    /**
     * Remove and return the object in the front of the queue.
     * Return null if the queue is empty.
     * @return 
     */
    public T poll();
    
    /**
     * Remove and return the object in the front of the queue.
     * Throw NoSuchElementException if the queue is empty.
     * @return 
     */
    public T remove();
    
    /**
     * Exactly what it says it does. Remove all elements, leaving the queue empty.
     */
    public void clear();
    
    /**
     * Return true if the object is in the queue.
     * @param obj
     * @return 
     */
    public boolean contains(T obj);
    
    /**
     * Return the number of elements in the queue.
     * @return 
     */
    public int size();
    
    /**
     * Return true if size == 0
     * @return 
     */

    public boolean isEmpty();
    
    /**
     * Return the queue as an array. The front of the queue should be index 0.
     * The back of the queue should be at index size-1.
     * @return 
     */
    public Object[] toArray();
}
