package TDD;

import java.util.List;
import java.util.stream.Collectors;

public class StringCalculator {
	public static void main(String[] args) {
		System.out.println(Add("//;\n1;3,2"));
	}
	static int Add(String numbers) {
		if("".equals(numbers)) {
			return 0;
		}
		else {
			String delimiter_temp=numbers.substring(2,numbers.indexOf("\n"));
			String delimiter=delimiter_temp.concat("|\\n|,");
			String new_str=numbers.substring(numbers.indexOf("\n")+1);
			List<String> arr=List.of(new_str.split(delimiter));
			int sum=arr.stream()
			   .map(a->Integer.parseInt(a))
			   .reduce(0,(a,b)->a+b);
			return sum;
//			System.out.println(delimiter);
//			return 0;
		}
	}

}
