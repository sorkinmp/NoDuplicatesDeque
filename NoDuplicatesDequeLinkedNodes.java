
public class NoDuplicatesDequeLinkedNodes<T> implements NoDuplicatesDequeInterface<T> {

	// Variables
	private DLNode lastNode;  // references node at back of deque

	// Constructors

	// default constructor
	public NoDuplicatesDequeLinkedNodes() {
		lastNode = null;
	}

	// Methods

	/** Checks to see if the new entry is already in deque.
	@param newEntry The object to be checked.
	@return True if newEntry is already in deque.
	 * False otherwise. */
	@Override
	public boolean isDuplicate(T newEntry) {
		DLNode current = lastNode;
		// loop through all nodes
		while (current.next != lastNode) {
			// if the data of current node is newEntry
			if (current.data == newEntry) {
				return true;
			}
			current = current.next;
		}
		// for the second to last node
		if (current.data == newEntry) {
			return true;
		}
		
		// if no data matches newEntry
		return false;
	}

	/** Adds a new entry to the front of this deque if
	 * the entry is not already in deque.
    @param newEntry  An object to be added. */
	@Override
	public void addToFront(T newEntry) {
		DLNode newNode = new DLNode(newEntry);
		if (isEmpty()) {
			lastNode = newNode;
			lastNode.previous = newNode;
			lastNode.next = newNode;
			return;
		}

		// check duplicate
		// if newEntry not a duplicate
		// then add it to the front
		if (!isDuplicate(newEntry)) {
			DLNode firstNode = lastNode.next;  // first node is right after last node

			firstNode.previous = newNode;
			newNode.next = firstNode;
			newNode.previous = lastNode;
			lastNode.next = newNode;
		}
	}

	/** Adds a new entry to the back of this deque if
	 * the entry is not already in deque.
    @param newEntry  An object to be added. */
	@Override
	public void addToBack(T newEntry) {
		DLNode newNode = new DLNode(newEntry);
		// make isEmpty condition
		if (isEmpty()) {
			lastNode = newNode;
			lastNode.previous = newNode;
			lastNode.next = newNode;
			return;
		}
		// check duplicate
		// if newEntry not a duplicate
		// then add it to the back
		if (!isDuplicate(newEntry)) {
			newNode.previous = lastNode;
			newNode.next = lastNode.next;
			lastNode.next = newNode;
			lastNode = newNode;
		}
	}

	/** Removes and returns the front entry of this deque.
    @return  The object at the front of the deque.
    @throws  EmptyQueueException if the deque is empty before the operation. */
	@Override
	public T removeFront() {
		if (isEmpty()) {
			throw new EmptyQueueException("Deque is empty");
		}
		DLNode firstNode = lastNode.next;
		// if only one node
		if (lastNode.next == lastNode) {
			T data = firstNode.data;
			lastNode = null;
			return data;
		}
		lastNode.next = firstNode.next;
		firstNode.next.previous = lastNode;
		return firstNode.data;
	}

	/** Removes and returns the back entry of this deque.
    @return  The object at the back of the deque.
    @throws  EmptyQueueException if the deque is empty before the operation. */
	@Override
	public T removeBack() {
		if (isEmpty()) {
			throw new EmptyQueueException("Deque is empty");
		}
		DLNode backNode = lastNode;
		DLNode firstNode = lastNode.next;
		DLNode newBackNode = lastNode.previous;
		//  if only one node
		if (lastNode.next == lastNode) {
			T data = firstNode.data;
			lastNode = null;
			return data;
		}

		firstNode.previous = newBackNode;
		newBackNode.next = firstNode;
		lastNode = newBackNode;
		return backNode.data;
	}

