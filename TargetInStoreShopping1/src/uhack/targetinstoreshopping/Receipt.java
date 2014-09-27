package uhack.targetinstoreshopping;

import java.util.ArrayList;
import java.util.Date;

public class Receipt
{
	private String description;
	private int id;
	private String date;
	
	public String getDate()
	{
		return "date";
	}

	public void setDate(String date)
	{
		this.date = date;
	}

	public Receipt(String text, int id)
	{
		description = text;
		this.id = id;
		date = Long.toString((new Date()).getTime());
	}

	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}
	
	public String getDataString()
	{
		return "#$" + id + "$" + description + "$" + date + "$#";
	}
	
	public static Receipt dataToReceipt(String data)
	{
		int bottom = 2;
		ArrayList<String> s = new ArrayList<String>();
		for(int i = 2; i < data.length(); i++)
		{
			if(data.charAt(i) == '$' && s.size()<3)
			{
				s.add(data.substring(bottom, i));
				bottom = i+1;
			}
		}
		Receipt r = new Receipt(s.get(1), Integer.parseInt(s.get(0)));
		r.setDate(s.get(2));
		
		return r;
	}
}
