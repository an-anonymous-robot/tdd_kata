package TDD;

import java.util.List;
import java.util.stream.Collectors;

public class StringCalculator {
	static int count=0;
	public static void main(String[] args) {
		try {
		System.out.println(Add("//;\n1;-3,-2"));
		System.out.println(GetCalledCount());
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	 public static int GetCalledCount() {
		 return count;
	 }
	 
	static int Add(String numbers) throws NegativeNumberException {
		count++;
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
			
			List<Integer> negNums=nums.stream()
									  .filter(p->p<0)
									  .collect(Collectors.toList());
			if(negNums.size()>0) {
				StringBuilder s=new StringBuilder("negatives not allowed!");
				for(int n:negNums) {
					s.append(" "+String.valueOf(n));
				}
				throw new NegativeNumberException(s.toString());
			}
			
			int sum=nums.stream().reduce(0, (a,b)->a+b);
			return sum;
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
