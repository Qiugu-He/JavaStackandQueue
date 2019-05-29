import java.util.Scanner;
public class StackAndQueue {

	public static void main(String [] args)
	{
		while(true) {
			// get user input
			System.out.println("Please enter a string: ");
			Scanner scan = new Scanner(System.in);
			String input = scan.nextLine().replace("\n","");
			if(input.equals("")) {
				scan.close();
				break;
			}
			//remove all special character
			input = input.replaceAll( "[^a-zA-Z0-9 ]" , "" );
			input = input.replaceAll( "\\s+" , "" );
			
			//initialize stack and queue 
			Queue q = new Queue();
			Stack s = new Stack();
			char []charArray = input.toCharArray();
			//store all chars into stack and queue
			for(int i = 0; i < charArray.length; i++)
			{
				s.push(charArray[i]);
				q.enqueue(charArray[i]);
			}
			
			//for test purpose
			/*System.out.println(s.toString());
			System.out.println(q.toString());*/
			
			Boolean check = false;
			//check if the string is palindrome
			while(!s.isEmpty())
			{	
				if(Character.toLowerCase(s.pop()) != Character.toLowerCase(q.dequeue()))
				{	
					check = true;
					System.out.println("The String is not palindrome.\n");
					break;
				}
			}
			if(!check) {
				System.out.println("The String is palindrome.\n");
			}
	  }//input
		System.out.println("Program end normally.");
	}//main
}// end class

//-----------------
// Node class
//-----------------
class Node{
	char data; // the item to be stored
	Node next; // next link
	
	//constructor
	public Node(char data, Node next) {
		this.data= data;
		this.next = next;
	}
}

//********************
// Queue class
//*******************
class Queue{
	Node front, tail;
	
	//constructor
	public Queue() {
		this.front = this.tail = null;
	}
	
	//enqueue
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
	
	//dequeue
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
	
	//toString
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
}//end Queue

//-----------------
// Stack class
//----------------
class Stack{
	Node top;
	//constructor
	public Stack() {
		this.top = null;
	}
	
	//push
	public void push(char x)
	{
		Node newNode = new Node(x, null);
		newNode.next = top;
		top = newNode;
	}
	
	//isEmpty
	public boolean isEmpty()
	{
		return top == null;
	}
	
	//pop
	public char pop(){
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
	
	//peek
	public void peek() {
		if (top == null)
		{
			System.out.println("Stack is empty");
			return;
		}
		top = top.next;
	}
	
	//toString
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
}//end Stack
