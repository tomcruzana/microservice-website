package dev.company.customer.entity;

public class CartItem {

	private String cartId;

	private int productItemId;

	private int quantity;

	public CartItem() {
	}

	public String getCartId() {
		return cartId;
	}

	public void setCartId(String cartId) {
		this.cartId = cartId;
	}

	public int getProductItemId() {
		return productItemId;
	}

	public void setProductItemId(int productItemId) {
		this.productItemId = productItemId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
