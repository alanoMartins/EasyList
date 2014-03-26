package br.com.fa7.easylist.models;

public class Item extends Entity {

	private String name;
	private String description;
	private double price;

	public Item(String name, String description, double price) {
		super();
		this.name = name;
		this.description = description;
		this.price = price;
	}

	public Item(String name, double price) {
		super();
		this.name = name;
		this.price = price;
	}

	public Item(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

}
