/* This program implements the Stack operations using array and iterates the contents of stack
using a inner class. The push operation places the integer in the first available free location
of array and the pop operation removes the last element */

class StackOfInts {
	private int[] stack;
	public int next = 0;
	public StackOfInts(int[] values){
		stack = new int[values.length];
		stack = values;
	}
	public StackOfInts(int length){
		stack = new int[length];
	}
	public StackOfInts() {
		stack = new int[1];
	}
	public void push(int var){
		if(next < stack.length){
			stack[next++] = var;
		}
	}
	public int pop() {
		if(!isEmpty()){
			return stack[--next];
		}
		return 0;
	}
	private boolean isEmpty(){
		if (next == 0) {
			return true;
		}
		return false;
	}
	private int getStackSize(){
		return next;
	}
	public StepThrough getStepThroughObject(){
		return new StepThrough();
	}
	public class StackIterator {
		public boolean isLast(){
			return (getStackSize() == 0 );
		}
	}

	public class StepThrough {
		private int i = 0;
		public void increment() {
			if ( i < stack.length) {
				i++;
			}
		}
		public int current(){
			return stack[i];
		}
		public boolean isLast() {
			if ( i == getStackSize() ){
				return true;
			} else {
				return false;
			}
		}
	}

	public static void main(String[] args) {
		int length = 6;
		StackOfInts stackIntObject = new StackOfInts(length);
		for(int i=0;i<length;i++) {
			stackIntObject.push(i*2);
		}

		StackOfInts.StackIterator stackIteratorObject  = stackIntObject.new StackIterator();
		while (!stackIteratorObject.isLast()) {
			System.out.print(stackIntObject.pop()+" ");
		}
		for(int i=0;i<length;i++) {
			stackIntObject.push(i*i);
		}
		System.out.println();
		StepThrough stepThroughObject = stackIntObject.getStepThroughObject();
		while(!stepThroughObject.isLast()) {
			System.out.print(" "+stepThroughObject.current());
			stepThroughObject.increment();
		}
	}
}