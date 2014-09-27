package uhack.targetinstoreshopping;

import java.util.List;

import android.app.Activity;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

class CustomArrayAdapter2 extends ArrayAdapter<Receipt> implements OnCreateContextMenuListener
{

	private final List<Receipt> rList;
	private int position;
	private final Activity context;

	public CustomArrayAdapter2(Activity context, List<Receipt> list)
	{
		super(context, R.layout.receipt_view);
		this.context = context;
		this.rList = list;

	}

	static class ViewHolder
	{
		protected TextView date;
		protected TextView id;
	}

	@Override
	public View getView(final int position, View convertView, ViewGroup parent)
	{
		View view = null;
		
		if (convertView == null)
		{
			LayoutInflater inflator = context.getLayoutInflater();
			view = inflator.inflate(R.layout.receipt_view, null);
			final ViewHolder viewHolder = new ViewHolder();
			viewHolder.date = (TextView) view.findViewById(R.id.Date);
			viewHolder.id = (TextView) view.findViewById(R.id.id);
			view.setTag(viewHolder);
		}
		else
		{
			view = convertView;
		}
		ViewHolder holder = (ViewHolder) view.getTag();
		holder.date.setText(rList.get(position).getDate());
		holder.id.setText(rList.get(position).getId() + "");
		
		
		this.position = position;
		
		view.setOnCreateContextMenuListener(this);
		return view;
	}

	@Override
	public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo)
	{
		
	}
	
	

	
}
