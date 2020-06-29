package demo1;

/**
 * 定义一个商品类
 * */

public class Product {
	private String name;
	private double price;
	/** 定义的商品描述*/
	private String description;
	/** 定义的商品服务 */
	private String[] services;
	
	public Product() {}
	
	public Product(String name, String desciption) {
		setName(name);
		setDescription(desciption);
		
	}
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String[] getServices() {
		return services;
	}

	public void setServices(String[] services) {
		this.services = services;
	}

}
