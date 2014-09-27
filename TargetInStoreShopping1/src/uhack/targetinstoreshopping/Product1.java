package uhack.targetinstoreshopping;

import java.io.Serializable;

import android.media.Image;

public class Product1 implements Serializable
{

	private static final long serialVersionUID = 1L;
	private double price;
	private String name;
	private String Descrption;
	private Image picture;
	private int quantity;
	private int id;
	

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public int getQuantity()
	{
		return quantity;
	}

	public void setQuantity(int quantity)
	{
		this.quantity = quantity;
	}

	public Product1(String name, double price, String descrption, Image picture)
	{
		super();
		this.price = price;
		this.name = name;
		Descrption = descrption;
		this.picture = picture;
		quantity = 1;
	}
	
	public Product1(int id, int quantity)
	{
		//TODO load data from database
		this.id = id;
		this.quantity = quantity;
	}
	
	public Product1(Product1 p)
	{
		this.price =p.getPrice();
		this.name = p.getName();
		this.Descrption = p.getDescrption();
		this.picture = p.getPicture();
		quantity = 1;
	}

	public double getPrice()
	{
		return price;
	}

	public String getName()
	{
		return name;
	}

	public String getDescrption()
	{
		return Descrption;
	}

	public Image getPicture()
	{
		return picture;
	}
	
	
	public String getDataString() // id being the database primary key
	{
		return "$" + id + "$" + quantity + "$#";
	}
	

}