	/** Takes an object in the deque and moves it to the front.
	 * If the object is not in queue, add it to the front.
	@param anEntry An object in the queue. */
	@Override
	public void moveToFront(T anEntry) {
		// if the deque is empty
		// just add the object
		if (isEmpty()) {
			addToFront(anEntry);
		}
		// if deque not empty
		// run the duplicate method
		if (isDuplicate(anEntry)) {
			DLNode current = lastNode;
			// find the node
			while (current.data != anEntry) {
				current = current.next;
			}
			// delete the node
			// remove the links
			current.previous.next = current.next;
			current.next.previous = current.previous;
			current.next = null;
			current.previous = null;
			// after removing the links, add current's data to the front
			addToFront(current.data);
			// finally delete the node itself
			current = null;
			return;
		}
		// if anEntry not in deque
		addToFront(anEntry);
	}

	/** Takes an object in the deque and moves it to the back.
	 * If the object is not in queue, add it to the back.
	@param anEntry An object in the queue. */
	@Override
	public void moveToBack(T anEntry) {
		// if the deque is empty
		// add anEntry to back
		if (isEmpty()) {
			addToBack(anEntry);
		}
		// if deque not empty
		// run isDuplicate method
		if (isDuplicate(anEntry)) {
			DLNode current = lastNode;
			// find the node
			while (current.data != anEntry) {
				current = current.next;
			}
			// delete the node
			// remove the links
			current.previous.next = current.next;
			current.next.previous = current.previous;
			current.next = null;
			current.previous = null;
			// after removing the links, add current's data to the back
			addToBack(current.data);
			// finally delete the node itself
			current = null;
			return;
		}
		// if anEntry not in deque
		addToBack(anEntry);
	}

	/** Retrieves the front entry of this deque.
    @return  The object at the front of the deque.
    @throws  EmptyQueueException if the deque is empty before the operation. */
	@Override
	public T getFront() {
		if (isEmpty()) {
			throw new EmptyQueueException("Deque is empty");
		}
		return lastNode.next.data;
	}

	/** Retrieves the back entry of this deque.
    @return  The object at the back of the deque.
    @throws  EmptyQueueException if the deque is empty before the operation. */
	@Override
	public T getBack() {
		if (isEmpty()) {
			throw new EmptyQueueException("Deque is empty");
		}
		return lastNode.data;
	}

	/** Detects whether this deque is empty.
    @return  True if the queue is empty, or false otherwise. */
	@Override
	public boolean isEmpty() {
		return lastNode == null;
	}

	/** Removes all entries from this deque. */
	@Override
	public void clear() {
		lastNode = null;
	}

	/**
	* 
	* The string is formed using the data from the front to the back of the deque.
	* If a deque has the following data: Front-> Ava, Joe, Sarah, Robert <-Back then
	* the toString should return a string "[Ava, Joe, Sarah, Robert]"
	* It returns "[]" for an empty deque
	* @return a string representing the content of the deque from the front to the back.
	*/ 
	
	public String toString(){
	    String firstBracket = "[";
	    String lastBracket = "]";
	    // if it is empty
	    if (isEmpty()) {
	    	return firstBracket + lastBracket;
	    }
	    DLNode firstNode = lastNode.next;
	    while (firstNode != lastNode) {
	    	firstBracket = firstBracket + firstNode.data + ", ";
	    	firstNode = firstNode.next;
	    }
	    firstBracket = firstBracket + lastNode.data;
	    return firstBracket + lastBracket;
	}

	// class we created for Lab 6: Doubly Linked Dequeue
	private class DLNode
	{
		// Variables
		private T      data;  	 // Dequeue entry
		private DLNode next;  	 // Link to next node
		private DLNode previous; // Link to previous node

		// Constructors
		// data parameter constructor
		private DLNode(T data)
		{
			this.data = data;
			next = null;	
			previous = null;	
		} // end constructor

		// data, previousNode, and nextNode constructor
		private DLNode(DLNode previousNode, T data, DLNode nextNode)
		{
			this.data = data;
			next = nextNode;	
			previous = previousNode;
		} // end constructor

	} // end DLNode

}
