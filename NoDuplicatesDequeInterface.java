/**
   An interface for the ADT deque without duplicates.   
   @author Matthew Sorkin
   @version 1.0
 */
public interface NoDuplicatesDequeInterface<T> extends DequeInterface<T>
{
	/** Checks to see if the new entry is already in deque.
	@param newEntry The object to be checked.
	@return True if newEntry is already in deque.
	 * False otherwise. */
	public boolean isDuplicate(T newEntry);
	
	/** Adds a new entry to the front/back of this deque if
	 * the entry is not already in deque.
    @param newEntry  An object to be added. */
	public void addToFront(T newEntry);
	public void addToBack(T newEntry);

	/** Removes and returns the front/back entry of this deque.
    @return  The object at the front/back of the deque.
    @throws  EmptyQueueException if the deque is empty before the operation. */
	public T removeFront();
	public T removeBack();

	/** Takes an object in the deque and moves it to the front/back.
	 * If the object is not in queue, add it to the front/back.
	@param anEntry An object in the queue. */
	public void moveToFront(T anEntry);
	public void moveToBack(T anEntry);
	
	/** Retrieves the front/back entry of this deque.
    @return  The object at the front/back of the deque.
    @throws  EmptyQueueException if the deque is empty before the operation. */
	public T getFront();
	public T getBack();

	/** Detects whether this deque is empty.
    @return  True if the queue is empty, or false otherwise. */
	public boolean isEmpty();

	/** Removes all entries from this deque. */
	public void clear();
} // end NoDuplicatesDequeInterface
