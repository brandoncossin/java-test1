package com.ecommerce.models;

public class CartPageForm {
    private int item_id;
    private String phone_number;

    public int getItemId() {
		return item_id;
	}
	public void setItemId(int item_id) {
		this.item_id = item_id;
	}

	public String getPhoneNumber() {
		return phone_number;
	}

	public void setPhoneNumber(String phone_number) {
		this.phone_number = phone_number;
	}
}
