import java.util.ArrayList;

public class Select{

	private static int getNumber;

	public static void main(String[] args) throws Exception {

		getNumber = Integer.parseInt(args[0]);

		ArrayList<Integer> numbers = getInputFromFile();

		//Used to test the runtime of our partition
		// final long startTime = System.currentTimeMillis();

		if (getNumber > numbers.size()) {
			throw new UnsupportedOperationException("BAD DATA");
		}
		System.out.println(partition(numbers, 0, numbers.size()-1));

		final long endTime = System.currentTimeMillis();

		//Used to test the runtime of our partition
		// System.out.println("Total execution time: " + (endTime - startTime) + "ms" );
	}

	// Returns an ArrayList<Integer> from a file that the user chooses.
	public static ArrayList<Integer> getInputFromFile() throws java.io.IOException{

		java.io.BufferedReader stdIn = new java.io.BufferedReader(new java.io.InputStreamReader(System.in));
		String s = stdIn.readLine();

		ArrayList<Integer> numbers = new ArrayList<Integer>();

		while (s != null) {
			try{
				numbers.add(Integer.parseInt(s));
			}catch (Exception e){
				throw new UnsupportedOperationException("BAD DATA");
			}
			s = stdIn.readLine();
		}

		return numbers;
	}

	// Recusively calls itself until it finds the index the user is looking for
	// and then returns it.
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

		while (leftPointer != rightPointer) {
			if(useLeftPointer){
				if(numbers.get(leftPointer) > numbers.get(pivotIndex)){
					temp = numbers.get(pivotIndex);
					numbers.set(pivotIndex, numbers.get(leftPointer));
					numbers.set(leftPointer, temp);
					pivotIndex = leftPointer;
					useLeftPointer = !useLeftPointer;
				} else {
					if(leftPointer < pivotIndex){
						leftPointer++;
					} else {
						useLeftPointer = !useLeftPointer;
					}
				}
			} else {
				if (numbers.get(rightPointer) <= numbers.get(pivotIndex)) {
					temp = numbers.get(pivotIndex);
					numbers.set(pivotIndex, numbers.get(rightPointer));
					numbers.set(rightPointer, temp);
					pivotIndex = rightPointer;
					useLeftPointer = !useLeftPointer;
				} else {
					if (rightPointer > pivotIndex) {
						rightPointer--;
					} else {
						useLeftPointer = !useLeftPointer;
					}
				}
			}
		}

		int pivotTemp = checkPivot(numbers, pivotIndex, pivotIndex);

		if (pivotTemp == -1) {
			return partition(numbers, startIndex, pivotIndex - 1);
		} else if (pivotTemp == 1) {
			return partition(numbers, pivotIndex + 1, endIndex);
		}

		return numbers.get(pivotIndex);
	}

	// Checks to see if the pivot point is in the correct index.
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

	// Simple toString for creating a visual of an ArrayList<Integer> object.
	public static String toString(ArrayList<Integer> numbers) {
		String str = "";
		for (int i = 0; i < numbers.size(); i++) {
			str = str + numbers.get(i) + " ";
		}
		return str;
	}

}
