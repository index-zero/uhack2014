package uhack.targetinstoreshopping;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import android.app.ListActivity;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class PastReceiptActivity extends ListActivity
{
	private ListView rListView;
	private List<Receipt> rList = new ArrayList<Receipt>();
	private static ArrayAdapter<Receipt> adapter;
	private static final String FILE_NAME = "receipts";

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_past_receipt);
		rListView = getListView();

		generateReceipts();
		adapter = new CustomArrayAdapter2(this, rList);
		rListView.setAdapter(adapter);

	}

	private void generateReceipts()
	{
		for (int i = 0; i < 10; i++)
		{
			rList.add(new Receipt("None", i));
		}
		try
		{
			save();//TODO
		} catch (IOException e)
		{}
		// adapter.notifyDataSetChanged();
	}

	private void save() throws IOException
	{
		String string = "";
		for (int i = 0; i < rList.size(); i++)
		{
			string = rList.get(i).getDataString();
		}
		FileOutputStream fileStream = openFileOutput(FILE_NAME, Context.MODE_PRIVATE);
		fileStream.write(string.getBytes());
		fileStream.close();
	}

	private void load()
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
		rList.clear();
		int bottom = 0;
		for (int i = 0; i < data.length(); i++)
		{
			if (data.length() != i+1)//index out of bounds
			{
				if (data.substring(i, i + 1).equals("##"))
				{
					rList.add(Receipt.dataToReceipt(data.substring(bottom, i)));
					bottom = i+1;
				}
			}
			else
			{
				rList.add(Receipt.dataToReceipt(data.substring(bottom)));
			}
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.past_receipt, menu);
		return true;
	}

}
