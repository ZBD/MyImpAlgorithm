package MyDataStructure;


public class MyStack {
	private MyNode top;
	
	public MyStack() {
		top = null;
	}

	//pop the top of the stack
	public int pop() throws Exception{
		if (top == null) {
			throw new Exception("Stack is empty!");
		}
		int res = top.val;
		top = top.next;
		return res;
	}
	
	//return the top of the stack
	public int top() throws Exception{
		if (top == null) {
			throw new Exception("Stack is empty!");
		}

		return top.val;
	}
	
	//push the new val into stack
	public void push(int val) {
		top = new MyNode(val, top);
	}

	//return the minimal value in the stack
	public int min() {
		return top.min;
	}

	//internal structure of stack node, each node keep a min field which records the minimal value beneath it on the stack
	class MyNode {
		int val;
		int min;
		MyNode next;
		
		public MyNode(int val, MyNode next) {
			this.val = val;
			this.next = next;
			this.min = next == null ? val : Math.min(val, next.min);
		}
	}
}