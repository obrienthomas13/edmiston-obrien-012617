import java.util.ArrayList;

public class Select{
	private static int getNumber;
	
	
	public static void main(String[] args) throws Exception{

		getNumber = Integer.parseInt(args[0]);
		ArrayList<Integer> numbers = getInputFromFile();
		if (getNumber > numbers.size()) {
			throw new UnsupportedOperationException("BAD DATA");
		}

		
		int pivotIndex = -1;
		int pivotTemp = -2;

		/*
		while (pivotTemp != 0) {

			pivotIndex = (int)(numbers.size() * Math.random());
			numbers = partition(numbers, pivotIndex);
			
		}*/

		

		System.out.println(partition(numbers, 0, numbers.size()-1));

	}

	public static ArrayList<Integer> getInputFromFile() throws java.io.IOException{

		java.io.BufferedReader stdIn = new java.io.BufferedReader(new java.io.InputStreamReader(System.in));
		String s = stdIn.readLine();
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		while (s != null) {
			numbers.add(Integer.parseInt(s));
			s = stdIn.readLine();
		}
		return numbers;
	}

	// k = numFind
	public static int partition(ArrayList<Integer> numbers, int startIndex, int endIndex) {
		int pivotIndex = (int)(numbers.size() * Math.random());

		int leftPointer = startIndex;
		int rightPointer = endIndex;
		if(startIndex < 0 || endIndex > numbers.size()){
			throw new UnsupportedOperationException("Start or end index invalid");
		}
		boolean useLeftPointer = true;
		
		int temp;
		
		while(leftPointer != rightPointer){
			
			//Right pointer
			if(useLeftPointer){
				System.out.println("\n USE LEFT POINTER TRUE\n");
				System.out.println("left pointer " + (leftPointer));
				System.out.println("right pointer " + (rightPointer));
				System.out.println("pivot index " + (pivotIndex));
				System.out.println(toString(numbers));
				if(numbers.get(leftPointer) > numbers.get(pivotIndex)){
					temp = numbers.get(pivotIndex);
					numbers.set(pivotIndex, numbers.get(leftPointer));
					numbers.set(leftPointer, temp);
					System.out.println("Moving pivot from: " + pivotIndex + " to " + leftPointer);
					pivotIndex = leftPointer;
					System.out.println("Moved pivot from: " + pivotIndex + " to " + leftPointer);
					useLeftPointer = !useLeftPointer;
				} else {
					if(leftPointer < pivotIndex){
						leftPointer++;	
					} else {
						useLeftPointer = !useLeftPointer;
					}
					
				}
				
				
			} else{
				System.out.println("\n USE LEFT POINTER FALSE \n");
				System.out.println("left pointer " + (leftPointer));
				System.out.println("right pointer " + (rightPointer));
				System.out.println("pivot index " + (pivotIndex));
					System.out.println(toString(numbers));					
				if(numbers.get(rightPointer) < numbers.get(pivotIndex)){
					temp = numbers.get(pivotIndex);
					numbers.set(pivotIndex, numbers.get(rightPointer));
					numbers.set(rightPointer, temp);
					System.out.println("Moving pivot from: " + pivotIndex + " to " + rightPointer);
					pivotIndex = rightPointer;
					System.out.println("Moved pivot from: " + pivotIndex + " to " + rightPointer);

					useLeftPointer = !useLeftPointer;
				} else {if(leftPointer < pivotIndex){
						leftPointer++;	
					} else {
						useLeftPointer = !useLeftPointer;
					}
					rightPointer--;
				}
				
				
			}
			
			System.out.println("\n Left Pointer: " + leftPointer + "  Right Pointer: " + rightPointer + "\n");
		}
			int pivotTemp = checkPivot(numbers, pivotIndex);
			// fix this
			if (pivotTemp == -1) {
				//numbers = new ArrayList<Integer>(numbers.subList(0, pivotIndex));
				return partition(numbers, startIndex, pivotIndex);
			} else if (pivotTemp == 1) {
				//numbers = new ArrayList<Integer>(numbers.subList(pivotIndex, numbers.size() - 1));
				getNumber -= pivotIndex;
				return partition(numbers, pivotIndex, endIndex);
				
			}
			System.out.println("\n\n\nEnd of Partition\n\n\n");

		return numbers.get(pivotIndex);
	}

	public static int checkPivot(ArrayList<Integer> numbers, int pivotIndex) {
		if (pivotIndex + 1 > getNumber) {
			return -1;
		} else if (pivotIndex + 1 == getNumber) {
			return 0;
		} else if (pivotIndex + 1 < getNumber) {
			return 1;
		} else {
			throw new UnsupportedOperationException();
		}
	}

	public static String toString(ArrayList<Integer> numbers) {
		String str = "";
		for (int i = 0; i < numbers.size(); i++) {
			str = str + numbers.get(i) + " ";
		}
		return str;
	}

}
