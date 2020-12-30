package linkedListDemo;

import java.util.*;

public class linkedListDemo1 {
	public static void main(String[] args) {
		Demo l = new Demo();
		l.head = null;
		Scanner in = new Scanner(System.in);
		do {
			System.out.println("\n********* MENU *********");
			System.out.println("\n1.Insert In End");
			System.out.println("\n2.Insert In Beg");
			System.out.println("\n3.Insert At A  Particular Pos");
			System.out.println("\n4.Delete At a Pos");
			System.out.println("\n5.Length");
			System.out.println("\n6.Reverse");
			System.out.println("\n7.Display Nodes");
			System.out.println("\n8.EXIT");
			System.out.println("\nEnter ur choice: ");
			int n = in.nextInt();
			switch (n) {
			case 1:
				System.out.println("\nEnter the value ");
				l.head = l.insertInEnd(in.nextInt(), l.head);
				break;
			case 2:
				System.out.println("\nEnter the value");
				l.head = l.insertInBeg(in.nextInt(), l.head);
				break;
			case 3:
				System.out.println("\nEnter the value and pos");
				l.head = l.insertAtPos(in.nextInt(), in.nextInt(), l.head);
				break;
			case 4:
				l.head = l.delete(in.nextInt(), l.head);
				break;
			case 5:
				System.out.println(l.length(l.head));
				break;
			case 6:
				l.head = l.reverse(l.head);
				break;
			case 7:
				l.display(l.head);
				break;
			case 8:
				System.exit(0);
				break;
			default:
				System.out.println("\n Wrong Choice!");
				break;
			}
			System.out.println("\n do u want to cont... ");
		} while (in.nextInt() == 1);

	}
}

class Node {

	int data;
	Node next;

	Node(int data) {
		this.data = data;
		this.next = null;

	}
}

class Demo {

	Node head;

	Node insertInBeg(int data, Node head) {
		Node temp = new Node(data);

		if (head == null)
			head = temp;

		else {
			temp.next = head;
			head = temp;
		}
		return head;
	}

	Node insertInEnd(int data, Node head) {
		Node temp = new Node(data);
		Node temp1 = head;

		if (temp1 == null)
			head = temp;
		else {
			while (temp1.next != null)
				temp1 = temp1.next;
			temp1.next = temp;

		}

		return head;

	}

	Node insertAtPos(int data, int pos, Node head) {
		Node temp = new Node(data);

		if (pos == 1) {
			temp.next = head;
			head = temp;
		} else {
			Node temp1 = head;
			for (int i = 1; temp1 != null && i < pos; i++)
				temp1 = temp1.next;
			temp.next = temp1.next;
			temp1.next = temp;
		}

		return head;
	}

	Node delete(int pos, Node head) {
		Node temp = head;
		if (pos == 1)
			head = temp.next;
		else {
			for (int i = 1; temp != null && i < pos - 1; i++)
				temp = temp.next;
			temp.next = temp.next.next;
		}
		return head;
	}

	int length(Node head) {
		Node temp = head;
		int count = 0;
		if (temp == null)
			return 0;
		else {
			while (temp != null) {
				temp = temp.next;
				count++;
			}
		}
		return count;
	}

	Node reverse(Node head) {
		Node prevNode = null, curNode = head, nextNode = null;
		while (curNode != null) {
			nextNode = curNode.next;
			curNode.next = prevNode;

			prevNode = curNode;
			curNode = nextNode;
		}

		head = prevNode;
		return head;
	}

	void display(Node head) {
		Node temp = head;
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
	}
}
