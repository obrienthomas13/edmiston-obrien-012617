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
		int pivotIndex = startIndex + (int)((endIndex-startIndex) * Math.random());

		int leftPointer = startIndex;
		int rightPointer = endIndex;
		if (startIndex < 0 || endIndex > numbers.size()) {
			throw new UnsupportedOperationException("Start or end index invalid");
		}
		boolean useLeftPointer = true;

		boolean pivotEqualsLeft = false;
		boolean pivotEqualsRight = false;

		int temp;

		// while((leftPointer != rightPointer) && (!pivotEqualsRight || !pivotEqualsLeft)){
		// while(!(leftPointer > rightPointer) && leftPointer != rightPointer){
		while (leftPointer != rightPointer) {
			//Right pointer
			if(useLeftPointer){
				// System.out.println("\n USE LEFT POINTER TRUE\n");
				// System.out.println("left pointer " + (leftPointer));
				// System.out.println("right pointer " + (rightPointer));
				// System.out.println("pivot index " + (pivotIndex));
				// System.out.println(toString(numbers));
				if(numbers.get(leftPointer) > numbers.get(pivotIndex)){
					temp = numbers.get(pivotIndex);
					numbers.set(pivotIndex, numbers.get(leftPointer));
					numbers.set(leftPointer, temp);
					// System.out.println("Moving pivot from: " + pivotIndex + " to " + leftPointer);
					pivotIndex = leftPointer;
					// System.out.println("Moved pivot from: " + pivotIndex + " to " + leftPointer);
					useLeftPointer = !useLeftPointer;
				} else {
					if(leftPointer < pivotIndex){
						// System.out.println("here1");
						leftPointer++;
					} else {
						// System.out.println("there1");
						useLeftPointer = !useLeftPointer;
					}

				}


			} else {
				// System.out.println("\n USE LEFT POINTER FALSE \n");
				// System.out.println("left pointer " + (leftPointer));
				// System.out.println("right pointer " + (rightPointer));
				// System.out.println("pivot index " + (pivotIndex));
				// System.out.println(toString(numbers));
				if (numbers.get(rightPointer) <= numbers.get(pivotIndex)) {
					temp = numbers.get(pivotIndex);
					numbers.set(pivotIndex, numbers.get(rightPointer));
					numbers.set(rightPointer, temp);
					// System.out.println("Moving pivot from: " + pivotIndex + " to " + rightPointer);
					pivotIndex = rightPointer;
					// System.out.println("Moved pivot from: " + pivotIndex + " to " + rightPointer);
					useLeftPointer = !useLeftPointer;
				} else {
					if (rightPointer > pivotIndex) {
						// System.out.println("here2");
						rightPointer--;
					} else {
						// System.out.println("there2");
						useLeftPointer = !useLeftPointer;
					}
				}
			}

			// System.out.println("\n Left Pointer: " + leftPointer + "  Right Pointer: " + rightPointer + "\n");
		}
		
		// Some code to run on the left of the pivot for repitition
		
		int pivotTemp = checkPivot(numbers, pivotIndex, pivotIndex);
		
		// fix this
		// System.out.println("startIndex: " + startIndex);
		// System.out.println("pivotIndex: " + pivotIndex);
		// System.out.println("endIndex: " + endIndex);
		if (pivotTemp == -1) {
			//numbers = new ArrayList<Integer>(numbers.subList(0, pivotIndex));
			return partition(numbers, startIndex, pivotIndex - 1);
		} else if (pivotTemp == 1) {
			//numbers = new ArrayList<Integer>(numbers.subList(pivotIndex, numbers.size() - 1));
			// getNumber -= pivotIndex + 1;
			return partition(numbers, pivotIndex + 1, endIndex);

		}
		// System.out.println("\n\n\nEnd of Partition\n\n\n");
		System.out.println(toString(numbers));
		return numbers.get(pivotIndex);
	}

	public static int checkPivot(ArrayList<Integer> numbers, int smallPivotIndex, int largePivotIndex) {
		if (smallPivotIndex + 1 > getNumber) {
			return -1;
		} else if (smallPivotIndex + 1 <= getNumber && getNumber <= largePivotIndex + 1) {
			return 0;
		} else if (largePivotIndex + 1 < getNumber) {
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
