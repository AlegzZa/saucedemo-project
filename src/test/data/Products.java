package test.data;

import config.Reader;

public class Products {
	private String product;
	private String details;
	private String price;
	
	public Products(String filename) {
		this.product=Reader.json(filename).get("product").toString();
		this.details=Reader.json(filename).get("details").toString();
		this.price=Reader.json(filename).get("price").toString();

	}
	
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
}
