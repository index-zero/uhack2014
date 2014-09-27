package uhack.targetinstoreshopping;

import java.io.InputStream;
import java.io.Serializable;
import java.net.URL;

import android.graphics.drawable.Drawable;
import android.os.StrictMode;

public class Product implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private double price;
	private String name;
	private String Descrption;
	private String picture;
	
	public Product(String name, double price, String descrption, String picture) {
		super();
		this.price = price;
		this.name = name;
		Descrption = descrption;
		this.picture = picture;
	}

	public double getPrice() {
		return price;
	}

	public String getName() {
		return name;
	}

	public String getDescrption() {
		return Descrption;
	}

	public String getPicture() {
		return picture;
	}
	
	public Drawable getPictureOnline() {

		try {

			StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
					.permitAll().build();
			StrictMode.setThreadPolicy(policy);

			InputStream is = (InputStream) (new URL(picture)).getContent();
			return Drawable.createFromStream(is, "src");

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;

	}
	
	
}
