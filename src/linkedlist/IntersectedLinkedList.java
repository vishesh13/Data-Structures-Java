package linkedlist;

import java.util.HashSet;

/**
 * Linked Lists class with intersected node
 * 
 * @author Bishesh
 *
 */
public class IntersectedLinkedList {
	IntersectedLinkedListNode head;

	class IntersectedLinkedListNode {
		int data;
		IntersectedLinkedListNode next;

		public IntersectedLinkedListNode(int key) {
			data = key;
		}
	}

	/**
	 * Method to insert node at the head of list
	 * 
	 * @param key
	 */
	public void insertFirst(int key) {
		if (head == null)
			head = new IntersectedLinkedListNode(key);
		else {
			IntersectedLinkedListNode newNode = new IntersectedLinkedListNode(key);
			newNode.next = head;
			head = newNode;
		}
	}

	/**
	 * Method to display the value of elements in the list
	 */
	public void printList() {
		IntersectedLinkedListNode current = head;

		while (current != null) {
			System.out.print(current.data + " ");
			current = current.next;
		}
		System.out.println();
	}

	/**
	 * Method to retrieve intersected node
	 * 
	 * @param one
	 * @param two
	 */
	public static void getIntersectionNode(IntersectedLinkedList one, IntersectedLinkedList two) {
		HashSet<IntersectedLinkedListNode> set = new HashSet<>();
		IntersectedLinkedListNode current = one.head;

		while (current != null) {
			set.add(current);
			current = current.next;
		}

		current = two.head;

		while (current != null) {
			if (set.contains(current)) {
				System.out.println(current.data);
				break;
			} else {
				current = current.next;
			}
		}

	}

	public static void main(String[] args) {
		IntersectedLinkedList llist1 = new IntersectedLinkedList();
		llist1.insertFirst(7);
		llist1.insertFirst(6);
		llist1.insertFirst(5);
		llist1.insertFirst(4);
		llist1.insertFirst(3);
		llist1.insertFirst(2);
		llist1.insertFirst(1);

		IntersectedLinkedList llist2 = new IntersectedLinkedList();
		llist2.insertFirst(10);
		llist2.insertFirst(9);
		llist2.insertFirst(8);
		llist2.head.next.next.next = llist1.head.next.next.next;

		llist1.printList();
		llist2.printList();

		IntersectedLinkedList.getIntersectionNode(llist1, llist2);
	}

}
