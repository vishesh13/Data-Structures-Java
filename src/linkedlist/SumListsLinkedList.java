package linkedlist;

public class SumListsLinkedList {
	SumListsLinkedListNode head;

	class SumListsLinkedListNode {
		int data;
		SumListsLinkedListNode next;

		SumListsLinkedListNode(int key) {
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
			head = new SumListsLinkedListNode(key);
		else {
			SumListsLinkedListNode newNode = new SumListsLinkedListNode(key);
			newNode.next = head;
			head = newNode;
		}
	}

	/**
	 * Method to insert node at the end of list
	 * 
	 * @param key
	 */
	public void insertLast(int key) {
		SumListsLinkedListNode newNode = new SumListsLinkedListNode(key);

		if (head == null)
			head = newNode;
		else {
			SumListsLinkedListNode current = head;
			while (current.next != null) {
				current = current.next;
			}
			newNode.next = current.next;
			current.next = newNode;
		}
	}

	/**
	 * Method to display the value of elements in the list
	 */
	public void printList() {
		SumListsLinkedListNode current = head;

		while (current != null) {
			System.out.print(current.data + " ");
			current = current.next;
		}
		System.out.println();
	}

	/**
	 * Method get integer values from list
	 * 
	 * @param list
	 * @return
	 */
	public static int getInetegerValue(SumListsLinkedList list) {
		SumListsLinkedListNode current = list.head;
		int i = 0;
		int value = 0;
		while (current != null) {
			value += current.data * Math.pow(10, i);
			current = current.next;
			i++;
		}
		return value;
	}

	/**
	 * Method to get result linked list
	 * 
	 * @param value
	 * @return
	 */
	public static SumListsLinkedList getResultList(int value) {
		SumListsLinkedList llist = new SumListsLinkedList();
		while (value > 0) {
			llist.insertLast(value % 10);
			value = value / 10;
		}
		return llist;
	}

	public static void main(String[] args) {
		SumListsLinkedList llist1 = new SumListsLinkedList();
		llist1.insertFirst(6);
		llist1.insertFirst(1);
		llist1.insertFirst(7);

		SumListsLinkedList llist2 = new SumListsLinkedList();
		llist2.insertFirst(2);
		llist2.insertFirst(9);
		llist2.insertFirst(5);

		int resultSum = getInetegerValue(llist1) + getInetegerValue(llist2);

		SumListsLinkedList llist3 = getResultList(resultSum);
		System.out.print(resultSum + " List: ");
		llist3.printList();

	}
}
