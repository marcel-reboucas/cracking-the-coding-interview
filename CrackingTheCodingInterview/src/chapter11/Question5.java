package chapter11;

public class Question5 {

	public static int findIndex(String[] array, int start, int end,  String wantedValue) {
		
		if (end-start == 0) { return -1;}
		
		int midIndex = (start + end)/2;
		
		String midValue = array[midIndex];
		
		int searchValue = 0;
		while(midValue.equals("")){
			searchValue += 1;
			
			if (midIndex + searchValue > start) {
				if (!array[midIndex + searchValue].equals("")){
					midValue = array[midIndex + searchValue];
					midIndex = midIndex + searchValue;
					break;
				}
			}
			
			
			if (midValue.equals("") && midIndex - searchValue < array.length-1) {
				if (!array[midIndex - searchValue].equals("")){
					midValue = array[midIndex - searchValue];
					midIndex = midIndex - searchValue;
					break;
				}
			} 
		}
		
		
		if (midValue.equals(wantedValue)) { return midIndex; }
		if (end-start == 1) { return -1;}
		
		if (midValue.compareTo(wantedValue) == 1) {
			return findIndex(array, start, midIndex-1, wantedValue);
		} else {
			return findIndex(array, midIndex + 1, end, wantedValue);
		}
	}
	
	public static void main(String[] args) {
		
		String[] array = new String[]{"a","","c","","d","","e","f"};
		
		System.out.println(findIndex(array, 0, array.length-1, "c"));
	}
}
