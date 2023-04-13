package sample07_generic;

import java.awt.event.ItemEvent;

public class GenericPhoneBox <T extends Phone> {

	private T item;
	public T getItem() {
		return item;
	}
	public void setItem(T item) {
		this.item = item;
	}
	
}
