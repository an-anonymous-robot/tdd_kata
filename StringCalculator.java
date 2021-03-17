package TDD;

import java.util.List;
import java.util.stream.Collectors;

public class StringCalculator {
	public static void main(String[] args) {
		System.out.println(Add("1\n3,2"));
	}
	static int Add(String numbers) {
		if("".equals(numbers)) {
			return 0;
		}
		else {
			List<String> arr=List.of(numbers.split("\\n|,"));
			int sum=arr.stream()
			   .map(a->Integer.parseInt(a))
			   .reduce(0,(a,b)->a+b);
			return sum;
		}
	}

}
