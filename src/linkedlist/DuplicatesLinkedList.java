package linkedlist;

import java.util.ArrayList;

public class DuplicatesLinkedList {

	DuplicatesLinkedListNode head;

	class DuplicatesLinkedListNode {
		DuplicatesLinkedListNode next;
		int data;

		public DuplicatesLinkedListNode(int key) {
			data = key;
			next = null;
		}
	}

	/**
	 * Method to insert nodes into linkedlist
	 * 
	 * @param key
	 */
	public void push(int key) {
		if (head == null) {
			head = new DuplicatesLinkedListNode(key);
		} else {
			DuplicatesLinkedListNode newNode = new DuplicatesLinkedListNode(key);
			newNode.next = head;
			head = newNode;
		}
	}

	/**
	 * method to print the values of linked list nodes
	 */
	public void printList() {
		DuplicatesLinkedListNode current = head;
		while (current != null) {
			System.out.print(current.data + " ");
			current = current.next;
		}
		System.out.println();
	}

	/**
	 * method to detect duplicates
	 * 
	 */
	public void getDuplicates() {
		ArrayList<Integer> al = new ArrayList<>();
		DuplicatesLinkedListNode current = head;
		while (current != null) {
			if (!al.contains(current.data))
				al.add(current.data);
			else
				System.out.print(current.data + " ");

			current = current.next;
		}

	}

	/**
	 * method to detect duplicates
	 * 
	 */
	public void removeDuplicates() {
		ArrayList<Integer> al = new ArrayList<>();
		DuplicatesLinkedListNode current = head;
		DuplicatesLinkedListNode prev = null;

		while (current != null) {
			if (!al.contains(current.data)) {
				al.add(current.data);
				prev = current;
				current = current.next;
			} else {
				prev.next = current.next;
				current = current.next;
			}
		}

	}

	public static void main(String[] args) {
		DuplicatesLinkedList llist = new DuplicatesLinkedList();
		llist.push(60);
		llist.push(50);
		llist.push(50);
		llist.push(40);
		llist.push(30);
		llist.push(20);
		llist.push(20);
		llist.push(10);
		llist.push(2);

		llist.printList();

		llist.getDuplicates();
		llist.removeDuplicates();
		System.out.println();
		llist.printList();
	}
}
