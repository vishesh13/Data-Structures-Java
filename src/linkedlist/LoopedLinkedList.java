package linkedlist;

/**
 * Linked List class with looped nodes
 * 
 * @author Bishesh
 *
 */
public class LoopedLinkedList {
	LoopedLinkedListNode head;
	boolean hasLoop = true;

	class LoopedLinkedListNode {
		LoopedLinkedListNode next;
		int data;

		LoopedLinkedListNode(int key) {
			data = key;
			next = null;
		}
	}

	/* Inserts a new Node at front of the list. */
	public void push(int new_data) {
		/*
		 * 1 & 2: Allocate the Node & Put in the data
		 */
		LoopedLinkedListNode new_node = new LoopedLinkedListNode(new_data);

		/* 3. Make next of new Node as head */
		new_node.next = head;

		/* 4. Move the head to point to new Node */
		head = new_node;
	}

	/**
	 * Method to validate if linked list has a loop
	 */
	public void isLooped() {
		LoopedLinkedListNode fast = head;
		LoopedLinkedListNode slow = head;

		while (slow != null && fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				hasLoop = true;
				break;
			}
		}
	}

	public void removeLoop() {
		LoopedLinkedListNode fast = head;
		LoopedLinkedListNode slow = head;

		slow = slow.next;
		fast = fast.next.next;

		while (fast != null && fast.next != null) {
			if (slow == fast)
				break;

			slow = slow.next;
			fast = fast.next.next;
		}

		if (slow == fast) {
			slow = head;
			while (slow.next != fast.next) {
				slow = slow.next;
				fast = fast.next;
			}
			fast.next = null;
			hasLoop = false;
		}
	}

	/**
	 * method to print the values of linked list nodes
	 */
	public void printList() {
		LoopedLinkedListNode current = head;
		while (current != null) {
			System.out.print(current.data + " ");
			current = current.next;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		LoopedLinkedList llist = new LoopedLinkedList();
		llist.push(20);
		llist.push(4);
		llist.push(15);
		llist.push(10);

		/* Create loop for testing */
		llist.head.next.next.next.next = llist.head;
		// llist.printList();

		// llist.isLooped();
		// System.out.println("Has Loop: " + llist.hasLoop);
		llist.removeLoop();
		// llist.isLooped();
		System.out.println("Has Loop: " + llist.hasLoop);

		llist.printList();

	}
}
