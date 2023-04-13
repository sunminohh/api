package sample07_generic;

import javax.swing.Box;

public class NoneGenericBoxApp {
	public static void main(String[] args) {
		
		// 문자열을 담을 수 있는 NoneGenericBox객체 만들기
		NoneGenericBox box1 = new NoneGenericBox();
		
		// 박스객체에 문자열 저장하기 
		box1.setItem("홍길동");
		
		// 박스객체에 저장된 문자열 조회하기
		String value = (String)box1.getItem();
		System.out.println("박스에 저장했던 값 -> " +value);
	}
}
