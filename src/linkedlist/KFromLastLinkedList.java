package linkedlist;

public class KFromLastLinkedList {
	KFromLastLinkedListNode head;

	class KFromLastLinkedListNode {
		KFromLastLinkedListNode next;
		KFromLastLinkedListNode prev;
		int key;

		public KFromLastLinkedListNode(int data) {
			key = data;
		}
	}

	/**
	 * Method to insert node at the head of list
	 * 
	 * @param key
	 */
	public void insertFirst(int key) {
		if (head == null) {
			KFromLastLinkedListNode newNode = new KFromLastLinkedListNode(key);
			newNode.prev = head;
			head = newNode;
		} else {
			KFromLastLinkedListNode newNode = new KFromLastLinkedListNode(key);
			head.prev = newNode;
			newNode.next = head;
			head = newNode;
		}
	}

	/**
	 * Method to display the value of elements in the list
	 */
	public void printList() {
		KFromLastLinkedListNode current = head;
		while (current != null) {
			System.out.print(current.key + " ");
			current = current.next;
		}
		System.out.println();
	}

	/**
	 * Method to get Kth element from the last with doubly linkedlist
	 * 
	 * @param k
	 */
	public void getKthElementFromLast(int k) {
		KFromLastLinkedListNode current = head;
		KFromLastLinkedListNode prevCurrent = null;
		int i = 1;

		while (current != null) {
			prevCurrent = current;
			current = current.next;
		}

		while (i < k && prevCurrent != null) {
			prevCurrent = prevCurrent.prev;
			i++;
		}

		System.out.print("Kth Element from last: " + prevCurrent.key);
	}

	/**
	 * Method to get Kth element from the last with linkedlist length
	 * 
	 * @param k
	 */
	public void getKthWithLength(int k) {
		KFromLastLinkedListNode current = head;
		int nodeCount = 0;
		while (current != null) {
			nodeCount++;
			current = current.next;
		}

		current = head;
		k = nodeCount - k + 1;
		nodeCount = 1;

		while (nodeCount != k) {
			nodeCount++;
			current = current.next;
		}

		System.out.println("KthWithLength: " + current.key);
	}

	public static void main(String[] args) {
		KFromLastLinkedList llist = new KFromLastLinkedList();
		llist.insertFirst(7);
		llist.insertFirst(6);
		llist.insertFirst(5);
		llist.insertFirst(4);
		llist.insertFirst(3);
		llist.insertFirst(2);
		llist.insertFirst(1);

		llist.printList();
		llist.getKthElementFromLast(3);
		System.out.println();
		llist.getKthWithLength(3);
	}

}
