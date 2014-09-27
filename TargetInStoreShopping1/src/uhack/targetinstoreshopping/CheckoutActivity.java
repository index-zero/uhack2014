package uhack.targetinstoreshopping;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class CheckoutActivity extends Activity {

	private ArrayList<Product1> cart;
	private double totalPrice = 0;
	private double tax = 0; 
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_checkout);
		
		cart = (ArrayList<Product1>)(getIntent().getExtras().get("cart"));
		
		//Extract the TextViews
		TextView taxText = (TextView)findViewById(R.id.CheckoutActivityTaxText);
		TextView taxAmount = (TextView)findViewById(R.id.CheckoutActivityTaxTextBox);
		TextView totalText = (TextView)findViewById(R.id.CheckoutActivityTotalPriceText);
		TextView totalAmount = (TextView)findViewById(R.id.CheckoutActivityTotalPriceTextBox);
		TextView subtotalAmount = (TextView)findViewById(R.id.CheckoutActivitySubtotalTextBox);
		
		//set padding on the text view to align it with the total
		taxText.setPadding(totalText.getWidth()+20, 
				taxText.getPaddingTop(), 
				taxText.getPaddingRight(), 
				taxText.getPaddingBottom());
		
		
		ArrayAdapter<Product1> adapter = new CustomArrayAdapter(this, cart);
		ListView productView = (ListView)findViewById(R.id.CheckoutActivityListView);
		productView.setAdapter(adapter);
		
		
		for(int i = 0; i < cart.size(); i++){
			
			totalPrice += cart.get(i).getPrice();
			//TODO Implement tax calculations here
		}
		subtotalAmount.setText(Double.toString(totalPrice));
		totalPrice += tax;
		taxAmount.setText(Double.toString(tax));
		totalAmount.setText(Double.toString(totalPrice));
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.checkout, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	public void continueShopping(View v){
		finish();
	}
	
	public void checkout(View v){
		Intent openBarcode = new Intent(this, BarcodeActivity.class);
		//TODO Add the transaction number to the Intent
		startActivityForResult(openBarcode, 0);
	}
	
	protected void onActivityResult (int requestCode, int resultCode, Intent data){
		if(resultCode == RESULT_OK){
			/*Intent intent = new Intent(this, Reciept.class);
			intent.putExtra("cart", cart);
			startActivity(intent);*/
			finish();
		}else{
			Toast t = new Toast(this);
			t.setText("There was an error processing your transaction");
			t.show();
			finish();
		}
	}
	
}
