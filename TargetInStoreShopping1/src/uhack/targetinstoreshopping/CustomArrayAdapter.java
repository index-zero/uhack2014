package uhack.targetinstoreshopping;

import java.util.List;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

class CustomArrayAdapter extends ArrayAdapter<Product1> implements
		OnCreateContextMenuListener {

	private final List<Product1> productList;
	private final Activity context;

	public CustomArrayAdapter(Activity context, List<Product1> list) {
		super(context, R.layout.product_view);
		this.context = context;
		this.productList = list;
	}

	static class ViewHolder {
		protected ImageView productImage;
		protected TextView productName;
		protected TextView productPrice;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View view = null;
		if (convertView == null) {
			LayoutInflater inflator = context.getLayoutInflater();
			view = inflator.inflate(R.layout.product_view, null);
			final ViewHolder viewHolder = new ViewHolder();
			viewHolder.productName = (TextView) view
					.findViewById(R.id.product_name);
			viewHolder.productPrice = (TextView) view
					.findViewById(R.id.product_price);
			viewHolder.productImage = (ImageView) view
					.findViewById(R.id.product_image);
			view.setTag(viewHolder);
		} else {
			view = convertView;
		}
		ViewHolder holder = (ViewHolder) view.getTag();
		holder.productName.setText(productList.get(position).getName());
		holder.productPrice.setText(productList.get(position).getPrice() + "");
		/*Drawable d = productList.get(position).getPictureOnline();
		float scaleFactor = (float)75.0 / d.getMinimumHeight();
		holder.productImage.setScaleX(scaleFactor);
		holder.productImage.setBackground(d);*/
		
		
		
		// TODO need to somehow get the bitmap for the images 
		//holder.productImage.setImageBitmap((productList.get(position).getPicture());

		view.setOnCreateContextMenuListener(this);
		return view;
	}

	public void onCreateContextMenu(ContextMenu contextMenu, View view,
			ContextMenu.ContextMenuInfo contextMenuInfo) {

	}

}