package chapter3;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * How would you design a stack which, in addition to push and pop,
 *  also has a function min which returns the minimum element? 
 *  Push, pop and min should all operate in O(1) time. 
 * 
 * Possible improvements after seeing the solution:
 * - Should've used an arraylist, so it wouldn't be necessary to keep the index.
 */


public class Question3 {
	public static void main(String[] args) {
		SetOfStacks stacks = new SetOfStacks(3);
		
		stacks.push(3);
		stacks.push(4);
		stacks.push(5);
		
		System.out.println(stacks);
		
		stacks.push(1);
		stacks.push(2);
		stacks.push(3);
		
		System.out.println(stacks);
		
		stacks.push(1);
		stacks.push(2);
		stacks.push(3);
		
		System.out.println(stacks);
		stacks.push(1);
		stacks.push(2);
		stacks.push(3);
		
		System.out.println(stacks);
		stacks.pop();
		
		System.out.println(stacks);
		
		stacks.pop();
		stacks.pop();
		stacks.pop();
		stacks.pop();
		System.out.println(stacks);
		
		stacks.popAt(1);
		stacks.popAt(1);
		stacks.popAt(1);
		
		stacks.popAt(0);
		stacks.popAt(0);
		stacks.popAt(0);
		
		stacks.pop();
		
		stacks.push(3);
		System.out.println(stacks);
		
	}
}

class SetOfStacks {
	
	private Integer stackCapacity;
	private Integer currentStackIndex;
	private Map<Integer,Stack<Integer>> stacks;
		
	public SetOfStacks(Integer capacity) {
		this.stackCapacity = capacity;
		currentStackIndex = 0;
		stacks = new HashMap<Integer,Stack<Integer>>();
	}
	
	public void push(Integer value){
		
		if (stacks.get(currentStackIndex) == null) {
			Stack<Integer> newStack = new Stack<Integer>();
			newStack.push(value);
			stacks.put(currentStackIndex, newStack);
			
		} else if (stacks.get(currentStackIndex).size() == stackCapacity) {
			currentStackIndex++;
			
			Stack<Integer> newStack = new Stack<Integer>();
			newStack.push(value);
			stacks.put(currentStackIndex, newStack);
		} else {
			Stack<Integer> currentStack = stacks.get(currentStackIndex);
			currentStack.push(value);
		}
	}
	
	public Integer pop(){
		
		if (stacks.get(currentStackIndex) == null) {
			return null;
			
		} else if (stacks.get(currentStackIndex).size() == 1) {
		
			Integer value = stacks.get(currentStackIndex).pop();
			stacks.remove(currentStackIndex);
			
			if (currentStackIndex > 0) {
				currentStackIndex--;
			}
			
			return value;
			
		} else {
			Stack<Integer> currentStack = stacks.get(currentStackIndex);
			return currentStack.pop();
		}
	}
	
	public String toString() {
		return stacks.toString();
	}
	
	public Integer popAt(Integer index) {
		
		if (stacks.get(index) == null) { return null; }
		
		Stack<Integer> currentStack = stacks.get(index);
		
		if (currentStack.size() == 1) {
			Integer value = currentStack.pop();
			
			stacks.remove(index);
			
			if (currentStackIndex > 0) {
				currentStackIndex--;
			}
			
			for (Integer key : stacks.keySet()) {
				if (key > index){
					Stack<Integer> copy = stacks.get(key);
					stacks.put(key-1, copy);
					stacks.remove(key);
				}
			}
			return value;
			
		} else {
			return currentStack.pop();
		}
	}
}

