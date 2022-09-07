
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Calculator {
   	//main func
	 public static void main(String args[])
	{
		    String nums;
		    Scanner sc = new Scanner(System.in);
		    System.out.println("Enter string");
		    nums = sc.nextLine();
		    
		    
		    int ans = add(nums);
		    System.out.println("Ans = "+ans);
	}
	 
	public static int add(String numbers) {
		String[] num = splitter(numbers);
		int size=num.length;
		return findSum(num, size);
	}



	public static boolean isAlpha(String s) {
        return s != null && s.matches("^[a-zA-Z]*$");
    }
	
	private static int findSum(String[] num, int size) {
		
		Map<String, Integer> mymap = new HashMap<String, Integer>() {
	        {
	        	int cnt=1;
	            for (char ch = 'a'; ch <= 'z'; ++ch) 
	                put(String.valueOf(ch), cnt++); 

	        }
		};
		int sum=0;
		for(int i=0; i<size; i++){
			if(isAlpha(num[i]))
			{
				if(mymap.containsKey(num[i]))
				{
					int tabc = mymap.get(num[i]);
					sum+=tabc;
				}
			}
			else
			{
				sum = sum + Integer.parseInt(num[i]);
			}
			
		}
		return sum;
	}

	private static String[] splitter(String numbers) {
		if(numbers.isEmpty()) {
			return new String[0];
		} else if(isCustomDelimiterString(numbers)) {
			return splitUsingCustomDelimiter(numbers);
		}
		return splitUsingCommaAndNewLine(numbers);
	}

	private static boolean isCustomDelimiterString(String numbers) {
		return numbers.startsWith("//");
	}

	private static String[] splitUsingCommaAndNewLine(String numbers) {
		String[] num=numbers.split(",|\n");
		return num;
	}

	private static String[] splitUsingCustomDelimiter(String numbers) {
		Matcher m = Pattern.compile("//(.)\n(.*)").matcher(numbers);
		m.matches();
		String customDelim = m.group(1);
		String num=m.group(2);
		return num.split(Pattern.quote(customDelim));
	}
}