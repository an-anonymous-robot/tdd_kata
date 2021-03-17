package TDD;

import java.util.List;
import java.util.stream.Collectors;
//case 1
public class StringCalculator {
	public static void main(String[] args) {
		System.out.println(Add("1,2"));
	}
	static int Add(String numbers) {
		if("".equals(numbers)) {
			return 0;
		}
		else {
			String[] nums=numbers.split(",");
			int sum=Integer.parseInt(nums[0])+Integer.parseInt(nums[1]);
			return sum;
		}
	}

}
