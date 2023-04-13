package sample09_set;

import java.util.TreeSet;

public class TreeSetApp1 {
	public static void main(String[] args) {
		
		TreeSet<String> names = new TreeSet<>();
		
		names.add("김오거");
		names.add("강오거");
		names.add("이오거");
		names.add("류오거");
		names.add("안오거"); 
		
		for (String name : names) {
			System.out.println(name);
		}
	}
}
