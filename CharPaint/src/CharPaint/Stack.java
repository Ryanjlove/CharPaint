/**
 * Stack interface.
 */
package CharPaint;

public interface Stack<T> {

	/**
	 * Adds something to the top of the stack.
	 * 
	 * @param obj - the object to be added.
	 * @return the object parameter.
	 */
	public T push(T obj);

	/**
	 * Returns a reference to the top of the stack. Does not modify the stack.
	 * 
	 * @return a reference to the top of the stack.
	 */
	public T peek();

	/**
	 * Removes the top element from the stack.
	 * 
	 * @return a reference to the element that was on the top of the stack.
	 */
	public T pop();

	/**
	 * Determines if the stack is empty.
	 * 
	 * @return true if the stack is empty.
	 */
	public boolean empty();
}
