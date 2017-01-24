import java.util.ArrayList;
public class Select{
	
	
	public static void main(String[] args) throws Exception{
		int getNumber = Integer.parseInt(args[0]);
		ArrayList<Integer> numbers = getInputFromFile();
		
		if(getNumber > numbers.size()){
			System.out.println("BAD DATA");
			return;
		}
		
		int randNum = (int)(numbers.size() * Math.random());
		
		
		for(int i = 0; i < numbers.size(); i++){
			System.out.print(numbers.get(i));
		}
		
	}
	
	public static ArrayList<Integer> getInputFromFile() throws java.io.IOException{
		java.io.BufferedReader stdIn =
			new java.io.BufferedReader(new java.io.InputStreamReader(System.in));
		String s = stdIn.readLine();	
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		while(s!= null){
			numbers.add(Integer.parseInt(s));
			s = stdIn.readLine();
		}
		return numbers;
	}
	
}