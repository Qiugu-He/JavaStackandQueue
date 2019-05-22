import java.util.Scanner;
public class StackAndQueue {

	public static void main(String [] args)
	{
		Queue q = new Queue();
		Stack s = new Stack();
		
		System.out.println("Please enter an string: (q for quite)");
		Scanner scan = new Scanner(System.in);
		while(scan.hasNextLine()) {
			String input = scan.nextLine();
			if(input.equals("q")) {
				break;
			}
			char []charArray = input.toCharArray();
			for(int i = 0; i < charArray.length; i++)
			{
				s.push(charArray[i]);
				q.enqueue(charArray[i]);
			}
			
		/*	System.out.println(s.toString());
			System.out.println(q.toString());*/
			
			Boolean check = false;
			while(!s.isEmpty())
			{	
				if(s.pop() != q.dequeue())
				{	
					check = true;
					break;
				}
			}
			if(check) {
				System.out.println("The String is not palindrome.");
			}else {
				System.out.println("The String is palindrome.");
			}
			System.out.println("\nPlease enter an string: (q for quite)");
			scan = new Scanner(System.in);
			
	  }//input
		scan.close();
		System.out.println("Program end normaly.");
	}//main
}

class Node{
	char data;
	Node next;
	public Node(char data, Node next) {
		this.data= data;
		this.next = next;
	}
}

class Queue{
	Node front, tail;
	public Queue() {
		this.front = this.tail = null;
	}
	public void enqueue(char x)
	{
		Node newNode = new Node(x, null);
		if(this.tail == null) {
			this.front = this.tail = newNode;
			return;
		}
		this.tail.next = newNode;
		this.tail = newNode;
	}
	public char dequeue() {
		if(this.front == null) {
			return 0;
		}
		Node temp = this.front;
		this.front = this.front.next;
		if(this.front == null)
		{
			this.tail = null;
		}
		return temp.data;
	}
	
	public String toString()
	{
		String toReturn = "";
		Node temp = front;
		while(temp != null)
		{
			toReturn  += temp.data; 
			temp = temp.next;
		}
		return toReturn;
	}
	
}

class Stack{
	Node top;
	public Stack() {
		this.top = null;
	}
	public void push(char x)
	{
		Node newNode = new Node(x, null);
		newNode.next = top;
		top = newNode;
	}
	public boolean isEmpty()
	{
		return top == null;
	}
	public char pop()
	{
		if(!isEmpty())
		{
			Node temp = top;
			top = top.next;
			return temp.data;
		}
		else
		{
			System.out.println("Stack is empty");
			return 0;
		}
	}
	public void peek() {
		if (top == null)
		{
			System.out.println("Stack is empty");
			return;
		}
		top = top.next;
	}
	public String toString()
	{
		String toReturn = "";
		Node temp = top;
		while(temp != null)
		{
			toReturn  += temp.data; 
			temp = temp.next;
		}
		return toReturn;
	}
}
