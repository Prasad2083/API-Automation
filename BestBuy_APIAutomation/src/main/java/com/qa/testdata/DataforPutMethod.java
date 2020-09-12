package com.qa.testdata;

public class DataforPutMethod {
	
	String name,type,upc,description,manufacturer,price,shipping,model,url,image,id,createdAt,updatedAt;
	
	

	public DataforPutMethod() {
		
	}
	
	public DataforPutMethod(String name,String type,String price,String shipping, String upc, String description,
			String manufacturer, String model, String url, String image ) {
		this.name=name;
		this.type=type;
		this.price=price;
		this.shipping=shipping;
		this.upc=upc;
		this.description=description;
		this.manufacturer=manufacturer;
		this.model=model;
		this.url=url;
		this.image=image;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	public int getPrice() {
		return Integer.parseInt(price);
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public int getShipping() {
		return Integer.parseInt(shipping);
	}

	public void setShipping(String shipping) {
		this.shipping = shipping;
	}

	public String getUpc() {
		return upc;
	}

	public void setUpc(String upc) {
		this.upc = upc;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	
	
	

	
	}


