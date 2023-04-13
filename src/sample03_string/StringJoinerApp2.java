package sample03_string;

import java.util.StringJoiner;

public class StringJoinerApp2 {
	public static void main(String[] args) {
		String[] names = {"김유신", "강감찬", "이순신"};
	
		StringJoiner joiner = new StringJoiner(",");
		for (String name : names) {
			joiner.add(name);
		}
		
		String text = joiner.toString();
		System.out.println(text);
	}
}
