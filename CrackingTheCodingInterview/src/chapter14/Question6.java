package chapter14;

import java.util.Arrays;
import java.util.Iterator;

/***
 * Implement a CircularArray class that supports an array-like data structure which can be efficiently rotated. The class should use a generic type, 
 * and should support iterationviathestandardfor (Objo : circuLarArray) notation.

 * @author Marcel
 *
 */

class CircularArray<T> implements Iterable<T>{
	
	private T[] array;
	
	public CircularArray(T[] data) {
		this.array = data;
	}

	@SuppressWarnings("unchecked")
	public CircularArray(int size) {
		this.array = (T[]) new Object[size];
	}
	
	public void setAtIndex(int index, T value) {
		if (index >= 0 && index < array.length) {
			array[index] = value;
		}
	}
	
	public T getAtIndex(int index) {
		if (index >= 0 && index < array.length) {
			return array[index];
		}
		return null;
	}
	
	public T[] getArray() {
		return this.array;
	}
	
	public void rotateArray(int positions) {
		
		
		int realPositions = 0;
		
		if (positions > 0) {
			realPositions = positions % array.length;
		} else {
			realPositions = (positions % array.length) + array.length;
		}
		
		T[] firstPart = Arrays.copyOfRange(array, 0, array.length - realPositions);
		T[] lastPart = Arrays.copyOfRange(array, array.length - realPositions, array.length);
		
		 System.arraycopy(lastPart, 0, this.array, 0, lastPart.length);
		 System.arraycopy(firstPart, 0, this.array, lastPart.length, firstPart.length);
	}

	@Override
	public Iterator<T> iterator() {
		return Arrays.asList(this.array).iterator();
	}
	
}


public class Question6 {
	
	public static void main(String[] args) {
		Integer[] array = new Integer[]{1,2,3,4};
		CircularArray<Integer> circular = new CircularArray<Integer>(array);
		
		circular.rotateArray(1);
		
		System.out.println(Arrays.toString(circular.getArray()));
		
		for (Object o : circular) {
			System.out.println((Integer) o);
		}
	}
	
	

}
