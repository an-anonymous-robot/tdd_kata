package TDD;

import java.util.List;
import java.util.stream.Collectors;

public class StringCalculator {
	public static void main(String[] args) {
		try {
		System.out.println(Add("//;\n1;3,-2"));
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	static int Add(String numbers) throws NegativeNumberException {
		
		if("".equals(numbers)) {
			return 0;
		}
		else {
			String delimiter_temp=numbers.substring(2,numbers.indexOf("\n"));
			String delimiter=delimiter_temp.concat("|\\n|,");
			String new_str=numbers.substring(numbers.indexOf("\n")+1);
			List<String> arr=List.of(new_str.split(delimiter));
			List<Integer> nums=arr.stream()
			   .map(a->Integer.parseInt(a))
			   .collect(Collectors.toList());
			for(int i:nums) {
				if(i<0) {
				String s="negatives not allowed!";
				s=s.concat(" "+String.valueOf(i));
				throw new NegativeNumberException(s);
				}
			}
			return 0;
//			System.out.println(delimiter);
//			return 0;
		}
		
	}
	
	static class NegativeNumberException extends Exception{
		NegativeNumberException(String s){
			
			
			super(s);
		}
	}

}
