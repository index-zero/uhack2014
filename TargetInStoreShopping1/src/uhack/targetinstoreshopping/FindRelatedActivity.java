package uhack.targetinstoreshopping;

import java.util.List;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class FindRelatedActivity extends ListActivity
{
	private List<Product1> productList;
	private ListView productListView;
	private int itemSelected;
	
	public void setItemSelected(int itemSelected)
	{
		this.itemSelected = itemSelected;
	}

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_find_related);
		productListView = getListView();
		registerForContextMenu(productListView);
		
	}
	
	@Override
	public boolean onMenuItemSelected(int featureId, MenuItem item)
	{

		if (item.getTitle().equals("Add"))
		{
			
		}
		else if(item.getTitle().equals("More Details"))
		{
			//TODO
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
		contextMenu.add("Add");
		contextMenu.add("More Details");

	}

}
