package sample03_string;

public class StringApp3 {
	public static void main(String[] args) {
		
		// 기본자로형의 값을 문자열로 변환하기
		// 불린, 정수, 실수, 객체, 문자, 문자배열을 String으로 변환해서 반환한다.
		// true -> "true"
		//	 	String text = String.valueOf(true);
		// 'A' -> "A"
		//	 	String text = String.valueOf('A');
		// ['안', '녕', '하', '세', '요'] -> "안녕하세요"
		// 3.14 -> "3.14"
		// 	 	String text = String.valueOf(3.14);
		// 10000 -> "10000"
		// 	 	String text = String.valueOf(10000);
		// 10000000000000L -> "10000000000000" 
		
		// static String valueOf(boolean value) 
		// static String valueOf(char value)
		// static String valueOf(char[] arr, int offset, int length)
		// static String valueOf(double value)
		// static String valueOf(int value)
		// static String valueOf(long value)
		// static String vlaueOf(Objects obj) 
		
		// 문자열을 기본자료형값으로 변환하기
		// "true" -> true
		//	 	boolean result = Boolean.parseBoolean("true");
		// "ABC" -> 'A'
		//	 	char result = "ABC".charAt(0);
		// "3.14" -> 3.14
		// 	 	double value = Double.paseDouble("3.14");
		// "10000" -> 10000
		// 	 	int value = Integer.paseInt("10000");
		// "11000000000" -> 1000000000
		//		long value = Long.parseLong("1000000000")
		
		// 임의의 정수에 대하여 정수의 각 자리값을 더한 결과를 출력하기
		// 정수 : 11023
		// 출력값 : 16 = 1 + 1 + 2 + 9 + 3
		int number = 110293;
		String text = String.valueOf(number);  // 110293 -> "110293"
		String[] values = text.split("");      // "110293" -> {"1", "1", "0", "2", "9", "3"}
		
		int total = 0;
		for (String value : values) {
			int num = Integer.parseInt(value);  // "1" -> 1
			total += num;
		}
		
		System.out.println("자릿수의 합 -> " +total); 
			
		
	}
}











