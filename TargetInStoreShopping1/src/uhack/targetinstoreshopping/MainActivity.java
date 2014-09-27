package uhack.targetinstoreshopping;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import android.app.Dialog;
import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.ListView;
import android.widget.NumberPicker;

public class MainActivity extends ListActivity implements NumberPicker.OnValueChangeListener
{
	String productUPC;
	private ListView productListView;
	private HorizontalScrollView relatedListView;
	private Button scan;
	private static List<Product1> productList;
	private static ArrayAdapter<Product1> adapter;
	private static int itemSelected = 0;
	private final static String FILE_NAME = "products";

	private String id;
	private String content;
	private String data1;

	public String getId()
	{
		return this.id;
	}

	public String getContent()
	{
		return this.content;
	}

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		productListView = getListView();
		registerForContextMenu(productListView);
		relatedListView = (HorizontalScrollView) findViewById(R.id.ScrollViewRelated);
		scan = (Button) findViewById(R.id.buttonScan);
		
		
		

		scan.setOnClickListener(new OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				
				 Intent intent = new Intent("com.google.zxing.client.android.SCAN"); 
				 intent.putExtra("com.google.zxing.client.android.SCAN.SCAN_MODE", "QR_CODE_MODE"); 
				 startActivityForResult(intent, 0);
				 
				 //Intent intent = new Intent(v.getContext(), PastReceiptActivity.class); startActivityForResult(intent, 0);
			}

