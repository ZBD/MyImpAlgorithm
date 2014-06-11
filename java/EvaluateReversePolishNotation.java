import java.util.ArrayList;


public class EvaluateReversePolishNotation {
	private MyStack stack;

	public int evalRPN(String[] tokens) {
		stack = new MyStack();
		int size = tokens.length;
		for (int i = 0; i < size; i++) {
			if (tokens[i].equals("+")) { 
				if (stack.getSize() < 2) {
					System.out.println("The Reverse Polish Notation is wrong!");
					return -1;
				}
				int op2 = stack.pop();
				int op1 = stack.pop();
				stack.push(op1 + op2);
			}
			else if (tokens[i].equals("-")) { 
				if (stack.getSize() < 2) {
					System.out.println("The Reverse Polish Notation is wrong!");
					return -1;
				}
				int op2 = stack.pop();
				int op1 = stack.pop();
				stack.push(op1 - op2);
			}
			else if (tokens[i].equals("*")) { 
				if (stack.getSize() < 2) {
					System.out.println("The Reverse Polish Notation is wrong!");
					return -1;
				}
				int op2 = stack.pop();
				int op1 = stack.pop();
				stack.push(op1 * op2);
			}
			else if (tokens[i].equals("/")) { 
				if (stack.getSize() < 2) {
					System.out.println("The Reverse Polish Notation is wrong!");
					return -1;
				}
				int op2 = stack.pop();
				int op1 = stack.pop();
				stack.push(op1 / op2);
			}
			else {
				int value = Integer.parseInt(tokens[i]);
				stack.push(value);
			}
		}
		if (stack.getSize() != 1 ) {
			System.out.println("The Reverse Polish Notation is wrong!");
			return -1;
		}
		return stack.pop();

	}


	class MyStack {
		int size;
		ArrayList<Integer> stack;

		public MyStack() {
			size = 0;
			stack = new ArrayList<Integer>();
		}

		public int getSize() {
			return size;
		}

		public int pop() {
			if (size == 0) {
				System.out.println("The Stack is empty");
				return 0;
			}
			size--;
			return stack.get(size).intValue();
		}

		public void push(int value) {
			stack.add(size, new Integer(value));
			size++;
		} 
	}
}