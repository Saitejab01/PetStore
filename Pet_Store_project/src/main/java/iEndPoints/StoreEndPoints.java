package iEndPoints;

public interface StoreEndPoints {
	
	public String GET_INVENTORY="/store/inventory";
	String PLACE_AN_ORDER="/store/order";
	String PURCHASE_DETAILS_BY_ORDER_ID="/store/order/{orderId}";

}
