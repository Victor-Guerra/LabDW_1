package mx.tec.web.lab.vo;

public class Sku {
	
	private String id;
	private String color;
	private String size;
	private double listPrice; 
	private double salePrice;
	private double quantityOnHand;
	private String smallImgLink;
	private String mediumImgLink;
	private String largeImgLink;
	/**
	 * 
	 */
	public Sku() {
		
	}
	/**
	 * @param id
	 * @param color
	 * @param size
	 * @param listPrice
	 * @param salePrice
	 * @param quantityOnHand
	 */
	public Sku(String id, String color, String size, double listPrice, double salePrice, double quantityOnHand, String smallImgLink, String mediumImgLink, String largeImgLink) {
		this.id = id;
		this.color = color;
		this.size = size;
		this.listPrice = listPrice;
		this.salePrice = salePrice;
		this.quantityOnHand = quantityOnHand;
		this.smallImgLink = smallImgLink;
		this.mediumImgLink = mediumImgLink;
		this.largeImgLink = largeImgLink;
	}
	

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @return the color
	 */
	public String getColor() {
		return color;
	}
	/**
	 * @return the size
	 */
	public String getSize() {
		return size;
	}
	/**
	 * @return the listPrice
	 */
	public double getListPrice() {
		return listPrice;
	}
	/**
	 * @return the salePrice
	 */
	public double getSalePrice() {
		return salePrice;
	}
	/**
	 * @return the quantityOnHand
	 */
	public double getQuantityOnHand() {
		return quantityOnHand;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @param color the color to set
	 */
	public void setColor(String color) {
		this.color = color;
	}
	/**
	 * @param size the size to set
	 */
	public void setSize(String size) {
		this.size = size;
	}
	/**
	 * @param listPrice the listPrice to set
	 */
	public void setListPrice(double listPrice) {
		this.listPrice = listPrice;
	}
	/**
	 * @param salePrice the salePrice to set
	 */
	public void setSalePrice(double salePrice) {
		this.salePrice = salePrice;
	}
	/**
	 * @param quantityOnHand the quantityOnHand to set
	 */
	public void setQuantityOnHand(double quantityOnHand) {
		this.quantityOnHand = quantityOnHand;
	}
	/**
	 * @return the smallImgLink
	 */
	public String getSmallImgLink() {
		return smallImgLink;
	}
	/**
	 * @param smallImgLink the smallImgLink to set
	 */
	public void setSmallImgLink(String smallImgLink) {
		this.smallImgLink = smallImgLink;
	}
	/**
	 * @return the mediumImgLink
	 */
	public String getMediumImgLink() {
		return mediumImgLink;
	}
	/**
	 * @param mediumImgLink the mediumImgLink to set
	 */
	public void setMediumImgLink(String mediumImgLink) {
		this.mediumImgLink = mediumImgLink;
	}
	/**
	 * @return the largeImgLink
	 */
	public String getLargeImgLink() {
		return largeImgLink;
	}
	/**
	 * @param largeImgLink the largeImgLink to set
	 */
	public void setLargeImgLink(String largeImgLink) {
		this.largeImgLink = largeImgLink;
	}
}
