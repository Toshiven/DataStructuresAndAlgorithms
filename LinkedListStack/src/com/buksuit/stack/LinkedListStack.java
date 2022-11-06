package com.buksuit.stack;

class Node {
		String data; //Integer data
		Node next; //Pointer to next node
	}

	class Stack {
		private Node top;
		private  int NodesCount;
		
		public Stack() {
			this.top = null;
			this.NodesCount = 0;
		}
		
		//Utility function to add the element an 'string' to stack
		public void push(String string) { //Insert at beginning
			
			//Allocate a new node in a heap
			Node node = new Node();
			
			//Check if stack (heap) is full. Then inserting an element would
			//lead to stack overflow
			if(node == null) {
				System.out.println("Heap Overflow");
				return;
			}
			
			//Set data in the allocated node
			node.data = string;
			
			//Set the .next pointer of the new node to point to the current
			//top node of the list.
			node.next = top;
			
			//Update top pointer
			top = node;
			
			//Increase stacks size by 1
			this.NodesCount += 1;
		}
		
		//Utility function to check if the stack is empty or not
		public boolean isEmpty() {
			return top == null;
		}
		
		//Utility function to return the top element of the stack
		public String peek() {
			if(isEmpty()) {
				System.out.println("The stack is empty.");
				System.exit(-1);
			}
			return top.data;
		}
		
		//Utility function to pop a top element from the stack
		public String pop() { //remove at the beginning
			
			//Check for stack underflow
			if(isEmpty()) {
				System.out.println("Stack Underflow.");
				System.exit(-1);
			}
			
			//Take not of the top node's data
			String top = peek();
			
			//Decrease stack size by 1
			this.NodesCount -= 1;
			
			//Update the top pointer to point to the next node
			this.top = (this.top).next;
			
			return top;
		}
		
		//Utility function to return size of the stack
		public int size() {
			return this.NodesCount;
		}
		
		//Utility function to display the elements of the stack
		public void display() {
			
			//Check for stack underflow
			if (top == null) {
	            System.out.printf("\nStack Underflow");
	            System.exit(-1);
	        }
	        else {
	            Node node = top;
	            while (node != null) {
	 
	                // print node data
	                System.out.print(node.data);
	 
	                // assign temp link to temp
	                
	                node = node.next;
	                if(node != null)
	                    System.out.print(" ");
	            }
			
		}
		
	}
	}
	
	
public class LinkedListStack {
	
	public static void main(String[] args) {
		
		Stack stack =  new Stack();
		
		stack.push("Code");
		stack.push("Stack");
		stack.push("First");
		stack.push("My");
		
		System.out.println();
		
		stack.display();
		System.out.println();
		
		stack.pop();
		stack.pop();
		
		stack.push("My");
		
		stack.display();
		
		System.out.println();
		
		stack.push("Java");
		stack.push("Is");
		stack.push("Name");
		stack.push("My");
		stack.display();
		
		System.out.printf("\n\n");
		
		if(stack.isEmpty()) {
			System.out.println("Stack is empty.");
		}else {
			System.out.println("Stack is not empty.");
		}
	}

}
