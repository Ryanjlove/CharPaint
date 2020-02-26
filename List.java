package CharPaint;


import java.util.ListIterator;


public interface List<T> extends Iterable<T> {
    /**
     * Insert an element at a specified location.
     * @param index
     * @param obj
     * @throws IndexOutOfBoundsException
     */
    public void add(int index, T obj);
    
    /**
     * Append an object to the end of the list.
     * @param obj
     */
    public boolean add(T obj);
    
    /**
     * Clears the list
     */
    public void clear();
    
    /**
     * Checks to see if obj
     * is contained in the list,
     * returns true if it is contained,
     * returns false if not in the list
    */
    public boolean contains(T obj);
    
    /**
     * If obj is in the list, return the 
     * index of the first occurrence.
     * Otherwise, return -1.
     * @param obj
     * @return 
     */
    public int indexOf(T obj);
    
    /**
     * Checks to see if list is empty,
     * returns true if empty,
     * returns false if not
     * @return 
     */
    public boolean isEmpty();
    
    /**
     * Returns the first instance of the object
     * in the list if starting from the back
     * @param obj
     * @return 
     */
    public int lastIndexOf(T obj);
    
    /**
     * Get and return the value stored at the index.
     * 
     * @param index
     * @return
     * @throws IndexOutOfBoundsException
     */
    public T get(int index);
        
    /**
     * Remove the object at the given index,
     * returns the object removed,
     * if index invalid,
     * throws IndexOutOfBoundException
     * @param index
     * @return 
     */
    public T remove(int index);
    
    /**
     * Searches the list for the object,
     * removes it if found
     * @param obj
     * @return 
     */
    public boolean remove(T obj);
    
    /**
     * ListIterator to move through the list
     * @param index
     * @return 
     */
    public ListIterator<T> listIterator(int index);
    
    /**
     * Update the value in the list at the specified index.
     * Return the old value
     * @throws IndexOutOfBoundsException
     * @param index
     * @param obj
     * @return 
     */
    public T set(int index, T obj);
    
    /**
     * Returns size of the list
     * @return 
     */
    public int size();
    
    /**
     * Creates an object array that contains
     * each element of the list
     * @return 
     */
    public Object[] toArray();
}

