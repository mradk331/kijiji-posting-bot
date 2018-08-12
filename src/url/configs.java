package url;

public class configs {

	
	public nameID A1 = new nameID( "Arts & Collectibles", "https://www.kijiji.ca/p-post-ad.html?categoryId=12&adTitle=");
	public nameID A2 = new nameID( "Headphones", "https://www.kijiji.ca/p-post-ad.html?categoryId=770&adTitle="); 
	public nameID A3 = new nameID( "Ipod & mp3 Accessories",  "https://www.kijiji.ca/p-post-ad.html?categoryId=769&adTitle=");
	public nameID A4 = new nameID( "Ipod & mp3s",  "https://www.kijiji.ca/p-post-ad.html?categoryId=768&adTitle=");
	public nameID A5 = new nameID( "Speakers",  "https://www.kijiji.ca/p-post-ad.html?categoryId=14922002&adTitle=");
	public nameID A6 = new nameID( "Stereo Systems & Home Theatre",  "https://www.kijiji.ca/p-post-ad.html?categoryId=14922001&adTitle=");
	public nameID A7 = new nameID( "Other audio",  "https://www.kijiji.ca/p-post-ad.html?categoryId=771&adTitle=");
	public nameID A8 = new nameID( "Speakers",  "https://www.kijiji.ca/p-post-ad.html?categoryId=14922002&adTitle=");
	public nameID A9 = new nameID( "Speakers",  "https://www.kijiji.ca/p-post-ad.html?categoryId=14922002&adTitle=");
	public nameID A10 = new nameID( "Speakers",  "https://www.kijiji.ca/p-post-ad.html?categoryId=14922002&adTitle=");
	public nameID A11 = new nameID( "Speakers",  "https://www.kijiji.ca/p-post-ad.html?categoryId=14922002&adTitle=");
	public nameID A12 = new nameID( "Speakers",  "https://www.kijiji.ca/p-post-ad.html?categoryId=14922002&adTitle=");
	public nameID A13 = new nameID( "Speakers",  "https://www.kijiji.ca/p-post-ad.html?categoryId=14922002&adTitle=");
	public nameID A14 = new nameID( "Speakers",  "https://www.kijiji.ca/p-post-ad.html?categoryId=14922002&adTitle=");
	public nameID A15 = new nameID( "Speakers",  "https://www.kijiji.ca/p-post-ad.html?categoryId=14922002&adTitle=");
	public nameID A16 = new nameID( "Speakers",  "https://www.kijiji.ca/p-post-ad.html?categoryId=14922002&adTitle=");
	public nameID A17 = new nameID( "Speakers",  "https://www.kijiji.ca/p-post-ad.html?categoryId=14922002&adTitle=");

	
	
	
}
class nameID{
	String name;
	String address;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	nameID(String name, String Address)
	{
		this.name = name;
		this.address = Address;
		
	}
	
}