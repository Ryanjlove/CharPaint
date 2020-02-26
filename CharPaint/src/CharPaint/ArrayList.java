package CharPaint;
//package CharPaint;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;


/**
 * Implementation of an array list. In this implementation:
 *  - The list can be resized.
 *  - No null values allowed.
 */
public class ArrayList<T> implements List<T>, Serializable {
    private Object[] list;
    private int size;
    private int capacity;
    public static final int DEFAULT_CAPACITY = 100;
    
    public ArrayList() {
        this(DEFAULT_CAPACITY);
    }
    
    public ArrayList(int initialCapacity) {
        capacity = initialCapacity;
        list = new Object[capacity];
    }
    
    @Override
    public void add(int index, T obj) {
        insert(index, obj);
    }
    
    /**
     * Helper method to insert new element into
     * the ArrayList
     * @param index
     * @param obj 
     */
    private void insert(int index, T obj) {
        if (obj == null)
            throw new NullPointerException();
        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException();
        if (size == capacity) {
            resize(capacity * 2);
        }
        //shift the elements down to make room for the new element
        for (int i = size; i > index; i--) {
            list[i] = list[i-1];
        }
        list[index] = obj;
        size++;
    }

    @Override
    public boolean add(T obj) {
        add(size, obj);
        return true;
    }

    @Override
    public void clear() {
        list = new Object[capacity];
        size = 0;
    }

    @Override
    public boolean contains(T obj) {
        return indexOf(obj) != -1;
    }

    @Override
    public int indexOf(T obj) {
        for (int i = 0; i < size; i++) {
            if (list[i].equals(obj)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int lastIndexOf(T obj) {
        for (int i = size-1; i >= 0; i--) {
            if (list[i].equals(obj)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException();
        return (T)list[index];
    }

    @Override
    public T remove(int index) {
        T old = get(index);
        for (int i = index; i < size-1; i++) {
            list[i] = list[i+1];
        }
        list[--size] = null;
        return old;
    }
    
    @Override
    public boolean remove(T obj) {
        int index = indexOf(obj);
        if (index < 0)
            return false;
        remove(index);
        return true;
    }

    @Override
    public T set(int index, T obj) {
        if (obj == null)
            throw new NullPointerException();
        T old = get(index);
        list[index] = obj;
        return old;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Object[] toArray() {
        Object[] rarr = Arrays.copyOf(list, size);
        return rarr;
    }
    
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int current = 0;
            private boolean nextCalled = false;
            
            @Override
            public boolean hasNext() {
                return current < size;
            }

            @Override
            public T next() {
                if (!hasNext())
                    throw new NoSuchElementException();
                T obj = (T)list[current++];
                nextCalled = true;
                return obj;
            }

            @Override
            public void remove() {
                if (!nextCalled)
                    throw new IllegalStateException();
                current--;
                for (int i = current; i < size-1; i++) {
                    list[i] = list[i+1];
                }
                list[--size] = null;
                nextCalled = false;
            }
        };
    }
    
    @Override
    public ListIterator<T> listIterator(int index) {
                return new ListIterator<T>() {
            private int nextIndex = index;
            private boolean nextCalled = false, previousCalled = false;
            @Override
            public boolean hasNext() {
                return nextIndex < size;
            }

            @Override
            public T next() {
                if (hasNext()) {
                    nextCalled = true; previousCalled = false;
                    T obj = (T)list[nextIndex++];
                    return obj;
                } else {
                    throw new NoSuchElementException();
                }
            }

            @Override
            public boolean hasPrevious() {
                return nextIndex > 0;
            }

            @Override
            public T previous() {
                if (hasPrevious()) {
                    previousCalled = true;
                    nextCalled = false;
                    T obj = (T)list[--nextIndex];
                    return obj;
                } else {
                    throw new NoSuchElementException();
                }
            }

            @Override
            public int nextIndex() {
                return nextIndex;
            }

            @Override
            public int previousIndex() {
                return nextIndex-1;
            }

            @Override
            public void remove() {
                if (!(previousCalled || nextCalled)) {
                    throw new IllegalStateException();
                }
                if (nextCalled) {
                    nextIndex--;
                }
                for (int i = nextIndex; i < size-1; i++) {
                    list[i] = list[i+1];
                }
                list[--size] = null;
                previousCalled = nextCalled = false;
            }

            @Override
            public void set(T e) {
                if (!(previousCalled || nextCalled))
                    throw new IllegalStateException();
                int index = previousCalled?nextIndex:nextIndex-1;
                list[index] = e;
                previousCalled = nextCalled = false;
            }

            @Override
            public void add(T e) {
                insert(nextIndex++, e);
                previousCalled = nextCalled = false;
            }
        };
    }
    
    /**
     * Resize array if capacity is exceeded
     * @param newCapacity 
     */
    private void resize(int newCapacity) {
        list = Arrays.copyOf(list, newCapacity);
        capacity = newCapacity;
    }
            
}
