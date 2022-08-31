package com.ecommerce.models;

public class CartItem {
    private int item_id;
    private int price;
    private String name;
    private int quantity;
    private String phone_number;

    public int getItemId() {
		return item_id;
	}
	public void setItemId(int item_id) {
		this.item_id = item_id;
	}

    public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}

    public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
    public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getPhoneNumber() {
		return phone_number;
	}

	public void setPhoneNumber(String phone_number) {
		this.phone_number = phone_number;
	}
}
