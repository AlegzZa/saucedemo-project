package test.data;

import config.Reader;

public class OrderDetailsFinal {

	private String paymentInformation;
	private String shippingInformation;
	private String totalPrice;
	private String tax;
    private String itemTotal;
    
    public OrderDetailsFinal(String filename) {
		this.paymentInformation=Reader.json(filename).get("PaymentInformation").toString();
		this.shippingInformation=Reader.json(filename).get("ShippingInformation").toString();
		this.itemTotal=(Reader.json(filename).get("Item").toString());
		this.tax=Reader.json(filename).get("Tax").toString();
		this.totalPrice=Reader.json(filename).get("Total").toString();
		

	}

	public String getPaymentInformation() {
		return paymentInformation;
	}

	public void setPaymentInformation(String paymentInformation) {
		this.paymentInformation = paymentInformation;
	}

	public String getShippingInformation() {
		return shippingInformation;
	}

	public void setShippingInformation(String shippingInformation) {
		this.shippingInformation = shippingInformation;
	}

	
	public String getTax() {
		return tax;
	}

	public void setTax(String tax) {
		this.tax = tax;
	}

	public String getItemTotal() {
		return itemTotal;
	}

	public void setItemTotal(String total) {
		this.itemTotal = total;
	}

	public String getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(String totalPrice) {
		this.totalPrice = totalPrice;
	}
}
