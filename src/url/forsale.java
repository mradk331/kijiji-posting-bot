package url;

public class forsale {

private String name;
private String desc;
private String price;
private String zip;
private String pics;
private String brand;
private String size;	
private int active;	

public String getSize() {
	return size;
}



public void setSize(String size) {
	this.size = size;
}



public String getBrand() {
	return brand;
}



public void setBrand(String brand) {
	this.brand = brand;
}



public forsale(String name, String desc, String price, String zip, String size, int active) {
	
	
	this.name = name;
	this.desc = desc;
	this.price = price;
	this.zip = zip;
	this.size = size;
	this.active = active;
	
	String desc1 = desc.substring(0, 20);
	
	
	
	String arr[] = name.split(" ");

	String firstWord = arr[0];   
	brand = firstWord;
	String secondWord = arr[1];   
	
	
	pics = "\\" + firstWord + " " + secondWord;
	
}

	
	
public String getName() {
	return name;
}



public void setName(String name) {
	this.name = name;
}



public String getDesc() {
	return desc;
}



public void setDesc(String desc) {
	this.desc = desc;
}



public String getPrice() {
	return price;
}



public void setPrice(String price) {
	this.price = price;
}



public String getZip() {
	return zip;
}



public void setZip(String zip) {
	this.zip = zip;
}



public String getPics() {
	return pics;
}



public void setPics(String pics) {
	this.pics = pics;
}


public int getActive()
{
	
	return this.active;
}

public void setActive(int x)
{
	
	this.active = x;
}

public void print()
{
	System.out.println("");
	System.out.println(price);
	System.out.println(name);
	System.out.println(desc);
	System.out.println(zip);
	System.out.println(pics);
	System.out.println(active);
	
	
	
}

}
