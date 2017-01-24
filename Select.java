import java.util.ArrayList;

public class Select{

	public static void main(String[] args) throws Exception{

		int getNumber = Integer.parseInt(args[0]);
		ArrayList<Integer> numbers = getInputFromFile();

		if (getNumber > numbers.size()) {
			throw new UnsupportedOperationException("BAD DATA");
		}

		int pivotIndex = -1;
		int pivotTemp = -2;

		while (pivotTemp != 0) {

			pivotIndex = (int)(numbers.size() * Math.random());
			numbers = partition(numbers, pivotIndex, getNumber);
			pivotTemp = checkPivot(numbers, pivotIndex, getNumber);

			if (pivotTemp == -1) {
				numbers = new ArrayList<Integer>(numbers.subList(0, pivotIndex - 2));
			} else if (pivotTemp == 1) {
				numbers = new ArrayList<Integer>(numbers.subList(pivotIndex, numbers.size() - 1));
			}
		}

		if (pivotTemp != 0 || pivotIndex == -1) {
			throw new UnsupportedOperationException("It doesn't equal 0 past the while loop");
		}

		System.out.println(numbers.get(pivotIndex));

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
	public static ArrayList<Integer> partition(ArrayList<Integer> numbers, int pivotIndex, int numFind) {
		return numbers;
	}

	public static int checkPivot(ArrayList<Integer> numbers, int pivotIndex, int numFind) {
		if (pivotIndex + 1 > numFind) {
			return -1;
		} else if (pivotIndex + 1 == numFind) {
			return 0;
		} else if (pivotIndex + 1 < numFind) {
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
