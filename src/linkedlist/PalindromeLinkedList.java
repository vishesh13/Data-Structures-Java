package linkedlist;

import java.util.Stack;

public class PalindromeLinkedList {
	PalindromeLinkedListNode head;
	boolean isPalindrome = true;

	/**
	 * Linked List Node
	 * 
	 * @author bishesh
	 *
	 */
	class PalindromeLinkedListNode {
		PalindromeLinkedListNode next;
		int data;

		public PalindromeLinkedListNode(int key) {
			data = key;
		}
	}

	public void insertFirst(int key) {
		if (head == null)
			head = new PalindromeLinkedListNode(key);
		else {
			PalindromeLinkedListNode newNode = new PalindromeLinkedListNode(key);
			newNode.next = head;
			head = newNode;
		}
	}

	public void printList() {
		PalindromeLinkedListNode current = head;

		while (current != null) {
			System.out.print(current.data + " ");
			current = current.next;
		}
		System.out.println();
	}

	public boolean isListPalindrome() {
		Stack<PalindromeLinkedListNode> stack = new Stack<>();

		PalindromeLinkedListNode current = head;
		PalindromeLinkedListNode stackNode;

		while (current != null) {
			stack.push(current);
			current = current.next;
		}

		current = head;

		while (current != null) {
			stackNode = stack.pop();
			if (stackNode.data != current.data) {
				isPalindrome = false;
				break;
			}

			current = current.next;
		}

		return isPalindrome;
	}

	public static void main(String[] args) {
		PalindromeLinkedList llist = new PalindromeLinkedList();
		llist.insertFirst(1);
		llist.insertFirst(3);
		llist.insertFirst(2);
		llist.insertFirst(3);
		llist.insertFirst(1);

		llist.printList();

		System.out.println("IsPalindrome: " + llist.isListPalindrome());
	}

}