			/*
			 * URL productURL; try { productURL = new URL("http://api.target.com/v2/products/11678018?idType=TCIN&key=J5PsS2XGuqCnkdQq0Let6RSfvU7oyPwF"); } catch (MalformedURLException e) { // TODO Auto-generated catch block e.printStackTrace(); }
			 * 
			 * CatalogEntryView product = null;
			 */

		});

		productList = generateList();
		
		adapter = new CustomArrayAdapter(this, productList);
		/*try
		{
			load();
		} catch (IOException e1)
		{
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}*/
		productListView.setAdapter(adapter);
		
		/*try
		{
			load();
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
*/
	}

	private void thread()
	{
		Thread t = new Thread(new Runnable()
		{
			@Override
			public void run()
			{
				Log.v("", "run");
				String url = "http://api.target.com/v2/products/"+getUPC()+"?idType=UPC&key=J5PsS2XGuqCnkdQq0Let6RSfvU7oyPwF";
				// HttpGet htt = new HttpGet("http://api.target.com/v2/products/11678018?idType=TCIN&key=J5PsS2XGuqCnkdQq0Let6RSfvU7oyPwF");
				String charset = "UTF-8";
				String param1 = "value1";
				String param2 = "value2";
				// ...

				String query;
			
				try
				{
					query = String.format("param1=%s&param2=%s", URLEncoder.encode(param1, charset), URLEncoder.encode(param2, charset));

					URLConnection connection = new URL(url).openConnection();// + "?" + query).openConnection();
					// connection.setRequestProperty("Accept-Charset", charset);
					InputStream response = connection.getInputStream();
					Log.v("", convertStreamToString(response));
					data1 = convertStreamToString(response);
					
					StringTokenizer st = new StringTokenizer(data1, "fullImage>");
					try{
						String f = st.nextToken();
					}
					catch(Exception e)
					{
						
					}
					String img = "";
					String im = st.nextToken();
					for(int i = 0; i < im.length(); i++)
					{
						if(im.charAt(i) == '<')
						{
							img = im.substring(0,i);
						}
					}
					
					/*Double d = Double.parseDouble(price);
					int id = Integer.parseInt(getUPC());
					String name = "Name here";*/
					
					StringTokenizer st2 = new StringTokenizer(data1, "\"formattedPriceValue\": \"");
					st2.nextToken();
					String price;
					String title = "";
					String s2 = st2.nextToken();
					for(int i = 0; i < s2.length(); i++)
					{
						if(s2.charAt(i) == '\"')
						{
							price = s2.substring(0,i);
						}
					}
					
					productList.add(new Product1(Integer.parseInt(id), 1));
					adapter.notifyDataSetChanged();

				} catch (UnsupportedEncodingException e)
				{
					// TODO Auto-generated catch block
					Log.v("", "error 1");
					e.printStackTrace();
				} catch (IOException e)
				{
					// TODO Auto-generated catch block
					Log.v("", "error 2");

					e.printStackTrace();
				}

			}
		});
		t.start();
	}
	
	static String convertStreamToString(java.io.InputStream is) {
	    @SuppressWarnings("resource")
		java.util.Scanner s = new java.util.Scanner(is).useDelimiter("\\A");
	    return s.hasNext() ? s.next() : "";
	}

	private List<Product1> generateList()
	{

		// TODO get the list from our data
		List<Product1> list = new ArrayList<Product1>();
		
		return list;

	}

	private void save() throws IOException
	{

		String string = "";
		for (int i = 0; i < productList.size(); i++)
		{
			string = productList.get(i).getDataString();
		}
		FileOutputStream fileStream = openFileOutput(FILE_NAME, Context.MODE_PRIVATE);
		fileStream.write(string.getBytes());
		fileStream.close();
	}

	private void load() throws IOException
	{
		File file = new File(this.getFilesDir(), FILE_NAME);
		int length = (int) file.length();

		byte[] bytes = new byte[length];

		FileInputStream in;
		try
		{
			in = new FileInputStream(file);
			try
			{
				try
				{
					in.read(bytes);
				} catch (IOException e)
				{
				}
			} finally
			{
				try
				{
					in.close();
				} catch (IOException e)
				{
				}
			}
		} catch (FileNotFoundException e)
		{
		}
		String data = new String(bytes);
		// TODO parse data, search db f
		ArrayList<String> strings = new ArrayList<String>();
		int bottem = 1;
		for(int i = 1; i < data.length(); i++)
		{
			if (data.charAt(i) == '$')
			{
				strings.add(data.substring(1, i));
				bottem = i+1;
			}
		}
		for(int i = 0; i < strings.size(); i+=2)
		{
			productList.add(new Product1(Integer.parseInt(strings.get(i)), Integer.parseInt(strings.get(i+1))));
		}
		adapter.notifyDataSetChanged();
		
		

	}

	@Override
	public boolean onMenuItemSelected(int featureId, MenuItem item)
	{

		if (item.getTitle().equals("More Details"))
		{
			// TODO editFighter(list.get(position).getName());
		}
		else if (item.getTitle().equals("Change Quantity"))
		{
			final Dialog dialog = new Dialog(MainActivity.this);
			dialog.setTitle("NumberPicker");
			dialog.setContentView(R.layout.dialog);
			Button b1 = (Button) dialog.findViewById(R.id.button1);
			Button b2 = (Button) dialog.findViewById(R.id.button2);
			final NumberPicker numberPicker = (NumberPicker) dialog.findViewById(R.id.numberPicker1);
			numberPicker.setMaxValue(100);
			numberPicker.setMinValue(1);
			numberPicker.setWrapSelectorWheel(false);
			numberPicker.setOnValueChangedListener(this);
			b1.setOnClickListener(new OnClickListener()
			{
				@Override
				public void onClick(View v)
				{
					productList.get(itemSelected).setQuantity(numberPicker.getValue());
					adapter.notifyDataSetChanged();
					dialog.dismiss();
				}
			});
			b2.setOnClickListener(new OnClickListener()
			{
				@Override
				public void onClick(View v)
				{
					dialog.dismiss();
				}
			});
			dialog.show();
		}

		else if (item.getTitle().equals("Remove"))
		{
			removeItem(itemSelected);
		}
		else
			return false;
		return true;
	}

	@Override
	public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo)
	{
		AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) contextMenuInfo;
		int position = info.position;
		setItemSelected(position);
		contextMenu.add("More Details");
		contextMenu.add("Change Quantity");
		contextMenu.add("Remove");
	}

	public static void setItemSelected(int position)
	{
		itemSelected = position;
	}

	public static void removeItem(int position)
	{
		productList.remove(position);
		adapter.notifyDataSetChanged();
	}

	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent intent)
	{
		if (requestCode == 0)
		{
			if (resultCode == RESULT_OK)
			{
				String contents = intent.getStringExtra("SCAN_RESULT");
				String format = intent.getStringExtra("SCAN_RESULT_FORMAT");
				// Handle successful scan
				setUPC(contents);
				thread();
			}
			else if (resultCode == RESULT_CANCELED)
			{
				// Handle cancel
			}
		}
	}

	@Override
	public void onValueChange(NumberPicker arg0, int arg1, int arg2)
	{
		// TODO Auto-generated method stub

	}
	
	public void setUPC(String upc) {
		productUPC = upc;
		
	}
	
	@Override
	public void onBackPressed()
	{
		Intent intent = new Intent(this, CheckoutActivity.class); 
		intent.putExtra("cart", new ArrayList<Product1>()); 
		startActivityForResult(intent, 0);
	}
	
	public String getUPC() {
		return productUPC;
	}
}