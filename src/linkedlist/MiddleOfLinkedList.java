package linkedlist;

public class MiddleOfLinkedList {
	MiddleOfLinkedListNode head;

	class MiddleOfLinkedListNode {
		int data;
		MiddleOfLinkedListNode next;

		public MiddleOfLinkedListNode(int key) {
			data = key;
			next = null;
		}
	}

	/**
	 * Method to insert values to linked list
	 * 
	 * @param key
	 */
	public void push(int key) {
		if (head == null) {
			head = new MiddleOfLinkedListNode(key);
		} else {
			MiddleOfLinkedListNode newNode = new MiddleOfLinkedListNode(key);
			newNode.next = head;
			head = newNode;
		}
	}

	/**
	 * method to print the values of linked list nodes
	 */
	public void printList() {
		MiddleOfLinkedListNode current = head;
		while (current != null) {
			System.out.print(current.data + " ");
			current = current.next;
		}
		System.out.println();
	}

	/**
	 * method to print middle node value of the linked list
	 */
	public void middleNode() {
		MiddleOfLinkedListNode fast = head;
		MiddleOfLinkedListNode slow = head;

		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		System.out.println("Middle: " + slow.data);
	}

	/**
	 * method to delete the middle node value of the linked list
	 */
	public void deleteMiddleNode() {
		MiddleOfLinkedListNode fast = head;
		MiddleOfLinkedListNode slow = head;
		MiddleOfLinkedListNode prev = null;

		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			prev = slow;
			slow = slow.next;
		}
		System.out.println("Previous of the middle node: " + prev.data);
		System.out.println("To be deleted middle node: " + slow.data);
		System.out.println("Next of the middle node: " + slow.next.data);
		prev.next = slow.next;
	}

	public static void main(String[] args) {
		MiddleOfLinkedList llist = new MiddleOfLinkedList();
		llist.push(20);
		llist.push(4);
		llist.push(15);
		llist.push(10);
		llist.push(1);

		llist.printList();
		llist.middleNode();
		System.out.println();
		llist.deleteMiddleNode();

		System.out.println();
		llist.printList();
	}
}
