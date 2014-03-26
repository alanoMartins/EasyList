package br.com.fa7.easylist.models;

import java.util.ArrayList;
import java.util.List;

public class Wishlist extends Entity {

	private List<Item> itens;
	private String description;

	public Wishlist(String description) {
		this.description = description;
		itens = new ArrayList<Item>();

	}
	
	public void addItem(Item item){
		itens.add(item);
	}
	
	public List<Item> getItens(){
		return itens;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
