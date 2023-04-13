package sample08_list;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.management.ValueExp;
import javax.print.DocFlavor.STRING;

public class ArrayListApp2 {
	public static void main(String[] args) {
		
		ArrayList<String> names = new ArrayList<>();
		names.add("오거");
		names.add("오거는");
		names.add("오민선님의");
		names.add("오거북이");
		
		System.out.println("### 콜렉션객체(ArrayList객체)에 저장된 값을 외부반복으로 처리하기");
		for (String name : names) {
			System.out.println(name);
		}
		// 변형, 수집
		List<Character> values = new ArrayList<>();
		for (String name : names) {
			values.add(name.charAt(0));
		}
		// 소비
		for (char c : values) {
			System.out.println(c);
		}
		
		System.out.println("### 콜렉션객체(ArrayList객체)에 저장된 값을 내부반복으로 처리하기");
		names.stream().forEach(name -> System.out.println(name)); 
		
		names.stream()
			.map(name -> name.charAt(0))					// 변형
			.collect(Collectors.toList())					// 수집
			.forEach(value -> System.out.println(value));	// 소비 
	}
}
