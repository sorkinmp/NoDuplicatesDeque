/**
   A driver that demonstrates the class NoDuplicatesLinkedNodes.

   @author Matthew Sorkin
   @version 1.0
 */
public class NoDuplicatesLinkedNodesDriver {

	public static void main(String[] args) {
		testDequeOperations();
		System.out.println("\n\nDone.");
	}  // end main

	public static void testDequeOperations() {
		System.out.println("Create a deque: ");
		NoDuplicatesDequeInterface<String> myDeque = new NoDuplicatesDequeLinkedNodes<>();
		System.out.println("\n\nisEmpty() returns " + myDeque.isEmpty() + "\n");
		System.out.println("\ntoString() returns " + myDeque.toString() + "\n");

		System.out.println("Add to front and back of deque to get\n" +
				"Joe Jess Jim Jill Jane Jerry\n");
		myDeque.addToFront("Jim");
		myDeque.addToFront("Jess");

		myDeque.addToBack("Jill");
		myDeque.addToBack("Jane");

		myDeque.addToFront("Joe");
		myDeque.addToBack("Jerry");
		System.out.println("Let's try to add Jerry again (there should only\n" + 
				"be one copy when we print the deque).");
		myDeque.addToBack("Jerry");

		System.out.println("\nisEmpty() returns " + myDeque.isEmpty() + "\n");

		System.out.println("\ntoString() returns " + myDeque.toString() + "\n");

		System.out.println("\n\nTesting getFront, getBack, removeFront, removeBack:\n");
		String front,  back;
		front = myDeque.getFront();
		System.out.println(front + " is at the front of the deque.");

		back = myDeque.getBack();   
		System.out.println(back + " is at the back of the deque.");					

		front = myDeque.removeFront();
		System.out.println(front + " is removed from the front of the deque.");

		back = myDeque.removeBack();
		System.out.println(back + " is removed from the back of the deque.");

		front = myDeque.getFront();
		System.out.println(front + " is at the front of the deque.");

		back = myDeque.getBack();   
		System.out.println(back + " is at the back of the deque.");	

		System.out.println("\n\nTesting clear:\n");
		myDeque.clear();
		System.out.println("\nisEmpty() returns " + myDeque.isEmpty() + "\n\n");
		
		System.out.println("Let's test moveToFront and moveToBack");
		myDeque.addToFront("Jerome");
		myDeque.addToFront("Jamal");
		myDeque.addToBack("Jacob");
		
		System.out.println("\nisEmpty() returns " + myDeque.isEmpty() + "\n");
		System.out.println("\ntoString() returns " + myDeque.toString() + "\n");
		
		System.out.println("Let's move Jerome to the back");
		myDeque.moveToBack("Jerome");
		System.out.println("\ntoString() returns " + myDeque.toString() + "\n");
		
		System.out.println("Let's move Jacob to the front");
		myDeque.moveToFront("Jacob");
		System.out.println("\ntoString() returns " + myDeque.toString() + "\n");
		
		System.out.println("\"\\n\\nTesting clear:\\n\"");
		myDeque.clear();
		System.out.println("\nisEmpty() returns " + myDeque.isEmpty() + "\n\n");
		
		System.out.println("The next calls will throw an exception." + "\n");
		front = myDeque.removeFront();
		front = myDeque.removeBack();
	}
}
